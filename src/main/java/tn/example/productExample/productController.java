package tn.example.productExample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Collection;

@RestController
@RequestMapping("/products")
public class productController {
    @Autowired
    private productRepository repository;
    @GetMapping("/all")
    public Collection<Product> Toys() {
        return repository.findAll();
    }
    @PostMapping("/newproduct")
    public ResponseEntity<Product> addToy(@RequestBody Product product) throws URISyntaxException {
        //log.info("Request for adding new product {}", product);
        Product result = repository.save(product);
        return ResponseEntity.created(new URI("/newproduct" + result.getId())).body(result);
    }
}
