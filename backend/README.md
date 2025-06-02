# Eficio Backend

Backend do sistema Eficio desenvolvido com Spring Boot e arquitetura MVC.

## Tecnologias Utilizadas

- Java 17
- Spring Boot 3.2.3
- Spring Data JPA
- H2 Database
- Maven
- Lombok

## Estrutura do Projeto

```
backend/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/
│   │   │       └── eficio/
│   │   │           └── backend/
│   │   │               ├── controllers/
│   │   │               ├── services/
│   │   │               ├── repositories/
│   │   │               ├── models/
│   │   │               └── BackendApplication.java
│   │   └── resources/
│   │       ├── application.properties
│   │       └── data.sql
└── pom.xml
```

## Configuração do Ambiente

1. Certifique-se de ter o Java 17 instalado
2. Clone o repositório
3. Navegue até a pasta do projeto
4. Execute o comando: `mvn spring-boot:run`

## Endpoints da API

### Produtos
- GET `/api/products` - Lista todos os produtos
- GET `/api/products/{id}` - Obtém um produto específico
- POST `/api/products` - Cria um novo produto
- PUT `/api/products/{id}` - Atualiza um produto
- DELETE `/api/products/{id}` - Remove um produto
- GET `/api/products/low-stock` - Lista produtos com estoque baixo
- GET `/api/products/category/{category}` - Lista produtos por categoria

### Pedidos
- GET `/api/orders` - Lista todos os pedidos
- GET `/api/orders/{id}` - Obtém um pedido específico
- POST `/api/orders` - Cria um novo pedido
- PUT `/api/orders/{id}` - Atualiza um pedido
- DELETE `/api/orders/{id}` - Remove um pedido
- GET `/api/orders/date-range` - Lista pedidos por período
- GET `/api/orders/status/{status}` - Lista pedidos por status

### Notas Fiscais
- GET `/api/invoices` - Lista todas as notas fiscais
- GET `/api/invoices/{id}` - Obtém uma nota fiscal específica
- POST `/api/invoices` - Cria uma nova nota fiscal
- PUT `/api/invoices/{id}` - Atualiza uma nota fiscal
- DELETE `/api/invoices/{id}` - Remove uma nota fiscal
- GET `/api/invoices/date-range` - Lista notas fiscais por período
- GET `/api/invoices/status/{status}` - Lista notas fiscais por status
- GET `/api/invoices/type/{type}` - Lista notas fiscais por tipo

### Transações
- GET `/api/transactions` - Lista todas as transações
- GET `/api/transactions/{id}` - Obtém uma transação específica
- POST `/api/transactions` - Cria uma nova transação
- PUT `/api/transactions/{id}` - Atualiza uma transação
- DELETE `/api/transactions/{id}` - Remove uma transação
- GET `/api/transactions/date-range` - Lista transações por período
- GET `/api/transactions/type/{type}` - Lista transações por tipo
- GET `/api/transactions/category/{category}` - Lista transações por categoria

## Banco de Dados

O projeto utiliza o H2 Database em memória. Para acessar o console do H2:

1. Inicie a aplicação
2. Acesse: `http://localhost:8080/h2-console`
3. Use as credenciais configuradas no `application.properties`

## Dados de Teste

O arquivo `data.sql` contém dados iniciais para teste, incluindo:
- Produtos
- Pedidos
- Notas Fiscais
- Transações 