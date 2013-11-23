/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.mackenzie.mb;

import br.com.mackenzie.entities.Customer;
import br.com.mackenzie.entities.Media;
import br.com.mackenzie.service.CustomerFacade;
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
public class CadastroClienteManagedBean {
    @EJB
    private CustomerFacade customerFacade;
    
    Customer customer = new Customer();
    Media media = new Media();
    /**
     * Creates a new instance of CadastroCliente
     */
    public CadastroClienteManagedBean() {
    }
    
    public void cadastrarCliente(){
        
        customerFacade.create(customer);
        
    }
    
}
