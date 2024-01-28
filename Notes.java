import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Notes extends Application{

    Label label;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        primaryStage.setTitle("Test");

        BorderPane borderPane = new BorderPane();
        Scene scene = new Scene(borderPane, 300, 300);

        StackPane stackPane = new StackPane();
        stackPane.setBackground(new Background(new BackgroundFill(Color.rgb(50, 50, 50), null, null))); // Color

        Button openInputWindowButton = new Button("Open Input Window");
        openInputWindowButton.setOnAction(e -> openInputWindow());

        VBox vBox = new VBox(10);
        label = new Label();
        vBox.getChildren().addAll(label, openInputWindowButton);

        borderPane.setTop(vBox);
        BorderPane.setMargin(vBox, new Insets(10)); // Add margin for better spacing

        primaryStage.setScene(scene);
        primaryStage.show();
    }
    public void setLabel(String text){
        label.setText(text);
    }
    public String getLabelText(){
        return label.getText();
    }

    private void openInputWindow() {
        InputWindow inputWindow = new InputWindow(this);
        inputWindow.showAndWait();
    }

}