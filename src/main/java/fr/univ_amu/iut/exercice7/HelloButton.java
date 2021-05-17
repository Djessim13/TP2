package fr.univ_amu.iut.exercice7;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class HelloButton extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Hello !");
        primaryStage.setHeight(100);
        primaryStage.setWidth(250);
        BorderPane pane = new BorderPane();
        Scene scene = new Scene(pane);

        Button hello = new Button("Hello !");
        hello.setId("buttonHello");
        pane.setCenter(hello);

        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
