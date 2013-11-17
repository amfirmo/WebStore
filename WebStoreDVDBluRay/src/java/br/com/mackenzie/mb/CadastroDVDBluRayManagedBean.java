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
import java.io.IOException;
import java.io.InputStream;
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
@ManagedBean
@SessionScoped
public class CadastroDVDBluRayManagedBean {
    @Getter
    @Setter
    private Media media = new Media();
    @Getter
    @Setter
    private javax.servlet.http.Part cover;
    @Getter
    @Setter
    private javax.servlet.http.Part content;
    @Getter
    @Setter
    @EJB
    private MediaFacade mediaFacade;
    @Getter
    @Setter
    private Actor newActor = new Actor();
    @Getter
    @Setter
    private List<Actor> actors = new ArrayList<>();
    
    /**
     * Creates a new instance of CadastroDVDBluRayManagedBean
     */
    public CadastroDVDBluRayManagedBean() {
        
        
    }
    
    public void save(){
 
        try{
            media = new Media();
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
            dp.setName("DVD BLURay");
            media.setDepartment(dp);
            
            mediaFacade.create(media);
            
            media = new Media();
                    
            
 
        }
        catch(Exception e){
           System.out.println("---------------------------------Erro: "+e);
        }
    }
    
    public void addActor(){
        if(media.getActors()==null){
            List<Actor> actors = new ArrayList<>();
            actors.add(newActor);
        }else{
            media.getActors().add(newActor);
        }
    }
    
}
