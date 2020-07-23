package com.github.rnlin430.rnlibrary;

import jdk.nashorn.internal.codegen.ApplySpecialization;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class ConsoleLog {

    private static final String red    = "\u001b[00;31m";
    private static final String green  = "\u001b[00;32m";
    private static final String yellow = "\u001b[00;33m";
    private static final String purple = "\u001b[00;34m";
    private static final String pink   = "\u001b[00;35m";
    private static final String cyan   = "\u001b[00;36m";
    private static final String end    = "\u001b[00m";

    private final JavaPlugin plugin;
    private final String pluginName;

    public ConsoleLog(@NotNull JavaPlugin plugin) {
        this.plugin = plugin;
        this.pluginName = plugin.getDescription().getName();
    }

    public void writeLine(@Nullable String text) { plugin.getLogger().info(end + text + end); }
    public void sendCaution(@Nullable String text) { plugin.getLogger().info("[CAUTION] " + yellow + text + end); }
    public void sendWarning(@Nullable String text) { plugin.getLogger().info("[WARNING] " + red + text + end); }
    public void sendDescription(@Nullable String text) { plugin.getLogger().info("[INFO] " + cyan + text + end); }
    public void sendDebugMessage(@Nullable String text) { plugin.getLogger().info("[DEBUG] " + pink + text + end); }

    public void warnInfo(@Nullable String[] messages) {
        System.out.println(red + "*--============================== WARNING =============================--*" + end);
        for (String mg : messages) System.out.println(red +  mg + end);
        byte length = (byte)pluginName.length();
        byte width = 68;
        if (length > width) {
            System.out.println(red + "---"+ pluginName + "---" + end);
            return;
        }
        StringBuffer sb = new StringBuffer();
        byte temp = (byte) (width - length);
        if ((temp & 0x01) == 0x01) {
            temp++;
        }
        temp >>= 1;
        for (short i = 0; i < temp; i++) {
            sb.append('=');
        }
        sb.append("   " + pluginName + "   ");
        for (short i = 0; i < temp; i++) {
            sb.append('=');
        }
        String result = new String(sb);
        System.out.println(red + result + end);
    }

    @NotNull
    public String getGreenMessage(@Nullable String message) { return green + message + end; }
    @NotNull
    public String getRedMessage(@Nullable String message) { return red + message + end; }
    @NotNull
    public String getYellowMessage(@Nullable String message) { return yellow + message + end; }
    @NotNull
    public String getPurpleMessage(@Nullable String message) { return purple + message + end; }
    @NotNull
    public String getPinkMessage(@Nullable String message) { return pink + message + end; }
    @NotNull
    public String getCyanMessage(@Nullable String message) { return cyan + message + end; }
}
