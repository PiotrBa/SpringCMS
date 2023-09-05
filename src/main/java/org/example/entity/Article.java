package org.example.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

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
    @JoinColumn(name = "author_id")
    private Author author;
    @OneToMany
    @JoinTable(name = "article_category", joinColumns = @JoinColumn(name = "article_id"), inverseJoinColumns = @JoinColumn(name = "category_id"))
    private List<Category> categories = new ArrayList<>();

    @Lob
    private String content;

    @Column(updatable = false)
    private LocalDateTime created;
    private LocalDateTime updated;

   @PrePersist
    protected void onCreate(){
        created = LocalDateTime.now();
    }

   @PrePersist
    protected void onUpdate(){
        updated = LocalDateTime.now();
    }

}
