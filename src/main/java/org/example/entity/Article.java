package org.example.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDateTime;

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
    @JoinColumn(name = "author_id")
    private Author author;
    @ManyToOne
    @JoinTable(name = "article_category", joinColumns = @JoinColumn(name = "article_id"), inverseJoinColumns = @JoinColumn(name = "category_id"))
    private Category category;
    private String content;

    @Column(updatable = false)
    private LocalDateTime created;
    private LocalDateTime updated;


    protected void onCreate(){
        created = LocalDateTime.now();
    }

    protected void onUpdate(){
        updated = LocalDateTime.now();
    }

}
