/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.mackenzie.entities;

import br.com.mackenzie.util.UserType;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.TableGenerator;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author 71321934
 */

@Setter
@Getter
@Entity
@Inheritance(strategy= InheritanceType.JOINED)
@TableGenerator(name = "TAB_GEN_USR", 
                table="TB_SEQ",
                pkColumnName = "SEQ_NAME", 
                pkColumnValue = "USR", 
                valueColumnName = "SEQ_VAL")
@DiscriminatorColumn(name = "DTYPE")
public class SystemUser implements Serializable {
    
    @Id
    @GeneratedValue(strategy= GenerationType.TABLE, generator="TAB_GEN_USR")
    private int id;
    
    private String name;
    
    private String userName;
    
    private String passWord;
    /*@ObjectTypeConverter(name = "USERTYPE", objectType = UserType.class, dataType = String.class, conversionValues = {
		@ConversionValue(objectValue = "CUSTOMER", dataValue = "C"),
		@ConversionValue(objectValue = "ADMINISTRATOR", dataValue = "A") })
    */
    @Enumerated
    @Column(name = "USERTYPE")
    private UserType userType;

    public SystemUser() {
    }
    
}
