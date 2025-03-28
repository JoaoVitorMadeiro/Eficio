package com.joaomadeiro.user.entity;

import jakarta.persistence.Entity;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Builder
public class UserEntity {

    @EqualsAndHashCode.Include
    private String id;
    private String name;
    private String email;
    private String password;
    private String role;
    private String token;
    private String refreshToken;
    private String createdAt;
    private String updatedAt;


}
