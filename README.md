# Java Roadmap Projects

A collection of **Java-based implementations** of the backend projects from [roadmap.sh/backend/projects](https://roadmap.sh/backend/projects).

This repository is structured as a **multi-module Maven project** in IntelliJ IDEA, where each roadmap project lives in its own independent module.  
Perfect for learning backend development step-by-step in **Java** (JDK 25 recommended), practicing clean architecture, testing, persistence, APIs, CLI tools, Docker, and more.

## Why this repo?

- Follows the official [roadmap.sh backend project list](https://roadmap.sh/backend/projects) (Beginner → Intermediate → Advanced)
- Everything in **one repo** → easy to clone, open in IntelliJ, and switch between projects
- Each module is self-contained (own `pom.xml`, `src/`, README inside if needed)
- Focus on **realistic Java practices**: Maven, proper package structure, JSON handling (Gson/Jackson), Spring Boot for APIs, etc.
- Great for building a strong **Java backend portfolio**

## Project List & Status

### Beginner

- [x] **task-tracker-cli** — CLI Task Tracker (JSON persistence, full CRUD)
- [ ] **github-user-activity-cli** — GitHub User Activity CLI (GitHub API)
- [ ] **expense-tracker-cli** — CLI Expense Tracker
- [ ] **number-guessing-game-cli** — Number Guessing Game
- [ ] **unit-converter-web** — Web Unit Converter
- [ ] **personal-blog-web** — Personal Blog Web App
- [ ] **weather-api** — Weather API
- [ ] **blogging-platform-api** — Blogging Platform API (REST)
- [ ] **todo-list-api** — Todo List API (REST)
- [ ] **expense-tracker-api** — Expense Tracker API
- [ ] **github-trending-cli** — GitHub Trending CLI
- [ ] **tmdb-cli** — TMDB CLI Tool (movie data)

### Intermediate

- [ ] **caching-proxy-server** — Caching Proxy
- [ ] **markdown-notes-api** — Markdown Note-taking API
- [ ] **url-shortener-api** — URL Shortener Service
- [ ] **broadcast-server** — Broadcast Server
- [ ] **multi-container-app** — Multi-Container App (Docker Compose)
- [ ] **ecommerce-api** — E-Commerce API (cart + payments stub)
- [ ] **workout-tracker-api** — Workout Tracker API
- [ ] **image-processing-api** — Image Processing Service
- [ ] **linux-server-setup** — Linux Server Security & Setup (docs + scripts)

### Advanced

- [ ] **movie-reservation-api** — Movie Reservation System
- [ ] **realtime-leaderboard-api** — Real-time Leaderboard
- [ ] **db-backup-utility-cli** — Database Backup Utility
- [ ] **scalable-ecommerce-microservices** — Scalable E-Commerce (Microservices)

(✓ = implemented | □ = planned / in progress)

## Tech Stack (per module type)

- **CLI projects** → Pure Java + Gson/Jackson (no frameworks), Picocli (optional for args)
- **API / REST projects** → Spring Boot 3.x + Spring Web + Spring Data JPA / JDBC
- **Databases** → H2 (dev), PostgreSQL/MySQL (prod-ready), sometimes Redis
- **Build tool** → Maven (multi-module aggregator)
- **Testing** → JUnit 5 + AssertJ (aim for good coverage)
- **Other** → Docker, docker-compose (where relevant), Git

## How to Run / Develop

1. **Prerequisites**
    - JDK 25
    - IntelliJ IDEA (Ultimate)
    - Maven (usually bundled in IntelliJ)

2. **Get Started**
   ```bash
   git clone https://github.com/haruna-usman-bello/java-roadmap-projects.git
   cd java-roadmap-projects
   # Open the folder in IntelliJ → it auto-detects as Maven project
3. **In IntelliJ**
   - Right-click root pom.xml → Maven → Reload Project
   - To run a CLI module: right-click Main.java → Run (add program args if needed)
   - To run a Spring Boot API: right-click the @SpringBootApplication class → Run

4. **Add a new module (example)**
   - Right-click root → New → Module → Maven → ArtifactId = new-project-name
   - Update root pom.xml<modules> section
   - Maven → Reload Project

## Folder Structure

   ```bash
      java-roadmap-projects/
   ├── pom.xml                 # Root aggregator POM
   ├── .gitignore
   ├── README.md
   │
   ├── task-tracker-cli/
   │   ├── pom.xml
   │   ├── src/main/java/...
   │   └── tasks.json         (runtime file – gitignored)
   │
   ├── todo-list-api/
   │   ├── pom.xml
   │   ├── src/main/java/...  (Spring Boot app)
   │   └── application.yml
   │
   └── ... (one folder per project)
```

## Contributing
**Contributions welcome!**
   - Pick an uncompleted project
   - Create a branch: git checkout -b feature/expense-tracker-api 
   - Implement following the official project requirements 
   - Open a PR with clear description

## License
MIT License – feel free to use, fork, learn, and share.

[![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white)](https://openjdk.org/)
[![Maven](https://img.shields.io/badge/Apache%20Maven-C71A36?style=for-the-badge&logo=Apache%20Maven&logoColor=white)](https://maven.apache.org/)
[![Spring Boot](https://img.shields.io/badge/Spring%20Boot-6DB33F?style=for-the-badge&logo=spring&logoColor=white)](https://spring.io/projects/spring-boot)
[![GitHub](https://img.shields.io/badge/GitHub-100000?style=for-the-badge&logo=github&logoColor=white)](https://github.com/YOUR_USERNAME/java-roadmap-projects)
[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg?style=for-the-badge)](https://opensource.org/licenses/MIT)
[![Java Version](https://img.shields.io/badge/Java-17%20%7C%2021-blue?style=for-the-badge)](https://www.oracle.com/java/)
