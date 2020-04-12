package github.mjksabit;

public class InvalidRequest extends Request {
    @Override
    void ADDED_TO_FACTORY() {
        // true
    }

    @Override
    public String handle() {
        return "invalid\n"+
                NO_JSON;
    }
}
