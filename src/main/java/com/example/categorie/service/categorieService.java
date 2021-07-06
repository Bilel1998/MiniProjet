package com.example.categorie.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.categorie.repository.categorieRepository;
import com.example.categorie.model.categorie;
import com.example.categorie.exception.categoryNotFoundException;
import java.util.List;

@Service
public class categorieService {
    private categorieRepository categorieRepository;
    @Autowired
    public categorieService(categorieRepository categorieRepository){this.categorieRepository=categorieRepository;}
    public categorie addCategorie(categorie categorie){return this.categorieRepository.save(categorie);}
    public List<categorie> findAllCategories(){return this.categorieRepository.findAll();}
    public categorie updateCategorie(categorie categorie){return this.categorieRepository.save(categorie);}
    public void deleteCategorie(Long id){this.categorieRepository.deleteById(id);}
    public categorie findCategorieById(Long id){
        return this.categorieRepository.findCategorieById(id);
    }
}
