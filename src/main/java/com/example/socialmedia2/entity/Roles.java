package com.example.socialmedia2.entity;

import com.example.socialmedia2.base.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Roles extends BaseEntity<Long> {
    private String username;
    private String role;
    private String name;
}
