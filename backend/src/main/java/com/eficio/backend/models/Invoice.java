package com.eficio.backend.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "invoices")
public class Invoice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotBlank(message = "Invoice number is required")
    @Column(nullable = false, unique = true)
    private String number;
    
    @NotBlank(message = "Customer name is required")
    @Column(name = "customer_name", nullable = false)
    private String customerName;
    
    @NotNull(message = "Invoice date is required")
    @Column(nullable = false)
    private LocalDateTime date;
    
    @NotNull(message = "Invoice status is required")
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private InvoiceStatus status;
    
    @NotNull(message = "Invoice total is required")
    @Positive(message = "Invoice total must be greater than zero")
    @Column(nullable = false)
    private Double total;
    
    @NotNull(message = "Invoice type is required")
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private InvoiceType type;
    
    @Version
    private Long version;
    
    public enum InvoiceStatus {
        PENDING, ISSUED, CANCELLED
    }
    
    public enum InvoiceType {
        NF_E, NFC_E, NF_SE
    }
} 