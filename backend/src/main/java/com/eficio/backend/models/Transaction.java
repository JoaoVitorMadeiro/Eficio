package com.eficio.backend.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
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
@Table(name = "transactions")
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotBlank(message = "Description is required")
    @Column(nullable = false)
    private String description;
    
    @NotNull(message = "Transaction date is required")
    @Column(nullable = false)
    private LocalDateTime date;
    
    @NotNull(message = "Amount is required")
    @Column(nullable = false)
    private Double amount;
    
    @NotNull(message = "Transaction type is required")
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private TransactionType type;
    
    @NotBlank(message = "Category is required")
    @Column(nullable = false)
    private String category;
    
    @NotNull(message = "Payment method is required")
    @Column(name = "payment_method", nullable = false)
    @Enumerated(EnumType.STRING)
    private PaymentMethod paymentMethod;
    
    @Version
    private Long version;
    
    public enum TransactionType {
        INCOME, EXPENSE
    }
    
    public enum PaymentMethod {
        CREDIT_CARD, DEBIT_CARD, PIX, BANK_TRANSFER, CASH
    }
} 