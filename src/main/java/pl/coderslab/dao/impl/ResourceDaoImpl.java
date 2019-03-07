package pl.coderslab.dao.impl;

import java.util.Collection;

import org.springframework.core.io.Resource;

import pl.coderslab.dao.ResourceDao;

public class ResourceDaoImpl extends AbstractBaseDao<Resource, Long> implements ResourceDao {
    

    public Resource find(Long id) {
        return entityManager.find(Resource.class, id);
    }

    public Collection<Resource> findAll() {
        return entityManager.createQuery("SELECT b FROM Resource b").getResultList();
    }
}
