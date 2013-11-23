/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.mackenzie.entities;

import br.com.mackenzie.util.MediaType;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.ManyToMany;
import lombok.Getter;
import lombok.Setter;
/**
 * @author 71321934
 */
@Getter
@Setter
@Entity
@DiscriminatorValue(value = "MD")
public class Media extends Product implements Serializable{
    
    private String title;
    private int releaseYear=1900;
    private String genre;
    private String description;
    private String coverFileName;
    private byte[] coverImage;
    @ManyToMany(cascade = CascadeType.PERSIST)
    private List<Actor> actors = new ArrayList<>();
    private int duration;
    private String spokenLanguage;
    private String subtitles;
    @Enumerated
    private MediaType mediaType;
    private String videoFileName;
    private byte[] videoFile;
    private String studio;
}
