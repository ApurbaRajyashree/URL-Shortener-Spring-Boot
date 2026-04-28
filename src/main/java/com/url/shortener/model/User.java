package com.url.shortener.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "user", uniqueConstraints = {
        @UniqueConstraint(name = "UNIQUE_user_username", columnNames = {"username"}),
        @UniqueConstraint(name = "UNIQUE_user_email", columnNames = {"email"})
})
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "username")
    private String username;
    private String password;
    @Column(name = "email")
    private String email;
    private String role = "ROLE_USER";

}
