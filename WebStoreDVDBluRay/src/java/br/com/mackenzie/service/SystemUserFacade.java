/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.mackenzie.service;

import br.com.mackenzie.entities.Customer;
import br.com.mackenzie.entities.SystemUser;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.jboss.logging.Logger;

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
    
        return new Customer();
    
    }
    
    public SystemUser findByUserPass(String user, String pass){
        SystemUser systemUser = null;
        
        Query q = getEntityManager().createNativeQuery("SELECT * FROM SYSTEMUSER WHERE USERNAME = ? AND PASSWORD = ?", SystemUser.class);
        q.setParameter(1, user);
        q.setParameter(2, pass);
        
        try{
            systemUser = (SystemUser) q.getSingleResult();
        }catch(NoResultException nre){
            System.err.println("Nao encontrou o user: "+user+"com o pass: "+pass);
        }
        return systemUser;
    }
    
}
