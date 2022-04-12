package com.usa.ciclo3.ciclo3.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "Game")
/**
 * @version Entidad de la tabla Game
 */
public class Game implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    /**
     * @param id Identificador autocreado para la tabla Game.
     */
    private Integer id;
    /**
     * @param name Nombre del juego.
     */
    private String name;
    /**
     * @param developer Nombre de la desarroladora del juego.
     */
    private String developer;
    /**
     * @param year Año de publicacion del juego.
     */
    private Integer year;
    /**
     * @param description Descripcion del juego.
     */
    private String description;

    @ManyToOne
    @JoinColumn(name="categoryId")
    @JsonIgnoreProperties("games")
    /**
     * @param category pinta la relacion entre la tabla Game y Category.
     */
    private Category category;

    @OneToMany(cascade = {CascadeType.PERSIST}, mappedBy = "game")
    @JsonIgnoreProperties({"game","client"})
    /**
     * @param messages pinta la relacion entre la tabla Game y Message.
     */
    private List<Message> messages;

    @OneToMany(cascade = {CascadeType.PERSIST}, mappedBy = "game")
    @JsonIgnoreProperties({"game","message"})
    /**
     * @param reservation pinta la relacion entre la tabla Game y Reservation.
     */
    public List<Reservation> reservations;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDeveloper() {
        return developer;
    }

    public void setDeveloper(String developer) {
        this.developer = developer;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public List<Message> getMessages() {
        return messages;
    }

    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }

    public List<Reservation> getReservations() {
        return reservations;
    }

    public void setReservations(List<Reservation> reservations) {
        this.reservations = reservations;
    }

}
