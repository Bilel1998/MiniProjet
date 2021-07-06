package com.example.categorie;

import com.example.categorie.model.categorie;
import com.example.categorie.repository.categorieRepository;
import com.example.categorie.repository.produitRepository;
import org.junit.jupiter.api.Test;
import org.mockito.internal.matchers.Null;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.example.categorie.model.produit;

import java.sql.Time;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@SpringBootTest
class CategorieApplicationTests {

	@Autowired
	private produitRepository produitRepository;
	@Autowired
	private categorieRepository categorieRepository;
	@Test
	public void testCreateProduit()
	{
		//produit prod= new produit( new categorie("c1",10, new Timestamp( 2021, 6, 29,4,4,4,4)),"p11",10,true,new Timestamp( 2021, 6, 29,4,4,4,4),new Timestamp(2021, 6, 29,4,4,4,4));
		produit prod=new produit();
		prod.setId((long)1);
		prod.setCategorie(categorieRepository.getById((long)3));
		prod.setNom("p1");
		prod.setQt(10);
		prod.setDateCreation( new Timestamp( 2021, 6, 29,4,4,4,4));
		produitRepository.save(prod);
	}
	@Test
	public void testCreateCategorie()
	{
		categorie cat= new categorie("c1",10);
		categorieRepository.save(cat);
	}
	@Test
	public void testUpdateProduit()
	{
		produit prod= produitRepository.findById((long)2).get();
		prod.setQt(20);
		produitRepository.save(prod);
	}
	@Test
	public void testUpdateCategorie()
	{
		//categorie cat= categorieRepository.findCategorieById((long)1).get();
		//cat.setQt(20);
		//categorieRepository.save(cat);
	}
	@Test
	public void testDeleteProduit()
	{
		produitRepository.deleteById((long)8);
	}
	@Test
	public void testDeleteCategorie()
	{
		categorieRepository.deleteById((long)1);
	}
	@Test
	public void testFindAllProduits()
	{
		List<produit> prods= produitRepository.findAll();
		System.out.println("La taille est "+prods.size());
	}
	@Test
	public void testFindAllCategories()
	{
		List<categorie> categories= categorieRepository.findAll();
		System.out.println("La taille est "+categories.size());
	}
}
