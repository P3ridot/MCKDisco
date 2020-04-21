package me.peridot.mckdisco.scheduler;

import me.peridot.mckdisco.MCKDisco;
import me.peridot.mckdisco.enums.DiscoType;
import me.peridot.mckdisco.listener.InventoryClickListener;
import me.peridot.mckdisco.util.EquipmentUtil;
import me.peridot.mckdisco.util.Util;
import org.bukkit.Bukkit;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class UpdateArmorScheduler {

    private final MCKDisco plugin;

    public UpdateArmorScheduler(MCKDisco plugin) {
        this.plugin = plugin;
    }

    public void start() {
        EquipmentUtil eq = new EquipmentUtil();
        Bukkit.getScheduler().runTaskTimer(plugin, () -> {
            for (Player player : Bukkit.getOnlinePlayers()) {
                DiscoType discoType = InventoryClickListener.playerDiscoTypeMap.get(player);
                if (discoType != null) {
                    if (discoType == DiscoType.RANDOM) {
                        try {
                            eq.setPlayerSlot(player, 5, Util.createColorArmor(new ItemStack(Material.LEATHER_HELMET), Util.randomColor()));
                            eq.setPlayerSlot(player, 4, Util.createColorArmor(new ItemStack(Material.LEATHER_CHESTPLATE), Util.randomColor()));
                            eq.setPlayerSlot(player, 3, Util.createColorArmor(new ItemStack(Material.LEATHER_LEGGINGS), Util.randomColor()));
                            eq.setPlayerSlot(player, 2, Util.createColorArmor(new ItemStack(Material.LEATHER_BOOTS), Util.randomColor()));
                        } catch (Exception ex) {
                            ex.printStackTrace();
                        }
                    } else if (discoType == DiscoType.SMOOTH) {
                        try {
                            eq.setPlayerSlot(player, 5, Util.createColorArmor(new ItemStack(Material.LEATHER_HELMET), Color.fromRGB(ColorScheduler.redSmooth, ColorScheduler.greenSmooth, ColorScheduler.blueSmooth)));
                            eq.setPlayerSlot(player, 4, Util.createColorArmor(new ItemStack(Material.LEATHER_CHESTPLATE), Color.fromRGB(ColorScheduler.redSmooth, ColorScheduler.greenSmooth, ColorScheduler.blueSmooth)));
                            eq.setPlayerSlot(player, 3, Util.createColorArmor(new ItemStack(Material.LEATHER_LEGGINGS), Color.fromRGB(ColorScheduler.redSmooth, ColorScheduler.greenSmooth, ColorScheduler.blueSmooth)));
                            eq.setPlayerSlot(player, 2, Util.createColorArmor(new ItemStack(Material.LEATHER_BOOTS), Color.fromRGB(ColorScheduler.redSmooth, ColorScheduler.greenSmooth, ColorScheduler.blueSmooth)));
                        } catch (Exception ex) {
                            ex.printStackTrace();
                        }
                    } else if (discoType == DiscoType.POLICE) {
                        try {
                            eq.setPlayerSlot(player, 5, Util.createColorArmor(new ItemStack(Material.LEATHER_HELMET), Color.fromRGB(ColorScheduler.redPolice, 0, ColorScheduler.bluePolice)));
                            eq.setPlayerSlot(player, 4, Util.createColorArmor(new ItemStack(Material.LEATHER_CHESTPLATE), Color.fromRGB(ColorScheduler.redPolice, 0, ColorScheduler.bluePolice)));
                            eq.setPlayerSlot(player, 3, Util.createColorArmor(new ItemStack(Material.LEATHER_LEGGINGS), Color.fromRGB(ColorScheduler.redPolice, 0, ColorScheduler.bluePolice)));
                            eq.setPlayerSlot(player, 2, Util.createColorArmor(new ItemStack(Material.LEATHER_BOOTS), Color.fromRGB(ColorScheduler.redPolice, 0, ColorScheduler.bluePolice)));
                        } catch (Exception ex) {
                            ex.printStackTrace();
                        }
                    } else if (discoType == DiscoType.GRAY) {
                        try {
                            eq.setPlayerSlot(player, 5, Util.createColorArmor(new ItemStack(Material.LEATHER_HELMET), Color.fromRGB(ColorScheduler.grayShade, ColorScheduler.grayShade, ColorScheduler.grayShade)));
                            eq.setPlayerSlot(player, 4, Util.createColorArmor(new ItemStack(Material.LEATHER_CHESTPLATE), Color.fromRGB(ColorScheduler.grayShade, ColorScheduler.grayShade, ColorScheduler.grayShade)));
                            eq.setPlayerSlot(player, 3, Util.createColorArmor(new ItemStack(Material.LEATHER_LEGGINGS), Color.fromRGB(ColorScheduler.grayShade, ColorScheduler.grayShade, ColorScheduler.grayShade)));
                            eq.setPlayerSlot(player, 2, Util.createColorArmor(new ItemStack(Material.LEATHER_BOOTS), Color.fromRGB(ColorScheduler.grayShade, ColorScheduler.grayShade, ColorScheduler.grayShade)));
                        } catch (Exception ex) {
                            ex.printStackTrace();
                        }
                    }
                } else {
                    try {
                        eq.setPlayerSlot(player, 5, player.getInventory().getHelmet());
                        eq.setPlayerSlot(player, 4, player.getInventory().getChestplate());
                        eq.setPlayerSlot(player, 3, player.getInventory().getLeggings());
                        eq.setPlayerSlot(player, 2, player.getInventory().getBoots());
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }
            }
        }, 0, 1);
    }

}
