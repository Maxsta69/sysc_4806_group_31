# Capstone Project Manager

## Building, Testing, Deployment

### Build Requirements
- Java 21. You should not have to download this yourself. Gradle will download an appropriate JDK automatically with the foojay-resolver plugin (see `settings.gradle.kts`).
- Gradle is used for building. You do not need to install Gradle on your local machine. The Gradle wrapper is commited to this repository and can be run with `./gradlew` (Unix) or `gradlew.bat` (Windows).
- The remaining instructions assume a Unix environment. You can use Git Bash or WSL on Windows if you want to follow the instructions exactly.

### Building
Build with `./gradlew clean assemble`.

### Testing
Run tests with `./gradlew check`.

Testing is done automatically on PRs and the main branch with the ??? workflow in `.github/workflows`.

### Deployment
The system is deployed automatically from the main branch to Azure with the ??? workflow in `.github/workflows`.

### IntelliJ IDEA Recommendations
- Set `Settings > Build, Execution, Deployment` > `Build Tools` > `Gradle` > `Distribution` to `Wrapper` instead of `Local installation`
- Set `Settings > Build, Execution, Deployment` > `Build Tools` > `Gradle` > `Gradle JVM` to a JVM/JDK that is Java 17 or higher
- Ensure the EditorConfig plugin is enabled

## Project Structure

## Releases / Milestones

## Authors
- Amber Skinner
- Edward Kurita
- Matthew Ross
- Max Bui
- Zane Labonté-Hagar
