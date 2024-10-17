// package com.example.proyect.demo.infrastructure.utils.enums;

// import java.util.Arrays;
// import java.util.List;

// public enum Role {
//     ROLE_ADMINISTRATOR(Arrays.asList(
//         RolePermission.READ_ALL_EMPRESAS,
//         RolePermission.READ_ONE_EMPRESA,
//         RolePermission.CREATE_ONE_EMPRESA,
//         RolePermission.UPDATE_ONE_EMPRESA,
//         RolePermission.DISABLE_ONE_EMPRESA,

//         RolePermission.READ_ALL_TIPOSEMPRESAS,
//         RolePermission.READ_ONE_TIPOEMPRESA,
//         RolePermission.CREATE_ONE_TIPOEMPRESA,
//         RolePermission.UPDATE_ONE_TIPOEMPRESA,
//         RolePermission.DISABLE_ONE_TIPOEMPRESA,

//         RolePermission.READ_MY_PROFILE

//     )),
//     ROLE_ASSISTANT_ADMINISTRATOR(Arrays.asList(
//             RolePermission.READ_ALL_EMPRESAS,
//             RolePermission.READ_ONE_EMPRESA,
//             RolePermission.UPDATE_ONE_EMPRESA,

//             RolePermission.READ_ALL_TIPOSEMPRESAS,
//             RolePermission.READ_ONE_TIPOEMPRESA,
//             RolePermission.UPDATE_ONE_TIPOEMPRESA,

//             RolePermission.READ_MY_PROFILE
//     )),
//     ROLE_CUSTOMER(Arrays.asList(
//             RolePermission.READ_MY_PROFILE
//     ));
//     private List<RolePermission> permissions;

//     Role(List<RolePermission> permissions) {
//         this.permissions = permissions;
//     }

//     public List<RolePermission> getPermissions() {
//         return permissions;
//     }

//     public void setPermissions(List<RolePermission> permissions) {
//         this.permissions = permissions;
//     }
// }