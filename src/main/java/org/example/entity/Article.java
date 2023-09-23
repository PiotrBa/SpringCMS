package org.example.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "articles")
@Getter
@Setter
@ToString
public class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 200)
    private String title;
    @ManyToOne
    private Author author;
    @ManyToMany(fetch = FetchType.EAGER)
    private List<Category> categories = new ArrayList<>();
    private String content;

    @Column(updatable = false)
    private LocalDateTime created;
    private LocalDateTime updated;

}
