import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
public class SimpleJavaFXApp extends Application {
@Override
public void start(Stage primaryStage) {
// Create a label
Label label = new Label("Button not clicked yet.");
// Create a button
Button button = new Button("Click Me");
button.setOnAction(e -> label.setText("Button clicked!"));
// Create a layout and add the button and label
VBox layout = new VBox(10);
layout.getChildren().addAll(button, label);
// Create a scene and add it to the stage
Scene scene = new Scene(layout, 300, 200);
primaryStage.setScene(scene);
primaryStage.setTitle("Simple JavaFX App");
primaryStage.show();
}
public static void main(String[] args) {
launch(args);
}
}