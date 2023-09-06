package org.example.dao;

import org.example.entity.Article;
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


    public List<Article> findAll(){
        TypedQuery<Article> query = entityManager.createQuery("SELECT a FROM Article a", Article.class);
        List<Article> articleList = query.getResultList();
        return articleList;
    }



}
