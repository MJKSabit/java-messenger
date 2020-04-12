package github.mjksabit;

import javax.imageio.IIOException;
import java.io.BufferedReader;
import java.io.IOException;

abstract public class Response {
    protected static String NO_JSON = "{}";
    protected String arg;

    public void setArg(String arg) {
        this.arg = arg;
    }

    abstract public void execute();
}
