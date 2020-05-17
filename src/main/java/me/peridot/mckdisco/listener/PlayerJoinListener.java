package me.peridot.mckdisco.listener;

import me.peridot.mckdisco.MCKDisco;
import me.peridot.mckdisco.user.User;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerJoinListener implements Listener {

    private final MCKDisco plugin;

    public PlayerJoinListener(MCKDisco plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        User user = plugin.getUserCache().createUser(player);
        user.setArmor(player.getInventory().getArmorContents());
    }

}
