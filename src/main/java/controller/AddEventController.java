package controller;

import app.MainApp;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.util.StringConverter;
import model.Event;

import java.time.LocalDate;

public class AddEventController {
    @FXML private TextField titleField;
    @FXML private DatePicker datePicker;
    @FXML private TextArea descriptionArea;
    private MainApp mainApp;

    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
        datePicker.setConverter(new StringConverter<>() {
            @Override public String toString(LocalDate date) {
                return date != null ? date.toString() : "";
            }
            @Override public LocalDate fromString(String string) {
                return (string == null || string.isEmpty()) ? null : LocalDate.parse(string);
            }
        });
    }

    @FXML
    private void handleAddEvent() {
        String title = titleField.getText();
        LocalDate date = datePicker.getValue();
        String desc = descriptionArea.getText();

        if (title.isEmpty() || date == null) {
            showAlert("Missing Data", "Please enter a title and date.");
            return;
        }
        mainApp.addEvent(new Event(title, date, desc));
        clearForm();
    }

    @FXML
    private void handleBack() {
        mainApp.showEventListView();
    }

    private void clearForm() {
        titleField.clear();
        datePicker.setValue(null);
        descriptionArea.clear();
    }

    private void showAlert(String header, String content) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setHeaderText(header);
        alert.setContentText(content);
        alert.showAndWait();
    }
}
