package com.example.categorie.repository;
import com.example.categorie.model.categorie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface categorieRepository extends JpaRepository<categorie,Long> {
    categorie findCategorieById(Long id);
}
