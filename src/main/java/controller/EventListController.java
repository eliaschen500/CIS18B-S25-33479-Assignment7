package controller;

import app.MainApp;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.effect.DropShadow;
import javafx.scene.paint.Color;
import javafx.animation.FadeTransition;
import javafx.util.Duration;
import model.Event;

public class EventListController {
    @FXML private ListView<Event> eventListView;
    private ObservableList<Event> eventList;
    private MainApp mainApp;

    public void setMainApp(MainApp mainApp, ObservableList<Event> eventList) {
        this.mainApp = mainApp;
        this.eventList = eventList;
        eventListView.setItems(eventList);

        eventListView.setCellFactory(lv -> new ListCell<>() {
            @Override
            protected void updateItem(Event item, boolean empty) {
                super.updateItem(item, empty);
                if (empty || item == null) {
                    setText(null);
                    setEffect(null);
                } else {
                    setText(item.getTitle() + " (" + item.getDate() + ")");
                    if (item.getDate().isAfter(java.time.LocalDate.now())) {
                        setEffect(new DropShadow(12, Color.web("#00B4DB")));
                    } else {
                        setEffect(null);
                    }
                }
            }
        });
    }

    @FXML
    private void handleShowAddEvent() {
        mainApp.showAddEventView();
    }
}