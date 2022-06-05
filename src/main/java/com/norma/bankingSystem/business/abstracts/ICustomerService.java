package com.norma.bankingSystem.business.abstracts;

import com.norma.bankingSystem.entity.model.Customer;

import java.util.List;
import java.util.Map;

public interface ICustomerService {

    List<Customer> getAll();

    Customer getById(Long id);

    Customer add(Customer user);

    Customer update(Long id, Customer user);

    Map<String, Boolean> delete(Long id);
}
