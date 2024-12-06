# Shuttle🎇 Abandoned for lack of interest

## Despite the fact that the project was abandoned even before the start of productive development, you can pick up something good in this project for yourself

The **Shuttle** project is a set of microservices mostly based on Spring Boot for controlling a space taxi. 
Within the framework of this project, various functionality has been implemented for working with space flights and interaction between microservices.

## How to Launch a Project

To launch the Shuttle project, follow these steps:

### Prerequisites

Ensure you have the following software installed on your system:
- Docker and Docker Compose
- Java 21 or newer
- Gradle 6.8 or newer

### Step 1: Setting Up Databases

The project requires PostgreSQL and MongoDB databases. You can either install them manually or set them up using Docker.

#### Option A: Install Databases Manually

1. **PostgreSQL**:
   - Download and install PostgreSQL from the [official website](https://www.postgresql.org/download/).
   - Start the PostgreSQL service.

2. **MongoDB**:
   - Download and install MongoDB from the [official website](https://www.mongodb.com/try/download/community).
   - Start the MongoDB service.

#### Option B: Use Docker for Databases
1. **PostgreSQL**:
   ```sh
   docker pull postgres:latest
   docker run --name some-postgres -e POSTGRES_PASSWORD=mysecretpassword -d postgres
   ```
2. **MongoDB**:
   ```sh
   export MONGODB_VERSION=6.0-ubi8
   docker run --name mongodb -d mongodb/mongodb-community-server:$MONGODB_VERSION
   ```
### Step 2: Run Kafka, Zookeeper, Otel-collector, Prometheus, Graphana.
   ```sh
   cd docker
   docker compose up
   ```
### Step 3: Publish to Maven Local
   ```sh
   cd shared
   ./gradlew publishToMavenLocal
   ```

### Step 4: Run Discovery and Config server
   ```sh
   cd discovery-server
   ./gradlew bootRun
   cd ../config-server
   ./gradlew bootRun
   ```
### Step 5: Run the rest of the microservices one at a time, as it suits you
  I apologize for such inconveniences, in the future all microservices will be launched via kybernetes

## Microservices 🛠️
The following list lists the microservices of the project with the status of their implementation 
(this list may change regularly due to the addition of new features and architecture refactoring):

- Pilot Feedback Service and User Feedback Service (Implemented, not tested)✅
- Shuttle Information Service (Not implemented)😪
- Pilot Information Service (Not implemented)😪
- User Information Service (Not implemented)😪
- Pilot Rank Service (In progress)🔨
- Trip Path Finder Service (In progress)🔨
- Trip Calculation Service (Not implemented)😪
- Payment Service (Not implemented)😪
- Pilot Personal Data Service (In progress)🔨
- Order Service (Not implemented)😪
- Station Information Service (Not implemented)😪

Microservices communicate with each other through Apache Kafka, which provides messaging and rating updates.

## Functionality 🌌
- Calculation of the path from one planet to another, taking into account their movement in orbit
- Collecting and processing feedback from users and pilots.
- Choosing a flight class.
- Pilot rank system.
- Verification of personal data of pilots.
- Calculating the cost of a flight due to the length and complexity of the flight.
- Implementation of the payment service taking into account the Shuttle commission (thank you for choosing us!😊😊😊).
- React app for documentation, using React flow (its very beautiful and awesome!!!!)

## Possible functionality ✨
- Simulation of shuttle breakdowns (WITHOUT ENDANGERING THE LIVES OF PASSENGERS!😇😇😇).
- Implementation in 3D space, so that it would be like NASA: https://eyes.nasa.gov/apps/solar-system/#/home

## Architecture 🏗️

The project uses the following technologies and approaches:

- **Spring Boot** for creating microservices. (There are exceptions, for example, the path finding microservice)
- **Apache Kafka** for message processing.
- **OpenTelometry, Graphana, Prometheus** for monitoring and tracing.
- **Docker & Kubernetes & GitHub Actions** for deploying.
- **PGSQL, MONGODB, REDIS, CASSANDRA** as databases. 
- 
## Charts and metrics 📊
### Visualization of the shuttle ordering process
The diagram previously shown here is now invalid

#### In the future, all documentation, diagrams, calculations of metrics such as DAU, MAU and so on will be implemented as a React application using React Flow, there will be no more such vile diagrams 😥😥😥

## Installation and requirements

To run the project, you will need the following tools and dependencies:

- Java 17 or later
- Maven 3.8.1 or later
- Docker (optional, for working with containers)

Make sure that all dependencies are installed and configured before starting the project.

## License

don't steal anything please((((

## Contacts 📬

If you have any questions or suggestions, you can contact me via [GitHub Issues](https://github.com/ваш_пользовательский_имя/Shuttle/issues ) or by [Email](mailto:vkuksa.tech@outlook.com) or by [Telegram](https://t.me/vkuksatech).

---

**Shuttle** is the space taxi of the future, driven by modern microservice technologies!
