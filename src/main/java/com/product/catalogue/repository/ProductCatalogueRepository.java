package com.product.catalogue.repository;

import com.product.catalogue.domain.Product;
import com.product.catalogue.exception.ProductException;
import java.util.List;
import java.util.Optional;

import org.springframework.dao.DataAccessException;
import org.springframework.data.mongodb.repository.MongoRepository;

/**Repository Interface for Product Catalogue Microservice.
 */
public interface ProductCatalogueRepository extends MongoRepository<Product, String>{
  /**
  * Method insertProduct.
  * @param prd Product
  * @throws ProductException - Product Exception
  */
  //void insertProduct(Product prd) throws ProductException;
  Product save(Product prd);

  /**
  * Method deleteProduct.
  * @param productName String
  * @throws ProductException - Product Exception
  * @throws DataAccessException - DataAccess Exception
  */
  //void deleteProduct(String productName) throws DataAccessException, ProductException;
  void delete(String name);

  /**
  * Method retrieveProduct.
  * @param productName String
  * @return Product
  * @throws ProductException - Product Exception
  */
  //Product retrieveProduct(String productName) throws ProductException;
  Optional<Product> findByName(String name);

  /**
  * Method retrievAllProducts.
  * @return List
  * @throws ProductException - Product Exception
  */
  //List<Product> retrievAllProducts() throws ProductException;
  List<Product> findAll();

  /**Method to delete All the Products in the Catalogue. 
  * @throws ProductException - Product Exception
  * @throws DataAccessException - DataAccess Exception
  */
  //void deleteAll() throws DataAccessException, ProductException;
  void deleteAll();
}
