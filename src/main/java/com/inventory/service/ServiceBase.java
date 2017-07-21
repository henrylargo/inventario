/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inventory.service;

import com.inventory.util.Constantes;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

/**
 *
 * @author Hp
 * @param <T>
 */
public abstract class ServiceBase<T> {

    private final Class<T> entityClass;

    public ServiceBase(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    protected abstract EntityManager getEntityManager();

    public void guardar(T entity) {
        getEntityManager().persist(entity);
    }

    public void modificar(T entity) {
        getEntityManager().merge(entity);
    }

    public void eliminar(T entity) {
        getEntityManager().remove(getEntityManager().merge(entity));
    }

    public T find(Object id) {
        return getEntityManager().find(entityClass, id);
    }
    
    public List<T> obtenerTodosSinOrdenar() {
        CriteriaBuilder criteriaBuilder = getEntityManager().getCriteriaBuilder();
        CriteriaQuery<T> cq = criteriaBuilder.createQuery(entityClass);
        Root<T> rt = cq.from(entityClass);
        cq.select(rt);
        return getEntityManager().createQuery(cq).getResultList();
    }
    
    public List<T> obtenerTodos() {
        CriteriaBuilder criteriaBuilder = getEntityManager().getCriteriaBuilder();
        CriteriaQuery<T> cq = criteriaBuilder.createQuery(entityClass);
        Root<T> rt = cq.from(entityClass);
        cq.select(rt);
        cq.orderBy(criteriaBuilder.asc(rt.get("codigo")));
        return getEntityManager().createQuery(cq).getResultList();
    }

    public List<T> obtenerTodosActivos() {
        CriteriaBuilder criteriaBuilder = getEntityManager().getCriteriaBuilder();
        CriteriaQuery<T> cq = criteriaBuilder.createQuery(entityClass);
        Root<T> rt = cq.from(entityClass);
        cq.select(rt);
        Predicate predicate = criteriaBuilder.conjunction();
        predicate = criteriaBuilder.and(predicate, criteriaBuilder.equal(rt.get("estado"), Constantes.ESTADO_ACTIVO));
        cq.where(predicate);
        cq.orderBy(criteriaBuilder.asc(rt.get("codigo")));
        return getEntityManager().createQuery(cq).getResultList();
    }

}