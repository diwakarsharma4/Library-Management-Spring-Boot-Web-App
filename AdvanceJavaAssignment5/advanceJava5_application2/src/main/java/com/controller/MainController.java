package com.controller;

import java.util.List;
import java.util.Scanner;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.view.RedirectView;

import com.dao.AuthorDao;
import com.dao.ProductDao;
import com.model.Author;
import com.model.Product;

import java.net.MalformedURLException;
import java.net.URL;
import java.io.IOException;




@Controller
public class MainController {
	
	@Autowired
	private ProductDao productDao;
	private AuthorDao authorDao;
	
	
	
	@RequestMapping(path = "/redirectTolog", method = RequestMethod.GET)
	public RedirectView redirect(){
		String url = "http://localhost:8080/advanceJava5_application1/";
		RedirectView redirectView = new RedirectView();
		redirectView.setUrl(url);
		return redirectView;
	}
	
	
	//create
	@RequestMapping("/add-product")
	public String addProduct(Model m) {
//		List<Author> authors = authorDao.getAuthors();
//		System.out.println(authors);
		m.addAttribute("title", "add-product");
//		m.addAttribute("authors", authors);
		return "add_product_form";
	}
	
	
	
	//handle add-product 
	@RequestMapping(value="/handle-product", method = RequestMethod.POST)
	public RedirectView handleProduct(@ModelAttribute Product product, HttpServletRequest request) {
		productDao.createProduct(product);
		RedirectView redirectView = new RedirectView();
		redirectView.setUrl(request.getContextPath()+"/");
		return redirectView;
	}
	
	//handle update-product
	@RequestMapping(value="/update-product", method = RequestMethod.POST)
	public RedirectView handleUpdate(@ModelAttribute Product product, HttpServletRequest request) {
		productDao.updateProduct(product);
		RedirectView redirectView = new RedirectView();
		redirectView.setUrl(request.getContextPath()+"/");
		return redirectView;
	}
	
	
	//read
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String read(Model m) {
		List<Product> products = productDao.getProducts();
		m.addAttribute("products", products);
		System.out.println("app2 data : ");
		System.out.println(m);
		
		URL url;
		try {
			url = new URL("http://localhost:8080/advanceJava5_application1/processForm");
		      Scanner sc;
			try {
				sc = new Scanner(url.openStream());
			      StringBuffer sb = new StringBuffer();
			      while(sc.hasNext()) {
			         sb.append(sc.next());
			      }
			      String result = sb.toString();
			      System.out.println(result);
			      result = result.replaceAll("<[^>]*>", "");
			      System.out.println("Contents of the web page: "+result);
			      sc.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	      
		return "index";
	}
	
	
	
	//update 
	@RequestMapping("/update/{productId}")
	public String updateProduct(@PathVariable("productId") int productId, Model model) {
		Product product = this.productDao.getProduct(productId);
		model.addAttribute("product", product);
		return "update_product_form";
	}
	
	
	//delete
	@RequestMapping("/delete/{productId}")
	public RedirectView deleteProduct(@PathVariable("productId") int productId, HttpServletRequest request) {
		this.productDao.deleteProduct(productId);
		RedirectView redirectView = new RedirectView();
		redirectView.setUrl(request.getContextPath()+"/");
		return redirectView;
	}
	
	


}
