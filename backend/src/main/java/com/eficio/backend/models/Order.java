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
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotBlank(message = "Customer name is required")
    @Column(name = "customer_name", nullable = false)
    private String customerName;
    
    @NotNull(message = "Order date is required")
    @Column(nullable = false)
    private LocalDateTime date;
    
    @NotBlank(message = "Order status is required")
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private OrderStatus status;
    
    @NotNull(message = "Order total is required")
    @Positive(message = "Order total must be greater than zero")
    @Column(nullable = false)
    private Double total;
    
    @NotBlank(message = "Payment method is required")
    @Column(name = "payment_method", nullable = false)
    @Enumerated(EnumType.STRING)
    private PaymentMethod paymentMethod;
    
    @Version
    private Long version;
    
    public enum OrderStatus {
        PENDING, PROCESSING, COMPLETED, CANCELLED
    }
    
    public enum PaymentMethod {
        CREDIT_CARD, DEBIT_CARD, PIX, BANK_TRANSFER, CASH
    }
} 