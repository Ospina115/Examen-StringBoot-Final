package com.example.proyect.demo.infrastructure.utils.enums;

import java.util.Arrays;
import java.util.List;

public enum RoleEnum {
    ADMINISTRATOR(Arrays.asList(
        RolePermissionEnum.READ_ALL_EMPRESAS,
        RolePermissionEnum.READ_ONE_EMPRESA,
        RolePermissionEnum.CREATE_ONE_EMPRESA,
        RolePermissionEnum.UPDATE_ONE_EMPRESA,
        RolePermissionEnum.DISABLE_ONE_EMPRESA,

        RolePermissionEnum.READ_ALL_TIPOSEMPRESAS,
        RolePermissionEnum.READ_ONE_TIPOEMPRESA,
        RolePermissionEnum.CREATE_ONE_TIPOEMPRESA,
        RolePermissionEnum.UPDATE_ONE_TIPOEMPRESA,
        RolePermissionEnum.DISABLE_ONE_TIPOEMPRESA,

        RolePermissionEnum.UPDATE_ONE_PAIS,

        RolePermissionEnum.READ_MY_PROFILE

    )),
    ASSISTANT_ADMINISTRATOR(Arrays.asList(
            RolePermissionEnum.READ_ALL_EMPRESAS,
            RolePermissionEnum.READ_ONE_EMPRESA,
            RolePermissionEnum.UPDATE_ONE_EMPRESA,

            RolePermissionEnum.READ_ALL_TIPOSEMPRESAS,
            RolePermissionEnum.READ_ONE_TIPOEMPRESA,
            RolePermissionEnum.UPDATE_ONE_TIPOEMPRESA,

            RolePermissionEnum.READ_MY_PROFILE
    )),
    CUSTOMER(Arrays.asList(
            RolePermissionEnum.READ_MY_PROFILE
    ));
    private List<RolePermissionEnum> permissions;

    RoleEnum(List<RolePermissionEnum> permissions) {
        this.permissions = permissions;
    }

    public List<RolePermissionEnum> getPermissions() {
        return permissions;
    }

    public void setPermissions(List<RolePermissionEnum> permissions) {
        this.permissions = permissions;
    }
}