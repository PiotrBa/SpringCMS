package org.example.dao;

import org.example.entity.Author;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

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


    public List<Author> findAll(){
        TypedQuery<Author> query = entityManager.createQuery("SELECT a FROM Author a", Author.class);
        List<Author> authorList = query.getResultList();
        return authorList;
    }

}
