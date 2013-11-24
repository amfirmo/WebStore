/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.mackenzie.util;

import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Andre
 */
public enum UserType {
    
    CUSTOMER, ADMINISTRATOR;
    @Getter @Setter
    private String descricao;
}
