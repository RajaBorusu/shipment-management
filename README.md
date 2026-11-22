# Shipment Management Service

A small Spring Boot REST API used to learn the AWS DevOps delivery lifecycle.

## Requirements
- JDK 21
- Maven 3.9+
- Postman or curl

## Run locally
From this directory:

```bash
mvn clean test
mvn spring-boot:run
```

The API listens on http://localhost:8080.

## API examples

Create a shipment:

```bash
curl -X POST http://localhost:8080/api/shipments ^
  -H "Content-Type: application/json" ^
  -d "{\"origin\":\"Hyderabad\",\"destination\":\"Bangalore\"}"
```

List shipments:

```bash
curl http://localhost:8080/api/shipments
```

Get one shipment (replace the ID with the ID returned by POST):

```bash
curl http://localhost:8080/api/shipments/SHP-XXXXXXXX
```

Update status:

```bash
curl -X PATCH http://localhost:8080/api/shipments/SHP-XXXXXXXX/status ^
  -H "Content-Type: application/json" ^
  -d "{\"status\":\"IN_TRANSIT\"}"
```

Delete:

```bash
curl -X DELETE http://localhost:8080/api/shipments/SHP-XXXXXXXX
```

## H2 console
Open http://localhost:8080/h2-console and use:
- JDBC URL: jdbc:h2:mem:shipmentdb
- User: sa
- Password: (leave blank)

## Notes
H2 in-memory is for local learning only. Its data is lost when the application stops.
Do not expose the H2 console publicly. Before production, use a managed database such as
Amazon RDS, configure credentials securely, add authentication/authorization, and review
validation, logging, health checks, tests, and deployment security.
