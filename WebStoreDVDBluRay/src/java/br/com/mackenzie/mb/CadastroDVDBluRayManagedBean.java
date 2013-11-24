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
import br.com.mackenzie.util.MediaType;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.servlet.http.Part;
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
    private Part cover;
    private Part content;
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
        InputStream inputSCover = null;
        InputStream inputSContent = null;
        try{
            
            inputSCover = cover.getInputStream();
            inputSContent = content.getInputStream();
            
            byte[] bufferCover = read(inputSCover);
            byte[] bufferContent = read(inputSContent);
            
            media.setCoverImage(bufferCover);
            media.setVideoFile(bufferContent);

            Department dp = new Department();
            dp.setId(1);
            media.setDepartment(dp);
            //TODO vir da pagina
            //smedia.setMediaType(Media.MediaType.DVD);
            
            media.setActors(actors);
            
            mediaFacade.create(media);
            
            media = new Media();
            
            actors = new ArrayList<>();
            
        }
        catch(Exception e){
            System.out.println("---------------------------------Erro: "+e);
        }finally{
            try {
                
                if(inputSCover !=null)
                    inputSCover.close();
                
                if(inputSContent !=null)
                    inputSContent.close();
                
            } catch (IOException ex) {
                Logger.getLogger(CadastroDVDBluRayManagedBean.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public void addActor(){
        actors.add(newActor);
        newActor = new Actor();
    }
    //gambiarra para ter o nome
    private static String getFilename(Part part) {
        for (String cd : part.getHeader("content-disposition").split(";")) {
            if (cd.trim().startsWith("filename")) {
                String filename = cd.substring(cd.indexOf('=') + 1).trim().replace("\"", "");
                return filename.substring(filename.lastIndexOf('/') + 1).substring(filename.lastIndexOf('\\') + 1); // MSIE fix.
            }
        }
        return null;
    }
    
    
    private byte[] read(InputStream input){
        //1GB
        //byte[] buffer = new byte[1073741824];
        //128MB
        byte[] buffer = new byte[134217728];
        byte[] bufferOut = null;
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        try{
            while(true) {
                int n = input.read(buffer);
                if( n < 0 ) break;
                baos.write(buffer,0,n);
            }
            bufferOut = baos.toByteArray();
            
        }catch(IOException e){
            Logger.getLogger(CadastroDVDBluRayManagedBean.class.getName()).log(Level.SEVERE, null, e);
        }finally{
            
        }
        return bufferOut;
    }
    
     public List<MediaType> getMediaTypes(){
        return Arrays.asList(MediaType.values());
    }
     
    public String goHome(){
        return "index";
    }
    
}
