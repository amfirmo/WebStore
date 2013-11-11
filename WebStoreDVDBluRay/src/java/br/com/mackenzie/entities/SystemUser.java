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
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
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
@Inheritance(strategy= InheritanceType.TABLE_PER_CLASS)
@TableGenerator(name="gerador", 
                table="TABLE_SEQ", 
                pkColumnName="SEQUENCE_NAME",
                pkColumnValue="SEQUENCE_USER", 
                valueColumnName="SEQUENCE_VALUE")
public class SystemUser implements Serializable {
    
    @Id
    @GeneratedValue(strategy= GenerationType.TABLE, generator="gerador")
    private int id;
    
    private String name;
    
    @ManyToOne
    private Profile profile;
    
    private String userName;
    
    private String passWord;

    public SystemUser() {
    }
    
    public SystemUser(String name, Profile profile, String userName, String password){
        
        this.name = name;
        this.profile = profile;
        this.userName = userName;
        this.passWord = password;
        
    }
    
    
}