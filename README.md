# Sistema de estoque

> Sistema de Controle de Estoque desenvolvido como projeto de estudo, aplicando Java para Backend com arquitetura em camadas.

![Java](https://img.shields.io/badge/Java-25-orange?style=for-the-badge&logo=openjdk&logoColor=white)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.x-brightgreen?style=for-the-badge&logo=springboot&logoColor=white)
![MySQL](https://img.shields.io/badge/MySQL-8.0-blue?style=for-the-badge&logo=mysql&logoColor=white)
![Maven](https://img.shields.io/badge/Maven-Build-C71A36?style=for-the-badge&logo=apachemaven&logoColor=white)
![Status](https://img.shields.io/badge/status-em%20desenvolvimento-yellow?style=for-the-badge)

---

## Sobre o projeto

A ideia é criar um sistema web para controle de estoque, desenvolvido do zero como projeto de estudo em **Java para Backend**. O objetivo principal não é apenas entregar um sistema funcional, mas **compreender profundamente cada camada da arquitetura** — desde a persistência de dados até a exposição de endpoints REST.

O projeto segue uma abordagem incremental: começando por um **MVP simplificado** (CRUD de produtos, sem autenticação) e evoluindo gradualmente até o escopo completo definido no levantamento de requisitos original.

## Objetivos do sistema

- Organizar e controlar o estoque de produtos
- Facilitar a alocação e retirada de produtos
- Identificar produtos em falta ou abaixo do estoque mínimo
- Setorizar produtos por categoria
- Agilizar consultas e geração de relatórios

## Arquitetura

O projeto segue o padrão de **arquitetura em camadas**:

```
Controller → Service → Repository → Banco de Dados
```

| Camada | Responsabilidade |
|---|---|
| `controller` | Expõe os endpoints REST da aplicação |
| `service` | Concentra as regras de negócio |
| `repository` | Responsável pelo acesso e persistência de dados |
| `model` | Representa as entidades/tabelas do banco de dados |

### Estrutura de pacotes

```
br.com.estudo.estoque
│
├── controller
├── service
├── repository
├── model
├── dto
├── config
├── security
└── exception
```

## Tecnologias utilizadas

| Camada | Tecnologia |
|---|---|
| Linguagem | Java 25 |
| Framework | Spring Boot |
| API | Spring MVC |
| Persistência | Spring Data JPA (Hibernate) |
| Banco de Dados | MySQL |
| Build | Maven |
| IDE | IntelliJ IDEA |
| Testes | JUnit 5 |

## Funcionalidades planejadas

- [x] Estrutura inicial do projeto (Maven + Spring Boot)
- [x] Conexão com banco de dados MySQL
- [x] Entidade `Produto` (model)
- [x] Camada `repository` de produtos
- [X] Camada `service` de produtos
- [X] Camada `controller` (API REST) de produtos
- [X] Categorias e Fornecedores
- [ ] Movimentações (entrada e saída) com atualização automática de saldo
- [ ] Autenticação simples (usuário único)
- [ ] Relatórios em PDF
- [ ] Alertas de estoque mínimo

## Como executar o projeto

### Pré-requisitos

- Java 25 (ou superior)
- Maven
- MySQL em execução localmente

### Passos

1. Clone o repositório
   ```bash
   git clone <url-do-repositorio>
   ```

2. Crie o schema do banco de dados no MySQL
   ```sql
   CREATE SCHEMA estoque;
   ```

3. Configure suas credenciais locais criando um arquivo `application-local.properties` em `src/main/resources`, com base no `application.properties` público:
   ```properties
   spring.datasource.url=jdbc:mysql://localhost:3306/estoque
   spring.datasource.username=SEU_USUARIO
   spring.datasource.password=SUA_SENHA
   ```

4. Execute a aplicação
   ```bash
   ./mvnw spring-boot:run
   ```

>  O arquivo `application-local.properties` contém credenciais sensíveis e está no `.gitignore` — nunca deve ser versionado.

##  Status do projeto

Projeto em desenvolvimento ativo, como parte dos estudos em Análise e Desenvolvimento de Sistemas (ADS), com foco em Backend Java.

---

<p align="center">Desenvolvido como projeto de estudo </p>
