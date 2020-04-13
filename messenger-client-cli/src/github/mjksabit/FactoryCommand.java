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
            case "login":
                command = new SignInCommand();
                break;
            case "logout":
                command = new LogOutCommand();
                break;
            case "newmsgbox":
                command = new NewMessageBoxCommand();
                break;
            case "listmsgbox":
                command = new ListMessageBoxCommand();
                break;
            default:
                command = new UnknownCommand();
        }

        return command;
    }
}
