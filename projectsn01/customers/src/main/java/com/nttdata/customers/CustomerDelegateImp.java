package com.nttdata.customers;

import com.nttdata.customers.api.ApiApiDelegate;
import com.nttdata.customers.business.CustomerService;
import com.nttdata.customers.dto.CustomerRequest;
import com.nttdata.customers.dto.CustomerResponse;
import com.nttdata.customers.dto.ListCustomerResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class CustomerDelegateImp implements ApiApiDelegate {

    @Autowired
    CustomerService customerService;

    @Override
    public ResponseEntity<CustomerResponse> save(CustomerRequest customerRequest) {
        return ResponseEntity.ok(customerService.save(customerRequest));
    }

    @Override
    public ResponseEntity<CustomerResponse> update(Integer id, CustomerRequest customerRequest) {
        return ResponseEntity.ok(customerService.update(id,customerRequest));
    }

    @Override
    public ResponseEntity<CustomerResponse> delete(Integer id) {

        return ResponseEntity.ok(customerService.delete(id));
    }

    @Override
    public ResponseEntity<ListCustomerResponse> findAll() {
        return ResponseEntity.ok(customerService.findAll());
    }

    @Override
    public ResponseEntity<CustomerResponse> findById(Integer id) {

        return ResponseEntity.ok(customerService.findById(id));
    }
}
