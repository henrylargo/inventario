/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inventory.service;

import com.inventory.entity.Menu;
import java.io.Serializable;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Hp
 */
@LocalBean
@Stateless
public class MenuService extends ServiceBase<Menu> implements Serializable {

    @PersistenceContext(name = "inventory-PU")
    private EntityManager em;

    public MenuService() {
        super(Menu.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

}
