-- Products
INSERT INTO products (name, code, price, quantity, min_quantity, category) VALUES
('Notebook Dell', 'NB001', 3500.00, 10, 5, 'Eletrônicos'),
('Monitor LG', 'MN001', 800.00, 15, 3, 'Eletrônicos'),
('Teclado Mecânico', 'TC001', 200.00, 20, 5, 'Periféricos'),
('Mouse Gamer', 'MS001', 150.00, 25, 5, 'Periféricos');

-- Orders
INSERT INTO orders (customer_name, date, status, total, payment_method) VALUES
('João Silva', '2024-03-15 10:00:00', 'COMPLETED', 4300.00, 'CREDIT_CARD'),
('Maria Santos', '2024-03-15 14:30:00', 'PENDING', 950.00, 'PIX'),
('Pedro Oliveira', '2024-03-16 09:15:00', 'COMPLETED', 200.00, 'DEBIT_CARD');

-- Invoices
INSERT INTO invoices (number, customer_name, date, status, total, type) VALUES
('NF001', 'João Silva', '2024-03-15 10:05:00', 'ISSUED', 4300.00, 'NF-e'),
('NF002', 'Maria Santos', '2024-03-15 14:35:00', 'PENDING', 950.00, 'NF-e'),
('NF003', 'Pedro Oliveira', '2024-03-16 09:20:00', 'ISSUED', 200.00, 'NFC-e');

-- Transactions
INSERT INTO transactions (description, date, amount, type, category, payment_method) VALUES
('Venda Notebook', '2024-03-15 10:00:00', 3500.00, 'INCOME', 'Vendas', 'CREDIT_CARD'),
('Venda Monitor', '2024-03-15 14:30:00', 800.00, 'INCOME', 'Vendas', 'PIX'),
('Compra Teclado', '2024-03-16 09:15:00', 200.00, 'INCOME', 'Vendas', 'DEBIT_CARD'),
('Aluguel', '2024-03-01 00:00:00', 2000.00, 'EXPENSE', 'Despesas Fixas', 'BANK_TRANSFER'),
('Internet', '2024-03-05 00:00:00', 150.00, 'EXPENSE', 'Despesas Fixas', 'CREDIT_CARD'); 