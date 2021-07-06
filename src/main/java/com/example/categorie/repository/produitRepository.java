package com.example.categorie.repository;
import com.example.categorie.model.produit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface produitRepository extends JpaRepository<produit,Long> {

}
