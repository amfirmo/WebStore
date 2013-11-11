/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.mackenzie.entities;

/**
 *
 * @author 71321934
 */
public enum MediaType {
    
    DVD(1),BLURAY(2);
    
    private int value;
    
    private MediaType(int receivedValue){
        value = receivedValue;
    }

    public static MediaType getBLURAY() {
        return BLURAY;
    }
    
    public static MediaType getDVD() {
        return DVD;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}