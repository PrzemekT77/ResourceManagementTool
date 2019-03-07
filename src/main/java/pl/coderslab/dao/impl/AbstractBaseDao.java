package pl.coderslab.dao.impl;

import java.io.Serializable;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

/**
 * Base implementation of DAO methods for reducing boilerplate code.
 *
 * @param <E>
 * @param <I>
 */
@Transactional
public abstract class AbstractBaseDao<E, I extends Serializable> {

	@PersistenceContext
    protected EntityManager entityManager;
	
    /**
     * Base implementation of save method.
     *
     * @param entity - Entity to persist
     * @return Entity
     */
    public E save(E entity) {
        entityManager.persist(entity);
        return entity;
    }

    /**
     * Base implementation of update method.
     *
     * @param entity - Entity to merge
     * @return Entity
     */
    public E update(E entity) {
        return entityManager.merge(entity);
    }

    /**
     * Base implementation of delete method.
     *
     * @param entity - Entity to delete
     * @return Entity
     */
    public void delete(E entity) {
        entityManager.remove(entityManager.contains(entity) ? entity : entityManager.merge(entity));
    }
}
