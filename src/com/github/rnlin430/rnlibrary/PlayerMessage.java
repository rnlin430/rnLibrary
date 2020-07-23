package com.github.rnlin430.rnlibrary;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.Plugin;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;

public class PlayerMessage {
    private String pluginname = null;
    private boolean isDebugMassage = true;
    private Plugin  plugin;

    public PlayerMessage(Plugin p) {
        this.plugin = p;
        this.pluginname = plugin.getDescription().getName();
    }

    public void sendDescription(final CommandSender sender, final String message) {
        sender.sendMessage(ChatColor.AQUA + message);
    }

    public void sendInfo(final CommandSender sender, final String message) {
        sender.sendMessage(ChatColor.AQUA + "[" + pluginname + "]" + ChatColor.AQUA + message);
    }

    public void debugMessage(final CommandSender sender, final String message) {
        if(!isDebugMassage) return;
        sender.sendMessage("[" + pluginname + "] " + "[DEBUG] " + ChatColor.GRAY + message);
    }

    public void warningMessage(final CommandSender sender, final String message) {
        sender.sendMessage("[" + pluginname + "] " + ChatColor.RED + message);
    }

    public void cautionMessage(final CommandSender sender, final String message) {
        sender.sendMessage("[" + pluginname + "] " + ChatColor.YELLOW + "" + ChatColor.BOLD + message);
    }

    public void activateDebugMassage(final boolean b) {
        isDebugMassage = b;
    }

    public void broadcast(final String message, final String permission) {
        plugin.getServer().broadcast("[" + pluginname + "] " + message, permission);
    }

    public void broadcast(final String message) {
        plugin.getServer().broadcastMessage("[" + pluginname + "] " + message);
    }
}
