/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.mackenzie.mb;

import br.com.mackenzie.entities.Client;
import br.com.mackenzie.entities.SystemUser;
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

    
    private String userName;
    private String pass;
    private boolean validated=false;
    /**
     * Creates a new instance of LoginManagedBean
     */
    public LoginManagedBean() {
    }
    
    public void validateUser(){
        //@TODO validar o usuario
        this.validated = true;
    
    }
    
}
