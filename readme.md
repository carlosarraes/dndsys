## DND Sys

Projeto da pós-graduação focado na persistência de dados e nas boas práticas de gerenciamento de banco de dados.

### Como Iniciar o Projeto

Primeiramente, clone o repositório para a sua máquina local. É necessário ter o Docker instalado ou um servidor PostgreSQL rodando localmente, pois a aplicação se conectará à porta padrão do PostgreSQL.

Execute os seguintes comandos para iniciar o banco de dados e a aplicação:

    Iniciar o banco de dados com Docker Compose:
        `docker compose up -d`

Este comando inicia o banco de dados PostgreSQL em um container Docker.

    Iniciar a aplicação Spring Boot com Maven:
        `mvn spring-boot:run`

Este comando inicia a aplicação na sua máquina local. Por padrão, a aplicação estará disponível em http://localhost:8080.

### Como Utilizar

Você pode utilizar seu cliente HTTP favorito (como Postman, Insomnia, etc.) para interagir com a API. Para facilitar, há uma coleção de requisições disponível caso você queira utilizar o cliente HTTP "Bruno".
