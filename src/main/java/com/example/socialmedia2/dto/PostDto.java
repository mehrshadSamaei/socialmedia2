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
public class PostDto extends BaseDto<Long> {
    private Byte[] photo;
}
