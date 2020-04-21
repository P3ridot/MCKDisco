package me.peridot.mckdisco.listener;

import me.peridot.mckdisco.MCKDisco;
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
        InventoryClickListener.playerDiscoTypeMap.put(player, null);
    }

}
