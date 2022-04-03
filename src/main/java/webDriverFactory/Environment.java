package webDriverFactory;

import static java.lang.System.getenv;

public class Environment {

    public static String getVariable(String variable) {
        return getenv(variable);

    }
}