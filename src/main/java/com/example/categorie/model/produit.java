package com.example.categorie.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.context.annotation.Configuration;
import com.example.categorie.model.categorie;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
public class produit {
    @Id
    @SequenceGenerator(name="id", sequenceName="id" , allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.IDENTITY , generator = "id")
    private Long id;
    @ManyToOne
    @JsonIgnore
    @JoinColumn(name="categorie_id",referencedColumnName = "id")
    private categorie categorie;
    private String nom;
    private int qt;
    private boolean disponible;
    @CreationTimestamp
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Column(nullable = false,updatable = false)
    private Timestamp dateCreation;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Timestamp dateModif;

    public produit() {
    }

    @Override
    public String toString() {
        return "produit{" +
                "id=" + id +
                ", categorie=" + categorie +
                ", nom='" + nom + '\'' +
                ", qt=" + qt +
                ", disponible=" + disponible +
                ", dateCreation=" + dateCreation +
                ", dateModif=" + dateModif +
                '}';
    }

    public produit(com.example.categorie.model.categorie categorie, String nom, int qt, boolean disponible) {
        this.categorie = categorie;
        this.nom = nom;
        this.qt = qt;
        this.disponible = disponible;
    }

    public produit(categorie categorie, String nom, int qt, boolean disponible, Timestamp dateCreation, Timestamp dateModif) {
        this.categorie = categorie;
        this.nom = nom;
        this.qt = qt;
        this.disponible = disponible;
        this.dateCreation = dateCreation;
        this.dateModif = dateModif;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public categorie getCategorie() {
        return categorie;
    }

    public void setCategorie(categorie categorie) {
        this.categorie = categorie;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getQt() {
        return qt;
    }

    public void setQt(int qt) {
        this.qt = qt;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    public Timestamp getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(Timestamp dateCreation) {
        this.dateCreation = dateCreation;
    }

    public Timestamp getDateModif() {
        return dateModif;
    }

    public void setDateModif(Timestamp dateModif) {
        this.dateModif = dateModif;
    }
}
