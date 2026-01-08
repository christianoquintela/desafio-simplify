package com.example.desafio_simplify.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "User.TABLE_NAME")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class User {
    public static final String TABLE_NAME = "users";
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true)
    private Long id;

    @Column(name = "username", nullable = false, length = 100, unique = true)
    @NotBlank(message = "Não pode ficar em branco")
    @Size(min = 2, max = 100)
    private String username;

    //    @JsonProperty garante que a senha seja só de escrita, e não poderá ser lida, não será enviado json com a senha para o front.
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @Column(name = "password", nullable = false, length = 60)
    @NotBlank
    @Size(min = 8, max = 60)
    private String password;
}
