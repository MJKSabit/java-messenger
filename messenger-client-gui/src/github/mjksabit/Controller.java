package github.mjksabit;

import javafx.animation.Animation;
import javafx.animation.FadeTransition;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.effect.GaussianBlur;
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
    public void initialize() {
        serverConnectThread = Executors.newFixedThreadPool(1);
        serverConnectThread.submit(() -> connection = new ServerConnect());
        ServerConnect.controller = this;

        showNotification("Application Started");

    }

    public void switchToMessenger() {
        logged_in = true;
        messenger_main.setEffect(null);
        pane_log.setVisible(false);
        updateMessagesListRequest();
    }

    public void switchFromMessenger() {
        logged_in = false;
        messenger_main.setEffect(new GaussianBlur());
        pane_log.setVisible(true);
        messageUpdateThread.shutdown();
    }

//
//    public void updateMessageBoxRequest() {
//        messageUpdateThread
//    }

    public volatile boolean logged_in = false;
    ExecutorService messageUpdateThread = Executors.newFixedThreadPool(2);
    public void updateMessagesListRequest() {
        messageUpdateThread.submit(() -> {
            while (logged_in) {
                connection.executeCommand("listmsgbox");
                System.out.println("ON");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    break;
                }
            }
            System.out.println("Out of loop");
        });
    }

    @FXML
    Text show_username_txt;
    public void setUsername(String Username) {
        show_username_txt.setText(Username);
    }

    @FXML
    public void exitApplication(ActionEvent event) {
        System.out.println("here");
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
    }


}
