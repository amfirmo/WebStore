/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.mackenzie.service;

import br.com.mackenzie.entities.Cidade;
import br.com.mackenzie.entities.Estado;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;

/**
 *
 * @author Andre
 */
@Stateless
public class CidadeFacade extends AbstractFacade<Cidade> {
    @PersistenceContext(unitName = "WebStoreDVDBluRayPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CidadeFacade() {
        super(Cidade.class);
    }
    
    public List<Cidade> findByEstado(Estado estado){
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
        Query q = getEntityManager().createNativeQuery("SELECT * FROM CIDADE WHERE ESTADO_ID = ?", Cidade.class);
        q.setParameter(1, estado.getId());
        return q.getResultList();
    }
    
}
