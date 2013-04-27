package com.github.enk0ded.runas.commands;

import com.github.enk0ded.runas.Paths;
import com.github.enk0ded.runas.RunAs;
import com.github.enk0ded.runas.Utils;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandException;
import org.bukkit.command.CommandSender;

/**
 *
 * @author ENK0DED
 */
public class CommandSwapusr {

    public RunAs plugin;
    public Utils utils;
    public Paths paths;

    public CommandSwapusr(RunAs plugin, Utils utils, Paths paths) {
        this.plugin = plugin;
        this.utils = utils;
        this.paths = paths;
    }

    public boolean execute(CommandSender sender, String[] args) {
        if (!utils.checkLength(args, true, 1, false, 0)) {
            sender.sendMessage(plugin.getMessage());
            return false;
        }

        plugin.reloadConfig();
        plugin.setUserName(plugin.getConfig().getString("user"));
        plugin.setCommand(utils.argsToString(args, false).replaceFirst("<user>", plugin.getUserName()));

        try {
            Bukkit.dispatchCommand(sender, plugin.getCommand());
            plugin.setMessage("Command \"/" + plugin.getCommand() + "\" was executed by " + plugin.getUserName() + ".");
        } catch (CommandException e) {
            plugin.setMessage("Command \"/" + plugin.getCommand() + "\" could not be executed by " + plugin.getUserName() + ".");
        }

        return true;
    }
}