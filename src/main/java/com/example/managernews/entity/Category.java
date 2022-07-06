package com.example.managernews.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "category")
public class Category {
    @Id
    private Integer id;

    private String name;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "category")
    private Set<News> listNews = new HashSet<>();
}
