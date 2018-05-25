package org.supcom.javase.managers;

import org.supcom.javase.models.BaseEntity;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.io.Serializable;

public abstract class BaseManager<ID extends Serializable,E extends BaseEntity<ID>>  {
    public abstract EntityManager getEntityManager();
    private final Class<E> entityClass;
    protected BaseManager(Class<E> entityClass){
        this.entityClass=entityClass;
    }

    public E findById(ID id){
        return getEntityManager().find(entityClass,id);
    }
    @Transactional
    public void addEntity(E e){
        getEntityManager().persist(e);//tzid
    }

    @Transactional
    public void removeEntity(E e){
        getEntityManager().remove(getEntityManager().merge(e));
    }

}
