# Eficio – Sistema SaaS para Gestão de Pequenas Empresas

## 📌 Descrição

**Eficio** é um sistema **SaaS** baseado em **microservices**, projetado para a gestão de **vendas, estoques e finanças**. Ele inclui suporte para **emissão de notas fiscais**, integração com **APIs bancárias** e arquitetura escalável com **Docker e Kubernetes**.

---

## 🏗 Arquitetura do Sistema

- **Auth-Service** → Autenticação e autorização (**JWT, OAuth2**)
- **User-Service** → Gestão de usuários e perfis
- **Sales-Service** → Processamento de vendas e pedidos
- **Stock-Service** → Controle de estoque
- **Finance-Service** → Gestão financeira e conciliação bancária
- **Invoice-Service** → Emissão de notas fiscais
- **API Gateway** → Gerenciamento centralizado de rotas

### 🔄 Comunicação

- **Síncrona (REST + OpenFeign)** para operações rápidas
- **Assíncrona (Kafka/RabbitMQ)** para eventos como atualização de estoque após venda

---

## 🚀 Tecnologias Utilizadas

- **Java 17 + Spring Boot**
- **Maven**
- **PostgreSQL**
- **Redis**
- **Docker, Kubernetes**
- **Kafka/RabbitMQ**
- **Keycloak/OAuth2**

---

## 📋 Requisitos do Sistema

### Requisitos Funcionais

1. O sistema deve permitir o cadastro e autenticação de usuários.
2. Deve ser possível gerenciar permissões de acesso.
3. O sistema deve processar vendas e atualizar o estoque automaticamente.
4. Deve permitir a emissão de notas fiscais.
5. O módulo financeiro deve permitir conciliação bancária e controle de fluxo de caixa.
6. O sistema deve permitir integração com APIs externas para pagamento e emissão de NF-e.

### Requisitos Não Funcionais

1. O sistema deve ser escalável e suportar alta carga de usuários simultâneos.
2. Deve ser implantado em containers utilizando Docker e Kubernetes.
3. Deve garantir segurança na autenticação com OAuth2 e JWT.
4. A comunicação entre microserviços deve ser otimizada com Kafka/RabbitMQ.
5. O banco de dados deve garantir consistência e disponibilidade.

---

## 📂 Estrutura do Repositório

```
Eficio/
│── Auth/           # Serviço de autenticação
│── User/           # Gestão de usuários
│── Sales/          # Processamento de vendas
│── Stock/          # Controle de estoque
│── Finance/        # Gestão financeira
│── Invoice/        # Emissão de notas fiscais
│── API Gateway/    # Gerenciamento de rotas
│── pom.xml         # Arquivo de configuração do Maven
│── Dockerfile      # Arquivo de configuração para Docker
└── README.md       # Documentação principal
```

---

## 🚀 Deploy e Execução

### Pré-requisitos
- Docker e Docker Compose
- Java 17
- Maven

### Executando o sistema
```bash
git clone <repositorio>
cd Eficio
docker-compose up -d
```

### Acessando os serviços
- API Gateway: `http://localhost:8080`
- Auth-Service: `http://localhost:8081`
- User-Service: `http://localhost:8082`


