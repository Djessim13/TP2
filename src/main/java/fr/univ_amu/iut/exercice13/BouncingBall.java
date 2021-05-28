package fr.univ_amu.iut.exercice13;

import javafx.animation.Animation;
import javafx.animation.Interpolator;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.util.Duration;

public class BouncingBall extends Application {

    private Button startButton;
    private Button pauseButton;
    private Button resumeButton;
    private Button stopButton;
    private Slider slider;
    private Circle circle;
    private VBox root;
    private HBox commands;
    private Pane pane;
    private TranslateTransition transition;



    @Override
    public void start(Stage stage) {

        circle = new Circle();
        circle.setRadius(10);
        circle.setCenterX(100);
        circle.setFill(Color.rgb(0, 0, 255));

        transition = new TranslateTransition(Duration.millis(1000), circle);

        transition.setFromY(10);
        transition.setToY(400);
        transition.setAutoReverse(true);
        transition.setCycleCount(Animation.INDEFINITE);
        transition.setRate(2);

        startButton = new Button("Start");

        startButton.setOnAction(actionEvent -> transition.playFromStart());
        pauseButton = new Button("Pause");
        pauseButton.setOnAction(actionEvent -> transition.pause());
        resumeButton = new Button("Resume");
        resumeButton.setOnAction(actionEvent -> transition.play());
        stopButton = new Button("Stop");
        stopButton.setOnAction(actionEvent -> transition.stop());

        slider = new Slider();
        slider.minProperty().set(0);
        slider.maxProperty().set(20);
        slider.valueProperty().set(transition.rateProperty().doubleValue());
        slider.valueProperty().addListener((observable, oldValue, newValue) -> transition.setRate(newValue.doubleValue()));
        slider.setMinHeight(40);

        root = new VBox();
        commands = new HBox();
        pane = new Pane();


        root.setAlignment(Pos.CENTER);

        Pane space = new Pane();
        space.setMinWidth(10);


        commands.setSpacing(10);
        commands.setMinHeight(50);
        commands.setMinWidth(300);
        commands.getChildren().addAll(startButton, pauseButton, resumeButton, stopButton);
        commands.setAlignment(Pos.CENTER);

        pane.setMinHeight(400);
        pane.getChildren().add(circle);
        pane.setPadding(new Insets(20, 20, 20, 20));


        root.getChildren().addAll(commands, slider, pane);

        Scene scene = new Scene(root);

        stage.setScene(scene);
        stage.show();


    }
}