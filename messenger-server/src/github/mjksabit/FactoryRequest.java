package github.mjksabit;

import java.io.IOException;

public class FactoryRequest {
    static Request created;

    public static Request getRequest(String type, String arg){
        switch (type) {
            case "exit":
                created = new ExitRequest();
                break;
            default:
                created = new InvalidRequest();
        }

        created.setArg(arg);

        return created;
    }
}
