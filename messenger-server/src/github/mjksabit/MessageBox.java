package github.mjksabit;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;

public class MessageBox {
    private static int ID = 0;
    final private int id;

    private ArrayList<User> users;
    private ArrayList<Message> messages;

    public int getId() {
        return id;
    }

    public MessageBox(User creator, User other) {
        id = updateID();
        users = new ArrayList<>();
        messages = new ArrayList<>();

        users.add(creator);
        users.add(other);

        creator.addMessageBox(this);
        other.addMessageBox(this);
    }

    private synchronized int updateID() {
        return ++ID;
    }

    private void update() { // Part of Observable
        for (User user : users) {
            user.moveToBottom(id);
            user.addUnreadMessage(id);
        }
    }

    public void addMessage(User sentBy, String message) {

        messages.add(new Message(sentBy, message));
        update();
    }

    public ArrayList<User>  userList() {
        return users;
    }

    public JSONArray getMessages() throws JSONException {
        JSONArray array = new JSONArray();
        for (Message message : messages) {
            array.put(message.getJSON());
        }
        return array;
    }
}
