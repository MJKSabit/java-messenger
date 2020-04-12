package github.mjksabit;

public class FactoryCommand {
    public static Command getCommand(String commandText) {
        Command command;
        switch (commandText) {
            case "exit":
                command = new ExitCommand();
                break;
            case "sign-up":
                command = new SignUpCommand();
                break;
            default:
                command = new UnknownCommand();
        }

        return command;
    }
}
