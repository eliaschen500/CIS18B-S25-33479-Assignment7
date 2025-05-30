package app;

import controller.AddEventController;
import controller.EventListController;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.Event;

public class MainApp extends Application {
    private Stage primaryStage;
    private ObservableList<Event> eventList = FXCollections.observableArrayList();

    @Override
    public void start(Stage primaryStage) throws Exception {
        this.primaryStage = primaryStage;
        showEventListView();
        primaryStage.setTitle("Event Planner");
        primaryStage.show();
    }

    public void showEventListView() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/EventListView.fxml"));
            Parent root = loader.load();
            EventListController controller = loader.getController();
            controller.setMainApp(this, eventList);
            primaryStage.setScene(new Scene(root, 400, 400));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void showAddEventView() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/AddEventView.fxml"));
            Parent root = loader.load();
            AddEventController controller = loader.getController();
            controller.setMainApp(this);
            primaryStage.setScene(new Scene(root, 400, 400));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void addEvent(Event event) {
        eventList.add(event);
        showEventListView();
    }

    public static void main(String[] args) {
        launch(args);
    }
}