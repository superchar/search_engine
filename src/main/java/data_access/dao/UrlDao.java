package data_access.dao;

import data_access.entities.Url;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created by Андрей on 02.10.2016.
 */
@Repository
public class UrlDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public Url insert(Url url){
        entityManager.persist(url);
        return url;
    }
}
