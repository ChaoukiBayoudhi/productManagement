package tn.example.productExample;

import net.minidev.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Collection;
import java.util.Optional;

@RestController
@RequestMapping("/commands")
public class commandController {
    @Autowired
    private commandRepository commandRepos;
    @Autowired
    private productRepository productRepos;
    @Autowired
    private customerRepository customerRepos;
    @PostMapping("/newcommand")
    public ResponseEntity<?> addCommand(@RequestBody Command cmd) throws URISyntaxException
    {    JSONObject responseJson = new JSONObject();

        try {
            Optional<Product> product = productRepos.findAll().stream()
                    .filter(p -> p.getId() == cmd.getId().getIdProduct())
                    .findFirst();
            if (product.isEmpty())
                throw new Exception("Product Not Found");
                Optional<Customer> customer = customerRepos.findAll().stream()
                        .filter(p -> p.getId() == cmd.getId().getIdCustomer())
                        .findFirst();
                if (customer.isEmpty())
                    throw new Exception("Customer Not Found");
                if(commandRepos.findById(cmd.getId()).isPresent())
                {
                    responseJson.put("status", "Command with that id already exists.");

                    return new ResponseEntity<JSONObject>(responseJson, HttpStatus.BAD_REQUEST);
                }
                    //log.info("Request for adding new command {}", command);
                    cmd.setProd(productRepos.findById(cmd.getId().getIdProduct()).get());
                    cmd.setCust(customerRepos.findById(cmd.getId().getIdCustomer()).get());
                    Command result = commandRepos.save(cmd);
                    return ResponseEntity.created(new URI("/newcommand" + result.getId())).body(result);



        }catch(Exception e) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(e.getMessage());

        }
    }
    @GetMapping("/all")
    public Collection<Command> getAllCommands()
    {
        return commandRepos.findAll();
    }
}
