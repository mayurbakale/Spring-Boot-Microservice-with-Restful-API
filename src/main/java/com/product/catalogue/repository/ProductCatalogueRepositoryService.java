package com.product.catalogue.repository;

import com.product.catalogue.domain.Product;
import com.product.catalogue.exception.ProductException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DuplicateKeyException;
//import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

/**Repository Service Class for Product Catalogue Microservice.
 */
@Repository
class ProductCatalogueRepositoryService {//implements ProductCatalogueRepository {

  @Autowired
  JdbcTemplate jdbcTemplate;

  /**
  * Method insertProduct.
  * @param prd Product
  * @throws ProductException - Product Exception
  * @see com.product.catalogue.repository.ProductCatalogueRepository#insertProduct(Product)
  */
  public void insertProduct(Product prd) throws ProductException {
    try {
      String productInsertSql = 
          "insert into product(productId,name,description,amount,productType) values(?,?,?,?,?)";
      jdbcTemplate.update(productInsertSql, new Object[]{prd.getProductId(),
          prd.getName(),prd.getDescription(),prd.getAmount(),prd.getProductType()});
    } catch (Exception e) {
      if (e instanceof DuplicateKeyException) {
        throw new ProductException("Cannot add the product as it already exists.");        
      } else {
        throw new ProductException(e.getMessage());
      }
      
    }
  }

  /**
  * Method deleteProduct.
  * @param productName String
  * @throws ProductException - Product Exception
  * @throws DataAccessException - DataAccess Exception
  * @see com.product.catalogue.repository.ProductCatalogueRepository#deleteProduct(String)
  */
  public void deleteProduct(String productName) throws DataAccessException, ProductException {
    try {
      if (retrieveProduct(productName) != null) {
        String productDeleteSql = "delete from product where name = ?";
        jdbcTemplate.update(productDeleteSql, new Object[]{productName});
      }
    } catch (Exception e) {
      if (e instanceof ProductException) {
        throw new ProductException("Cannot Delete Product with Name " 
        + productName + " as it does not exist");
      } else {
        throw new ProductException(e.getMessage());
      }
    }
  }

  /**
  * Method retrieveProduct.
  * @param productName String
  * @return Product
  * @throws ProductException - Product Exception
  * @see com.product.catalogue.repository.ProductCatalogueRepository#retrieveProduct(String)
  */
  public Product retrieveProduct(String productName) throws ProductException {
    Product product = null;
    try {
      String retireveProductSql = "select * from product where name = ?";
      product = jdbcTemplate.queryForObject(retireveProductSql, 
          new Object[]{productName}, new RowMapper<Product>() {

            public Product mapRow(ResultSet rs, int rownum)
                  throws SQLException {
              Product prd = new Product();
              prd.setProductId(rs.getLong("productId"));
              prd.setName(rs.getString("name"));
              prd.setDescription(rs.getString("description"));
              prd.setAmount(rs.getBigDecimal("amount"));
              prd.setProductType(rs.getString("productType"));
              return prd;
            }
          });
    } catch (Exception e) {
      throw new ProductException("No Product Found.");
    }
    return product;
  }

  /**
  * Method retrievAllProducts.
  * @return List
  * @throws ProductException - Product Exception 
  * @see com.product.catalogue.repository.ProductCatalogueRepository#retrievAllProducts()
  */
  public List<Product> retrievAllProducts() throws ProductException {
    List<Product> productList = null;
    try {
      String retireveAllProductSql = "select * from product";
      productList = jdbcTemplate.query(retireveAllProductSql, new RowMapper<Product>() {

        public Product mapRow(ResultSet rs, int rownum)
                throws SQLException {
            Product prd = new Product();
            prd.setProductId(rs.getLong("productId"));
            prd.setName(rs.getString("name"));
            prd.setDescription(rs.getString("description"));
            prd.setAmount(rs.getBigDecimal("amount"));
            prd.setProductType(rs.getString("productType"));
            return prd;
        }
        
      });
    } catch (Exception e) {
      throw new ProductException(e.getMessage());
    }
    return productList;
  }

  /**
  * Method deleteAll.
  * @throws ProductException - Product Exception 
  * @throws DataAccessException - DataAccess Exception
  * @see com.product.catalogue.repository.ProductCatalogueRepository#deleteAll()
  */
  public void deleteAll() throws DataAccessException, ProductException {
    try {
      if (!retrievAllProducts().isEmpty()) {
        String productDeleteAllSql = "delete from product";
        jdbcTemplate.update(productDeleteAllSql);
      } else {
        throw new ProductException("No Products found in Catalogue for Deletion");
      }
    } catch (Exception e) {
      throw new ProductException(e.getMessage());
    }
  }
}
