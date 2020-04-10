package github.mjksabit;

public class CommandInvalid extends Command {
    @Override
    public Command getNewCommand() {
        return new CommandInvalid();
    }

    @Override
    public int numberOfArguments() {
        return 0;
    }

    @Override
    public String execute() {
        System.out.println("Invalid Command!");
        return "Invalid";
    }
}
