# Building a REST API with Spring Boot

## What will you build?

> You'll be building a simple Family Cash Card application — a modern way for parents to manage allowance funds for
> their kiddos. Parents often find themselves lacking an easy way to manage (i.e. send, receive, track) allowances for
> their kids. So instead of handing out a stack of bills, our cloud-based Family Cash Card app allows parents to
> virtually
> manage "cash cards" for their kiddos. You can think of the cash card being very similar to a gift card that many of us
> send and receive. The primary goal of the Family Cash Card app is to give parents ease and control over managing funds
> for their children. You'll use Spring Boot to progress from creating a single cash card in a database to allowing for
> the editing, deleting, and viewing of multiple cash cards, and finally securing your app against unauthorized access
> and
> unwanted exploits.

## Lab01: Spring Initializr

> Spring and Spring Boot are Java frameworks for building applications. Spring is versatile with many modules, while
> Spring Boot is a streamlined version with pre-configured settings and dependencies. Spring Boot uses Spring Core's
> Inversion of Control container and Spring Initializr is a tool for generating ready-to-run Spring Boot applications.

![](.doc/set_up_01.png)
![](.doc/set_up_02.png)

## Lab02: Testing First

> API contracts are formal agreements between API providers and consumers that define how they will interact, what data
> will be exchanged, and how success and failure cases will be communicated. API contracts are important because they
> communicate the behavior of a REST API and can be easily translated into functionality and automated tests. JSON is a
> popular data interchange format for APIs because it is easy to read and write, takes up less space than XML, and works
> seamlessly with Javascript-based applications.
>
> Test Driven Development (TDD) is an approach where tests are written before implementing application code. This
> ensures that the system is designed based on desired behavior instead of existing functionality. TDD also guides
> developers to write the minimum code needed to satisfy the implementation and guards against introducing errors in the
> future. The Testing Pyramid is a hierarchy of different types of tests, including **unit tests, integration tests, and
end-to-end tests**. **The Red, Green, Refactor loop** is a development cycle that involves writing a failing test,
> implementing the simplest thing to make the test pass, and then refactoring the code to improve it without changing
> any
> behavior.

## Lab03: GET

> **REST** is a way to manage the values of things via an API, often stored in a database. **CRUD** are the four basic
> operations that can be performed on objects in a data store. **HTTP** is commonly used with REST to handle requests
> and
> responses. For each CRUD operation, there is a specific HTTP method to be used: **POST for CREATE, GET for READ, PUT
for
UPDATE, DELETE for DELETE**. The endpoint URI for Cash Card objects begins with the /cashcards keyword, and READ,
> UPDATE, and DELETE require a unique identifier. For CREATE, the application will create a new unique identifier.

| Operation | API Endpoint/URI | HTTP Method/Verb | Response StatusCode |
|-----------|------------------|------------------|---------------------|
| Create    | /cashcards       | POST             | 201 (CREATED)       |
| Read      | /cashcards/{id}  | GET              | 200 (OK)            |
| Update	   | /cashcards/{id}  | PUT              | 204 (NO DATA)       |
| Delete    | /cashcards/{id}  | DELETE           | 204 (NO DATA)       |

For example,
```yaml
Request:
  Method: GET
  URL: http://cashcard.example.com/cashcards/123
  Body: (empty)
```

```yaml
Response:
  Status Code: 200
  Body:
  {
    "id": 123,
    "amount": 25.00
  }
```

In Spring Boot, REST is implemented using Spring's IoC container(as opposed to using the Java `new` keyword) and web controllers. 
- Controllers handle **requests**, and RestController is used to create REST controllers. Controller methods are designated as handler methods using annotations like `@GetMapping`. The `@PathVariable` annotation is used to get the value of the requested parameter.
- `ResponseEntity` is used to produce **Response** Entities with the correct response code and body.

## Lab04: Repositories & Spring Data

> The Separation of Concerns principle states that software should be modular with distinct and separate concerns. To enforce data management separation, the Controller-Repository Architecture pattern is used, with the Controller layer near the client and the Repository layer near the data store. Spring Data provides robust data management tools, including implementations of the Repository pattern. An in-memory database, H2, is used for convenience in local development, but trade-offs exist compared to a persistent database. Spring Boot's Auto Configuration feature automatically configures the application to communicate with H2. The CrudRepository, a specific type of Repository in Spring Data, provides convenient out-of-the-box methods for CRUD operations, with implementations generated by Spring Data during IoC container startup time.
## Lab05:
