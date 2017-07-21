package com.inventory.service;

import com.inventory.entity.Ubicacion;
import com.inventory.entity.Ubicacion_;
import com.inventory.util.Util;
import java.io.Serializable;
import java.util.List;
import java.util.Map;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;


/**
 *
 * @author Hp
 */
@LocalBean
@Stateless
public class UbicacionesService extends ServiceBase<Ubicacion> implements Serializable {

    @PersistenceContext(name = "inventory-PU")
    private EntityManager em;
    
    public UbicacionesService() {
        super(Ubicacion.class);
    }
    
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
    public List<Ubicacion> obtenerUbicaciones(Map<String, Object> criterios) {
        CriteriaBuilder cb = getEntityManager().getCriteriaBuilder();
        CriteriaQuery<Ubicacion> cq = cb.createQuery(Ubicacion.class);
        Root<Ubicacion> t = cq.from(Ubicacion.class);
        cq.select(t);
        Predicate predicate = cb.conjunction();
        long nivel = (long) criterios.get("nivel");
        Ubicacion ubicacion = (Ubicacion) criterios.get("ubicacion");
        if (!Util.esNulo(ubicacion) && !Util.esVacio(ubicacion)) {
            predicate = cb.and(predicate, cb.equal(t.get(Ubicacion_.codigoUbicacion), ubicacion));
        }
        if (!Util.esNulo(nivel) && !Util.esVacio(nivel)) {
            predicate = cb.and(predicate, cb.equal(t.get(Ubicacion_.nivel), nivel));
        }
        cq.where(predicate);
        TypedQuery<Ubicacion> tq = getEntityManager().createQuery(cq);
        return tq.getResultList(); 
    }

}