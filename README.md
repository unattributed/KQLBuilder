# KQLBuilder

KQLBuilder is a Java-based web application that provides a simple UI for building Kusto Query Language (KQL) queries. It helps users construct queries using dropdowns and form inputs, and supports parsing logs from Azure, AWS, and GCP through file upload or API access.

## Features
- Web UI for building KQL queries with dropdowns
- Support for Azure Monitor, AWS CloudWatch, and GCP Logging
- File upload for local log parsing
- KQL preview and Azure execution via API
- Modular and maintainable codebase with Java, Spring Boot, and Thymeleaf
- Securely designed with clear, well-documented code

## Requirements
- Java 17+
- Maven 3.8+
- Node.js (optional, for UI assets)

## Getting Started

### Clone the repository
```bash
git clone https://github.com/unattributed/KQLBuilder.git
cd KQLBuilder
```

### Build with Maven
```bash
mvn clean install
```

### Run the application
```bash
mvn spring-boot:run
```

Then open your browser to [http://localhost:8080](http://localhost:8080)

## Deployment Options

KQLBuilder can be deployed to any cloud platform that supports Java-based applications. Some common and cost-effective providers include:

### DigitalOcean
- Deploy on a Droplet (Ubuntu server)
- Install Java & Maven, clone the repo, and run the app
- Optionally use Nginx for reverse proxy and Let's Encrypt for HTTPS

### Vultr
- Use a Cloud Compute instance or High Frequency VPS
- Follow the same setup steps as DigitalOcean

### Others
- Compatible with AWS EC2, Azure VMs, GCP Compute Engine
- Docker support for containerized deployment (optional future enhancement)

## Project Structure
```
KQLBuilder/
├── src/main/java/com/intranet/logquerytool
│   ├── controller
│   ├── model
│   ├── service
│   └── util
├── src/main/resources
│   ├── templates
│   └── application.yml
├── pom.xml
└── README.md

Modularize now to future-proof code:

src/main/java/com/intranet/KQLBuilder/
├── Main.java                  # Entry point
├── CloudProvider.java         # Enum for providers
├── KQLQueryGenerator.java     # Interface or abstract class
├── generators/
│   ├── AzureQueryGenerator.java
│   ├── AWSQueryGenerator.java
│   └── GCPQueryGenerator.java
└── utils/
    └── ConsoleInput.java      # Helper for reading input cleanly


```

## License
MIT License
