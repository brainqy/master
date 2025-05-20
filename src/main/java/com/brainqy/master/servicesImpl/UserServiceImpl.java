package com.brainqy.master.servicesImpl;

/**
 * Description of the class or file.
 *
 * @author Dnyaneshwar Somwanshi
 * @version 1.0
 * @project master
 * @since 20-05-2025
 */
import com.brainqy.master.dtos.UserProfileUpdateRequestDto;
import com.brainqy.master.dtos.UserResponseDto;
import com.brainqy.master.dtos.UserUpdateRequestDto;
import com.brainqy.master.entities.Tenant;
import com.brainqy.master.entities.User;
import com.brainqy.master.entities.UserStatus;
import com.brainqy.master.repos.TenantRepository;
import com.brainqy.master.repos.UserRepository;
import com.brainqy.master.services.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.transaction.annotation.Transactional;
import java.util.stream.Collectors;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    private final UserRepository userRepository;
    private final TenantRepository tenantRepository; // Needed if admin can change tenant
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserServiceImpl(UserRepository userRepository,
                           TenantRepository tenantRepository,
                           PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.tenantRepository = tenantRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    @Transactional(readOnly = true)
    public UserResponseDto getUserById(Long userId) {
        logger.debug("Fetching user by ID: {}", userId);
        User user = userRepository.findById(userId)
                .orElseThrow(() -> {
                    logger.warn("User not found with ID: {}", userId);
                    return new RuntimeException("User not found with ID: " + userId); // ResourceNotFoundException
                });
        return mapToUserResponseDto(user);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<UserResponseDto> getAllUsers(Pageable pageable, String currentUserManagerTenantId) {
        logger.info("Fetching all users. Page: {}, Size: {}. Scoped to tenant: {}",
                pageable.getPageNumber(), pageable.getPageSize(), currentUserManagerTenantId);
        Page<User> usersPage;
        if (currentUserManagerTenantId != null && !currentUserManagerTenantId.isEmpty()) {
            Tenant tenant = tenantRepository.findById(Long.valueOf(currentUserManagerTenantId))
                    .orElseThrow(() -> new RuntimeException("Tenant not found for manager: " + currentUserManagerTenantId));
            usersPage = userRepository.findByTenant(tenant, pageable);
            logger.debug("Fetched {} users for tenant {}", usersPage.getTotalElements(), currentUserManagerTenantId);
        } else {
            // Admin fetching all users
            usersPage = userRepository.findAll(pageable);
            logger.debug("Admin fetched {} users from all tenants.", usersPage.getTotalElements());
        }
        List<UserResponseDto> userDtos = usersPage.getContent().stream()
                .map(this::mapToUserResponseDto)
                .collect(Collectors.toList());
        return new PageImpl<>(userDtos, pageable, usersPage.getTotalElements());
    }


    @Override
    @Transactional
    public UserResponseDto updateUserProfile(Long userId, UserProfileUpdateRequestDto profileUpdateDto) {
        logger.info("Updating profile for user ID: {}", userId);
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found with ID: " + userId)); // ResourceNotFoundException

        // Map fields from DTO to User entity (carefully, only what a user can change)
        if (profileUpdateDto.getName() != null) user.setName(profileUpdateDto.getName());
        if (profileUpdateDto.getDateOfBirth() != null) user.setDateOfBirth(profileUpdateDto.getDateOfBirth());
        if (profileUpdateDto.getGender() != null) user.setGender(profileUpdateDto.getGender());
        // ... map other updatable fields from UserProfileUpdateRequestDto ...
        user.setBio(profileUpdateDto.getBio());
        user.setSkills(profileUpdateDto.getSkills()); // Assuming skills is List<String>
        user.setLinkedInProfile(profileUpdateDto.getLinkedInProfile());
        // etc.

        User updatedUser = userRepository.save(user);
        logger.info("Profile updated successfully for user ID: {}", userId);
        return mapToUserResponseDto(updatedUser);
    }

    @Override
    public UserResponseDto adminUpdateUser(Long userId, UserProfileUpdateRequestDto userUpdateDto) {
        return null;
    }

    @Transactional
    @Override
    public UserResponseDto adminUpdateUser(Long userId, UserUpdateRequestDto userUpdateDto) {
        logger.info("Admin/Manager updating user ID: {}", userId);
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found with ID: " + userId));

        if (userUpdateDto.getName() != null) user.setName(userUpdateDto.getName());
        if (userUpdateDto.getEmail() != null && !user.getEmail().equals(userUpdateDto.getEmail())) {
            if (userRepository.existsByEmail(userUpdateDto.getEmail())) {
                throw new RuntimeException("Email " + userUpdateDto.getEmail() + " is already in use.");
            }
            user.setEmail(userUpdateDto.getEmail());
        }
        if (userUpdateDto.getRole() != null) user.setRole(userUpdateDto.getRole());
        if (userUpdateDto.getStatus() != null) user.setStatus(userUpdateDto.getStatus());

        // Admin changing tenant (handle with care, ensure manager cannot do this unless intended)
        if (userUpdateDto.getTenantId() != null &&
                (user.getTenant() == null || !user.getTenant().getId().equals(userUpdateDto.getTenantId()))) {
            Tenant tenant = tenantRepository.findById(Long.valueOf(userUpdateDto.getTenantId()))
                    .orElseThrow(() -> new RuntimeException("Tenant not found: " + userUpdateDto.getTenantId()));
            user.setTenant(tenant);
        }

        User updatedUser = userRepository.save(user);
        logger.info("User {} (ID: {}) updated by admin/manager.", updatedUser.getEmail(), userId);
        return mapToUserResponseDto(updatedUser);
    }


    @Override
    @Transactional
    public void changePassword(Long userId, String currentPassword, String newPassword) {
        logger.info("Attempting password change for user ID: {}", userId);
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found with ID: " + userId)); // ResourceNotFoundException

        if (!passwordEncoder.matches(currentPassword, user.getPasswordHash())) {
            logger.warn("Password change failed for user ID {}: Incorrect current password.", userId);
            throw new RuntimeException("Incorrect current password."); // BadRequestException
        }
        if (newPassword.length() < 8) { // Example validation
            logger.warn("Password change failed for user ID {}: New password too short.", userId);
            throw new RuntimeException("New password must be at least 8 characters long."); // BadRequestException
        }

        user.setPasswordHash(passwordEncoder.encode(newPassword));
        userRepository.save(user);
        logger.info("Password changed successfully for user ID: {}", userId);
    }

    @Override
    @Transactional
    public void deleteUser(Long userId) {
        logger.info("Attempting to delete user with ID: {}", userId);
        if (!userRepository.existsById(userId)) {
            logger.warn("Deletion failed: User not found with ID: {}", userId);
            throw new RuntimeException("User not found with ID: " + userId); // ResourceNotFoundException
        }
        // Consider soft delete (e.g., setting a 'deleted' flag) instead of hard delete
        // Also handle cascading deletes or nullifying relationships if necessary
        userRepository.deleteById(userId);
        logger.info("User with ID: {} deleted successfully.", userId);
    }


    @Override
    @Transactional
    public void requestDataDeletion(Long userId) {
        // This could involve:
        // 1. Marking the user account for deletion.
        // 2. Anonymizing their data.
        // 3. Triggering a background job for actual deletion after a grace period.
        // For now, a simple log.
        logger.info("Data deletion requested for user ID: {}. (Mock implementation)", userId);
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found with ID: " + userId));
        user.setStatus(UserStatus.PENDING_DELETION); // Example new status
        userRepository.save(user);
        // Send confirmation email, notify admins, etc.
    }

    // Helper method to map User entity to UserResponseDto
    private UserResponseDto mapToUserResponseDto(User user) {
        if (user == null) return null;
        return UserResponseDto.builder()
                .id(user.getId())
                .name(user.getName())
                .email(user.getEmail())
                .role(user.getRole())
                .status(user.getStatus())
                .tenantId(String.valueOf(user.getTenant() != null ? user.getTenant().getId() : null))
                .dateOfBirth(user.getDateOfBirth())
                .gender(user.getGender())
                .mobileNumber(user.getMobileNumber())
                // ... map all other relevant fields ...
                .xpPoints(user.getXpPoints())
                .dailyStreak(user.getDailyStreak())
                .interviewCredits(user.getInterviewCredits())
                .createdAt(user.getCreatedAt())
                .lastLogin(user.getLastLogin())
                .build();
    }
}

