package com.eficio.backend.controllers;

import com.eficio.backend.models.Invoice;
import com.eficio.backend.services.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/invoices")
@CrossOrigin(origins = "http://localhost:3000")
public class InvoiceController {
    @Autowired
    private InvoiceService invoiceService;

    @GetMapping
    public List<Invoice> getAllInvoices() {
        return invoiceService.getAllInvoices();
    }

    @GetMapping("/{id}")
    public Invoice getInvoiceById(@PathVariable Long id) {
        return invoiceService.getInvoiceById(id);
    }

    @PostMapping
    public Invoice createInvoice(@RequestBody Invoice invoice) {
        return invoiceService.createInvoice(invoice);
    }

    @PutMapping("/{id}")
    public Invoice updateInvoice(@PathVariable Long id, @RequestBody Invoice invoice) {
        return invoiceService.updateInvoice(id, invoice);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteInvoice(@PathVariable Long id) {
        invoiceService.deleteInvoice(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/date-range")
    public List<Invoice> getInvoicesByDateRange(
            @RequestParam LocalDateTime start,
            @RequestParam LocalDateTime end) {
        return invoiceService.getInvoicesByDateRange(start, end);
    }

    @GetMapping("/status/{status}")
    public List<Invoice> getInvoicesByStatus(@PathVariable String status) {
        return invoiceService.getInvoicesByStatus(status);
    }

    @GetMapping("/type/{type}")
    public List<Invoice> getInvoicesByType(@PathVariable String type) {
        return invoiceService.getInvoicesByType(type);
    }
} 