# docker-postgresql

 1. Instalar [Docker](https://docs.docker.com/engine/install/ubuntu/)
 2. Instalar [Docker Compose](https://docs.docker.com/compose/install/) 
 3. Generar archivo de configuración:
    ```
    cp .env.example .env
    ```
 4. Modificar archivo de configuración a su criterio(con el editor de texto de su preferencia):
    ```
    vi .env
    ```
 5. Crear contenedor:
    ```
    docker-compose up -d
    ```
 6. Verificar si fué creado correctamente:
    ```
    docker ps -a
    ```
