# 🧾 Complaint Management System – Second Semester Coursework

This project is a **Java Maven Web Application** developed using **Jakarta EE (Servlets & JSP)**. It demonstrates a full-stack approach to web application development, covering backend processing, frontend rendering, and data flow handling. The system focuses on basic complaint management functionality—allowing users to submit, view, and manage complaints.

---

## 📌 Project Overview

### 🎯 Key Features

* ✅ Submit, store, and retrieve complaint data
* ✅ Admin and employee access logic
* ✅ RESTful API structure via servlets
* ✅ Frontend UI built with JSP and Bootstrap
* ✅ Session handling and email-based data querying
* ✅ Object mapping with Jackson (JSON parsing)

---

## ⚙️ Setup & Configuration Guide

### 🔧 Prerequisites

* Java JDK 17+
* Apache Tomcat 10 or 11+
* Apache Maven
* MySQL (or compatible DB)
* IDE (e.g., IntelliJ IDEA, Eclipse)

### 📦 Clone the Repository

```bash
git clone https://github.com/ireshdilsh/second-sem-cw.git
cd second-sem-cw
```

### ⚙️ Build and Deploy

1. Open the project in your IDE.
2. Make sure `pom.xml` dependencies are downloaded.
3. Deploy the project to your local Apache Tomcat server.
4. Start the server and navigate to `http://localhost:8080/backend/`.

## 📁 Structured Source Code Layout

```
second-sem-cw/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com.example.backend/
│   │   │       ├── controller/        # Servlet controllers (Admin, Employee, Complaint)
│   │   │       ├── model/             # Data model and DB logic
│   │   │       └── dto/               # DTOs (e.g., ComplainDto)
│   │   ├── resources/
│   │   └── webapp/
│   │       ├── index.jsp              # Main entry JSP
│   │       └── views/                 # JSP pages
├── pom.xml                            # Maven dependencies
```

---

## 📜 Technologies Used

* Java 17
* Jakarta EE (Servlet API)
* Apache Tomcat
* JSP
* Bootstrap
* Maven
* MySQL
* Jackson Databind (JSON mapping)

---

## 🔁 Commit History

This repository follows a clear, chronological commit trail representing development stages:

* ✅ Initial Maven setup and folder structure
* ✅ Servlet and DTO creation
* ✅ JSP integration
* ✅ Complaint logic and session handling
* ✅ Bug fixes and polish

Explore the full commit history [here](https://github.com/ireshdilsh/second-sem-cw/commits/main)

---

## ✅ Future Enhancements

* Add login and authentication (JWT or session-based)
* Improve error handling and validations
* Create admin dashboard analytics
* Connect to cloud-hosted MySQL
* Use ORM (e.g., Hibernate or JPA)

---

## 👤 Author

**Iresh Dilshan Nishantha**
🎓 Undergraduate – Software Engineering
