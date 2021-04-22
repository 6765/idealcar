# Ideal Car

## Running application

### Requirements
 - Mysql 8+
 - Java 11+

### Using docker-compose
```bash
docker-compose up
```

## API

Step to reproduce:

1. Create a user
2. Use the accessToken for authentication in Authorization header as type Bearer 
3. Create a car (requires authentication)
4. Comment a car
5. List all cars

> A postman collection is available in the repository.

### Create user
```bash
curl --location --request POST 'http://localhost:8080/api/user' \
--header 'Content-Type: application/json' \
--header 'Accept: application/json' \
--data-raw '{
    "firstName": "Olga",
    "lastName": "Rath",
    "email": "Marshall81@yahoo.com",
    "password": "1kOwxaSX7m0yW00"
}'
```

### Create car
```bash
curl --location --request POST 'http://localhost:8080/api/car' \
--header 'Content-Type: application/json' \
--header 'Accept: application/json' \
--header 'Authorization: Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJQcmVzdG9uX0phY29iaUB5YWhvby5jb20iLCJleHAiOjE2MTkxMzc5NDcsImlhdCI6MTYxOTExOTk0N30.yI9t4rwSISWReybEGRlaSlpyHJUiJEUj23RA5C4m18M89fiYQmr9HI2KgQWrTGvJrQYDYusWfGNZ_caKZfdTyw' \
--data-raw '{
    "model": "vortals",
    "maker": "Breitenberg and Sons",
    "power": 400,
    "numberOfPlaces": 2
}'
```

### Comment a car
```bash
curl --location --request POST 'http://localhost:8080/api/comment/car/2' \
--header 'Content-Type: application/json' \
--header 'Accept: application/json' \
--header 'Authorization: Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJQcmVzdG9uX0phY29iaUB5YWhvby5jb20iLCJleHAiOjE2MTkxMzc5NDcsImlhdCI6MTYxOTExOTk0N30.yI9t4rwSISWReybEGRlaSlpyHJUiJEUj23RA5C4m18M89fiYQmr9HI2KgQWrTGvJrQYDYusWfGNZ_caKZfdTyw' \
--data-raw '{
    "comment": "contextually-based"
}'
```

### List cars
```bash
curl --location --request GET 'http://localhost:8080/api/car/all'
```