package com.CarsDemoEx.demo.Dto;

import lombok.Data;

import javax.security.auth.login.CredentialExpiredException;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Data
public class OwnerDto {

    @Size(min = 3, message = "This is not a name")
    @NotEmpty(message = "Please provide me a name.")
    private String nameOwner;

    @Pattern(regexp = "^[0-9]{4}-(((0[13578]|(10|12))-(0[1-9]|[1-2][0-9]|3[0-1]))|(02-(0[1-9]|[1-2][0-9]))|((0[469]|11)-(0[1-9]|[1-2][0-9]|30)))$")
    @NotEmpty(message = "Please provide me a date of birth -> YYYY-MM-DD")
    private String dateBirthOwner;
}
