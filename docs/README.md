# Documentação do Eficio

## Visão Geral
O Eficio é um sistema SaaS para gestão de pequenas empresas, desenvolvido com arquitetura de microserviços.

## Estrutura do Projeto
- `Auth/` - Serviço de autenticação e autorização
- `User/` - Gestão de usuários
- `Sales/` - Processamento de vendas
- `Stock/` - Controle de estoque
- `Finance/` - Gestão financeira
- `Invoice/` - Emissão de notas fiscais
- `ApiGateway/` - Gateway de API

## Requisitos
- Java 17
- Maven
- Docker e Docker Compose
- PostgreSQL
- Redis
- Kafka
- Keycloak

## Configuração do Ambiente
1. Clone o repositório
2. Execute `docker-compose up -d` para iniciar os serviços de infraestrutura
3. Configure o Keycloak em `http://localhost:8080`
4. Execute cada microserviço individualmente

## Endpoints da API

### Auth Service (Porta 8081)
- POST `/api/auth/login` - Autenticação de usuários
- POST `/api/auth/refresh` - Renovação de token
- GET `/api/auth/validate` - Validação de token

### User Service (Porta 8082)
- GET `/api/users` - Lista todos os usuários
- POST `/api/users` - Cria novo usuário
- GET `/api/users/{id}` - Obtém usuário por ID
- PUT `/api/users/{id}` - Atualiza usuário
- DELETE `/api/users/{id}` - Remove usuário

## Segurança
- Autenticação via OAuth2/OpenID Connect
- Tokens JWT
- CORS configurado
- Rate limiting por IP
- Validação de entrada
- Sanitização de dados

## Monitoramento
- Logs centralizados
- Métricas via Prometheus
- Tracing distribuído
- Health checks

## Desenvolvimento
1. Siga o padrão de código definido
2. Escreva testes unitários
3. Documente novas APIs
4. Atualize a documentação
5. Faça code review antes de merge 