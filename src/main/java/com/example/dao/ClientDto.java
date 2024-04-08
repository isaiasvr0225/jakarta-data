package com.example.dao;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

/**
 * DTO for {@link com.example.entity.Client}
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ClientDto implements Serializable {
    private Long id;
    @NotBlank
    private String fullName;
    @NotNull
    private Integer phone;
    @Email
    @NotBlank
    private String email;
}