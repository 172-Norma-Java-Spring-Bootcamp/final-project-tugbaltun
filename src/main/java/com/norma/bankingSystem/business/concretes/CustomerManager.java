package com.norma.bankingSystem.business.concretes;


import com.norma.bankingSystem.business.abstracts.ICustomerService;
import com.norma.bankingSystem.dataAccess.AccountRepository;
import com.norma.bankingSystem.dataAccess.CustomerRepository;
import com.norma.bankingSystem.entity.model.Customer;
import com.norma.bankingSystem.exception.ApiErrorException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class CustomerManager implements ICustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public List<Customer> getAll() {
        if (customerRepository.findAll().isEmpty()) {
            throw new ApiErrorException("Customer cannot be found in the cache");
        }
        return customerRepository.findAll();
    }

    @Override
    public Customer getById(Long id) {
        return customerRepository
                .findById(id)
                .orElseThrow(() -> new ApiErrorException("No customer with id:" +id));
    }

    @Override
    public Customer add(Customer user) {

        return customerRepository.save(user);
    }

    @Override
    public Customer update(Long id, Customer user) {
        Customer usertoUpdate =
                customerRepository
                        .findById(id)
                        .orElseThrow(() -> new ApiErrorException("No customer with id:" + id));

        usertoUpdate.setFirst_name(user.getFirst_name());
        usertoUpdate.setLast_name(user.getLast_name());
        usertoUpdate.setEmail(user.getEmail());
        usertoUpdate.setPassword(user.getPassword());
        usertoUpdate.setIdentity_number(user.getIdentity_number());
        usertoUpdate.setDate_of_registration(user.getDate_of_registration());
        usertoUpdate.setLast_successful_login(user.getLast_successful_login());
        usertoUpdate.setLast_wrong_entry(user.getLast_wrong_entry());
        return customerRepository.save(usertoUpdate);
    }


    @Override
    public Map<String, Boolean> delete(Long id) {
        return null;
    }
}
