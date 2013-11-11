/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.mackenzie.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author 71321934
 */
@Getter
@Setter
@Entity
public class Movie extends Product implements Serializable{
    
    private String title;
    private int releaseYear;
    private String genre;
    private String description;
    private byte[] coverImage;
    @ManyToMany
    private List<Actor> actors;
    private int duration;
    private String spokenLanguage;
    private List<String> subtitles;
    private MediaType mediaType;
    private byte[] videoFile;

}
