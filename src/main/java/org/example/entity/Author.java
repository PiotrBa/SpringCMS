package org.example.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "authors")
@Getter
@Setter
@ToString
public class Author {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;



}
