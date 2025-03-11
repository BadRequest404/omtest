# Flag Explorer App

A modern application that allows users to explore country flags and details.

## Project Structure

This project follows Clean Architecture principles with clear separation of concerns:

- `controller`: REST API endpoints
- `service`: Business logic
- `model`: Data entities
- `exception`: Custom exception handling

## Getting Started

### Prerequisites

- Java 17 or higher
- Maven

### Running the Application

1. Clone the repository
2. Navigate to the project directory
3. Run: `mvn spring-boot:run`
4. The API will be available at: `http://localhost:8080`

### API Endpoints

- `GET /countries` - Get a list of all countries
- `GET /countries/{name}` - Get details about a specific country

## Running Tests

Run: `mvn test`

## Future Enhancements

- Frontend implementation with React (Part 2)
- Pipeline integration for automated deployment (Part 3)