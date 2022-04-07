package br.com.letscode.dataproject.customer.controller;

import br.com.letscode.dataproject.customer.dto.CustomerDTO;
import br.com.letscode.dataproject.customer.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.awt.*;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    CustomerRepository customerRepository;

    // @GetMapping
    // public CustomerDTO getCustomers(){
    //     return CustomerDTO.convert(
    //             customerRepository.findById(1L).get());
    // }

    @GetMapping("/ok")
    public String sendOk() {
        return "OK";
    }
}
