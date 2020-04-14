package github.mjksabit;

public class InvalidResponse extends Response {
    @Override
    void ADDED_TO_THE_FACTORY() {
        // true
    }

    @Override
    public String executeWithNextCommand() {
        sout("Invalid Response");
        return null;
    }
}
