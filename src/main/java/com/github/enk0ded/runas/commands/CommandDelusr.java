package com.github.enk0ded.runas.commands;

import com.github.enk0ded.runas.Paths;
import com.github.enk0ded.runas.RunAs;
import com.github.enk0ded.runas.Utils;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;

/**
 *
 * @author ENK0DED
 */
public class CommandDelusr {
    public RunAs plugin;
    public Utils utils;
    public Paths paths;

    public CommandDelusr(RunAs plugin, Utils utils, Paths paths) {
        this.plugin = plugin;
        this.utils = utils;
        this.paths = paths;
    }

    public boolean execute(CommandSender sender, String[] args) {
        if (args.length == 0) {
            plugin.reloadConfig();
            plugin.getConfig().set(paths.getUserNameKey(), null);
            plugin.saveConfig();
            plugin.reloadConfig();

            sender.sendMessage("User was successfully deleted.");
            return true;
        } else if (args.length > 0) {
            sender.sendMessage(ChatColor.RED + "Too many arguments!");
            return false;
        } else {
            sender.sendMessage(ChatColor.RED + "You have not used this command correctly!");
            return false;
        }
    }
}