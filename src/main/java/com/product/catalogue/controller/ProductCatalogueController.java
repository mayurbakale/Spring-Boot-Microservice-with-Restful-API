package com.product.catalogue.controller;

import com.product.catalogue.domain.Product;
import com.product.catalogue.repository.ProductCatalogueRepository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**Spring Controller Class for Product Catalogue Microservice.
 */
@RestController
@RequestMapping("/productCatalogue")
public class ProductCatalogueController {
  
  @Autowired
  ProductCatalogueRepository repo;

  /**
   * Controller Method to add the Product into the Catalogue Repository.
   * @param prd Product
   * @return ResponseEntity
   */
  @PostMapping(path = "/add",consumes = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<String> addProduct(@RequestBody Product prd) {
    try {   
      //repo.insertProduct(prd);
      repo.save(prd);
    } catch (Exception e) {
      return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
    }
    return new ResponseEntity<>("Product is added to the Catalogue",HttpStatus.OK);
  }
  
  /**
   * Controller Method to delete the Product from the Catalogue Repository.
   * @param productName String
   * @return ResponseEntity
   */
  @GetMapping(path = "/delete/{productName}")
  public ResponseEntity<String> deleteProduct(@PathVariable String productName) {
    try {
      //repo.deleteProduct(productName);
      repo.delete(productName);
    } catch (Exception e) {
      return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
    }
    return new ResponseEntity<>("Product is removed from the Catalogue",HttpStatus.OK);
  }
  
  /**
   * Controller Method to delete all the Products from the Catalogue Repository.
   * @return ResponseEntity
   */
  @GetMapping(path = "/deleteAll")
  public ResponseEntity<String> deleteAllProducts() {
    try {
      repo.deleteAll();
    } catch (Exception e) {
      return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
    }
    return new ResponseEntity<>("All Products Removed From the Catalogue",HttpStatus.OK);
  }
  
  /**
   * Controller Method to retrieve the Product by product name from the Catalogue Repository.
   * @param productName String
   * @return ResponseEntity 
   */
  @GetMapping(path = "/get/{productName}", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<Object> retrieveProduct(@PathVariable String productName) {
    Optional<Product> prd = null;
    try {
      //prd = repo.retrieveProduct(productName);
      prd = repo.findByName(productName);
    } catch (Exception e) {
      return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
    }
    return new ResponseEntity<>(prd.get(),HttpStatus.OK);
  }
  
  /**
   * Controller Method to retrieve all the Products from the Catalogue Repository.
   * @return ResponseEntity
   */
  @GetMapping(path = "/getAll", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<Object> retrieveAllProducts() {
    List<Product> prd = null;
    try {
      //prd = repo.retrievAllProducts();
      prd = repo.findAll();
      if (!prd.isEmpty()) {
        return new ResponseEntity<>(prd,HttpStatus.OK);
      } else {
        return new ResponseEntity<>("No Products Found in the Catalogue",HttpStatus.OK);
      }
    } catch (Exception e) {
      return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
    }
  }    
}
