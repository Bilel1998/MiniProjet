package com.example.categorie;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.categorie.service.produitService;
import com.example.categorie.model.produit;
import com.example.categorie.repository.categorieRepository;
import com.example.categorie.repository.produitRepository;
import com.example.categorie.model.categorie;

import java.sql.Timestamp;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/produit")
public class produitController {
    @Autowired
    private produitService produitService;
    @Autowired
    private categorieRepository categorieRepository;
    @Autowired
    private produitRepository produitRepository;
    public produitController() {
    }
    public produitController(produitService produitService) {
        this.produitService = produitService;
    }
    @GetMapping("/all/{id}")
    public ResponseEntity<List<produit>> getAllProduits(@PathVariable("id") Long idC)
    {
        List<produit> produits=this.produitService.findAllproduits();
      //  for(int i=0;i<produits.size();i++)
        {
         //   if(produits.get(i).getCategorie().getId()!=idC)
            {
           //     produits.remove(i);
            }
        }
        Iterator<produit> it=produits.iterator();
        while (it.hasNext())
        {
            produit prod= it.next();

            if(prod.getCategorie().getId() != idC)
                it.remove();
        }
        return new ResponseEntity<>(produits, HttpStatus.OK);
    }
    @PostMapping("/add/{id}")
    public ResponseEntity<produit> addProduit(@RequestBody produit produit,@PathVariable("id") Long id)
    {
        categorie cat=categorieRepository.findCategorieById(id);
        produit.setCategorie(cat);
        produit newProduit=this.produitService.addProduit(produit);
        return new ResponseEntity<>(newProduit,HttpStatus.CREATED);
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<produit> updateProduit(@RequestBody produit produit,@PathVariable("id") Long id)
    {
        Date date= new Date();
        Timestamp ts=new Timestamp(date.getTime());
        produit.setDateModif(ts);
        categorie cat=this.categorieRepository.getById(id);
        produit.setCategorie(cat);
        produit updateProduit= this.produitRepository.save(produit);
        return new ResponseEntity<>(updateProduit,HttpStatus.OK);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteProduit (@PathVariable("id") Long id)
    {
        this.produitService.deleteProduit(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
