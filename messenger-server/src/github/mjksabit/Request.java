package github.mjksabit;

import org.json.JSONException;

abstract public class Request{
    protected static String NO_JSON = "{}";
    protected String arg;
    protected Client context;

    public void setContext(Client context) {
        this.context = context;
    }

    abstract void ADDED_TO_FACTORY();

    public void setArg(String arg) {
        this.arg = arg;
    }

    abstract public String handle() throws JSONException;
}
