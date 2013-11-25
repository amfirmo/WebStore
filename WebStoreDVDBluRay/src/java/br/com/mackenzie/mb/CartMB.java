/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.mackenzie.mb;

import br.com.mackenzie.entities.Product;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import lombok.Getter;
import lombok.Setter;
import org.apache.jasper.tagplugins.jstl.ForEach;

/**
 *
 * @author Andre
 */
@Setter @Getter
@ManagedBean
@SessionScoped
public class CartMB {
    
    private List<Product> produtos = new ArrayList<>();
    /**
     * Creates a new instance of CartMB
     */
    public CartMB() {
    }
    
    public void addProduct(Product product){
        this.produtos.add(product);
    }
    
    public void removeProduct(Product product){
        this.produtos.remove(product);
    }
    
    public int getQuantidade(){
        return produtos.size();
    }
    
    public String goHome(){
        return "index";
    }
    
    public double getValorTotal(){
        double totalPrice = 0;
        for (Product product : produtos) {
            totalPrice += product.getPrice();
        }
        return totalPrice;
    }
    
}
