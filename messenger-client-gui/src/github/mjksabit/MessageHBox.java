package github.mjksabit;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;

public class MessageHBox extends HBox {
    public MessageHBox(boolean messageFromUser, String message, String sender) {

        if (messageFromUser) super.setAlignment(Pos.BOTTOM_RIGHT);

        super.setMinWidth(400);


        Label messageLabel = new Label(message);
        messageLabel.setMaxWidth(380);
        messageLabel.setWrapText(true);
        messageLabel.setTextFill(Color.web("#c4c4c4"));
        messageLabel.setPadding(new Insets(10));

        messageLabel.setStyle("-fx-background-color: #2f6fbf; -fx-background-radius: 8;");

        super.getChildren().add(messageLabel);
    }
}
