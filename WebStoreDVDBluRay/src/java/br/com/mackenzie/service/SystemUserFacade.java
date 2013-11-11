/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.mackenzie.service;

import br.com.mackenzie.entities.Client;
import br.com.mackenzie.entities.SystemUser;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Andre
 */
@Stateless
public class SystemUserFacade extends AbstractFacade<SystemUser> {
    @PersistenceContext(unitName = "WebStoreDVDBluRayPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public SystemUserFacade() {
        super(SystemUser.class);
    }
    
    public SystemUser validateUser(String userName, String pass){
    
        return new Client();
    
    }
    
}
