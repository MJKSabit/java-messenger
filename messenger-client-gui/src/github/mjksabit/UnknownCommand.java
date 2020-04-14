package github.mjksabit;

public class UnknownCommand extends Command{
    @Override
    void ADDED_TO_THE_FACTORY() {
        // true
    }

    @Override
    boolean executeWithResponse() {
        ServerConnect.controller.showNotification("Unknown Command!");
        return false;
    }
}
