/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/

package br.com.mackenzie.service;

import br.com.mackenzie.entities.Media;
import java.io.Serializable;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Andre
 */
@Stateless
public class MediaFacade extends AbstractFacade<Media> implements Serializable{
    @PersistenceContext(unitName = "WebStoreDVDBluRayPU")
    private EntityManager em;
    
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
    public MediaFacade() {
        super(Media.class);
    }
    
    public List<Media> findByEstado(String genero, String titulo){
        /*
        Query q;
        q = getEntityManager().createQuery("SELECT c FROM APP.Cidade c", Cidade.class);
        //q.setParameter("estadoId", estado.getId());
        return q.getResultList();
        */
        /*
        CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
        cq.select(cq.from(Cidade.class));
        return getEntityManager().createQuery(cq).getResultList();
        */
        boolean[] and = {false,false};
        byte pos = 1;
        StringBuilder sb = new StringBuilder("SELECT * FROM MEDIA ");
        if(genero != null && !genero.equals("")){
            sb.append(" WHERE ");
            sb.append(" GENRE LIKE ? ");
            and[0] = true;
        }
        if(titulo != null && !titulo.equals("")){
            if(and[0]){
                sb.append(" AND ");
            }else{
                sb.append(" WHERE ");
            }    
            sb.append(" TITLE LIKE ? ");
            and[1]=true;
        }
        
        Query q = getEntityManager().createNativeQuery(sb.toString(), Media.class);
        if(and[0])
            q.setParameter(pos++, "%"+genero+"%");
        if(and[1])
            q.setParameter(pos++, "%"+titulo+"%");
        
        
        return q.getResultList();
    }
    
}
