package net.dolphinhttp;

import net.dolphinhttp.http.HttpServer;
import net.dolphinhttp.utils.Console;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        Console console = new Console();
        int serverPort = 80;
        boolean portSpecified = false;

        for (int i = 0; i < args.length; i++) {
            if ("--port".equals(args[i]) && i + 1 < args.length) {
                try {
                    serverPort = Integer.parseInt(args[i + 1]);
                    portSpecified = true;
                } catch (NumberFormatException e) {
                    console.error("Invalid port specified, using port 80 as default", true);
                }
            }
        }

        if (!portSpecified) {
            console.warn("Port not specified, using port 80 as default", true);
        }

        try {
            new HttpServer(serverPort);
            console.log("DolphinHTTP started on port " + serverPort, true);
        } catch (IOException e) {
            console.fatal("DolphinHTTP cannot start on port " + serverPort + ", Not enough privileges !", true);
        }
    }
}
