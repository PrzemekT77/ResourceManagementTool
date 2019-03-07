package pl.coderslab.dao;

import java.io.Serializable;
import java.util.Collection;

/**
 * Base DAO interface
 *
 * @param <E> - Entity
 * @param <I> - Primary Key (ID)
 */
public interface BaseDao<E, I extends Serializable> {

	/**
     * Save method declaration
     *
     * @param entity - Entity
     * @return Entity
     */
    E save(E entity);

    /**
     * Udpate method declaration
     *
     * @param entity - Entity
     * @return Entity
     */
    E update(E entity);

    /**
     * Find method declaration
     *
     * @param id - primary key(id)
     * @return Entity
     */
    E find(I id);

    /**
     * Delete method declaration
     *
     * @param entity - Entity
     */
    void delete(E entity);

    /**
     * Find adll method declaration
     *
     * @return Collection of Entities
     */
    Collection<E> findAll();
}
