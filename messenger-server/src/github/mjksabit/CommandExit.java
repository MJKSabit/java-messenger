package github.mjksabit;

public class CommandExit extends Command {

    @Override
    public CommandExit getNewCommand() {
        return new CommandExit();
    }

    @Override
    public int numberOfArguments() {
        return 0;
    }

    @Override
    public String execute() {
        // Thread.currentThread().interrupt();
        return "Exit";
    }
}
