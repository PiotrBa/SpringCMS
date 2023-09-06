package org.example.dao;

import org.example.entity.Category;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
@Transactional
public class CategoryDao {

    @PersistenceContext
    EntityManager entityManager;


    public void saveCategory(Category category){
        entityManager.persist(category);
    }

    public void deleteCategory(Category category){
        entityManager.remove(entityManager.contains(category) ? category : entityManager.merge(category));
    }

    public void updateCategory(Category category){
        entityManager.merge(category);
    }


    public List<Category> findAll(){
        TypedQuery<Category> query = entityManager.createQuery("SELECT c FROM Category c", Category.class);
        List<Category> categoriesList = query.getResultList();
        return categoriesList;
    }
}
