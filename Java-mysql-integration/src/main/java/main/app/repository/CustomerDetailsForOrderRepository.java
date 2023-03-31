package main.app.repository;

import main.app.entity.CustomerDetailsForOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerDetailsForOrderRepository extends JpaRepository<CustomerDetailsForOrder, Long> {

    @Query(value = "SELECT * FROM customer_details c WHERE c.customer_name=:customerName", nativeQuery = true)
    public List<CustomerDetailsForOrder> getCustomerForOrderByName(String customerName);

}
