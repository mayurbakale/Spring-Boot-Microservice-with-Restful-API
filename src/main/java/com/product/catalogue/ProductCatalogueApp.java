package com.product.catalogue;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

/**Spring BootStrap Application Class for Product Catalogue MicroService.
 */
@SpringBootApplication
@PropertySource("app.properties")
public class ProductCatalogueApp {
  
  /**
  * Method main.
  * @param args String[]
  */
  public static void main(String[] args) {
    SpringApplication.run(ProductCatalogueApp.class, args);
  }

}

