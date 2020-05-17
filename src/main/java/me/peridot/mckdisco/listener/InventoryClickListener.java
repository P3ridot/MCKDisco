package me.peridot.mckdisco.listener;

import api.peridot.periapi.utils.replacements.Replacement;
import me.peridot.mckdisco.MCKDisco;
import me.peridot.mckdisco.data.Config;
import me.peridot.mckdisco.enums.DiscoType;
import me.peridot.mckdisco.inventory.ArmorSelectInventory;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.HashMap;
import java.util.Map;

public class InventoryClickListener implements Listener {

    private final MCKDisco plugin;

    public static Map<Player, DiscoType> playerDiscoTypeMap = new HashMap<>();

    public InventoryClickListener(MCKDisco plugin) {
        this.plugin = plugin;
    }

    @EventHandler(ignoreCancelled = true)
    public void onClick(InventoryClickEvent event) {
        Player player = (Player) event.getWhoClicked();
        Inventory inventory = event.getInventory();
        ItemStack item = event.getCurrentItem();
        if (inventory == null || item == null) {
            return;
        }
        if (!inventory.equals(ArmorSelectInventory.inventoryMap.get(player))) {
            return;
        }
        String effect = "";
        if (item.isSimilar(Config.buttonDisable)) {
            playerDiscoTypeMap.put(player, null);
            plugin.getConfiguration().getLangAPI().sendMessage(player, "messages.disableeffect");
            event.setCancelled(true);
            return;
        } else if (item.isSimilar(Config.buttonRandom)) {
            playerDiscoTypeMap.put(player, DiscoType.RANDOM);
            effect = Config.effectRandom;
        } else if (item.isSimilar(Config.buttonSmooth)) {
            playerDiscoTypeMap.put(player, DiscoType.SMOOTH);
            effect = Config.effectSmooth;
        } else if (item.isSimilar(Config.buttonPolice)) {
            playerDiscoTypeMap.put(player, DiscoType.POLICE);
            effect = Config.effectPolice;
        } else if (item.isSimilar(Config.buttonGray)) {
            playerDiscoTypeMap.put(player, DiscoType.GRAY);
            effect = Config.effectGray;
        }
        plugin.getConfiguration().getLangAPI().sendMessage(player, "messages.selecteffect", new Replacement("{EFFECT}", effect));
        event.setCancelled(true);
    }

}
