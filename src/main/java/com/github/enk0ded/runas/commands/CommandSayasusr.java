package com.github.enk0ded.runas.commands;

import com.github.enk0ded.runas.Paths;
import com.github.enk0ded.runas.RunAs;
import com.github.enk0ded.runas.Utils;
import org.bukkit.command.CommandSender;

/**
 *
 * @author ENK0DED
 */
public class CommandSayasusr {
    public RunAs plugin;
    public Utils utils;
    public Paths paths;

    public CommandSayasusr(RunAs plugin, Utils utils, Paths paths) {
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
        plugin.setSay(utils.argsToString(args, true));

        if (!utils.sayAsUser(plugin.getUserName(), plugin.getSay())) {
            if (!"".equals(plugin.getMessage())) {
                sender.sendMessage(plugin.getMessage());
            }
        }

        return true;
    }
}