package github.mjksabit;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.*;

public class User {
    private String username;
    private String password;

    private Map<Integer, MessageBox> messageBoxes;
    private Map<Integer, Integer> unreadMessageCount;

    public User(String username, String password) {
        this.username = username;
        this.password = password;

        messageBoxes = new LinkedHashMap<>();
        unreadMessageCount = new HashMap<>();
    }

    public String getUsername() {
        return username;
    }

    public boolean matchPassword(String password) {
        return this.password.equals(password);
    }

    public void addMessageBox(MessageBox messageBox) {
        messageBoxes.put(messageBox.getId(), messageBox);
        unreadMessageCount.put(messageBox.getId(), 0);
    }

    public ArrayList<Integer> getMessageBoxes() {
        return new ArrayList<>(messageBoxes.keySet());
    }

    public int checkMessageExist(User other) {
        for (int messageBoxId : messageBoxes.keySet()){
            MessageBox messageBox = messageBoxes.get(messageBoxId);
            if (messageBox.userList().contains(other)) return messageBoxId;
        }
        return -1;
    }

    public void moveToBottom(int messageBoxId) {
        MessageBox messageBox = messageBoxes.get(messageBoxId);
        messageBoxes.remove(messageBoxId);
        messageBoxes.put(messageBoxId, messageBox);
    }

    public void addUnreadMessage(int messageBoxId) {
        int value = unreadMessageCount.get(messageBoxId);
        unreadMessageCount.put(messageBoxId, value+1);
    }

    public String getNameOfMessage(int msgBoxId, User currentUser) {
        StringBuilder stringBuilder = new StringBuilder();

        for (User user : messageBoxes.get(msgBoxId).userList()) {
            if (user == currentUser) continue;
            stringBuilder.append(" [").append(user.getUsername()).append("]");
        }
        return stringBuilder.toString();
    }

    public MessageBox getMessageBox(int msgBoxId) {
        if(messageBoxes.containsKey(msgBoxId))
            return messageBoxes.get(msgBoxId);
        return null;
    }

    public int getUnreadCount(int msgBoxId) {
        return unreadMessageCount.get(msgBoxId);
    }

    public JSONObject getMessages(int msgBoxId) throws JSONException {
        unreadMessageCount.put(msgBoxId, 0);
        JSONObject object = new JSONObject();

        object.put("name", getNameOfMessage(msgBoxId, this));
        object.put("messages", messageBoxes.get(msgBoxId).getMessages());

        return object;
    }
}
