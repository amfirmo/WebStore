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
public class Actor implements Serializable {
    
    @Id
    private int id;
    private String name;
    
}
