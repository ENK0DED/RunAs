package com.github.enk0ded.runas.commands;

import com.github.enk0ded.runas.Paths;
import com.github.enk0ded.runas.RunAs;
import com.github.enk0ded.runas.Utils;
import org.bukkit.command.CommandSender;

/**
 *
 * @author ENK0DED
 */
public class CommandRunasusr {
    public RunAs plugin;
    public Utils utils;
    public Paths paths;

    public CommandRunasusr(RunAs plugin, Utils utils, Paths paths) {
        this.plugin = plugin;
        this.utils = utils;
        this.paths = paths;
    }

    public boolean execute(CommandSender sender, String[] args) {
        if (!utils.checkLength(args, true, 2, false, 0)) {
            sender.sendMessage(plugin.getMessage());
            return false;
        }

        plugin.setUserName(args[0]);
        plugin.setCommand(utils.argsToString(args, true));

        if (utils.commandAsUser(plugin.getUserName(), plugin.getCommand())) {
            sender.sendMessage(plugin.getMessage());
            return true;
        } else {
            sender.sendMessage(plugin.getMessage());
            return false;
        }
    }
}