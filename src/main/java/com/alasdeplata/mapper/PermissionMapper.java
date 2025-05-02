package com.alasdeplata.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.alasdeplata.dto.permissions.PermissionRequest;
import com.alasdeplata.dto.permissions.PermissionResponse;
import com.alasdeplata.models.Permission;

@Mapper(componentModel = "spring")
public interface PermissionMapper {

    PermissionResponse toResponse(Permission permission);

    @Mapping(target = "id", ignore = true)
    Permission toEntity(PermissionRequest data);
}
