package github.mjksabit;

public class ExitRequest extends Request {
    @Override
    void ADDED_TO_FACTORY() {
        // true
    }

    @Override
    public String handle() {
        return "exit\n"+
                NO_JSON;
    }
}
