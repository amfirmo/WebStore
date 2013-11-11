/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.mackenzie.entities;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author 71321934
 */
@Getter
@Setter
@Entity
public class Address implements Serializable {
    
    @Id
    private long id;
    
    private String street;
    
    private String number;
    
    private String cep;
    
    private String city;
    
    private String complement;
    
    private AddressType addressType;
    
}