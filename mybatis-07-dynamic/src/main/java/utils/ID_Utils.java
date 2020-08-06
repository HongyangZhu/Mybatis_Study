package utils;

import java.util.UUID;

public class ID_Utils {
    public static String getID() {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }
}
