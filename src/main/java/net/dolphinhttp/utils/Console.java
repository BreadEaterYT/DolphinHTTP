package net.dolphinhttp.utils;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;

// Just a useless class to do a reference to console.log() from JavaScript ;)
public class Console {
    private PrintStream console;
    private final File logFile;

    public Console() throws IOException {
        this.console = System.out;
        this.logFile = new File("./dolphinhttp.log");
        if (!logFile.exists()) {
            logFile.createNewFile();
        }
    }

    private void appendToLogFile(String message) {
        try (FileWriter fileWriter = new FileWriter(logFile, true)) { // Append mode
            fileWriter.write(message + "\n");
        } catch (IOException e) {
            error("Failed to write to log file: " + e.getMessage(), false);
        }
    }

    public void log_fileonly(String message){
        appendToLogFile(message);
    }

    public void log(String message, boolean loginfile){
        console.println("[DOLPHINHTTP]:[" + java.time.LocalDateTime.now().toString() + "]:[INFO]> " + message);
        if (loginfile) appendToLogFile("[DOLPHINHTTP]:[" + java.time.LocalDateTime.now().toString() + "]:[INFO]> " + message);
    }

    public void warn(String message, boolean loginfile){
        console.println("[DOLPHINHTTP]:[" + java.time.LocalDateTime.now().toString() + "]:[WARN]> " + message);
        if (loginfile) appendToLogFile("[DOLPHINHTTP]:[" + java.time.LocalDateTime.now().toString() + "]:[WARN]> " + message);
    }

    public void error(String message, boolean loginfile){
        System.err.println("[DOLPHINHTTP]:[" + java.time.LocalDateTime.now().toString() + "]:[ERROR]> " + message);
        if (loginfile) appendToLogFile("[DOLPHINHTTP]:[" + java.time.LocalDateTime.now().toString() + "]:[ERROR]> " + message);
    }

    public void fatal(String message, boolean loginfile){
        System.err.println("[DOLPHINHTTP]:[" + java.time.LocalDateTime.now().toString() + "]:[FATAL]> " + message);
        if (loginfile) appendToLogFile("[DOLPHINHTTP]:[" + java.time.LocalDateTime.now().toString() + "]:[FATAL]> " + message);

        System.exit(500); // Like HTTP 500 Internal Error code
    }
}
