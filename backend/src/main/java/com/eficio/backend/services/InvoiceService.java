package com.eficio.backend.services;

import com.eficio.backend.models.Invoice;
import com.eficio.backend.repositories.InvoiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class InvoiceService {
    @Autowired
    private InvoiceRepository invoiceRepository;

    public List<Invoice> getAllInvoices() {
        return invoiceRepository.findAll();
    }

    public Invoice getInvoiceById(Long id) {
        return invoiceRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Invoice not found"));
    }

    public Invoice createInvoice(Invoice invoice) {
        invoice.setDate(LocalDateTime.now());
        return invoiceRepository.save(invoice);
    }

    public Invoice updateInvoice(Long id, Invoice invoice) {
        Invoice existingInvoice = getInvoiceById(id);
        existingInvoice.setNumber(invoice.getNumber());
        existingInvoice.setCustomerName(invoice.getCustomerName());
        existingInvoice.setStatus(invoice.getStatus());
        existingInvoice.setTotal(invoice.getTotal());
        existingInvoice.setType(invoice.getType());
        return invoiceRepository.save(existingInvoice);
    }

    public void deleteInvoice(Long id) {
        invoiceRepository.deleteById(id);
    }

    public List<Invoice> getInvoicesByDateRange(LocalDateTime start, LocalDateTime end) {
        return invoiceRepository.findByDateBetween(start, end);
    }

    public List<Invoice> getInvoicesByStatus(String status) {
        return invoiceRepository.findByStatus(status);
    }

    public List<Invoice> getInvoicesByType(String type) {
        return invoiceRepository.findByType(type);
    }
} 