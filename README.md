# Java BDD Selenium Project

This project automates job search scenarios on the Careers website using Selenium, Cucumber (BDD), and TestNG.

## Prerequisites

1. **Java** installed on your system (Java 8+ recommended).
2. **Maven** installed for building and running the project.
3. **Git** installed (optional, if you want to clone from a remote repository).

## Project Structure

- **src/main/java**: Contains main Java source code, including the `utils`, `pages`, and `testBase` packages.
- **src/test/java**: Contains step definitions (`StepDefinitions.java`) and the Cucumber test runner (`CucumberTestRunner.java`).
- **src/test/resources/features**: Contains feature files (e.g. `jobSearch.feature`) describing test scenarios in Gherkin syntax.
- **pom.xml**: Maven configuration file that manages project dependencies, build, and plugins.

## How to Set Up

1. **Clone the repository** (if not already):  
   ```bash
   git clone <REPO_URL>
   ```
   Navigate inside the project directory.

2. **Install dependencies**:  
   ```bash
   mvn clean install
   ```

3. **Configuration**:  
   - The **config.properties** file in `src/main/resources/config/` contains settings such as `browser`, `base.url`, etc.  
   - Adjust these configurations to your requirements.

4. **Optional**: Use **IDE** (IntelliJ/Eclipse) to import the Maven project for easier development.

## How to Run Tests

To run tests via Maven, execute:

```bash
mvn clean test -Dtest=Runner.CucumberTestRunner
```

- This command will run the Cucumber tests specified by `CucumberTestRunner`.

## Reports

- **Spark Report**: The Extent report is generated in `Spark.html` under the project root after tests run.
- **Screenshots**: On test failure, screenshots are saved to `reports/screenshots/`.

## Troubleshooting

- If the tests fail randomly or have timing issues, try adjusting the explicit and implicit wait times in `config.properties`.
- Check the browser driver versions if you encounter compatibility issues.

Feel free to contribute or raise issues if you encounter any problems!
