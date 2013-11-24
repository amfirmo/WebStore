/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/

package br.com.mackenzie.mb;

import br.com.mackenzie.entities.Media;
import br.com.mackenzie.service.MediaFacade;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Andre
 */
@Getter
@Setter
@ManagedBean
@RequestScoped
public class PesquisarMediaMB {
    @EJB
    MediaFacade mediaService;
    List<Media> medias = new ArrayList<>();
    String genero = "";
    String titulo = "";
    
    /**
     * Creates a new instance of PesquisarProdutos
     */
    public PesquisarMediaMB() {
    }
    
    @PostConstruct
    public void init(){
        medias = mediaService.findAll();
    }
    
    public void pesquisar(){
        medias = new ArrayList<>();
        medias = mediaService.findByEstado(genero, titulo);
    }
}
