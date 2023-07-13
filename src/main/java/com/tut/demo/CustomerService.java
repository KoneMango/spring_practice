package com.tut.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {
    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public Customer addCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    public Customer updateCustomer(String customerId, Customer updatedCustomer) throws ChangeSetPersister.NotFoundException {
        Customer existingCustomer = customerRepository.findById(customerId)
                .orElseThrow(() -> new ChangeSetPersister.NotFoundException());

        existingCustomer.setCompanyName(updatedCustomer.getCompanyName());
        existingCustomer.setAddress(updatedCustomer.getAddress());
        existingCustomer.setContactPerson(updatedCustomer.getContactPerson());

        return customerRepository.save(existingCustomer);
    }

    public List<Customer> listCustomer(){
        return customerRepository.findAll();
    }

    public void removeCustomer(String customerId){
        customerRepository.deleteById(customerId);
    }
}
