package github.mjksabit;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
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

    public ArrayList<Integer> getMessageBoxes() {
        return new ArrayList<>(messageBoxes.keySet());
    }

    public String getUsernameOfMessage(int msgBoxId) {
        StringBuilder stringBuilder = new StringBuilder();

        for (User user : messageBoxes.get(msgBoxId).userList()) {
            stringBuilder.append(" ["+user.getUsername()+"]");
        }

        return stringBuilder.toString();
    }
}
