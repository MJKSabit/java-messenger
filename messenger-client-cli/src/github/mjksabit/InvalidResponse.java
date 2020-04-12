package github.mjksabit;

public class InvalidResponse extends Response {
    @Override
    public void execute() {
        System.out.println("Invalid Response...");
    }
}
