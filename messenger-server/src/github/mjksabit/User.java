package github.mjksabit;

public class User {
    private String username;
    private String password;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public boolean matchPassword(String password) {
        return this.password.equals(password);
    }
}
