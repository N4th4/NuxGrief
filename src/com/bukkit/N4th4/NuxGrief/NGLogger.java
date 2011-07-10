package com.bukkit.N4th4.NuxGrief;

import java.util.logging.Logger;
import java.util.logging.Level;

public class NGLogger {
    private static Logger log;

    public static void initialize() {
        log = Logger.getLogger("Minecraft");
    }

    public static void info(String message) {
        log.log(Level.INFO, "[NuxGrief] " + message);
    }

    public static void severe(String message) {
        log.log(Level.SEVERE, "[NuxGrief] " + message);
    }
}
