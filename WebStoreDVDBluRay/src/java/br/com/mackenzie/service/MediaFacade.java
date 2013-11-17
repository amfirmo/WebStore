/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.mackenzie.service;

import br.com.mackenzie.entities.Media;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Andre
 */
@Stateless
public class MediaFacade extends AbstractFacade<Media> {
    @PersistenceContext(unitName = "WebStoreDVDBluRayPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public MediaFacade() {
        super(Media.class);
    }
    
}
