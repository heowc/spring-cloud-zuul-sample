### Architecture

```
 ::Zuul Proxy::
                                /users/**
 ┌───────────────────────┐       ┌───────────────────────┐
 │ main-service   (8080) │ <─┬─> │ user-service   (8081) │
 └───────────────────────┘   │   └───────────────────────┘
                             │   ┌───────────────────────┐
                             └─> │ product-service(8082) │
                                 └───────────────────────┘
                                /products/**
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

### Filters

```http request
http://localhost:8080/actuator/filters
```

```json
{
   "error":[
      {
         "class":"org.springframework.cloud.netflix.zuul.filters.post.SendErrorFilter",
         "order":0,
         "disabled":false,
         "static":true
      }
   ],
   "post":[
      {
         "class":"org.springframework.cloud.netflix.zuul.filters.post.SendResponseFilter",
         "order":1000,
         "disabled":false,
         "static":true
      }
   ],
   "pre":[
      {
         "class":"org.springframework.cloud.netflix.zuul.filters.pre.DebugFilter",
         "order":1,
         "disabled":false,
         "static":true
      },
      {
         "class":"org.springframework.cloud.netflix.zuul.filters.pre.FormBodyWrapperFilter",
         "order":-1,
         "disabled":false,
         "static":true
      },
      {
         "class":"org.springframework.cloud.netflix.zuul.filters.pre.Servlet30WrapperFilter",
         "order":-2,
         "disabled":false,
         "static":true
      },
      {
         "class":"org.springframework.cloud.netflix.zuul.filters.pre.ServletDetectionFilter",
         "order":-3,
         "disabled":false,
         "static":true
      },
      {
         "class":"org.springframework.cloud.netflix.zuul.filters.pre.PreDecorationFilter",
         "order":5,
         "disabled":false,
         "static":true
      }
   ],
   "route":[
      {
         "class":"org.springframework.cloud.netflix.zuul.filters.route.SimpleHostRoutingFilter",
         "order":100,
         "disabled":false,
         "static":true
      },
      {
         "class":"org.springframework.cloud.netflix.zuul.filters.route.RibbonRoutingFilter",
         "order":10,
         "disabled":false,
         "static":true
      },
      {
         "class":"org.springframework.cloud.netflix.zuul.filters.route.SendForwardFilter",
         "order":500,
         "disabled":false,
         "static":true
      }
   ]
}
```