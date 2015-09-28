package com.djlead.leadmod.sys;

import com.djlead.leadmod.blocks.BlockL;
import com.djlead.leadmod.blocks.RockLight;
import com.djlead.leadmod.blocks.UnobtainiumOre;
import cpw.mods.fml.common.registry.GameRegistry;

/**
 * Created by Lead on 26-9-2015.
 */
public class MyBlocks {

    public static final BlockL rocklight = new RockLight();

    public static final BlockL unobtainiumore = new UnobtainiumOre();


    public static void init() {
        GameRegistry.registerBlock(rocklight, "RockLight");
        GameRegistry.registerBlock(unobtainiumore, "UnobtainiumOre");
    }
}
