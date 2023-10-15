# Spring Customer API

A Spring Boot API for Customer Management 👨🏻‍💻

## Technology stack

- **Tools:** [Docker](https://www.docker.com/)
- **Database:** [H2](https://www.h2database.com/)
- **Deployment:** [Render](https://render.com/)
- **Back-end:** [Spring Boot](https://spring.io/)
- **Package Manager:** [Maven](https://maven.apache.org/)

## Swagger and Endpoints

You can view all the endpoints below in swagger-ui at the link: https://spring-customer-api.onrender.com/swagger-ui/index.html#/

## Create Customer

### Request

`POST /customer`

    curl --location 'https://spring-customer-api.onrender.com/customer' \
    --header 'Content-Type: application/json' \
    --data '{
    "customerName": "Nike USA",
    "customerDocument": "62080338000158",
    "customerAddress": "855 6th Ave, Nova Iorque, NY, Estados Unidos"
    }'

### Response

    HTTP/1.1 201 CREATED
    {
        "customerId": "1c80389b-f16d-4d63-a78b-e0e430cb4a40",
        "customerName": "Nike USA",
        "customerDocument": "62080338000158",
        "customerAddress": "855 6th Ave, Nova Iorque, NY, Estados Unidos",
        "createdAt": "2023-10-14T17:29:15.097222"
    }

## Find Customer By Id

### Request

`GET /customer/{customerId}`

    curl --location 'https://spring-customer-api.onrender.com/customer/1c80389b-f16d-4d63-a78b-e0e430cb4a40'

### Response

    HTTP/1.1 200 OK
    {
        "customerId": "1c80389b-f16d-4d63-a78b-e0e430cb4a40",
        "customerName": "Nike USA",
        "customerDocument": "62080338000158",
        "customerAddress": "855 6th Ave, Nova Iorque, NY, Estados Unidos",
        "createdAt": "2023-10-14T17:29:15.097222"
    }

## Find All Customers

### Request

`GET /customer`

    curl --location 'https://spring-customer-api.onrender.com/customer'

### Response

    HTTP/1.1 200 OK
    [
        {
            "customerId": "1c80389b-f16d-4d63-a78b-e0e430cb4a40",
            "customerName": "Nike USA",
            "customerDocument": "62080338000158",
            "customerAddress": "855 6th Ave, Nova Iorque, NY, Estados Unidos",
            "createdAt": "2023-10-14T17:29:15.097222"
        },
        {
            "customerId": "5000f63b-99c5-4c65-ae83-8bdd38ab700f",
            "customerName": "Adidas Brasil",
            "customerDocument": "02190648000101",
            "customerAddress": "Alphaville Industrial, Barueri, SP",
            "createdAt": "2023-10-14T17:38:36.90534"
        }
    ]