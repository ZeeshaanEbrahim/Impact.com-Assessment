# Impact.com-Assessment

# Number Range Summarizer

A Java application that takes a comma-delimited list of numbers and groups sequential numbers into ranges.

## Description

This program implements the `NumberRangeSummarizer` interface to process a list of numbers and produce a summarized output where consecutive numbers are grouped into ranges.

**Example:**
- **Input:** `"1,3,6,7,8,12,13,14,15,21,22,23,24,31"`
- **Output:** `"1,3,6-8,12-15,21-24,31"`

## Prerequisites

- **Java Development Kit (JDK) 8 or higher**
- **IntelliJ IDEA** (or any Java IDE)
- **JUnit 5** (for running unit tests)

## Project Structure

```
project/
|----- Implementation.java          # Main implementation class
|----- NumberRangeSummarizer.java   # Interface definition
|----- ImplementationTest.java      # Unit tests (in test folder)
|_____ README.md                    # This file
```

## Dependencies

### For Running the Application:
- **Java 8+** - No external dependencies required

### For Running Tests:
- **JUnit Jupiter 5.9.3** - Testing framework

## Setup Instructions

### Option 1: Using IntelliJ IDEA

1. **Clone or download** this project to your local machine

2. **Open the project** in IntelliJ IDEA:
   - File → Open → Select the project folder

3. **Add JUnit dependency** (for tests only):
   - Right-click on project → Open Module Settings (F4)
   - Click "Libraries" → Click "+" → "From Maven..."
   - Search for: `org.junit.jupiter:junit-jupiter:5.9.3`
   - Click OK → Apply → OK

### Option 2: Using Maven

Add this to your `pom.xml`:

```xml
<dependencies>
    <dependency>
        <groupId>org.junit.jupiter</groupId>
        <artifactId>junit-jupiter</artifactId>
        <version>5.9.3</version>
        <scope>test</scope>
    </dependency>
</dependencies>
```

### Option 3: Using Gradle

Add this to your `build.gradle`:

```gradle
dependencies {
    testImplementation 'org.junit.jupiter:junit-jupiter:5.9.3'
}
```

## Running the Application

### Method 1: Using IntelliJ IDEA

1. Open `Implementation.java`
2. Right-click in the editor
3. Select **"Run 'Implementation.main()'"**
4. Enter your comma-separated numbers in the console (e.g., `1,3,6,7,8,12,13,14,15`)
5. Press Enter to see the result

### Method 2: Command Line

1. **Compile the code:**
   ```bash
   javac Implementation.java NumberRangeSummarizer.java
   ```

2. **Run the program:**
   ```bash
   java Implementation
   ```

3. **Enter input** when prompted (e.g., `1,3,6,7,8,12,13,14,15`)

### Method 3: Programmatic Usage

```java
NumberRangeSummarizer summarizer = new Implementation();

// Collect numbers from string
Collection<Integer> numbers = summarizer.collect("1,3,6,7,8,12,13,14,15");

// Get summarized output
String result = summarizer.summarizeCollection(numbers);
System.out.println(result); // Output: 1,3,6-8,12-15
```

## Running Unit Tests

### Using IntelliJ IDEA:

1. Open `ImplementationTest.java`
2. Right-click anywhere in the file
3. Select **"Run 'ImplementationTest'"**
4. View results in the test runner panel at the bottom

### Using Maven:
```bash
mvn test
```

### Using Gradle:
```bash
gradle test
```

## Test Coverage

The test suite includes:
- Basic input/output functionality
- Single number handling
- Sequential ranges
- Non-sequential numbers
- Empty and null input handling
- Negative numbers
- Input with spaces
- End-to-end integration tests

## Example Usage

```
Input:  1,3,6,7,8,12,13,14,15,21,22,23,24,31
Output: 1,3,6-8,12-15,21-24,31

Input:  1,2,3,5,7,8,10
Output: 1-3,5,7-8,10

Input:  1,3,5,7,9
Output: 1,3,5,7,9
```

## Features

- Handles comma-separated integer input with or without spaces
- Groups consecutive numbers into ranges (e.g., 6-8)
- Preserves individual numbers when not part of a sequence
- Handles negative numbers
- Robust error handling for null and empty inputs

## Troubleshooting

### "Cannot resolve symbol 'Test'" error:
- Ensure JUnit 5 is added to your project libraries
- Try: File > Invalidate Caches > Restart in IntelliJ

### Tests not running:
- Verify the test folder is marked as "Test Sources Root"
- Right-click test folder > Mark Directory as > Test Sources Root

### Compilation errors:
- Ensure Java 8+ is installed: `java -version`
- Check that all .java files are in the same directory

## Author

Implementation of the NumberRangeSummarizer interface

## License

This project is provided as-is for educational purposes.
