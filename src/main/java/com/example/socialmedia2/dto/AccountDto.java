package com.example.socialmedia2.dto;

import com.example.socialmedia2.base.BaseDto;
import lombok.*;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.Size;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class AccountDto extends BaseDto<Long> {
    @NotBlank
    private String fName;
    @NotBlank
    private String lName;
    @NotBlank
    @NotEmpty
    private String username;
    @NotBlank
    @Size(min = 6 , max = 12)
    private String password;

}
