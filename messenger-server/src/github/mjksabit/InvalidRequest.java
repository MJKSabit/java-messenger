package github.mjksabit;

public class InvalidRequest extends Request {
    public InvalidRequest() {

    }

    @Override
    public String handle() {
        return "invalid\n"+
                NO_JSON;
    }
}
