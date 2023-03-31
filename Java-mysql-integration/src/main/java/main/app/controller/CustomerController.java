package main.app.controller;

import main.app.entity.Customer;
import main.app.entity.CustomerDetailsForOrder;
import main.app.model.CustomerInformation;
import main.app.repository.CustomerDetailsForOrderRepository;
import main.app.repository.CustomerRepository;
import main.app.response.RestServiceResponse;
import main.app.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    EmailService emailService;

    @Autowired
    CustomerDetailsForOrderRepository customerDetailsForOrderRepository;

    @GetMapping("/getAllCustomers")
    public List<CustomerInformation> getAllCustomers() {
        List<Customer> customerInDB = customerRepository.findAll();
        List<CustomerInformation> customerWithNameAndEmail = new ArrayList<>();
        for (Customer customer : customerInDB) {
            CustomerInformation customerInformation = new CustomerInformation();
            customerInformation.setCustomerName(customer.getCustomerName());
            customerInformation.setCustomerEmail(customer.getCustomerEmail());
            customerWithNameAndEmail.add(customerInformation);
        }
        return customerWithNameAndEmail;
    }

    @GetMapping("/getAllCustomersDetailedInfo")
    public List<Customer> getAllCustomersDetailedInfo() {
        List<Customer> customerInDB = customerRepository.findAll();
        return customerInDB;
    }

    @GetMapping("/getCustomerById/{id}")
    public Customer getCustomerById(@PathVariable("id") Long id) {
        Customer customer = customerRepository.findById(id).get();
        return customer;
    }

    @GetMapping("/getCustomerDetailsByName/{customerName}")
    public List<Customer> getCustomerDetailsByName(@PathVariable("customerName") String customerName) {
        List<Customer> customerList = customerRepository.getCustomerDetailsByName(customerName);
        return customerList;
    }

    @GetMapping("/getPrimeActiveCustomers")
    public List<Customer> getPrimeActiveCustomers() {
        List<Customer> customerList = customerRepository.getPrimeActiveCustomers();
        return customerList;
    }

    @GetMapping("/getPrimeInActiveCustomers")
    public List<Customer> getPrimeInActiveCustomers() {
        List<Customer> customerList = customerRepository.getPrimeInActiveCustomers();
        return customerList;
    }

    @PostMapping("/createDetailedCustomer")
    public Customer createDetailedCustomer(@RequestBody Customer customer) {
        Customer newCustomer = customerRepository.save(customer);
        return newCustomer;
    }

    @PutMapping("/updateDetailedCustomer")
    public Customer updateDetailedCustomer(@RequestBody Customer customer) {
        return customerRepository.save(customer);
    }

    @DeleteMapping("/deleteCustomerById/{id}")
    public String deleteCustomerById(@PathVariable("id") Long customerId) {
        try {
            customerRepository.deleteById(customerId);
            return "CustomerID:" + "\t" + customerId + "\nDeleted Successfully from DB.";
        } catch (Exception ex) {
            return "Customer with ID:" + customerId + " already Deleted.";
        }
    }

    @PostMapping("/signUpEmail")
    public RestServiceResponse signUpEmail(@RequestBody CustomerInformation customerInformation) {
        Customer newCustomer = new Customer();
        newCustomer.setCustomerName(customerInformation.getCustomerName());
        newCustomer.setCustomerEmail(customerInformation.getCustomerEmail());
        Date dateTime = new Date();
        newCustomer.setCreatedDate(dateTime);
        newCustomer.setUpdateDate(dateTime);
        newCustomer.setPrimeUser(false);
        customerRepository.save(newCustomer);

        emailService.sendEmail(customerInformation);
        RestServiceResponse restServiceResponse = new RestServiceResponse();
        restServiceResponse.setStatusCode(200);
        restServiceResponse.setStatusMessage("Customer " + customerInformation.getCustomerName() + " created successfully.");
        return restServiceResponse;
    }

    @GetMapping("/getCustomerForOrderByName/{customerName}")
    public List<CustomerDetailsForOrder> getCustomerForOrderByName(@PathVariable("customerName") String customerName) {
        List<CustomerDetailsForOrder> customerList = customerDetailsForOrderRepository.getCustomerForOrderByName(customerName);
        return customerList;
    }
}