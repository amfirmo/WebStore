/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.mackenzie.entities;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@TableGenerator(name = "TAB_GEN_ADD", 
                table="TB_SEQ",
                pkColumnName = "SEQ_NAME", 
                pkColumnValue = "ADD", 
                valueColumnName = "SEQ_VAL")
public class Address implements Serializable {
    
    @Id
    @GeneratedValue(strategy =GenerationType.TABLE, generator = "TAB_GEN_ADD")
    private long id;
    
    private String street;
    
    private String number;
    
    private String cep;
    
    private String city;
    
    private String complement;
    
    protected enum AddressType {BILLING, SHIPPING};
    @Enumerated
    private AddressType addressType;
    
}