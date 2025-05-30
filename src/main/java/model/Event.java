package model;

import javafx.beans.property.*;
import java.time.LocalDate;

/**
 * This class represents a basic event that holds a title, date, and description.
 * It uses JavaFX properties to enable data binding with the UI.
 */
public class Event {
    private final StringProperty title = new SimpleStringProperty();
    private final ObjectProperty<LocalDate> date = new SimpleObjectProperty<>();
    private final StringProperty description = new SimpleStringProperty();

    public Event(String title, LocalDate date, String description) {
        setTitle(title);
        setDate(date);
        setDescription(description);
    }

    public String getTitle() { return title.get(); }
    public void setTitle(String value) { title.set(value); }
    public StringProperty titleProperty() { return title; }

    public LocalDate getDate() { return date.get(); }
    public void setDate(LocalDate value) { date.set(value); }
    public ObjectProperty<LocalDate> dateProperty() { return date; }

    public String getDescription() { return description.get(); }
    public void setDescription(String value) { description.set(value); }
    public StringProperty descriptionProperty() { return description; }

    @Override
    public String toString() {
        return getTitle() + " (" + getDate() + ")";
    }
}
