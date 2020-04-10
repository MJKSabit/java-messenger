package github.mjksabit;

abstract public class Command {
    protected String[] args;
    protected String commandText;

    public void setArgs(String... args) {
        this.args = args;
    }

    abstract public int numberOfArguments();

    abstract public Command getNewCommand() ;

    abstract public String execute();
}
