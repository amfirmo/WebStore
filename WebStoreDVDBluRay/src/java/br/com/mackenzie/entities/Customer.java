/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.mackenzie.entities;

import java.io.Serializable;
import javax.persistence.DiscriminatorValue;
import javax.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@DiscriminatorValue(value="C")
public class Customer extends SystemUser implements Serializable{

    public Customer() {
    }
    
    private String phoneNumber;
    @OneToOne
    private Address address;
    @OneToOne
    private Address billingAddress;
}