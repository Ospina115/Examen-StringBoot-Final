// package com.example.proyect.demo.domain.entities;

// import java.util.Collection;
// import java.util.stream.Collectors;

// import org.springframework.security.core.GrantedAuthority;
// import org.springframework.security.core.authority.SimpleGrantedAuthority;
// import org.springframework.security.core.userdetails.UserDetails;

// import com.example.proyect.demo.infrastructure.utils.enums.Role;

// import jakarta.persistence.Column;
// import jakarta.persistence.Entity;
// import jakarta.persistence.EnumType;
// import jakarta.persistence.Enumerated;
// import jakarta.persistence.GeneratedValue;
// import jakarta.persistence.GenerationType;
// import jakarta.persistence.Id;
// import jakarta.persistence.Table;
// import lombok.Getter;
// import lombok.Setter;

// @Entity
// @Getter
// @Setter
// @Table(name = "\"user\"")                
// public class User implements UserDetails{

//     @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     private Long id;


//     @Column(unique = true)
//     private String username;
//     private String name;    
//     private String password;

//     @Enumerated(EnumType.STRING)
//     private Role role;


//     @Override
//     public Collection<? extends GrantedAuthority> getAuthorities() {
//         if(role == null) return null;

//         if(role.getPermissions() == null) return null;

//         return role.getPermissions().stream()
//                 .map(each -> each.name())
//                 .map(each -> new SimpleGrantedAuthority(each))
//                 .collect(Collectors.toList());
//     }
//     @Override
//     public String getPassword() {
//         return password;
//     }
//     @Override
//     public String getUsername() {
//         return username;
//     }

//     @Override
//     public boolean isAccountNonExpired() {
//         return true;
//     }
//     @Override
//     public boolean isAccountNonLocked() {
//         return true;
//     }
//     @Override
//     public boolean isCredentialsNonExpired() {
//         return true;
//     }
//     @Override
//     public boolean isEnabled() {
//         return true;
//     }
// }
