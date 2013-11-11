/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.mackenzie.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import javax.persistence.TableGenerator;

/**
 *
 * @author 71321934
 */
@Entity
@Inheritance(strategy= InheritanceType.SINGLE_TABLE)
@TableGenerator(name="gerador", 
                table="TABLE_SEQ", 
                pkColumnName="SEQUENCE_NAME",
                pkColumnValue="SEQUENCE_USER", 
                valueColumnName="SEQUENCE_VALUE")
public class User {
    
    @Id
    @GeneratedValue(strategy= GenerationType.TABLE, generator="gerador")
    private int id;
    
    private String name;
    
    @ManyToOne
    private Profile profile;
    
    private String userName;
    
    private String passWord;
}
