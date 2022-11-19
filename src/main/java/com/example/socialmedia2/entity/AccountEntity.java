package com.example.socialmedia2.entity;

import com.example.socialmedia2.base.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "accounts")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class AccountEntity extends BaseEntity<Long> {
    @Column(name = "first-name")
    private String fName;
    @Column(name = "lirst-name")
    private String lName;
    @Column(name = "username",unique = true , nullable = false)
    private String username;
    @Column(name = "password",nullable = false)
    private String password;
    @ManyToMany
    private Set<Roles> roles = new HashSet<>();
    @OneToMany(mappedBy = "account")
    private List<PostEntity> post;
    @OneToMany(mappedBy = "account")
    private List<CommentEntity> comment;

    public AccountEntity(String fName, String lName, String username, String password) {
        this.fName = fName;
        this.lName = lName;
        this.username = username;
        this.password = password;
    }
}
