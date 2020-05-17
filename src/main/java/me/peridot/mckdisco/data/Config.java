package me.peridot.mckdisco.data;

import api.peridot.periapi.configuration.langapi.LangAPI;
import api.peridot.periapi.items.ItemParser;
import me.peridot.mckdisco.MCKDisco;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.inventory.ItemStack;

public class Config {

    private final MCKDisco plugin;

    private LangAPI langAPI;
    public static String noPerm;
    public static String selectEffect;
    public static String disableEffect;

    public static String effectRandom;
    public static String effectSmooth;
    public static String effectPolice;
    public static String effectGray;

    //Inventory
    public static String inventoryTitle;

    //Buttons
    public static ItemStack buttonDisable;
    public static ItemStack buttonRandom;
    public static ItemStack buttonSmooth;
    public static ItemStack buttonPolice;
    public static ItemStack buttonGray;

    public Config(MCKDisco plugin) {
        this.plugin = plugin;
    }

    public void loadConfig() {
        ConfigurationSection config = plugin.getConfig();

        langAPI = new LangAPI(config);

        noPerm = config.getString("messages.noperm");
        selectEffect = config.getString("messages.selecteffect");
        disableEffect = config.getString("messages.disableeffect");

        effectRandom = config.getString("messages.effects.random");
        effectSmooth = config.getString("messages.effects.smooth");
        effectPolice = config.getString("messages.effects.police");
        effectGray = config.getString("messages.effects.gray");

        //Inventory
        inventoryTitle = config.getString("inventory.title");

        //Buttons
        buttonDisable = ItemParser.parseItemStack(config.getConfigurationSection("inventory.buttons.disable"));
        buttonRandom = ItemParser.parseItemStack(config.getConfigurationSection("inventory.buttons.random"));
        buttonSmooth = ItemParser.parseItemStack(config.getConfigurationSection("inventory.buttons.smooth"));
        buttonPolice = ItemParser.parseItemStack(config.getConfigurationSection("inventory.buttons.police"));
        buttonGray = ItemParser.parseItemStack(config.getConfigurationSection("inventory.buttons.gray"));
    }

    public LangAPI getLangAPI() {
        return langAPI;
    }
}
