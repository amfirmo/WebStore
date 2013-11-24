/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.mackenzie.entities;

import br.com.mackenzie.util.UserType;
import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@DiscriminatorValue(value="C")
public class Customer extends SystemUser implements Serializable{

    public Customer() {
        this.setUserType(UserType.CUSTOMER);
    }
    private String phoneNumber;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "customer")
    private Address address = new Address();
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "customer")
    private Address billingAddress = new Address();
}