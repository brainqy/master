package com.brainqy.master.services;

/**
 * Description of the class or file.
 *
 * @author Dnyaneshwar Somwanshi
 * @version 1.0
 * @project master
 * @since 19-05-2025
 */
import com.brainqy.master.dtos.TenantRequestDto;
import com.brainqy.master.dtos.TenantResponseDto;
import com.brainqy.master.dtos.UserSignupRequestDto;

import java.util.List;

public interface TenantService {
    TenantResponseDto createTenant(TenantRequestDto tenantRequestDto, UserSignupRequestDto initialAdminDto);
    TenantResponseDto getTenantById(String tenantId);
    List<TenantResponseDto> getAllTenants();
    TenantResponseDto updateTenant(String tenantId, TenantRequestDto tenantRequestDto);
    void deleteTenant(String tenantId); // Consider implications of deleting a tenant
    TenantResponseDto updateTenantBranding(String tenantId, String tenantName, String logoUrl, String primaryColor, String accentColor); // For managers
}