package com.github.enk0ded.runas;

import com.github.enk0ded.runas.commands.CommandDelusr;
import com.github.enk0ded.runas.commands.CommandRunas;
import com.github.enk0ded.runas.commands.CommandRunascfg;
import com.github.enk0ded.runas.commands.CommandRunasusr;
import com.github.enk0ded.runas.commands.CommandSayasusr;
import com.github.enk0ded.runas.commands.CommandSetusr;
import com.github.enk0ded.runas.commands.CommandSwapusr;
import java.util.logging.Logger;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * This class is the main entry point for RunAs. All events are routed to an
 * instance of this controller for processing by RunAs. For integrating RunAs in
 * other platforms, an instance of this class should be created and events
 * should be redirected to it.
 *
 * @author ENK0DED
 */
public class RunAs extends JavaPlugin {
    /**
     * Logger for debugging.
     */
    public static final Logger logger = Logger.getLogger("Minecraft.RunAs");
    public Utils utils;
    public Paths paths;
    private String command;
    private String message = "";
    private String say;
    private String userName;

    @Override
    public void onEnable() {
        super.onEnable();
        this.utils = new Utils(this);
        this.paths = new Paths();
        this.saveDefaultConfig();
    }

    @Override
    public void onDisable() {
        super.onDisable();
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (cmd.getName().equalsIgnoreCase("runascfg")) {
            return new CommandRunascfg(this, this.utils, this.paths).execute(sender, args);
        }

        if (cmd.getName().equalsIgnoreCase("runasusr")) {
            return new CommandRunasusr(this, this.utils, this.paths).execute(sender, args);
        }

        if (cmd.getName().equalsIgnoreCase("sayasusr")) {
            return new CommandSayasusr(this, this.utils, this.paths).execute(sender, args);
        }

        if (cmd.getName().equalsIgnoreCase("swapusr")) {
            return new CommandSwapusr(this, this.utils, this.paths).execute(sender, args);
        }

        // Modify Config
        if (cmd.getName().equalsIgnoreCase("setusr")) {
            return new CommandSetusr(this, this.utils, this.paths).execute(sender, args);
        }

        if (cmd.getName().equalsIgnoreCase("delusr")) {
            return new CommandDelusr(this, this.utils, this.paths).execute(sender, args);
        }

        // RunAs Control Command
        if (cmd.getName().equalsIgnoreCase("runas")) {
            return new CommandRunas(this, this.utils, this.paths).execute(sender, args);
        }

        return false;
    }

    public String getMessage() {
        return this.message;
    }

    public String getCommand() {
        return this.command;
    }

    public String getSay() {
        return this.say;
    }

    public String getUserName() {
        return this.userName;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setCommand(String command) {
        this.command = command;
    }

    public void setSay(String say) {
        this.say = say;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}