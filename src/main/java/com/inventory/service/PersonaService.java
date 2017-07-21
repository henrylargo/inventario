package com.inventory.service;

import com.inventory.entity.Persona;
import com.inventory.entity.Persona_;
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

@LocalBean
@Stateless
public class PersonaService extends ServiceBase<Persona> implements Serializable {

    @PersistenceContext(name = "inventory-PU")
    private EntityManager em;

    public PersonaService() {
        super(Persona.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
    public List<Persona> obtenerPersona(Map<String, Object> criterios) {
        CriteriaBuilder cb = getEntityManager().getCriteriaBuilder();
        CriteriaQuery<Persona> cq = cb.createQuery(Persona.class);
        Root<Persona> t = cq.from(Persona.class);
        cq.select(t);
        Predicate predicate = cb.conjunction();
        String identificacion = (String) criterios.get("identificacion");
        String nombres = (String) criterios.get("nombres");
        String apellidos = (String) criterios.get("apellidos");
        if (!Util.esNulo(identificacion) && !Util.esVacio(identificacion)) {
            predicate = cb.and(predicate, cb.equal(t.get(Persona_.identificacion), identificacion));
        }
        if (!Util.esNulo(nombres) && !Util.esVacio(nombres)) {
            predicate = cb.and(predicate, cb.like(t.get(Persona_.nombres), "%" + nombres + "%"));			
        }
        if (!Util.esNulo(apellidos) && !Util.esVacio(apellidos)) {
            predicate = cb.and(predicate, cb.like(t.get(Persona_.apellidos), "%" + apellidos + "%"));			
        }
        cq.where(predicate);
        TypedQuery<Persona> tq = getEntityManager().createQuery(cq);
        return tq.getResultList(); 
    }

}