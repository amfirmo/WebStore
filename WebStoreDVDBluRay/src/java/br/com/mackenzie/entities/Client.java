/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.mackenzie.entities;

import java.io.Serializable;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
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
@DiscriminatorValue(value="C")
public class Client extends SystemUser implements Serializable{
    
    @OneToOne
    private Address address;
    @OneToOne
    private Address billingAddress;
    private String phoneNumber;

    public Client() {
    }

    public Client(String name, 
                  Profile profile, 
                  String userName, 
                  String password, 
                  Address address, 
                  Address billingAddress,
                  String phoneNumber){
        
        this.setName(name);
        this.setProfile(profile);
        this.address = address;
        this.billingAddress=billingAddress;
        this.setPassWord(password);
        this.setUserName(userName);
        this.phoneNumber=phoneNumber;
    }
}
