# Eficio - Sistema de Gestão Empresarial

## Visão Geral
Eficio é um sistema de gestão empresarial moderno desenvolvido com uma arquitetura full-stack, utilizando React + TypeScript no frontend e Spring Boot no backend. O sistema foi projetado para oferecer uma experiência fluida e acessível, com foco em usabilidade e performance.

## Tecnologias Utilizadas

### Frontend
- React 18
- TypeScript
- Tailwind CSS
- Vite
- React Router DOM
- Axios
- React Icons

### Backend
- Spring Boot 3.2.3
- Java 17
- Maven
- Spring Data JPA
- Spring Security
- PostgreSQL
- Lombok
- Validation API

## Estrutura do Projeto

### Frontend (`/frontend`)
```
frontend/
├── src/
│   ├── components/     # Componentes reutilizáveis
│   ├── pages/         # Páginas da aplicação
│   ├── services/      # Serviços de API
│   ├── types/         # Definições de tipos TypeScript
│   ├── utils/         # Funções utilitárias
│   ├── App.tsx        # Componente principal
│   └── main.tsx       # Ponto de entrada
├── public/            # Arquivos estáticos
└── package.json       # Dependências e scripts
```

### Backend (`/backend`)
```
backend/
├── src/
│   ├── main/
│   │   ├── java/com/eficio/backend/
│   │   │   ├── config/        # Configurações do Spring
│   │   │   ├── controllers/   # Controladores REST
│   │   │   ├── models/        # Entidades e DTOs
│   │   │   ├── repositories/  # Repositórios JPA
│   │   │   ├── services/      # Lógica de negócios
│   │   │   └── exceptions/    # Tratamento de exceções
│   │   └── resources/
│   │       └── application.yml # Configurações da aplicação
│   └── test/                  # Testes unitários e de integração
└── pom.xml                    # Dependências Maven
```

## Funcionalidades Principais

### Módulo de Vendas
- Gestão de pedidos
- Controle de clientes
- Relatórios de vendas
- Dashboard de métricas

### Módulo Financeiro
- Controle de contas a pagar/receber
- Fluxo de caixa
- Relatórios financeiros
- Integração com bancos

### Módulo de Estoque
- Controle de produtos
- Gestão de fornecedores
- Alertas de estoque baixo
- Movimentações de entrada/saída

### Módulo de Faturamento
- Geração de notas fiscais
- Emissão de boletos
- Controle de impostos
- Relatórios fiscais

## Configuração do Ambiente

### Pré-requisitos
- Node.js 18+
- Java 17+
- PostgreSQL 14+
- Maven 3.8+

### Frontend
```bash
cd frontend
npm install
npm run dev
```

### Backend
```bash
cd backend
mvn clean install
mvn spring-boot:run
```

## Variáveis de Ambiente

### Frontend
```env
VITE_API_URL=http://localhost:8080
```

### Backend
```yaml
spring:
  datasource:
    url: jdbc:postgresql://localhost:5432/eficio
    username: seu_usuario
    password: sua_senha
  jpa:
    hibernate:
      ddl-auto: update
    show-sql: true
```

## Tratamento de Erros

O sistema implementa um tratamento de erros robusto com:

- Exceções personalizadas
- Respostas de erro padronizadas
- Logging detalhado
- Validação de dados

## Segurança

- Autenticação JWT
- Autorização baseada em roles
- CORS configurado
- Validação de entrada
- Sanitização de dados

## Testes

### Frontend
```bash
npm run test
```

### Backend
```bash
mvn test
```

## Contribuição

1. Fork o projeto
2. Crie uma branch para sua feature (`git checkout -b feature/AmazingFeature`)
3. Commit suas mudanças (`git commit -m 'Add some AmazingFeature'`)
4. Push para a branch (`git push origin feature/AmazingFeature`)
5. Abra um Pull Request

## Licença

Este projeto está sob a licença MIT. Veja o arquivo [LICENSE](LICENSE) para mais detalhes.

## Contato

João Vitor Madeiro - [@joaomadeiro](https://github.com/joaomadeiro)

Link do Projeto: [https://github.com/JoaoVitorMadeiro/Eficio](https://github.com/JoaoVitorMadeiro/Eficio) 