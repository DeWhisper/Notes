import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class InputWindow extends Stage{
    
    Notes testFx;

    public InputWindow(Notes testFx){
        this.testFx = testFx;
        setTitle("User Input");

        VBox vBox = new VBox(10);
        TextArea textArea = new TextArea();
        Button submitButton = new Button("Submit");
        textArea.setText(testFx.getLabelText());
        textArea.positionCaret(textArea.getText().length());

        submitButton.setOnAction(e -> {;
            testFx.setLabel(textArea.getText());
            close();
        });

        vBox.getChildren().addAll(textArea, submitButton);
        Scene inputScene = new Scene(vBox, 250, 150);

        setScene(inputScene);
    }
}
