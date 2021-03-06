


package com.slowlife.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.slowlife.entity.Article;
import com.slowlife.entity.FruitsLegumes; 
import com.slowlife.entity.Artisant;
import com.slowlife.entity.Commercant;
import com.slowlife.entity.Producteur;
import com.slowlife.service.ArticleService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class ArticleController {
	
	@Autowired
	ArticleService aServ;
	
	
	@RequestMapping(value="/addArticle", method = RequestMethod.POST )
	public void add(@RequestBody Article a) {
		aServ.save(a);
	}
	
	@DeleteMapping(value="/delArticle/{id}")
	public void delete(@PathVariable int id) {
		aServ.delete(id);
	}
	
	@GetMapping(value="/Articles")
	public List<Article> findAll() {
		return aServ.findAll(); 
	}
	
	@GetMapping(value="/Article/{id}")
	public Article findById(@PathVariable int id)  {
		return aServ.findById(id); 
	}
	
	@RequestMapping(value="/findArticles/{nom}/{ville}",method = RequestMethod.GET)
	public List<Article> findProdByNom(@PathVariable String nom, @PathVariable String ville)  {
		List<Article> listArticlesProd = aServ.findProdByNomAndVille(nom, ville);
		List<Article> listArticlesArt = aServ.findArtByNomAndVille(nom, ville);
		List<Article> listArticlesCom = aServ.findComByNomAndVille(nom, ville);
		List<Article> listArticles =  new ArrayList<Article>();
		listArticles.addAll(listArticlesProd);
		listArticles.addAll(listArticlesArt);
		listArticles.addAll(listArticlesCom);
		
		
		return listArticles;
	}
	
	
	@RequestMapping(value="/findArticlesByVille/{ville}",method = RequestMethod.GET)
	public List<Article> findProdByVille(@PathVariable String ville)  {
		List<Article> listArticlesProd = aServ.findProdByVille(ville);
		List<Article> listArticlesArt = aServ.findArtByVille(ville);
		List<Article> listArticlesCom = aServ.findComByVille(ville);
		List<Article> listArticles =  new ArrayList<Article>();
		listArticles.addAll(listArticlesProd);
		listArticles.addAll(listArticlesArt);
		listArticles.addAll(listArticlesCom);
		
		
		return listArticles;
	}
	

	@RequestMapping(value="/getFruitsLegumEnum",method = RequestMethod.GET)
	public List<String> getFruitsLegumEnum()  {
		List<String> ListesFruitsLegumes = new ArrayList<String>();
		for(FruitsLegumes f:FruitsLegumes.values()) {
			ListesFruitsLegumes.add(String.join(" ", f.toString().split("XX", 4)));
		}
		return ListesFruitsLegumes;
	}
	
	@RequestMapping(value="/findarticlebyprod",method = RequestMethod.POST)
	public List<Article> findByProducteur(@RequestBody Producteur p)  {
		return aServ.findByProducteur(p);
	}
	@RequestMapping(value="/findarticlebyart",method = RequestMethod.POST)
	public List<Article> findByArtisant(@RequestBody Artisant art)  {
		return aServ.findByArtisant(art);
	}
	@RequestMapping(value="/findarticlebycom",method = RequestMethod.POST)
	public List<Article> findByCommercant(@RequestBody Commercant c)  {
		return aServ.findByCommercant(c);
	}
	
	
	
}
