package com.project.EmailVerification.entites;

import com.sun.istack.NotNull;
import lombok.*;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Credentials {

    @NotBlank
    private String email;
    @NotBlank
    private String password;

}
