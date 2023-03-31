package com.order.app.repository;

import com.order.app.entity.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Orders, Long> {

    @Query(value = "SELECT * FROM ecomm_order.orders"
            + " WHERE transcation_id = "
            + " (SELECT max(transcation_id) from ecomm_order.orders)",nativeQuery = true)
    Orders getOrderDetailsByMaximumTransactionID();
}
