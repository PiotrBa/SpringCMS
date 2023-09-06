package org.example.dao;

import org.example.entity.Author;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
@Transactional
public class AuthorDao {

    @PersistenceContext
    EntityManager entityManager;

    public void saveAuthor(Author author){
        entityManager.persist(author);
    }

    public void delete(Author author){
        entityManager.remove(entityManager.contains(author) ? author : entityManager.merge(author));
    }

    public void  update(Author author){
        entityManager.merge(author);
    }

}
