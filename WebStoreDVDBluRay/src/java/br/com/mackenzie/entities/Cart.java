/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.mackenzie.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author 71321934
 */
@Getter
@Setter
@Entity
public class Cart implements Serializable {
    
    
    @Id
    @OneToOne
    private Customer customer;
    
    @ManyToMany
    private List<Product> products;
    
    private float totalPrice;
    
}