/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.mackenzie.entities;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.TableGenerator;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author 71321934
 */
@Setter
@Getter
@Entity
@TableGenerator(name = "TAB_GEN_COM", 
                table="TB_SEQ",
                pkColumnName = "SEQ_NAME", 
                pkColumnValue = "COM", 
                valueColumnName = "SEQ_VAL")
public class Comment implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "TAB_GEN_COM")
    private long id;
    
    @ManyToOne
    private Product product;
    
    private String description;
    
    private byte rating;
    
    @ManyToOne
    private Customer customer;
    
}
