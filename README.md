## ABOUT
Project use to integrate with aws services

Create network

```docker network create my-net```

Start Mongo with predefined network

```docker run --name mongo -p 27017:27017 --network my-net -e MONGO_INITDB_ROOT_USERNAME=admin -e MONGO_INITDB_ROOT_PASSWORD=admin -e MONGO_INITDB_DATABASE=hotel -d mongo:latest```

Build app

```docker build -t hotel-service:0.0.1 .```

Run app on the same network:

```docker run --name traveloka-backend -p 8080:8080 --network my-net -e SERVER_HOST=postgres traveloka-backend```

```docker run  --name postgres --network my-net -p 5432:5432 -e POSTGRES_PASSWORD=postgres -e POSTGRES_DB=traveloka -d postgres```

### BUILD
PRJ uses gradle kts as build tool.
Liquibase, Postgres as Database management sys

