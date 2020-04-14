package github.mjksabit;

public class FactoryResponse {
    static Response created;

    public static Response getResponse(String type, String arg) {
        switch (type) {
            case "new_user_success":
                created = new NewUserSuccessResponse();
                break;
            case "new_user_failed":
                created = new NewUserFailedResponse();
                break;
            case "login_success":
                created = new SignUpSuccessResponse();
                break;
            case "login_error":
                created = new SignUpErrorResponse();
                break;
            case "logged_out":
                created = new LogOutResponse();
                break;
            case "msgbox_create_success":
                created = new MessageBoxSuccessResponse();
                break;
            case "msgbox_create_failed":
                created = new MessageBoxFailedResponse();
                break;
            case "list_msg_box":
                created = new ListMessageBoxResponse();
                break;
//            case "msg_sent":
//                created = new MessageSentResponse();
//                break;
            case "msgbox":
                created = new ShowMessageResponse();
                break;
            default:
                created = new InvalidResponse();
        }

        created.setArg(arg);

        return created;
    }
}
