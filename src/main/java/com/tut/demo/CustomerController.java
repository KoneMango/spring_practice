package com.tut.demo;

import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    private final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping
    public ResponseEntity<Customer> addCustomer(@RequestBody Customer customer){
        Customer savedCustomer = customerService.addCustomer(customer);

        return ResponseEntity.status(HttpStatus.CREATED).body(savedCustomer);
    }

    @PostMapping("/update/{customerId}")
    public ResponseEntity<Customer> updateCustomer(@PathVariable String customerId, @RequestBody Customer updateCustomer) throws ChangeSetPersister.NotFoundException {
        Customer updatedCustomer = customerService.updateCustomer(customerId, updateCustomer);

        return ResponseEntity.status(HttpStatus.CREATED).body(updatedCustomer);
    }

    @GetMapping
    public List<Customer> listCustomer(){
        return customerService.listCustomer();
    }

    @DeleteMapping("/{customerId}")
    public void deleteCustomer(@PathVariable String customerId){
        customerService.removeCustomer(customerId);
    }
}
