package github.mjksabit;

public class FactoryResponse {
    static Response created;

    public static Response getResponse(String type, String arg) {
        switch (type) {
            case "exit":
                created = new ExitResponse();
                break;
            default:
                created = new InvalidResponse();
        }

        created.setArg(arg);

        return created;
    }
}
