package github.mjksabit;

public class ExitRequest extends Request {
    @Override
    public String handle() {
        return "exit\n"+
                NO_JSON;
    }
}
