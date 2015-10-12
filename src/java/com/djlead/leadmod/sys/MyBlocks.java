package com.djlead.leadmod.sys;

import com.djlead.leadmod.blocks.*;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.BlockCrops;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;

import java.util.List;

/** Register and initialize all blocks
 * Created by Lead on 26-9-2015.
 */
public class MyBlocks {

    public static final BaseBlock rocklight = new RockLight();
    public static final BaseBlock unobtainiumore = new UnobtainiumOre();
    public static final BlockCrops dealCrop = new DealCrop();
    public static final Block logBT = new LogBT();
    public static final Block sapplingBT = new SaplingBT();
    public static final Block leavesBT = new LeavesBT();
    public static final Block blockWhish = new WhishBlock();
    public static final Block thoughtSoil = new ThoughtSoil();
    public static final Block whishSoil = new WhishSoil();

    public static void init() {
        GameRegistry.registerBlock(rocklight, "RockLight");
        GameRegistry.registerBlock(unobtainiumore, "UnobtainiumOre");
        GameRegistry.registerBlock(dealCrop, "DealCrop");
        GameRegistry.registerBlock(logBT, "LogBT");
        GameRegistry.registerBlock(sapplingBT, "SaplingBT");
        GameRegistry.registerBlock(leavesBT, "LeavesBT");
        GameRegistry.registerBlock(blockWhish, "BlockWhishAlloy");
        GameRegistry.registerBlock(thoughtSoil, "ThoughtSoil");
        GameRegistry.registerBlock(whishSoil, "WhishSoil");
    }
}
