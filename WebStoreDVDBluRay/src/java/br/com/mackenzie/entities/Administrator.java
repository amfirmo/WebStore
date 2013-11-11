/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.mackenzie.entities;

import java.io.Serializable;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 *
 * @author 71321934
 */
@DiscriminatorValue(value = "A")
@Entity
public class Administrator extends SystemUser implements Serializable{
    
}
