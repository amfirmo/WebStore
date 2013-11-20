/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.mackenzie.mb;

import br.com.mackenzie.entities.Actor;
import br.com.mackenzie.entities.Department;
import br.com.mackenzie.entities.Media;
import br.com.mackenzie.service.MediaFacade;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Andre
 */
@Getter
@Setter
@ManagedBean
@SessionScoped
public class CadastroDVDBluRayManagedBean {
    private Media media = new Media();
    private javax.servlet.http.Part cover;
    private javax.servlet.http.Part content;
    @EJB
    private MediaFacade mediaFacade;
    private Actor newActor = new Actor();

    private List<Actor> actors = new ArrayList<>();
    
    /**
     * Creates a new instance of CadastroDVDBluRayManagedBean
     */
    public CadastroDVDBluRayManagedBean() {
    }
    
    public void save(){
 
        try{
            /*InputStream isCover = cover.getInputStream();
            byte[] bytesCover = null;
            isCover.read(bytesCover);
            media.setCoverImage(bytesCover);
            InputStream isContent = content.getInputStream();
            byte[] bytes = null;
            isContent.read(bytes);
            media.setVideoFile(bytes);*/
            Department dp = new Department();
            dp.setId(1);
            media.setDepartment(dp);
            media.setMediaType(Media.MediaType.DVD);
            media.setActors(actors);
            
            mediaFacade.create(media);
            
            media = new Media();
            actors = new ArrayList<>();
 
        }
        catch(Exception e){
           System.out.println("---------------------------------Erro: "+e);
        }
    }
    
    public void addActor(){
            actors.add(newActor);
            newActor = new Actor();
    }
    
}
