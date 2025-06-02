package com.eficio.backend.repositories;

import com.eficio.backend.models.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;
import java.time.LocalDateTime;
import java.util.List;

public interface InvoiceRepository extends JpaRepository<Invoice, Long> {
    List<Invoice> findByDateBetween(LocalDateTime start, LocalDateTime end);
    List<Invoice> findByStatus(String status);
    List<Invoice> findByType(String type);
} 