# **Eficio – Sistema SaaS para Gestão de Pequenas Empresas**

## 📌 **Descrição**
**Eficio** é um sistema **SaaS** baseado em **microservices**, projetado para a gestão de **vendas, estoques e finanças**. Ele inclui suporte para **emissão de notas fiscais**, integração com **APIs bancárias** e arquitetura escalável com **Docker e Kubernetes**.

---

## 🏗 **Arquitetura do Sistema**

🔹 **Auth-Service** → Autenticação e autorização (**JWT, OAuth2**)  
🔹 **User-Service** → Gestão de usuários e perfis  
🔹 **Sales-Service** → Processamento de vendas e pedidos  
🔹 **Stock-Service** → Controle de estoque  
🔹 **Finance-Service** → Gestão financeira e conciliação bancária  
🔹 **Invoice-Service** → Emissão de notas fiscais  
🔹 **API Gateway** → Gerenciamento centralizado de rotas

🔄 **Comunicação**:  
✅ **Síncrona (REST + OpenFeign)** para operações rápidas.  
✅ **Assíncrona (Kafka/RabbitMQ)** para eventos como atualização de estoque após venda.

---

## 🚀 **Tecnologias Utilizadas**

- **Java 17 + Spring Boot**
- **Spring Cloud (Eureka, OpenFeign, Gateway)**
- **Kafka / RabbitMQ**
- **PostgreSQL / MySQL**
- **Docker + Kubernetes**
- **Swagger / OpenAPI**
- **OAuth2 + JWT**
- **Grafana + Prometheus (Monitoramento)**

---

## 🛠 **Instalação e Configuração**

### **1️⃣ Clonando o Repositório**
```bash
git clone https://github.com/seu-usuario/eficio.git
cd eficio
```

### **2️⃣ Configuração do Banco de Dados**
Crie um banco **PostgreSQL** ou **MySQL** e configure no `application.yml` de cada serviço.

```yaml
spring:
  datasource:
    url: jdbc:postgresql://localhost:5432/eficio
    username: seu_usuario
    password: sua_senha
```

---

## 🐳 **Rodando com Docker**

### **Docker Compose (Ambiente de Desenvolvimento)**
```bash
docker-compose up -d
```
O **docker-compose.yml** já inclui todos os microservices e banco de dados.

---

## ☸ **Deploy com Kubernetes**

### **1️⃣ Criar os Deployments**
```bash
kubectl apply -f k8s/
```
O diretório `k8s/` contém os arquivos para deploy no **Kubernetes**, incluindo **ConfigMaps, Secrets e Services**.

### **2️⃣ Monitorar os Pods**
```bash
kubectl get pods
```

---

## 📖 **Documentação da API**

🔹 **Swagger UI** → `http://localhost:8080/swagger-ui.html`  
🔹 **OpenAPI JSON** → `http://localhost:8080/v3/api-docs`

---

## 🤝 **Como Contribuir?**

1. **Fork** o repositório
2. Crie uma **branch** (`git checkout -b feature/minha-feature`)
3. Faça commit das mudanças (`git commit -m "Adicionei nova feature"`)
4. Faça **push** para a branch (`git push origin feature/minha-feature`)
5. Abra um **Pull Request**

---

## 📝 **Licença**
Este projeto está sob a licença **MIT**.
