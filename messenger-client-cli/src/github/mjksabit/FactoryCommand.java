package github.mjksabit;

public class FactoryCommand {
    public static Command getCommand(String commandText) {
        Command command;
        switch (commandText) {
            case "exit":
                command = new ExitCommand();
                break;
            case "signup":
                command = new SignUpCommand();
                break;
            case "signin":
                command = new SignInCommand();
                break;
            case "logout":
                command = new LogOutCommand();
                break;
            default:
                command = new UnknownCommand();
        }

        return command;
    }
}
