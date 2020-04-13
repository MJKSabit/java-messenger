package github.mjksabit;

public class NewUserSuccessResponse extends Response{
    @Override
    void ADDED_TO_THE_FACTORY() {
        // true
    }

    @Override
    public String executeWithNextCommand() {
        System.out.println("Created User Successfully!");
        return null;
    }
}
