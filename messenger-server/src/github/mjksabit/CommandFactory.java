package github.mjksabit;

import java.util.HashMap;
import java.util.Map;

public class CommandFactory {
    public static Map<String, Command> AllCommands = new HashMap<>();

    static {
        AllCommands.put("exit", new CommandExit());
    }

    static Command getCommand(String command) {
        if (!AllCommands.containsKey(command.toLowerCase())) return new CommandInvalid();

        return AllCommands.get(command.toLowerCase()).getNewCommand();
    }
}
