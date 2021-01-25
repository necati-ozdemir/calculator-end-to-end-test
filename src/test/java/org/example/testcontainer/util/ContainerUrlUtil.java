package org.example.testcontainer.util;

public final class ContainerUrlUtil {

    public static String combineHttpUrlParts(String ip, Integer port) {
        return "http://" + ip + ":" + port;
    }

    public static String containerPortReplacer(String str, Integer port) {
        return str.replace("<container_port>", port.toString());
    }
}
