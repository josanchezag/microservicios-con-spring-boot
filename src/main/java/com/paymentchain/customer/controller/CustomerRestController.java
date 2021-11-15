package com.paymentchain.customer.controller;

import com.paymentchain.customer.entities.Customer;
import com.paymentchain.customer.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerRestController {

    @Autowired
    CustomerRepository customerRepository;

    @GetMapping()
    public List<Customer> list(){

        return  customerRepository.findAll();
    }

    @GetMapping("/{id}")
    public Customer get(@PathVariable String id){

        return customerRepository.getById(Long.parseLong(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> put(@PathVariable String id, @RequestBody Customer input){
        Customer result=customerRepository.save(input);
        return ResponseEntity.ok(result);
    }

    @PostMapping
    public ResponseEntity<?> pos(@RequestBody Customer input){
        Customer result=customerRepository.save(input);
        return ResponseEntity.ok(result);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable String id){
        customerRepository.deleteById(Long.parseLong(id));
        return ResponseEntity.ok("Respuesta Ok");
    }
}
