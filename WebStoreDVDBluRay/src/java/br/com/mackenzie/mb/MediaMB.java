/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.mackenzie.mb;

import br.com.mackenzie.entity.MediaOld;
import br.com.mackenzie.service.MediaService;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
/**
 * @author 71321934
 */
@ManagedBean
public class MediaMB {
    
    @EJB
    private MediaService mediaService;
    
    private List<MediaOld> lista;

    public void setMediaService(MediaService mediaService) {
        this.mediaService = mediaService;
    }

    public void setLista(List<MediaOld> lista) {
        this.lista = lista;
    }

    public MediaService getMediaService() {
        return mediaService;
    }

    public List<MediaOld> getLista() {
        return lista;
    }
    
    public MediaMB(){}
    
    public void criaObjetoNoBanco(){
        MediaOld media = new MediaOld("titulo", "sinopse", 2006, "portuguese");
        mediaService.createMedia(media);

    }
    
    public void listaTodos(){
    
        lista = mediaService.findAll();
        
    }
    
}
