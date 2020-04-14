package github.mjksabit;

public class FactoryCommand {
    public static final String SEPERATOR = " ~";

    public static Command getCommand(String singleLineArgs) {
        String[] commandArray = singleLineArgs.split(SEPERATOR);

        String commandText = commandArray[0];
        String[] commandArgs = new String[commandArray.length-1];

        for (int i=1; i<commandArray.length; i++) {
            commandArgs[i-1] = commandArray[i];
        }

        Command command;
        switch (commandText) {
//            case "exit":
//                command = new ExitCommand();
//                break;
            case "signup":
                command = new SignUpCommand();
                break;
            case "login":
                command = new SignInCommand();
                break;
            case "logout":
                command = new LogOutCommand();
                break;
//            case "newmsgbox":
//                command = new NewMessageBoxCommand();
//                break;
            case "listmsgbox":
                command = new ListMessageBoxCommand();
                break;
//            case "newmsg":
//                command = new NewMessageCommand();
//                break;
//            case "showmsg":
//                command = new ShowMessageBoxCommand();
//                break;
            default:
                command = new UnknownCommand();
        }

        command.setArgs(commandArgs);

        return command;
    }
}
