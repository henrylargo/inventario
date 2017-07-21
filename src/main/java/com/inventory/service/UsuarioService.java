package com.inventory.service;

import com.inventory.entity.Usuario;
import com.inventory.entity.Usuario_;
import com.inventory.util.Util;
import java.io.Serializable;
import java.util.List;
import java.util.Map;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

@LocalBean
@Stateless
public class UsuarioService extends ServiceBase<Usuario> implements Serializable{
    
    @PersistenceContext(name = "inventory-PU")
    private EntityManager em;

    public UsuarioService() {
        super(Usuario.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
    public Usuario obtenerUsuario(Map<String, Object> criterios) throws NoResultException{
        CriteriaBuilder cb = getEntityManager().getCriteriaBuilder();
        CriteriaQuery<Usuario> cq = cb.createQuery(Usuario.class);
        Root<Usuario> t = cq.from(Usuario.class);
        cq.select(t);
        Predicate predicate = cb.conjunction();
        String usuario = (String) criterios.get("usuario");
        String clave = (String) criterios.get("clave");
        if (!Util.esNulo(usuario) && !Util.esVacio(usuario)) {
            System.out.println("usuario:   " + usuario);
            predicate = cb.and(predicate, cb.equal(t.get(Usuario_.usuario), usuario));
        }
        if (!Util.esNulo(clave) && !Util.esVacio(clave)) {
            System.out.println("clave:   " + clave);
            predicate = cb.and(predicate, cb.equal(t.get(Usuario_.clave), clave));
        }
        cq.where(predicate);
        TypedQuery<Usuario> tq = getEntityManager().createQuery(cq);
        List<Usuario> usuarioLista = tq.getResultList();
        if (usuarioLista.isEmpty()) {
            return null;
        }
        return usuarioLista.get(0);
        
        
    }

}