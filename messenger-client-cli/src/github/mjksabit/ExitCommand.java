package github.mjksabit;

public class ExitCommand extends Command {

    @Override
    void ADDED_TO_THE_FACTORY() {
        // true
    }

    @Override
    public boolean executeWithResponse() {
        System.out.println("Exit Response...");
        return false;
    }
}
