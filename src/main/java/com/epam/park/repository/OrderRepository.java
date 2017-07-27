package com.epam.park.repository;

import com.epam.park.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Arty on 22.07.2017.
 */
@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
}
