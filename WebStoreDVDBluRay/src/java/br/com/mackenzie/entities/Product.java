/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.mackenzie.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
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
@Inheritance(strategy= InheritanceType.TABLE_PER_CLASS)
public class Product implements Serializable{
    
    @Id
    private int id;
    
    private String name;
    
    private float price;
    
    @OneToMany
    private List<Comment> comments;
    
    @OneToOne
    private Department department;
    
}