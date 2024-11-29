package com.sparta.currency_user.dto;

import com.sparta.currency_user.entity.User;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;

@Getter
public class UserRequestDto {

    @NotBlank(message = "이름은 필수 입력값입니다.")
    private String name;

    @Email(message = "유효한 이메일 주소를 입력해주세요.")
    @NotBlank(message = "이메일은 필수 입력값입니다.")
    private String email;

    public User toEntity() {
        return new User(
                this.name,
                this.email
        );
    }
}
