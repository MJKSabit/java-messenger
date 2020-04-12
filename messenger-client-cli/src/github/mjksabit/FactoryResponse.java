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
            default:
                created = new InvalidResponse();
        }

        created.setArg(arg);

        return created;
    }
}
