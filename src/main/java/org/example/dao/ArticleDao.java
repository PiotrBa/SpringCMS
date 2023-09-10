package org.example.dao;

import org.example.entity.Article;
import org.example.entity.Author;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
@Transactional
public class ArticleDao {

    @PersistenceContext
    EntityManager entityManager;

    public void save(Article article){
        entityManager.persist(article);
    }

    public void delete(Article article){
        entityManager.remove(entityManager.contains(article) ? article : entityManager.merge(article));
    }

    public void update(Article article){
        entityManager.merge(article);
    }


    public Article findByid(Long id){
        return entityManager.find(Article.class, id);
    }



    public List<Article> findAll(){
        TypedQuery<Article> query = entityManager.createQuery("SELECT a FROM Article a", Article.class);
        return query.getResultList();
    }


    public List<Article> findLast5Articles(){
        TypedQuery<Article> query = entityManager.createQuery("SELECT a FROM Article a ORDER BY a.created DESC", Article.class);
        query.setMaxResults(5);
        return query.getResultList();
    }


}
