# Spring Security Tasks

This repository contains multiple Spring Security practice tasks demonstrating different authentication and authorization techniques.

---

## 📝 Task 1: In-Memory Authentication (Basic)

- Simple **In-Memory Authentication** setup.
- Configured fixed username/password using Spring Security's `InMemoryUserDetailsManager`.
- No role-based access control in this task.
- Login handled by Spring Security’s default login form.
  
---

## 📝 Task 2: In-Memory Authentication with Defined Roles

- Extended **In-Memory Authentication** to assign roles to users.
- Configured URL-based authorization:
  - `/Admin/**` accessible only to users with **ADMIN** role.
  - `/User/**` accessible only to users with **USER** role.
- Still using Spring Security’s default login form.
- Users are redirected to default success URL after login.

---

## 📝 Task 3: Custom Login Page with Thymeleaf & Role-Based Forwarding

- Implemented **Custom Login Page** using **Thymeleaf** templates.
- Defined custom login processing path `/login`.
- After successful login, user is forwarded to different pages based on role:
  - **ADMIN** → Admin Home Page.
  - **USER** → User Home Page.
- Handled URL restrictions based on roles.
- Used Spring Security’s `SecurityContextHolder` to access authenticated user roles programmatically.

---
# 🛡️ Task 4: Database Authentication using UserDetailsService (REST API Based)

This task demonstrates **Database-Based Authentication** using **Spring Security's UserDetailsService**, manual REST login, and role-based access control.

---

## ✅ Features:
- Custom **UserDetailsService** to load user from **Database**.
- Manual **REST-based login** endpoint.
- **BCrypt** password encoding.
- Role-based URL authorization.
- **CSRF** and **FormLogin** disabled to allow stateless REST API behavior.

---

## 📂 Endpoints:

| Method | URL          | Description                                    | Auth Required |
|--------|--------------|------------------------------------------------|---------------|
| POST   | `/register`   | Register new user                              | ❌ No          |
| POST   | `/login`      | Login with username/password                  | ❌ No          |
| GET    | `/secure`     | Secure endpoint requires authentication       | ✅ Yes         |
| GET    | `/admin/**`   | Requires ADMIN role                           | ✅ Yes         |
| GET    | `/user/**`    | Requires USER role                            | ✅ Yes         |

---



## 🛠️ Tech Stack:
- Spring Boot
- Spring Security
- Thymeleaf (Task 3)
- Java 21
- Maven

---
# 📝 Task 5: Category, Product, and Order Management System  

## ✅ Objective
Create a system to manage **Categories**, **Products**, and **Orders with Order Items** using Spring Boot and MySQL.  

---

## ✅ Features Implemented
- Built a **RESTful API** using **Spring Boot**.
- Implemented CRUD operations for **Categories**, **Products**, and **Orders**.
- Used **DTOs** with **MapStruct** for object mapping.
- Added **input validation** using **Spring Validation**.
- Integrated with **MySQL** using **Spring Data JPA & Hibernate**.
- Handled **error responses gracefully** with appropriate HTTP status codes.

---

## ✅ Endpoints

### **Category Endpoints**
| Method | URL                   | Description                     |
|--------|------------------------|---------------------------------|
| POST   | `/categories`          | Create a new category          |
| GET    | `/categories`          | Retrieve all categories        |
| GET    | `/categories/{id}`     | Retrieve a category by ID      |
| PUT    | `/categories/{id}`     | Update a category by ID        |
| DELETE | `/categories/{id}`     | Delete a category by ID        |

### **Product Endpoints**
| Method | URL                   | Description                     |
|--------|------------------------|---------------------------------|
| POST   | `/products`            | Create a new product           |
| GET    | `/products`            | Retrieve all products          |
| GET    | `/products/{id}`       | Retrieve a product by ID       |
| PUT    | `/products/{id}`       | Update a product by ID         |
| DELETE | `/products/{id}`       | Delete a product by ID         |

### **Order Endpoints**
| Method | URL                   | Description                     |
|--------|------------------------|---------------------------------|
| POST   | `/orders`              | Create a new order             |
| GET    | `/orders`              | Retrieve all orders            |
| GET    | `/orders/{id}`         | Retrieve an order by ID        |
| PUT    | `/orders/{id}`         | Update an order by ID          |
| DELETE | `/orders/{id}`         | Delete an order by ID          |

---
