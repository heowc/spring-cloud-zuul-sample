### Architecture

```
 ::Zuul Proxy::
                                /user/**
 ┌───────────────────────┐       ┌───────────────────────┐
 │ main-service   (8080) │ <─┬─> │ user-service   (8081) │
 └───────────────────────┘   │   └───────────────────────┘
                             │   ┌───────────────────────┐
                             └─> │ product-service(8082) │
                                 └───────────────────────┘
                                /product/**
```

### Routes

```http request
http://localhost:8080/actuator/routes
```

```json
{
    "/products/**": "http://localhost:8081",
    "/users/**": "http://localhost:8082"
}
```