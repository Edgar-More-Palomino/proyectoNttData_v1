package com.nttdata.customers.business;

import com.nttdata.customers.dto.CustomerRequest;
import com.nttdata.customers.dto.CustomerResponse;
import com.nttdata.customers.model.entity.Customer;
import org.springframework.stereotype.Component;

@Component
public class CustomerMapper {
    public Customer getCustomerOfCustomerRequest(CustomerRequest request){
        Customer entity = new Customer();
        entity.setNombre(request.getNombre());
        entity.setDni(request.getDni());
        entity.setEmail(request.getEmail());
        entity.setApellido(request.getApellido());
        return entity;

    }

    public CustomerResponse getCustomerResponseOfCustomer(Customer entity){
        CustomerResponse customerResponse = new CustomerResponse();
        customerResponse.setNombre(entity.getNombre());
        customerResponse.setDni(entity.getDni());
        customerResponse.setEmail(entity.getEmail());
        customerResponse.setApellido(entity.getApellido());
        customerResponse.setId(entity.getId());
        return customerResponse;

    }
}
