package com.example.categorie.service;
import com.example.categorie.repository.produitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.categorie.model.produit;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class produitService {
    private produitRepository produitRepository;
    @Autowired
    public produitService(com.example.categorie.repository.produitRepository produitRepository) {
        this.produitRepository = produitRepository;
    }
    public produit addProduit(produit produit){return this.produitRepository.save(produit);}
    public List<produit> findAllproduits(){return this.produitRepository.findAll();}
    public produit updateProduit(produit produit){return this.produitRepository.save(produit);}
    public void deleteProduit(Long id){this.produitRepository.deleteById(id);}
}
