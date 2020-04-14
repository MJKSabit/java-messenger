package github.mjksabit;

import java.util.HashMap;
import java.util.Map;

public class Users {
    private volatile static Map<String, User> users = new HashMap<>();

    public synchronized static boolean addUser(String username, String password) {
        if (userExists(username)) return false;

        users.put(username, new User(username, password));
        return true;
    }

    public static User getUser(String username, String password) {
        if(userLogin(username, password)) return users.get(username);
        else return null;
    }

    public static User getUser(String username) {
        return userExists(username) ? users.get(username) : null;
    }

    public static boolean userExists(String username) {
        return users.containsKey(username);
    }

    public static boolean userLogin(String username, String password) {
        if(userExists(username) && users.get(username).matchPassword(password)) return true;
        return false;
    }
}
