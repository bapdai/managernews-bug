package com.example.managernews.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "news")
public class News {
    @Id
    private int id;

    private String title;

    private String description;

    private String content;

    private Integer views = 0;

    private Boolean status;

    private String author;

    @ManyToOne
    @JoinColumn(name = "category", nullable = false)
    private News category;
}
