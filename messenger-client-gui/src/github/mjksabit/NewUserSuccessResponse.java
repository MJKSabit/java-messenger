package github.mjksabit;

public class NewUserSuccessResponse extends Response{
    @Override
    void ADDED_TO_THE_FACTORY() {
        // true
    }

    @Override
    public String executeWithNextCommand() {
        sout("New User Created Successfully!");
        return null;
    }
}
