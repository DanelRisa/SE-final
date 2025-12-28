This is a Spring Boot-based e-learning platform that supports user registration, authentication, course management, lessons, enrollments, payments, reviews, categories, certificates, and notifications. 
We use JWT for security, PostgreSQL for database, and Liquibase for migrations.
---
How to launch
1. Prerequisites:
   - Java 17+
   - Maven 3.8+
   - PostgreSQL 15+ (db elearning_db)
   - Environment variables or update application.properties:
     - spring.datasource.url=jdbc:postgresql://localhost:5432/elearning_db
     - spring.datasource.username=your_db_user
     - spring.datasource.password=your_db_password
     - jwt.secret=your_jwt_secret_key

2. Build and Run

   mvn clean install
   mvn spring-boot:run

3. Postman
   Set baseUrl to http://localhost:8080 and token to JWT after login
---
Migrations are managed by Liquibase

mvn liquibase:update

Or Spring Boot will do it it automatically with spring.liquibase.enabled=true in application.properties. Changelog files are in src/main/resources/db/changelog

----
Architecture Description
- Backend: Spring Boot 3.x with Spring Data JPA, Spring Security (JWT), MapStruct for mapping, Lombok
- Database: PostgreSQL with entities like User, Course, Lesson, Enrollment, Review, Certificate and others
- Security: Role-based access (ADMIN, TEACHER, STUDENT). JWT for auth.
- Layers: Controllers - Services - Repositories - Entities
- Additional: Liquibase for DB migrations, Hibernate, Tests

----
API

- Auth:
  - POST /api/auth/register: Register a new user (username, email, password, role).
  - POST /api/auth/login: Login and get JWT token (username, password).

- Courses:
  - GET /api/courses: Get list of all courses.
  - DELETE /api/courses/{id}: Delete course by ID (ADMIN only).
  - POST /api/courses: Create new course (TEACHER only; title, description, categoryId).
  - GET /api/courses/{id}: Get course details by ID.
  - PUT /api/courses/{id}: Update course (TEACHER only; title, description).
  - POST /api/enrollments: Enroll in a course (STUDENT only; courseId).
  - GET /api/courses/{id}/lessons: Get lessons for a specific course.
  - POST /api/lessons: Create a new lesson (TEACHER only; title, content, courseId).
  - POST /api/payments: Pay for a course (courseId, amount).
  - POST /api/reviews: Create review for a course (STUDENT only; courseId, rating, comment).
  - GET /api/reviews/course/{id}: Get reviews for a specific course.

  - Categories:
  - GET /api/categories: Get list of all categories.
  - POST /api/categories: Create new category (ADMIN only; name).
  - DELETE /api/categories/{id}: Delete category by ID (ADMIN only).

- Certificates:
  - POST /api/certificates: Issue certificate (ADMIN/TEACHER only; userId, courseId).

- Notifications:
  - POST /api/notifications: Send notification (ADMIN only; userId, message).

- Reviews:
  - POST /api/reviews: Create review (STUDENT only).
