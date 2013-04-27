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
public class CommandRunas {
    public RunAs plugin;
    public Utils utils;
    public Paths paths;

    public CommandRunas(RunAs plugin, Utils utils, Paths paths) {
        this.plugin = plugin;
        this.utils = utils;
        this.paths = paths;
    }

    public boolean execute(CommandSender sender, String[] args) {
        String argument = null;

        if (args.length >= 1) {
            argument = args[0].toLowerCase();
            return this.executeRunAs(sender, args);
        } else {
            sender.sendMessage(ChatColor.GOLD + plugin.getDescription().getName() + " version " + plugin.getDescription().getVersion());
            return false;
        }
    }

    public boolean executeRunAs(CommandSender sender, String[] args) {
        switch (args.length) {
            case 1:
                String argument = args[0].toLowerCase();

                /*switch (argument) {
                    case "reload":
                        break;
                    default:
                        break;
                }*/
                break;
            case 2:
                
                break;
        }

        return false;
    }
}