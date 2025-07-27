# ✅ ToDo List - API REST com Java e Spring Boot

Este é um projeto backend para gerenciamento de tarefas (_ToDo List_), desenvolvido com **Java 17**, **Spring Boot** e **Maven**, seguindo boas práticas RESTful. A API permite criar, listar, atualizar e excluir tarefas, com integração de documentação via Swagger.

---

## ⚙️ Tecnologias Utilizadas

- Java 17  
- Spring Boot  
- Spring Web  
- Spring Data JPA  
- MySQL  
- Maven  
- Swagger (Springdoc OpenAPI)

---

## 🚀 Como executar o projeto localmente

### Pré-requisitos

- Java 17 instalado  
- Maven instalado  
- MySQL (ou MariaDB) em execução  
- Git instalado

### Etapas para execução

1. **Clone o repositório:**

```bash
git clone https://github.com/seu-usuario/todolist.git
cd todolist
Configure o banco de dados MySQL:

Crie um banco com o nome todolist:

sql
Copiar
Editar
CREATE DATABASE todolist;
Edite o arquivo de configurações application.properties:

properties
Copiar
Editar
spring.datasource.url=jdbc:mysql://localhost:3306/todolist
spring.datasource.username=seu_usuario
spring.datasource.password=sua_senha

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true

springdoc.api-docs.path=/api-docs
springdoc.swagger-ui.path=/swagger-ui.html
Compile e rode a aplicação:

bash
Copiar
Editar
mvn clean install
mvn spring-boot:run
🧪 Rodando os testes
Para executar os testes automatizados da aplicação:

bash
Copiar
Editar
mvn test
📚 Acessando o Swagger
A documentação interativa está disponível em:

bash
Copiar
Editar
http://localhost:8080/swagger-ui.html
✅ Estrutura do Objeto Todo
java
Copiar
Editar
public class Todo {
    private Long id;
    private String name;
    private String description;
    private boolean realized;
    private int priority;
}
Construtor utilizado:

java
Copiar
Editar
public Todo(String name, String description, boolean realized, int priority) {
    this.name = name;
    this.description = description;
    this.realized = realized;
    this.priority = priority;
}
🧰 Práticas Adotadas
Estrutura em camadas: Controller, Service, Repository

Padrões RESTful aplicados nos endpoints

Uso de @Valid para validações

Uso de Swagger para documentação e testes da API

Respostas sempre retornando a lista completa após mutações

Convenções Java e Spring seguidas

Testes de integração com @SpringBootTest

🔄 Endpoints da API
➕ Criar tarefa
URL: POST /todos

Body (JSON):

json
Copiar
Editar
{
  "name": "Estudar Spring Boot",
  "description": "Revisar tópicos importantes",
  "realized": false,
  "priority": 1
}
Retorno: Lista atualizada de tarefas.

📋 Listar tarefas
URL: GET /todos

Retorno:

json
Copiar
Editar
[
  {
    "id": 1,
    "name": "Estudar Spring Boot",
    "description": "Revisar tópicos importantes",
    "realized": false,
    "priority": 1
  }
]
✏️ Atualizar tarefa
URL: PUT /todos

Body (JSON):

json
Copiar
Editar
{
  "id": 1,
  "name": "Spring Boot atualizado",
  "description": "Tópicos revistos",
  "realized": true,
  "priority": 2
}
Retorno: Lista atualizada de tarefas.

🗑️ Remover tarefa
URL: DELETE /todos/{id}

Exemplo: DELETE /todos/1

Retorno: Lista atualizada de tarefas.

👨‍💻 Exemplo de uso com CURL
Criar:
bash
Copiar
Editar
curl -X POST http://localhost:8080/todos \
-H "Content-Type: application/json" \
-d '{
  "name": "Nova tarefa",
  "description": "Exemplo via CURL",
  "realized": false,
  "priority": 1
}'
Listar:
bash
Copiar
Editar
curl http://localhost:8080/todos
Atualizar:
bash
Copiar
Editar
curl -X PUT http://localhost:8080/todos \
-H "Content-Type: application/json" \
-d '{
  "id": 1,
  "name": "Atualizado",
  "description": "Feito via PUT",
  "realized": true,
  "priority": 2
}'
Deletar:
bash
Copiar
Editar
curl -X DELETE http://localhost:8080/todos/1
