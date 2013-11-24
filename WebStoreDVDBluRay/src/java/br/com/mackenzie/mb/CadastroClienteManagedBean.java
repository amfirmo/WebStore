/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/

package br.com.mackenzie.mb;

import br.com.mackenzie.entities.Address;
import br.com.mackenzie.entities.Customer;
import br.com.mackenzie.entities.Cidade;
import br.com.mackenzie.entities.Estado;
import br.com.mackenzie.service.CidadeFacade;
import br.com.mackenzie.service.CustomerFacade;
import br.com.mackenzie.service.EstadoFacade;
import br.com.mackenzie.util.AddressType;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
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
    @EJB
    private EstadoFacade estadoFacade;
    @EJB
    private CidadeFacade cidadeFacade;
    
    private List<Estado> estados = new ArrayList<>();
    private List<Cidade> cidades = new ArrayList<>();
    //private Estado estadoSelecionado = new Estado();
    //private Cidade cidadeSelecionada = new Cidade();
    
    Customer customer = new Customer();
    /**
     * Creates a new instance of CadastroCliente
     */
    public CadastroClienteManagedBean() {
        
    }
    
    public String cadastrarCliente(){
        try{
            customer.setAddress((Address) customer.getBillingAddress().clone());
        }catch(CloneNotSupportedException cnse){
            System.err.println(cnse);
        }
        customer.getAddress().setCustomer(customer);
        customer.getBillingAddress().setCustomer(customer);
        
        customer.getAddress().setAddressType(AddressType.SHIPPING);
        customer.getBillingAddress().setAddressType(AddressType.BILLING);
        
        customerFacade.create(customer);
        
        return goHome();
    }
    
    public void carregarCidades(){
        cidades = new ArrayList<>();
        cidades = cidadeFacade.findByEstado(this.customer.getBillingAddress().getStateAddress());
    }
    
    @PostConstruct
    public void init(){
        estados = estadoFacade.findAll();
    }
    
    public String goHome(){
        return "index";
    }
}
