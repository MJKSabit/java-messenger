package github.mjksabit;

import javafx.animation.Animation;
import javafx.animation.FadeTransition;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
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
    public void initialize() {
        serverConnectThread = Executors.newFixedThreadPool(1);
        serverConnectThread.submit(() -> connection = new ServerConnect());
        ServerConnect.controller = this;

        showNotification("Application Started");

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

    public void signUp() {
        String username = txt_username.getText();
        String password = txt_password.getText();

        serverConnectThread.submit(() -> {
           connection.executeCommand("signup"+SEPERATOR+
                   username+SEPERATOR+password);
        });

        resetUsername();
    }


}
