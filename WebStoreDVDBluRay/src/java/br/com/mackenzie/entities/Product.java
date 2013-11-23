/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.mackenzie.entities;

import java.io.Serializable;
import java.util.List;
import javax.annotation.Generated;
import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.TableGenerator;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author 71321934
 */
@Getter
@Setter
@Entity
@Inheritance(strategy= InheritanceType.JOINED)
@DiscriminatorColumn(name = "PRODUCT_TYPE",
                     discriminatorType = DiscriminatorType.STRING,
                     length = 2)
@TableGenerator(name = "TAB_GEN_PRD", 
                table="TB_SEQ",
                pkColumnName = "SEQ_NAME", 
                pkColumnValue = "PRD", 
                valueColumnName = "SEQ_VAL")
public abstract class Product implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "TAB_GEN_PRD")
    private int id;
    private String name;
    private float price;
    @OneToMany
    private List<Comment> comments;
    @ManyToOne
    private Department department;
}