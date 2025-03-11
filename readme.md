# Flag Explorer App

## Overview
The **Flag Explorer App** is a web-based application that allows users to browse country flags and view details such as the country's name, population, and capital. It is built using modern software development best practices, including frontend-backend integration, automated testing, and CI/CD pipeline implementation.

## Technologies Used
- **Frontend:** Vue.js
- **Backend:** Java (Spring Boot)
- **API Source:** [REST Countries API](https://restcountries.com/v3.1/all)
- **Testing Frameworks:** Vitest, Vue Test Utils (Frontend), JUnit (Backend)
- **CI/CD:** GitHub Actions

## Features
### Frontend
✅ Home screen displaying all country flags in a responsive grid layout.  
✅ Detail screen showing country name, population, and capital when a flag is clicked.  
✅ Fully tested components with unit and integration tests.

### Backend
✅ Exposes an API endpoint to retrieve a list of countries.  
✅ Supports querying by country name for additional details.  
✅ Includes unit and integration tests.

### CI/CD
✅ Automated tests for both frontend and backend.  
✅ Build pipeline for frontend and backend.  
✅ GitHub Actions workflow for continuous integration.

## Installation & Setup

### **Prerequisites**
- Node.js (18.x or later)
- Java (JDK 17 or later)
- Maven
- Git

### **Clone the Repository**
```sh
git clone <repository-url>
cd flag-explorer-app
```

### **Frontend Setup**
```sh
cd frontend
npm install
npm run serve
```
Visit `http://localhost:8080/` in your browser.

### **Backend Setup**
```sh
cd backend
mvn spring-boot:run
```
Backend runs on `http://localhost:8081/`.

## Running Tests
### **Frontend Tests**
```sh
cd frontend
npm test
```
### **Backend Tests**
```sh
cd backend
mvn test
```

## Deployment & CI/CD
The project includes a GitHub Actions workflow for CI/CD:
- **On push to `main` branch:**
    - Runs tests for frontend and backend.
    - Builds the application.
    - Packages frontend and backend for deployment.

### **Manual Build Commands**
If you want to manually build and package the project:
```sh
cd frontend
npm run build
```
```sh
cd backend
mvn package
```

## Directory Structure
```
flag-explorer-app/
│── backend/               # Spring Boot Backend API
│── frontend/              # Vue.js Frontend
│── .github/workflows/     # CI/CD Pipeline Configuration
│── README.md              # Documentation
│── .gitignore             # Git Ignore File
```

## License
This project is open-source and licensed under the MIT License.

