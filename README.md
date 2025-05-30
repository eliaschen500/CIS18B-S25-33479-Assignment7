# CIS18B-S25-33479-Assignment7
# JavaFX Event Planner Application

This JavaFX application allows users to create and manage basic events, such as meetings, study sessions, and parties. The program features a multi-view interface designed with FXML, uses JavaFX controls for user interaction, and incorporates property binding to ensure smooth and dynamic updates between the user interface and the data model. It also includes visual effects and gradient styling to enhance usability and visual appeal.

## How to Run the Program

### Requirements

- Java 17 or higher
- JavaFX SDK (version 17 or higher)
- Maven (recommended for easier dependency management)
- An IDE such as IntelliJ IDEA or Eclipse, or access to a terminal with Java and Maven configured

### Option 1: Running with IntelliJ IDEA

1. Open IntelliJ IDEA.
2. Choose "File" -> "Open" and select the project folder (ensure it contains `pom.xml`).
3. Verify that the `src/main/javaw` folder is marked as a **Sources Root**, and `src/main/resources` as a **Resources Root**.
4. Navigate to `MainApp.java` located in the `app` package.
5. Right-click `MainApp.java` and choose **Run 'MainApp.main()'**.

- If JavaFX SDK is manually managed, include the following in VM options:
- ```
- --module-path /path/to/javafx-sdk/lib --add-modules javafx.controls,javafx.fxml
- ```

### Option 2: Running via Command Line with Maven

Ensure Maven is installed and accessible from your terminal, then run:
cd CIS18B-S25-33479-Assignment7
mvn clean javafx:run
This command will compile and execute the program using the `pom.xml` configuration.

## JavaFX Controls Used

The application utilizes several JavaFX UI controls:

- `TextField`: for user input of event titles.
- `DatePicker`: for selecting the event date.
- `TextArea`: for entering event descriptions.
- `Button`: to confirm actions such as adding events or switching views.
- `ListView`: to display all existing scheduled events.
- Layout containers such as `VBox`, `HBox`, `Label`, and `BorderPane` for organizing the interface.

These components are defined and managed using FXML files and are linked to the application logic through FXML annotations.

## Application of Effects, Gradients, and Animations

This project applies several visual enhancements to improve the user experience:

- **Gradients**: Both FXML views incorporate linear gradient backgrounds for a modern visual style.
  - The event list view uses a vertical blue gradient.
  - The add event view features a pink-to-green gradient background.
  
- **Visual Effects**: 
  - A `DropShadow` effect is applied to upcoming events in the event list, drawing user attention to future tasks.

- **Animations**: 
  - The architecture supports fade-in animations for elements (extensible to include additional transitions for added/removed events).

## Use of JavaFX Properties for Binding

The application uses JavaFX property classes to enable real-time data binding between the UI and model:

- `StringProperty` is used for binding the event title and description.
- `ObjectProperty<LocalDate>` is used for binding the event date.

The `Event` class encapsulates these properties, making them accessible via standard getter, setter, and property accessor methods. This design allows FXML elements to bind directly to these properties, ensuring the interface reflects underlying data changes automatically.

## Project Structure
src/
├── main/
│   ├── java/
│   │   ├── app/
│   │   ├── controller/
│   │   └── model/
│   └── resources/
│       ├── AddEventView.fxml
│       └── EventListView.fxml
screenshots/
├── ScreenShot.png(add
└── ScreenShot.png

## Author
Zhengxing Chen
CIS18B – Assignment 7
5/30/2025
