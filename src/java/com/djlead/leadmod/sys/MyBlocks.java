package com.djlead.leadmod.sys;

import com.djlead.leadmod.blocks.BaseBlock;
import com.djlead.leadmod.blocks.DealCrop;
import com.djlead.leadmod.blocks.RockLight;
import com.djlead.leadmod.blocks.UnobtainiumOre;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.BlockCrops;

/** Register and initialize all blocks
 * Created by Lead on 26-9-2015.
 */
public class MyBlocks {

    public static final BaseBlock rocklight = new RockLight();
    public static final BaseBlock unobtainiumore = new UnobtainiumOre();
    public static final BlockCrops dealCrop = new DealCrop();


    public static void init() {
        GameRegistry.registerBlock(rocklight, "RockLight");
        GameRegistry.registerBlock(unobtainiumore, "UnobtainiumOre");
        GameRegistry.registerBlock(dealCrop, "DealCrop");
    }
}
