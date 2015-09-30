package com.djlead.leadmod.sys;

import com.djlead.leadmod.items.*;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.*;
import net.minecraftforge.common.util.EnumHelper;

/** Register and Init all Items and Food
 * Created by Lead on 26-9-2015.
 */
public class MyItems {


    public static Item.ToolMaterial whishAlloy = EnumHelper.addToolMaterial("whishalloy", 5, 2500, 25.0F, 30.0F, 30);
    //            HarvastLevel, Durability, Miningspeed, DamageVsEntities, Enchantability
    //    Wood          0           59          2.0F            4.0F            15
    //    Stone         1           131         4.0F            5.0F            5
    //    Iron          2           250         6.0F            6.0F            14
    //    diamond       3           1561        8.0F            7.0F           10
    //    gold                      32          12.0F           4.0F            22


    //  public static final ItemL ring = new LeadRing();
    public static final ItemL unobtainiumShard = new UnobtainiumShard();
    public static final ItemL unobtainiumFragment = new UnobtainiumFragment();
    public static final ItemL unobtainiumPart = new UnobtainiumPart();
    public static final ItemL unobtainium = new Unobtainium();
    public static final ItemL hardtofindium = new Hardtofindium();
    public static final ItemL impossibrium = new Impossibrium();
    public static final ItemL wishAlloy = new WhishAlloy();
    public static final ItemPickaxe djPickaxe = new DjPickaxe();
    public static final ItemSword djSword = new DjSword();
    public static final ItemSeeds dealSeed = new DealSeed();


    // Food
    public static final WhishApple whishApple = new WhishApple();
    public static final ThoughtApple thoughtApple = new ThoughtApple();

    public static void init() {
        GameRegistry.registerItem(unobtainiumShard, "UnobtainiumShard");
        GameRegistry.registerItem(unobtainiumFragment, "UnobtainiumFragment");
        GameRegistry.registerItem(unobtainiumPart, "UnobtainiumPart");
        GameRegistry.registerItem(unobtainium, "Unobtainium");
        GameRegistry.registerItem(hardtofindium, "Hardtofindium");
        GameRegistry.registerItem(impossibrium, "Impossibrium");
        GameRegistry.registerItem(wishAlloy, "WhishAlloy");
        GameRegistry.registerItem(djPickaxe, "DjPickaxe");
        GameRegistry.registerItem(djSword, "DjSword");
        GameRegistry.registerItem(dealSeed, "DealSeed");

        GameRegistry.registerItem(thoughtApple , "ThoughtApple");
        GameRegistry.registerItem(whishApple, "WhishApple");

    }
}
