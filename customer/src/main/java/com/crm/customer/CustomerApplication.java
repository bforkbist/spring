package com.crm.customer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CustomerApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomerApplication.class, args);
	}

}
/*spring
rest, mvc, security, cloud,aop,spring-boot,....
mvc =
model= real time entity/ object customer, product
view= front end
controller = controls fuctionality of the model and view

@restcontroller = controller + request body
output -> xml/ json
/get/put/post/delete


steps
//work on dependencies
//connect with sever
//connect to database //mysql and h2

// tables-> classes and classes -> tables

//controller for frontend part

//xml configure for beans
//xml configure for application context

//inject data
// class a -> service
// class b -> service
//xml

java annotations

//maven
mvn clean
mvn package
mvn build
mvn run


// repo.
JPA    crud
@autowired
//IOC dependency injection
//DAO (data access object)

//@RestContoller
//@Repository
//@Springapplication


* */