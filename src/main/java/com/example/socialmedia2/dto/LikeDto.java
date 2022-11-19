package com.example.socialmedia2.dto;

import com.example.socialmedia2.base.BaseDto;
import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class LikeDto extends BaseDto<Long> {
    private AccountDto account;
    private PostDto post;
}
