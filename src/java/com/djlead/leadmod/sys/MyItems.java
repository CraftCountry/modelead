package com.djlead.leadmod.sys;

import com.djlead.leadmod.items.*;
import cpw.mods.fml.common.registry.GameRegistry;

/**
 * Created by Lead on 26-9-2015.
 */
public class MyItems {

  //  public static final ItemL ring = new LeadRing();
    public static final ItemL unobtainiumShard = new UnobtainiumShard();
    public static final ItemL unobtainiumFragment = new UnobtainiumFragment();
    public static final ItemL unobtainiumPart = new UnobtainiumPart();
    public static final ItemL hardtofindium = new Hardtofindium();
    public static final ItemL impossibrium = new Impossibrium();
    public static final ItemL wishalloy = new WhishAlloy();

//    public static final FoodL whishapple = new WhishApple();



    public static void init() {
    //    GameRegistry.registerItem(ring, "LeadRing");
        GameRegistry.registerItem(unobtainiumShard, "UnobtainiumShard");
        GameRegistry.registerItem(unobtainiumFragment, "UnobtainiumFragment");
        GameRegistry.registerItem(unobtainiumPart, "UnobtainiumPart");
        GameRegistry.registerItem(hardtofindium, "Hardtofindium");
        GameRegistry.registerItem(impossibrium, "Impossibrium");
        GameRegistry.registerItem(wishalloy, "WhishAlloy");
//        GameRegistry.registerItem(whishapple, "WhishApple");
    }

}
