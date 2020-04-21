package me.peridot.mckdisco.inventory;

import api.peridot.periapi.utils.ColorUtil;
import me.peridot.mckdisco.data.Config;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;

import java.util.HashMap;
import java.util.Map;

public class ArmorSelectInventory {

    public static Map<Player, Inventory> inventoryMap = new HashMap<>();

    public static Inventory createInventory(Player player) {
        Inventory inventory = inventoryMap.get(player);
        if (inventory == null) {
            inventory = Bukkit.createInventory(null, InventoryType.HOPPER, ColorUtil.color(Config.inventoryTitle));
        }
        inventoryMap.put(player, inventory);
        inventory.clear();

        if (player.hasPermission("mckdisco.random")) {
            inventory.addItem(Config.buttonRandom);
        }
        if (player.hasPermission("mckdisco.smooth")) {
            inventory.addItem(Config.buttonSmooth);
        }
        if (player.hasPermission("mckdisco.police")) {
            inventory.addItem(Config.buttonPolice);
        }
        if (player.hasPermission("mckdisco.gray")) {
            inventory.addItem(Config.buttonGray);
        }
        inventory.addItem(Config.buttonDisable);

        return inventory;
    }

}
