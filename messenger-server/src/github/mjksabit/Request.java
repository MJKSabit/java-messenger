package github.mjksabit;

abstract public class Request{
    protected static String NO_JSON = "{}";
    protected String arg;

    abstract void ADDED_TO_FACTORY();

    public void setArg(String arg) {
        this.arg = arg;
    }

    abstract public String handle();
}
