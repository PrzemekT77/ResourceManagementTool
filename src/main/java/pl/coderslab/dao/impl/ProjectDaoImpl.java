package pl.coderslab.dao.impl;

import java.util.Collection;

import pl.coderslab.dao.ProjectDao;
import pl.coderslab.domain.Project;

public class ProjectDaoImpl extends AbstractBaseDao<Project, Long> implements ProjectDao {
    

    public Project find(Long id) {
        return entityManager.find(Project.class, id);
    }

    public Collection<Project> findAll() {
        return entityManager.createQuery("SELECT b FROM Project b").getResultList();
    }
}
