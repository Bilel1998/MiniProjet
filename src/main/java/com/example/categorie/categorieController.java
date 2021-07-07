package com.example.categorie;

import com.example.categorie.repository.categorieRepository;
import com.example.categorie.service.produitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.categorie.service.categorieService;
import com.example.categorie.model.categorie;
import com.example.categorie.model.produit;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/categorie")
public class categorieController {
    @Autowired
    private categorieRepository categorieRepository;
    private produitService produitService;
    private categorieService categorieService;


    public categorieController(com.example.categorie.service.categorieService categorieService, produitService produitService) {
        this.categorieRepository = categorieRepository;
        this.produitService=produitService;
    }
    @GetMapping("/all")
    public ResponseEntity<List<categorie>> getAllCategories()
    {
        List<categorie> categories=this.categorieRepository.findAll();
        return new ResponseEntity<>(categories, HttpStatus.OK);
    }
  
    @GetMapping("/findById/{id}")
    public  ResponseEntity<categorie> getCategorieById(@PathVariable("id") Long id) {
        List<categorie> categories = this.categorieRepository.findAll();
        categorie categorie = null;
        for (int i = 0; i < categories.size(); i++) {
            if (categories.get(i).getId() == id) {
                categorie = categories.get(i);
            }
        }
        return new ResponseEntity<>(categorie, HttpStatus.OK);
    }
    @PostMapping("/add")
    public ResponseEntity<categorie> addCategorie(@RequestBody categorie categorie)
    {

        categorie newCategorie=this.categorieRepository.save(categorie);
        return new ResponseEntity<>(newCategorie,HttpStatus.CREATED);
    }
    @PutMapping("/update")
    public ResponseEntity<categorie> updateCategorie(@RequestBody categorie categorie)
    {
        Date date= new Date();
        Timestamp ts=new Timestamp(date.getTime());
        categorie.setDateModif(ts);
        categorie updateCategorie=this.categorieRepository.save(categorie);
        return new ResponseEntity<>(updateCategorie,HttpStatus.OK);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteCategorie (@PathVariable("id") Long id)
    {
        this.categorieRepository.deleteById(id);

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
