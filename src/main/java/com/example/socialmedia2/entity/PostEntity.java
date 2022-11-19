package com.example.socialmedia2.entity;

import com.example.socialmedia2.base.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "posts")
@NoArgsConstructor
@Setter
@Getter
@AllArgsConstructor
public class PostEntity extends BaseEntity<Long> {
    @Column(name = "photo",columnDefinition="BLOB")
    @Lob
    @Type(type = "org.hibernate.type.ImageType")
    byte[] photo;

    @OneToMany(mappedBy = "post")
    private List<CommentEntity> comment;

    @ManyToOne
    private AccountEntity account;
}
