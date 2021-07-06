package com.example.categorie.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.hibernate.annotations.CreationTimestamp;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

@Entity
public class categorie {
    @Id
    @SequenceGenerator(name="id", sequenceName="id" , allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.IDENTITY , generator = "id")
    private Long id;
    @OneToMany( mappedBy = "categorie", fetch = FetchType.LAZY,cascade = CascadeType.REMOVE)
    private List<produit> products ;
    private String nom;
    private int qt;
    @CreationTimestamp
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Column(nullable = false,updatable = false)
    private Timestamp dateCreation;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Timestamp dateModif;

    public categorie(Long id, String nom, int qt) {
        this.id = id;
        this.nom = nom;
        this.qt = qt;
    }

    public categorie() {

    }


    public categorie( String nom, int qt) {
        this.nom = nom;
        this.qt = qt;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<produit> getProducts() {
        return products;
    }

    public void setProducts(List<produit> products) {
        this.products = products;
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
