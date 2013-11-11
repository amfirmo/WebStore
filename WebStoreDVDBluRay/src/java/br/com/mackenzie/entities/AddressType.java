/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.mackenzie.entities;

/**
 *
 * @author Andre
 */
public enum AddressType {
    
    BILLING(1), SHIPPING(2);
    
    private int addressValue;
    
    private AddressType(int value) {
        addressValue = value;
    }

    public int getAddressValue() {
        return addressValue;
    }

    public void setAddressValue(int addressValue) {
        this.addressValue = addressValue;
    }
}