package github.mjksabit;

public class UnknownCommand extends Command{
    @Override
    void ADDED_TO_THE_FACTORY() {
        // true
    }

    @Override
    boolean executeWithResponse() {
        System.out.println("Unknown Command!");
        return false;
    }
}
