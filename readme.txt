The Product Catalogue is developed focusing on the single responsibility principle of the Microservice domain. The module concentrates on the addition, deletion and retrieval of the Products in the Catalogue.

The Embedded In-Memory Database used is H2 database focusing on the performance consideration of the H2 databases and the RDBMS principle.

The module is developed using Spring Boot with REST webservices and H2 database queries for data storage. Spring Boot is used taken into consideration the in-built performance optimization. It also handles the lifecycle of the Spring Beans transparently.

The H2 database details are stored in the app.properties file placed in the classpath.

Below are the details to test the Microservice:

1) The Product table is created in the schema.sql file. An product is inserted using the data.sql file. This two files are in the classpath.
2) To perform the various operations: 
	i) Retrieve All the Products in the Catalogue:
	curl -s -X GET -H 'Content-Type: application/json' http://localhost:8080/productCatalogue/getAll
	
	ii) To add a new Product in the Catalogue, for example: Product Name - XYZ
	curl -s -X POST -H 'Content-Type: application/json' -d '{"productId":"2","name":"XYZ","description":"DescriptionXYZ","amount":"30","productType":"TypeXYZ"}' http://localhost:8080/productCatalogue/add
	
	iii) To retrieve a particular product, for example: the already inserted product with Product Name - ABC
	curl -s -X GET -H 'Content-Type: application/json' http://localhost:8080/productCatalogue/get/ABC
	
	iv) To delete a particular product, for example: the Product with Product Name - XYZ
	curl -s -X GET -H 'Content-Type: application/json' http://localhost:8080/productCatalogue/delete/XYZ
	
	v) To delete all the products from the catalogue, 
	curl -s -X GET -H 'Content-Type: application/json' http://localhost:8080/productCatalogue/deleteAll
	
The Developed Microservice is tested with the code checker tools to find the Code Quality issues along, bugs and Styling issues with tools, for example - Google Code Pro Analytix, CheckStyle.

The Tomcat port can be changed by changing the port number in the application.yml placed in the classpath

To enable debug logs, set the following DEBUG logs level in the application.yml file:
logging.level:
  com.product.catalogue: DEBUG
  
Build Tool used: Maven

