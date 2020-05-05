package github.mjksabit;

import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;

public class MessageBoxListHBox  extends HBox {
    int msgBox, msgCount;
    String name;

    public MessageBoxListHBox(int msgBox, int msgCount, String name) {
        this.msgBox = msgBox;
        this.msgCount = msgCount;
        this.name = name;

        Label msgName = new Label(name);
        msgName.setTextFill(Color.WHITE);
        super.getChildren().add(msgName);

        if(msgCount > 0) {
            Label msgCnt = new Label(msgCount+"");
            msgCnt.setStyle("-fx-fill: #CfCfCf; -fx-background-color: #ef6161; -fx-background-radius: 5; ");
            getChildren().add(msgCnt);
        }

    }

    public int getMsgBox() {
        return msgBox;
    }

    @Override
    public String toString() {
        return msgBox+"";
    }
}
