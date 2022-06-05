package com.norma.bankingSystem.apicontrollers;

import com.norma.bankingSystem.business.abstracts.ICustomerService;
import com.norma.bankingSystem.entity.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpHeaders.CONTENT_TYPE;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.http.ResponseEntity.*;
import static org.springframework.web.servlet.support.ServletUriComponentsBuilder.fromCurrentRequest;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1")
public class CustomerController {

    ICustomerService customerService;

    @Autowired
    public void setCustomerService(ICustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/customer/{id}")
    public ResponseEntity<Customer> getById(@PathVariable(value = "id") Long id) {
        return Optional.ofNullable(customerService.getById(id))
                .map(customer -> ok().header(CONTENT_TYPE, APPLICATION_JSON_VALUE).body(customer))
                .orElse(notFound().build());
    }

    @GetMapping("/customer")
    public ResponseEntity<List<Customer>> getAll() {
        return ok().header(CONTENT_TYPE, APPLICATION_JSON_VALUE).body(customerService.getAll());
    }

    @PostMapping("/customer")
    public ResponseEntity<Customer> add(@RequestBody Customer customer) {
        return created(fromCurrentRequest().build().toUri())
                .header(CONTENT_TYPE, APPLICATION_JSON_VALUE)
                .body(customerService.add(customer));
    }

    @PutMapping("/customer/{id}")
    public ResponseEntity<Customer> update(
            @PathVariable(value = "id") Long id, @RequestBody Customer customer) {
        return ok().header(CONTENT_TYPE, APPLICATION_JSON_VALUE)
                .body(customerService.update(id, customer));
    }
}
