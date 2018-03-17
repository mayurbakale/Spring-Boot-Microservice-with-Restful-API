package com.product.catalogue.domain;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;

/**Product Bean.
 */
public class Product implements Serializable {

  /**Serial Version ID.    
  */
  private static final long serialVersionUID = 1L;

  @NotNull(message = "Product ID must be specified")
  @NotEmpty(message = "Product ID must be specified")
  private long productId;

  @NotNull(message = "Name must be specified")
  @NotEmpty(message = "Name must be specified")
  private String name;

  private String description;

  @NotNull(message = "Amount must be specified")
  @NotEmpty(message = "Amount must be specified")
  private BigDecimal amount;

  @NotNull(message = "Product Type must be specified")
  @NotEmpty(message = "Product Type must be specified")
  private String productType;

  public Product() {
  }

  /**
  * Constructor for Product.
  * @param productId long
  * @param name String
  * @param description String
  * @param amount BigDecimal
  * @param productType String
  */
  public Product(long productId, String name, String description, 
      BigDecimal amount, String productType) {
    this.productId = productId;
    this.name = name;
    this.description = description;
    this.amount = amount;
    this.productType = productType;
  }

  /**
  * Method getProductId.
  * @return long
  */
  public long getProductId() {
    return productId;
  }

  /**
  * Method setProductId.
  * @param productId long
  */
  public void setProductId(long productId) {
    this.productId = productId;
  }

  /**
  * Method getName.
  * @return String
  */
  public String getName() {
    return name;
  }

  /**
  * Method setName.
  * @param name String
  */
  public void setName(String name) {
    this.name = name;
  }

  /**
  * Method getDescription.
  * @return String
  */
  public String getDescription() {
    return description;
  }

  /**
  * Method setDescription.
  * @param description String
  */
  public void setDescription(String description) {
    this.description = description;
  }

  /**
  * Method getAmount.
  * @return BigDecimal
  */
  public BigDecimal getAmount() {
    return amount;
  }

  /**
  * Method setAmount.
  * @param amount BigDecimal
  */
  public void setAmount(BigDecimal amount) {
    this.amount = amount;
  }

  /**
  * Method getProductType.
  * @return String
  */
  public String getProductType() {
    return productType;
  }

  /**
  * Method setProductType.
  * @param productType String
  */
  public void setProductType(String productType) {
    this.productType = productType;
  }

  /**
  * Method toString.
  * @return String
  */
  @Override
  public String toString() {
    return "Product [productId=" + productId + ", name=" 
        + name + ", description=" + description + ", amount="
        + amount + ", productType=" + productType + "]";
  }

  /**
  * Method hashCode.
  * @return int
  */
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((amount == null) ? 0 : amount.hashCode());
    result = prime * result + ((description == null) ? 0 : description.hashCode());
    result = prime * result + ((name == null) ? 0 : name.hashCode());
    result = prime * result + (int) (productId ^ (productId >>> 32));
    result = prime * result + ((productType == null) ? 0 : productType.hashCode());
    return result;
  }

  /**
  * Method equals.
  * @param obj Object
  * @return boolean
  */
  @Override
  public boolean equals(Object obj) {
    if (obj != null && obj instanceof Product) {
      Product other = (Product) obj;
      if (this == obj) {
        return true;
      }
      if (!amount.equals(other.amount)) {
        return false;
      }
      if (!description.equals(other.description)) {
        return false;
      }
      if (!name.equals(other.name)) {
        return false;
      }
      if (productId != other.productId) {
        return false;
      }
      if (!productType.equals(other.productType)) {
        return false;
      }
      return true;
    }
    return false;
  }
}
