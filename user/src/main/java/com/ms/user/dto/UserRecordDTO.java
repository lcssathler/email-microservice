package com.ms.user.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.Length;

public record UserRecordDTO(@NotBlank @Length(min = 3) String name,
                            @NotBlank @Email String email) {

}

