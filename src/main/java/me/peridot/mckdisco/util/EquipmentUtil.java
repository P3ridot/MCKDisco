package me.peridot.mckdisco.util;

import api.peridot.periapi.packets.PacketSender;
import api.peridot.periapi.packets.Reflections;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class EquipmentUtil {

    public void setPlayerSlot(Player player, int slot, ItemStack item) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, InstantiationException {
        Class<?> packetClass = Reflections.getNMSClass("PacketPlayOutEntityEquipment");
        Class<?> bukkitItemstackClass = Reflections.getBukkitClass("inventory.CraftItemStack");
        Class<?> itemstackClass = Reflections.getNMSClass("ItemStack");

        Object packet = null;

        if (Reflections.server_version_number >= 13) {
            Class<?> enumClass = Reflections.getNMSClass("EnumItemSlot");

            Method m = bukkitItemstackClass.getMethod("asNMSCopy", ItemStack.class);
            Method m2 = enumClass.getMethod("valueOf", String.class);
            Object o = m.invoke(bukkitItemstackClass, item);
            Object o2 = null;

            if (slot == 0) o2 = m2.invoke(enumClass, "MAINHAND");
            if (slot == 1) o2 = m2.invoke(enumClass, "OFFHAND");
            if (slot == 2) o2 = m2.invoke(enumClass, "FEET");
            if (slot == 3) o2 = m2.invoke(enumClass, "LEGS");
            if (slot == 4) o2 = m2.invoke(enumClass, "CHEST");
            if (slot == 5) o2 = m2.invoke(enumClass, "HEAD");

            Constructor<?> packetConstructor = packetClass.getConstructor(int.class, enumClass, itemstackClass);
            packet = packetConstructor.newInstance(player.getEntityId(), o2, o);
        } else {
            Method m = bukkitItemstackClass.getMethod("asNMSCopy", ItemStack.class);
            Object o = m.invoke(bukkitItemstackClass, item);

            if (Reflections.server_version_number <= 8) {
                if (slot == 1) {
                    slot = 0;
                } else if (slot >= 2 && slot <= 5) {
                    slot -= 1;
                } else if (slot > 5) {
                    slot = 0;
                }
            }

            Constructor<?> packetConstructor = packetClass.getConstructor(int.class, int.class, itemstackClass);
            packet = packetConstructor.newInstance(player.getEntityId(), slot, o);
        }

        for (Player onlinePlayer : Bukkit.getOnlinePlayers()) {
            if (!onlinePlayer.equals(player)) {
                PacketSender.sendPacket(onlinePlayer, packet);
            }
        }
    }

}
