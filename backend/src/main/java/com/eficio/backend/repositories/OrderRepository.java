package com.eficio.backend.repositories;

import com.eficio.backend.models.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import java.time.LocalDateTime;
import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {
    List<Order> findByDateBetween(LocalDateTime start, LocalDateTime end);
    List<Order> findByStatus(String status);
} 