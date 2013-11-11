/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.mackenzie.service;

import br.com.mackenzie.entity.Media;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;

/**
 * 1 - Stateless or Statefull
 * 2 - PersistenceContext
 * 3 - 
 * @author 71321934
 */
@Stateless
public class MediaService {
    
    @PersistenceContext
    private EntityManager em;
    
    public void createMedia(Media media){
    
        em.persist(media);
    
    }
    
    public List<Media> findAll(){
        CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
        
        cq.select(cq.from(Media.class));
        
        return em.createQuery(cq).getResultList();
    }
}
