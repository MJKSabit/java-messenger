package github.mjksabit;

import javafx.animation.Animation;
import javafx.animation.FadeTransition;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.effect.GaussianBlur;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.util.Duration;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class Controller {

    final static String SEPERATOR = " ~";
    public static ServerConnect connection = null;
    private ExecutorService serverConnectThread;

    @FXML
    TextField txt_username;
    @FXML
    PasswordField txt_password;

    @FXML
    VBox notification_container;
    @FXML
    Text notification_text;

    @FXML
    Pane messenger_main;
    @FXML
    Pane pane_log;

    @FXML
    ListView msgbox_list;
    public ObservableList<String> msgboxDataProvider = FXCollections.observableArrayList();

    @FXML
    public void initialize() {
        serverConnectThread = Executors.newFixedThreadPool(1);
        serverConnectThread.submit(() -> connection = new ServerConnect());
        ServerConnect.controller = this;

        messenger_main.setEffect(new GaussianBlur());
        pane_log.setVisible(true);
        showNotification("Application Started");

        msgbox_list.setItems(msgboxDataProvider);
        msgbox_list.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                String selected = msgbox_list.getSelectionModel().getSelectedItem().toString();
                commandExecutor("showmsg" , selected.split(" ")[0]);
//                System.out.println(selected.split(" ")[0]);
            }
        });

        msgShowList.setItems(messages);
    }

    @FXML
    TextField txt_newmsgbox;
    public void newMsgBox() {
        commandExecutor("newmsgbox", txt_newmsgbox.getText());
    }

    public void switchToMessenger() {
        logged_in = true;
        msgBoxId = 0;
        messenger_main.setEffect(null);
        pane_log.setVisible(false);
        System.out.println(ServerConnect.username);
        setUsername(ServerConnect.username);
//        commandExecutor("listmsgbox");
        msgbox_name.setText("");
        Platform.runLater(() -> messages.clear());
        updateMessagesListRequest();
    }

    public void switchFromMessenger() {
        logged_in = false;
        messenger_main.setEffect(new GaussianBlur());
        pane_log.setVisible(true);
        messageUpdateThread.shutdown();
    }


    @FXML
    ListView msgShowList;
    public ObservableList<String> messages = FXCollections.observableArrayList();

    @FXML
    TextField messageText;
    public void sendNewMessage() {
        Integer id = msgBoxId;
        commandExecutor("newmsg", id.toString(), messageText.getText());
        messageText.setText("");
    }

    @FXML
    Text msgbox_name;
    public void setMessageBoxName(String messageBoxName) {
        msgbox_name.setText(messageBoxName);
    }

    public volatile boolean logged_in = false;
    public volatile int msgBoxId = 0;
    ExecutorService messageUpdateThread;

    public void updateMessagesListRequest() {
        messageUpdateThread = Executors.newFixedThreadPool(1);

        messageUpdateThread.submit(() -> {
            while (logged_in) {
                connection.executeCommand("listmsgbox");
                if (msgBoxId != 0)
                    connection.executeCommand("showmsg"+SEPERATOR+msgBoxId);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    break;
                }
            }
        });
    }

    @FXML
    Text show_username_txt;
    public void setUsername(String Username) {
        show_username_txt.setText(Username);
    }

    @FXML
    public void exitApplication(ActionEvent event) {
        Platform.exit();
    }

    ExecutorService service = Executors.newFixedThreadPool(1);
    public void showNotification(String text) {

        service.submit(() -> {
            notification_text.setText(text);
            notification_container.setVisible(true);
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            finally {
                notification_container.setVisible(false);
            }
        });
    }

    private void resetUsername() {
        txt_username.setText("");
        txt_password.setText("");
    }

    private void commandExecutor(String... args) {
        StringBuilder stringBuilder = new StringBuilder(args[0]);

        for (int i=1; i<args.length; i++)
            stringBuilder.append(SEPERATOR).append(args[i]);

        serverConnectThread.submit(() -> connection.executeCommand(stringBuilder.toString()));
    }

    public void signUp() {
        commandExecutor("signup", txt_username.getText(), txt_password.getText());
        resetUsername();
    }

    public void login() {
        commandExecutor("login", txt_username.getText(), txt_password.getText());
    }

    public void logout() {
        switchFromMessenger();
        commandExecutor("logout");
        msgboxDataProvider.removeAll();
    }


}
