package com.brainqy.master.services;

import com.brainqy.master.dtos.UserProfileUpdateRequestDto;
import com.brainqy.master.dtos.UserResponseDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Description of the class or file.
 *
 * @author Dnyaneshwar Somwanshi
 * @version 1.0
 * @project master
 * @since 19-05-2025
 */
public interface UserService {
    UserResponseDto getUserById(Long userId);
    Page<UserResponseDto> getAllUsers(Pageable pageable, String tenantId); // tenantId for manager scope
    UserResponseDto updateUserProfile(Long userId, UserProfileUpdateRequestDto profileUpdateDto);
    UserResponseDto adminUpdateUser(Long userId, UserProfileUpdateRequestDto userUpdateDto); // For admin/manager
    void deleteUser(Long userId);
    void changePassword(Long userId, String currentPassword, String newPassword);
    void requestDataDeletion(Long userId);
    // Other user-specific methods
}
