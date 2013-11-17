/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.mackenzie.entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *1 - Anotação @Entity
 *2 - Anotação @Id
 *3 - Construtores
 *4 - Implements Serializable
 *5 - Generated Value 
 *6 - Getters e Setters 
 * @author 71321934
 */
@Entity
@Table(name = "TB_MEDIA")
public class MediaOld implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    
    private String titulo;
    
    private String sinopse;
    
    private int ano;
    
    private String languages;

    public MediaOld(String titulo, String sinopse, int ano, String languages) {
        this.titulo = titulo;
        this.sinopse = sinopse;
        this.ano = ano;
        this.languages = languages;
    }

    public MediaOld() {
    }
    
    public String getTitulo() {
        return titulo;
    }

    public int getId() {
        return id;
    }

    public String getSinopse() {
        return sinopse;
    }

    public int getAno() {
        return ano;
    }

    public String getLanguages() {
        return languages;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setSinopse(String sinopse) {
        this.sinopse = sinopse;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public void setLanguages(String languages) {
        this.languages = languages;
    }

    public void setId(int id) {
        this.id = id;
    }
}
