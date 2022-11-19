package com.example.socialmedia2.base;

import lombok.*;

import java.io.Serializable;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public abstract class BaseDto<ID extends Serializable> implements Serializable {
    private ID id;
}
