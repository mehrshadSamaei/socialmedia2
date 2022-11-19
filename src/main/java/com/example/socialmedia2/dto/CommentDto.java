package com.example.socialmedia2.dto;

import com.example.socialmedia2.base.BaseDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CommentDto extends BaseDto<Long> {
    private String comment;
    private AccountDto account;
    private PostDto post;
}
