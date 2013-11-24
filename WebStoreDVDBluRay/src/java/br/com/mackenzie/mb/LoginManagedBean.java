/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.mackenzie.mb;

import br.com.mackenzie.entities.SystemUser;
import br.com.mackenzie.service.SystemUserFacade;
import br.com.mackenzie.util.UserType;
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
public class LoginManagedBean {
    @EJB
    private SystemUserFacade systemUserFacade;
    
    private String userName="";
    private String pass="";
    private boolean validated=false;
    private SystemUser systemUser = new SystemUser();
    /**
     * Creates a new instance of LoginManagedBean
     */
    public LoginManagedBean() {
    }
    
    public String validateUser(){
        systemUser = systemUserFacade.findByUserPass(userName, pass);
        if(systemUser == null){
            systemUser = new SystemUser();
        }else{
            this.validated = true;
            if(systemUser.getUserType()!= null && systemUser.getUserType().equals(UserType.ADMINISTRATOR)){
                return "cadastrarDVDBluRay";
            }
        }
        return "";
        
    }
    
    public String goToCadastroCliente(){
        return "cadastrarCliente";
    }
    
    public String sair(){
        this.systemUser = new SystemUser();
        this.validated = false;
        this.pass = "";
        this.userName = "";
        return "index";
    }
}
