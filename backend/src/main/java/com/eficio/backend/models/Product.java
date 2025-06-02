package com.eficio.backend.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotBlank(message = "Product name is required")
    @Column(nullable = false)
    private String name;
    
    @NotBlank(message = "Product code is required")
    @Column(nullable = false, unique = true)
    private String code;
    
    @NotNull(message = "Price is required")
    @Positive(message = "Price must be greater than zero")
    @Column(nullable = false)
    private Double price;
    
    @NotNull(message = "Quantity is required")
    @Min(value = 0, message = "Quantity cannot be negative")
    @Column(nullable = false)
    private Integer quantity;
    
    @NotNull(message = "Minimum quantity is required")
    @Min(value = 0, message = "Minimum quantity cannot be negative")
    @Column(name = "min_quantity", nullable = false)
    private Integer minQuantity;
    
    @NotBlank(message = "Category is required")
    @Column(nullable = false)
    private String category;
    
    @Version
    private Long version;
} 