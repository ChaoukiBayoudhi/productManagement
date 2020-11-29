package tn.example.productExample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Collection;

@RestController
@RequestMapping("/customers")
public class customerController {
    @Autowired
    private customerRepository repository;
    @GetMapping("/all")
    public Collection<Customer> Toys() {
        return repository.findAll();
    }
    @PostMapping("/newcustomer")
    public ResponseEntity<Customer> addToy(@RequestBody Customer customer) throws URISyntaxException {
        //log.info("Request for adding new customer {}", customer);
        Customer result = repository.save(customer);
        return ResponseEntity.created(new URI("/newcustomer" + result.getId())).body(result);
    }
}
