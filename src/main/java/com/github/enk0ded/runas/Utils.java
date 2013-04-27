package com.github.enk0ded.runas;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandException;
import org.bukkit.entity.Player;

/**
 *
 * @author ENK0DED
 */
public class Utils {
    private RunAs plugin;

    public Utils(RunAs plugin) {
        this.plugin = plugin;
    }

    public boolean checkLength(String[] arguments, boolean equalMin, int min, boolean equalMax, int max) {
        // "größer gleich" Minimum
        if (equalMin) {
            // Wenn Maximum undefiniert
            if (max == 0) {
                if (arguments.length < min) {
                    plugin.setMessage(ChatColor.RED + "Too few arguments!");
                    return false;
                }
                // Wenn Maximum definiert
            } else {
                // "kleiner gleich" Maximum
                if (equalMax) {
                    if (arguments.length < min && arguments.length > max) {
                        plugin.setMessage(ChatColor.RED + "Too many arguments!");
                        return false;
                    }
                    // "kleiner" Maximum
                } else {
                    if (arguments.length < min && arguments.length >= max) {
                        plugin.setMessage(ChatColor.RED + "Too many arguments!");
                        return false;
                    }
                }
            }
            // "größer" Minimum
        } else {
            // Wenn Maximum undefiniert
            if (max == 0) {
                if (arguments.length <= min) {
                    plugin.setMessage(ChatColor.RED + "Too few arguments!");
                    return false;
                }
                // Wenn Maximum definiert
            } else {
                // "kleiner gleich" Maximum
                if (equalMax) {
                    if (arguments.length <= min && arguments.length > max) {
                        plugin.setMessage(ChatColor.RED + "Too many arguments!");
                        return false;
                    }
                    // "kleiner" Maximum
                } else {
                    if (arguments.length <= min && arguments.length >= max) {
                        plugin.setMessage(ChatColor.RED + "Too many arguments!");
                        return false;
                    }
                }
            }
        }

        return true;
    }

    public boolean commandAsUser(String userName, String command) {
        Player[] onlinePlayers = plugin.getServer().getOnlinePlayers();
        String playerName;

        for (Player onlinePlayer : onlinePlayers) {
            playerName = onlinePlayer.getName();
            if (playerName.equalsIgnoreCase(userName)) {
                try {
                    Bukkit.dispatchCommand(plugin.getServer().getPlayer(playerName), command);
                    plugin.setMessage("Command \"/" + command + "\" was executed by " + playerName + ".");
                    return true;
                } catch (CommandException e) {
                    plugin.setMessage("Command \"/" + command + "\" could not be executed by " + playerName + ".");
                }
            }
        }

        return false;
    }

    public boolean sayAsUser(String userName, String say) {
        Player[] onlinePlayers = plugin.getServer().getOnlinePlayers();
        String playerName;

        for (Player onlinePlayer : onlinePlayers) {
            playerName = onlinePlayer.getName();

            if (playerName.equalsIgnoreCase(userName)) {
                plugin.getServer().getPlayer(playerName).chat(say);
                return true;
            }
        }

        plugin.setMessage("\"" + say + "\" could not be said by " + userName + ".");
        return false;
    }

    public String argsToString(String[] args, boolean ignoreFirst) {
        StringBuilder arguments = new StringBuilder();
        int i = 0;

        for (String arg : args) {
            if (ignoreFirst) {
                if (arg.equals(args[0])) {
                    continue;
                }
            }

            if (i == 0) {
                arguments.append(arg);
            } else {
                arguments.append(" ").append(arg);
            }
            i++;
        }

        return arguments.toString();
    }
}