package github.mjksabit;

import java.util.ArrayList;

public class MessageBox {
    private static int ID = 0;
    final private int id;

    private ArrayList<User> users;

    public int getId() {
        return id;
    }

    public MessageBox(User creator, User other) {
        id = updateID();
        users = new ArrayList<>();

        users.add(creator);
        users.add(other);

        creator.addMessageBox(this);
        other.addMessageBox(this);
    }

    private synchronized int updateID() {
        return ++ID;
    }

    public ArrayList<User>  userList() {
        return users;
    }
}
