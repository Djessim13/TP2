package fr.univ_amu.iut.exercice9;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;

public class HelloBeautifulUsefulButton extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Hello !");
        primaryStage.setHeight(250);
        primaryStage.setWidth(250);
        BorderPane pane = new BorderPane();
        Scene scene = new Scene(pane);

        Button hello = new Button("Hello !");
        hello.setId("buttonHello");
        pane.setCenter(hello);

        ImageView image = new ImageView("https://raw.githubusercontent.com/IUTInfoAix-M2105/Syllabus/master/assets/logo.png");
        hello.setGraphic(image);

        hello.setOnAction(new EcouteurSimple());

        primaryStage.setScene(scene);
        primaryStage.show();

    }
}
