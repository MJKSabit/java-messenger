package github.mjksabit;

import org.json.JSONException;

import javax.imageio.IIOException;
import java.io.BufferedReader;
import java.io.IOException;

abstract public class Response {
    protected static String NO_JSON = "{}";
    protected String arg;

    abstract void ADDED_TO_THE_FACTORY();

    public void setArg(String arg) {
        this.arg = arg;
    }

    abstract public void execute() throws JSONException;
}
