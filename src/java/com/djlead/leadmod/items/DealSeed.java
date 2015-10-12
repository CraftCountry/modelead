package com.djlead.leadmod.items;

import com.djlead.leadmod.Reference;
import com.djlead.leadmod.sys.MyBlocks;
import com.djlead.leadmod.sys.MyTab;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemSeeds;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;

import java.util.List;

/**
 * Created by Lead on 30-9-2015.
 */
public class DealSeed extends ItemSeeds {
    public DealSeed() {
        super(MyBlocks.dealCrop, Blocks.farmland);
//        super(MyBlocks.dealCrop, MyBlocks.whishSoil);
        this.setUnlocalizedName("dealseed");
        this.setTextureName(Reference.MODID + ":" + "dealseed");
        this.setCreativeTab(MyTab.CreaTab);
    }

    @SideOnly(Side.CLIENT)
    public void addInformation(ItemStack stack, EntityPlayer player, List datalist, boolean bool) {
        datalist.add("Grows Unobtainium dust");
        datalist.add(EnumChatFormatting.AQUA + "More formatting");
        datalist.add(EnumChatFormatting.BLUE + "bla " + EnumChatFormatting.BOLD + "Bold");
        datalist.add(EnumChatFormatting.ITALIC + "and even " + EnumChatFormatting.STRIKETHROUGH + "Italic");
        datalist.add(EnumChatFormatting.LIGHT_PURPLE + "Que? " + EnumChatFormatting.GOLD + "" + EnumChatFormatting.OBFUSCATED + "Bold");
    }
}


