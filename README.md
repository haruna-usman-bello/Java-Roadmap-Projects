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
    - JDK 17 or 21
    - IntelliJ IDEA (Community or Ultimate)
    - Maven (usually bundled in IntelliJ)

2. **Get Started**
   ```bash
   git clone https://github.com/haruna-usman-bello/java-roadmap-projects.git
   cd java-roadmap-projects
   # Open the folder in IntelliJ → it auto-detects as Maven project