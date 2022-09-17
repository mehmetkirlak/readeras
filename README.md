
# "Readeras" is a Backend of simple e-commerce book market.
___
### Spring Boot and ReactJS Application
___

### Summary
"Readeras" can be used for basic level e-commerce book market.

___
The application has 3 apis
* BookAPI
```html
GET /v1/books - retrieves all books
GET /v1/books/{bookId} - retrieves a book
POST /v1/books - creates a new book
PUT /v1/books/{bookId} - updates specificied book
DELETE /v1/books/{bookId} - deletes specificied book
```
* CategoryAPI
```html
GET /v1/categories - retrieves all categories
GET /v1/categories/{categoryId} - retrieves a category
POST /v1/categories - creates a new category
PUT /v1/categories/{categoryId} - updates specificied category
DELETE /v1/categories/{categoryId} - deletes specificied category
```
* UserAPI
```html
GET /v1/users - retrieves all users
GET /v1/users/{userId} - retrieves a user
POST /v1/users - creates a new user
PUT /v1/users/{userId} - updates specificied user
DELETE /v1/users/{userId} - deletes specificied user
```

### Tech Stack

---
- Java 11
- Spring Boot
- Spring Data JPA
- Restful API
- Postgres Database
- Docker
- Docker compose

### Prerequisites

---
- Postgres
- Maven
- Docker

### Run & Build

First you need to pull java amazoncorretto version 11 image. If you want to use 
other java images you can configure it in Dockerfile.
After that you can just run `docker-compose up` command.