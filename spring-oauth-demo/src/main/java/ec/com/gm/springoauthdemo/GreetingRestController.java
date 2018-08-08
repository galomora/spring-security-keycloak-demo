package ec.com.gm.springoauthdemo;

import org.keycloak.adapters.springsecurity.client.KeycloakRestTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingRestController {
	
	private static final String BOOKS_SERVICE_URL = "http://localhost:28080/books";
	
	
	
	@Autowired KeycloakRestTemplate keycloakRestTemplate; 
	
	@RequestMapping (method = RequestMethod.GET, path="/greeting")
	@CrossOrigin
	public Greeting salute () {
		return new Greeting (1L, "Hello world");
	}
	
	@RequestMapping (method = RequestMethod.GET, path="/books")
	@CrossOrigin
	public String getProducts () {
		ResponseEntity<Object>response = keycloakRestTemplate.getForEntity(BOOKS_SERVICE_URL, Object.class);
		return response.getBody().toString();
	}
}
