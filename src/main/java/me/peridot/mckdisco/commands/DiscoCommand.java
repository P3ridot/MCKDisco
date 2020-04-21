package me.peridot.mckdisco.commands;

import me.peridot.mckdisco.MCKDisco;
import me.peridot.mckdisco.inventory.ArmorSelectInventory;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class DiscoCommand implements CommandExecutor {

    private final MCKDisco plugin;

    public DiscoCommand(MCKDisco plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] strings) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("[MCKDisco] Tylko gracz na serwerze moze uzyc tej komendy!");
            return true;
        }
        if (!sender.hasPermission("mckdisco.cmd")) {
            plugin.getConfiguration().getLangAPI().sendMessage(sender, "messages.noperm");
            return true;
        }
        Player player = (Player) sender;
        player.openInventory(ArmorSelectInventory.createInventory(player));
        return true;
    }
}
