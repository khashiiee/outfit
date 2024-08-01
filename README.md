# Outfit Recommendation System

## Table of Contents
1. [Project Overview](#project-overview)
2. [System Architecture](#system-architecture)
3. [Entity-Relationship Diagram](#entity-relationship-diagram)
4. [Key Features](#key-features)
5. [Technologies Used](#technologies-used)
6. [API Endpoints](#api-endpoints)
7. [Setup and Installation](#setup-and-installation)
8. [Future Improvements](#future-improvements)

## Project Overview
This project is an Outfit Recommendation System designed to suggest personalized outfits to users based on various factors such as event type, user preferences, budget, and available inventory. The system aims to enhance the shopping experience by providing curated outfit suggestions, potentially increasing sales and customer satisfaction.

## System Architecture

### Proposed Architecture
https://drive.google.com/file/d/1n-8WgLC_2y2z5jT0w-EoGYsY8pMhByqY/view?usp=drive_link

### Implemented Architecture
https://drive.google.com/file/d/1hh05m8Er8t0CGKFpzNF755wPL0_RzgB-/view?usp=drive_link

Explanation of key differences between proposed and implemented architectures:
- Proposed Architecture diagram includes several additional components and considerations:
  1. Client Layer: Web UI and Mobile App to support multiple platforms.
  2. API Gateway: Added a Rate Limiter for traffic control and prevention of abuse.
  3. Security: Authentication Service for user identity verification and Authorization Service for access control.
  4. Caching: Redis Cache for improving performance of frequently accessed data.
  5. Message Queue: RabbitMQ for asynchronous processing, particularly for analytics.
  6. Data Storage: Relational Database for most application data. Time Series Database for efficiently storing and querying time-based analytics data.

- Key architectural considerations addressed in the Proposed Architecture:
  1. Scalability: Microservices architecture allows independent scaling of components.
  2. Performance: Caching layer and asynchronous processing via message queue.
  3. Security: Dedicated authentication and authorization services.
  4. Resilience: Message queue helps in handling traffic spikes and ensures data integrity.
  5. Data Management: Separate databases for different types of data (relational vs time series).
  6. Extensibility: External services can be easily integrated or replaced.

    
## Entity-Relationship Diagram

### Proposed ERD
https://drive.google.com/file/d/1CTOj6d3ePG-UQ2iENmUb_YHM6k3R2a8A/view?usp=drive_link

### Implemented ERD
https://drive.google.com/file/d/1RrEkIExqcENbb3wQK-DL_vuhANxGKVPa/view?usp=drive_link

Explanation of key differences between proposed and implemented ERDs:
- Proposed ERD includes several improvements to address the requirements more comprehensively:
  1. UserPreference Entity:  More flexible and detailed user preferences, which can be easily extended without modifying the User entity.
  2. Analytics Entity: This helps track tool usage, including total requests, ratings, and sales. It's connected to RecommendationRequest, OutfitRating, and a new Purchase entity.
  3. Purchase Entity: This tracks actual purchases made through the recommendation system, which is crucial for assessing the tool's profitability.
  4. CustomizedOutfit Entity: This allows users to create custom outfits based on recommendations, implementing the mix-and-match functionality.
  5. Additional Attributes:
      - Event: Added a 'description' field for more detailed event information.
      - OutfitRating: Added a 'ratingDate' to track when ratings are made.
      - RecommendationRequest: Added a 'requestDate' to track when requests are made.
  6. Simplified User Entity: Moved preferences to the separate UserPreference entity for more flexibility.



## Key Features
- Event-based outfit recommendations
- Budget-aware suggestions
- User preference consideration
- Inventory-aware recommendations
- Mix-and-match functionality
- User feedback system
- Analytics for long-term feasibility assessment

## Technologies Used
- Java (version 21)
- Spring Boot (version 3.3.2)
- Cosmos DB
- Spring Cloud Azure (version 5.14.0)
- Spring Security
- Spring Web
- Lombok
- Spring Boot DevTools
- Maven

## API Endpoints

### POST /recommendations
Generates outfit recommendations based on user input.

#### Request Body:
```jsonc
{
  "userId": "string",
  "eventId": "string",
  "budget": "number",
  "season": "enum"   //  SPRING, SUMMER, AUTUMN, ALL, WINTER

}
```

#### Response Body:
```jsonc
{
  "recommendedOutfits": [
    {
      // Outfit details
    }
  ],
  "userId": "string",
  "eventId": "string",
  "budgetExceeded": "boolean",
  "affordableOutfits": [
    {
      // Outfit details
    }
  ],
  "expensiveYetGoodOutfits": [
    {
      // Outfit details
    }
  ]
}
```

## Setup and Installation
1. Clone the repository: `git clone https://github.com/khashiiee/outfit.git`
2. Navigate to the project directory: `cd outfit`
3. Build the project:  `mvn clean install` 
4. Run the application: `mvn spring-boot:run -Dspring-boot.run.jvmArguments="--add-opens java.base/java.math=ALL-UNNAMED"` 

## Note
The `--add-opens java.base/java.math=ALL-UNNAMED` argument is required to allow the application to access certain JDK internal APIs.

## Alternative Run Methods

### Using java -jar
If you prefer to run the application using the `java -jar` command after building:

1. Build the project with Maven:
   ```
   mvn clean package
   ```

2. Run the generated JAR file:
   ```
   java --add-opens java.base/java.math=ALL-UNNAMED -jar target/outfit-0.0.1-SNAPSHOT.jar
   ```

### IDE Configuration
When running the application in an IDE like IntelliJ IDEA, add the following to your VM options in the run configuration:

```
--add-opens java.base/java.math=ALL-UNNAMED
```

## Troubleshooting
If you encounter any issues related to Java modules or accessing internal APIs, ensure that the `--add-opens` argument is correctly applied in your run configuration.

## Future Improvements
- Implement machine learning algorithms or get the use of external service to score the outfits for better recommendations.
- Add support for seasonal trends.
- Add more outfit templates.
- Add support for JWT authentication instead of basic auth.

