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

## 📁 Structure:
