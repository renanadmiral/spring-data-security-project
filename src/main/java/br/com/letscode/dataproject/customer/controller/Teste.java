package br.com.letscode.dataproject.customer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.letscode.dataproject.customer.dto.CustomerDTO;
import br.com.letscode.dataproject.customer.repository.CustomerRepository;

@RestController
@RequestMapping("/costumer")
public class Teste {
    
    @Autowired
    private CustomerRepository cRep;

    @GetMapping
    public CustomerDTO getCostumer() {
        return CustomerDTO.convert(cRep.findById(1L).get());
    }
}
