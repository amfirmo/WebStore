/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.mackenzie.entities;

import br.com.mackenzie.util.UserType;
import java.io.Serializable;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author 71321934
 */
@Getter
@Setter
@DiscriminatorValue(value = "A")
@Entity
public class Administrator extends SystemUser implements Serializable{
        private static final long serialVersionUID = 1L;
    
    public Administrator() {
        this.setUserType(UserType.ADMINISTRATOR);
    }
}
