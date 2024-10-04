package com.nttdata.customers.business;

import com.nttdata.customers.dto.CustomerRequest;
import com.nttdata.customers.dto.CustomerResponse;
import com.nttdata.customers.dto.ListCustomerResponse;
import com.nttdata.customers.model.entity.Customer;
import com.nttdata.customers.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    CustomerRepository customerRepository;
    @Autowired
    CustomerMapper customerMapper;

    @Override
    public ListCustomerResponse findAll() {
        List<Customer> customerList = customerRepository.findAll();
        ListCustomerResponse response = new ListCustomerResponse();
        response.setListCustomerResponse(customerList.stream()
                .map(customer -> customerMapper.getCustomerResponseOfCustomer(customer))
                .collect(Collectors.toList()));
        return response;
    }

    @Override
    public CustomerResponse findById(Integer id)  {
        Optional<Customer> customer = customerRepository.findById(id);
        if (customer.isEmpty()) {
            try {
                throw new Exception("No existe cliente");
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }

        return customerMapper.getCustomerResponseOfCustomer(customer.get());
    }

    @Override
    public CustomerResponse save(CustomerRequest customerRequest) {
        Customer customer = customerMapper.getCustomerOfCustomerRequest(customerRequest);
        Customer customerCreated = customerRepository.save(customer);
        return customerMapper.getCustomerResponseOfCustomer(customerCreated);
    }

    @Override
    public CustomerResponse update(Integer id, CustomerRequest customerRequest) {
        Optional<Customer> customer = customerRepository.findById(id);
        if (customer.isEmpty()) {
            try {
                throw new Exception("No existe cliente");
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }

        Customer customerUpdate = customerMapper.getCustomerOfCustomerRequest(customerRequest);
        customerUpdate.setId(id);
        Customer customerResponse = customerRepository.save(customerUpdate);
        return customerMapper.getCustomerResponseOfCustomer(customerResponse);
    }

    @Override
    public CustomerResponse delete(Integer id)  {
        Optional<Customer> customerDelete = customerRepository.findById(id);
        if (customerDelete.isEmpty()) {
            try {
                throw new Exception("No existe cliente");
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        customerRepository.delete(customerDelete.get());
        return customerMapper.getCustomerResponseOfCustomer(customerDelete.get());
    }
}
