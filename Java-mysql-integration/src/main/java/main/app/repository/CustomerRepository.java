package main.app.repository;

import main.app.entity.Customer;
import main.app.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    @Query(value = "SELECT * FROM customer c WHERE c.customer_name=:customerName", nativeQuery = true)
    public List<Customer> getCustomerDetailsByName(String customerName);

    @Query(value = "select * from ecomm_order.customer where is_prime_user=true and prime_end_date >= date(now())", nativeQuery = true)
    public List<Customer> getPrimeActiveCustomers();

    @Query(value = "select * from ecomm_order.customer where is_prime_user=false or prime_end_date <= date(now())", nativeQuery = true)
    public List<Customer> getPrimeInActiveCustomers();
}
