package com.product.catalogue.exception;

/**Exception class for Product Catalogue MicroService.
 */
public class ProductException extends Exception {

  private String message;

  /**Serial Version ID.
 */
  private static final long serialVersionUID = 1L;

  /**
 * Constructor for ProductException.
 * @param message String
 */
  public ProductException(String message) {
    super(message);
    this.message = message;
  }

  /**
  * Method getMessage.
  * @return String
  */
  public String getMessage() {
    return message;
  }

  /**
  * Method setMessage.
  * @param message String
  */
  public void setMessage(String message) {
    this.message = message;
  }

  /**
  * Method toString.
  * @return String
  */
  @Override
  public String toString() {
    return "ProductException [message=" + message + "]";
  }
}
