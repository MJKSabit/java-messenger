package github.mjksabit;

import java.io.IOException;

public class FactoryRequest {
    static Request created;

    public static Request getRequest(String type, String arg, Client client) throws NullPointerException{
        switch (type) {
            case "exit":
                created = new ExitRequest();
                break;
            case "new_user":
                created = new NewUserRequest();
                break;
            case "sign_in":
                created = new SignInRequest();
                break;
            case "log_out":
                created = new LogOutRequest();
                break;
            case "new_msg_box":
                created = new NewMessageBoxRequest();
                break;
            case "list_msg_box":
                created = new ListMessageBoxRequest();
                break;
            case "new_msg":
                created = new NewMessageRequest();
                break;
            case "showmsg":
                created = new ShowMessageRequest();
                break;
            default:
                created = new InvalidRequest();
        }

        created.setArg(arg);
        created.setContext(client);

        return created;
    }
}
