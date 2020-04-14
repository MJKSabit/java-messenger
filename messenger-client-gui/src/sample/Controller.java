package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class Controller {

    @FXML
    TextField txt_username;
    @FXML
    PasswordField txt_password;


    public void signUp() {
        System.out.println(txt_username.getCharacters().toString());
        System.out.println(txt_password.getCharacters().toString());
    }
}
