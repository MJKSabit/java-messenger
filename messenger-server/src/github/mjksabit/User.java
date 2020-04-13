package github.mjksabit;

import java.util.LinkedHashMap;
import java.util.Map;

public class User {
    private String username;
    private String password;

    private Map<Integer, MessageBox> messageBoxes;

    public User(String username, String password) {
        this.username = username;
        this.password = password;

        messageBoxes = new LinkedHashMap<>();
    }

    public String getUsername() {
        return username;
    }

    public boolean matchPassword(String password) {
        return this.password.equals(password);
    }

    public void addMessageBox(MessageBox messageBox) {
        messageBoxes.put(messageBox.getId(), messageBox);
    }
}
