package github.mjksabit;

public class InvalidResponse extends Response {
    @Override
    void ADDED_TO_THE_FACTORY() {
        // true
    }

    @Override
    public String executeWithNextCommand() {
        System.out.println("Invalid Response: ");
        System.out.println(arg);
        return null;
    }
}
