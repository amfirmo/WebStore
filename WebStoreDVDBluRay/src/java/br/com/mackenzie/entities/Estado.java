/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.mackenzie.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.TableGenerator;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Andre
 */
@Getter @Setter
@Entity
@TableGenerator(name = "TAB_GEN_EST", 
                table="TB_SEQ",
                pkColumnName = "SEQ_NAME", 
                pkColumnValue = "EST", 
                valueColumnName = "SEQ_VAL")
public class Estado implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator ="TAB_GEN_EST")
    private long id;
    private String nome;
        
    @Override
    public String toString(){
        return getNome();
    }
    @OneToMany(mappedBy = "estado")
    private List<Cidade> cidades = new ArrayList<>();
}
