/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.mackenzie.entities;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author 71321934
 */
@Setter
@Getter
@Entity
public class Comment implements Serializable {
    
    @Id
    private long id;
    
    @ManyToOne
    private Product product;
    
    private String description;
    
    private byte rating;
    
    @ManyToOne
    private Client client;
    
}
