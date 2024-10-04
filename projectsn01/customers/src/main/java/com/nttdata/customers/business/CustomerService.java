package com.nttdata.customers.business;

import com.nttdata.customers.dto.CustomerRequest;
import com.nttdata.customers.dto.CustomerResponse;
import com.nttdata.customers.dto.ListCustomerResponse;

public interface CustomerService {
    public ListCustomerResponse findAll();

    public CustomerResponse findById(Integer id);

    public CustomerResponse save(CustomerRequest customerRequest);

    public CustomerResponse update(Integer id, CustomerRequest customerRequest);

    public CustomerResponse delete(Integer id);

}
