import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.Clipboard;
import javafx.scene.input.ClipboardContent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Notes extends Application{

    Label label;
    Button copyTextButton;
    TextField textField;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        primaryStage.setTitle("Test");

        BorderPane borderPane = new BorderPane();
        Scene scene = new Scene(borderPane, 500, 500);
        borderPane.setBackground(new Background(new BackgroundFill(Color.rgb(150, 150, 150), null, null))); // Color

        Button openInputWindowButton = new Button("Open Input Window"); //Button for opening Text editor
        openInputWindowButton.setOnAction(e -> openInputWindow());

        copyTextButton = new Button("Copy");   //Button for Copying Text Editor text
        copyTextButton.setDisable(true);    //Set disabled as default
        copyTextButton.setOnAction(e -> copyText());

        textField = new TextField();  //TextField
        textField.setEditable(false);

        VBox vBox = new VBox(10);
        label = new Label();
        vBox.getChildren().addAll(textField,label, openInputWindowButton, copyTextButton);

        borderPane.setTop(vBox);
        BorderPane.setMargin(vBox, new Insets(20)); // Add margin for better spacing

        primaryStage.setScene(scene);
        primaryStage.show();
    }
    /*
    public void setLabel(String text){
        label.setText(text);
    }
    public String getLabelText(){
        return label.getText();
    }
    */
    public void setTextInTextField(String text){
        textField.setText(text);
    }
    public String getTextInTextField(){
        return textField.getText();
    }

    private void openInputWindow() {
        InputWindow inputWindow = new InputWindow(this);
        inputWindow.showAndWait();
        copyTextButton.setDisable(getTextInTextField().isEmpty());
    }
    private void copyText() {
        String textToCopy = getTextInTextField();

        if (!textToCopy.isEmpty()) {
            Clipboard clipboard = Clipboard.getSystemClipboard();
            ClipboardContent content = new ClipboardContent();
            content.putString(textToCopy);
            clipboard.setContent(content);
        }
    }

}