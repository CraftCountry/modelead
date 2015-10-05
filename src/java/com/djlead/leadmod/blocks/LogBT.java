package com.djlead.leadmod.blocks;

import com.djlead.leadmod.Reference;
import com.djlead.leadmod.sys.MyTab;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.BlockLog;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;

import java.util.List;

/**
 * Created by Lead on 3-10-2015.
 */
public class LogBT extends BlockLog
{
    public static final String[] field_150168_M = new String[] {"bigtree"};
    public LogBT() {
        super();
        this.setBlockName("logbt");
        this.setCreativeTab(MyTab.CreaTab);
    }

    /**
     * returns a list of blocks with the same ID, but different meta (eg: wood returns 4 blocks)
     */
    @SideOnly(Side.CLIENT)
    public void getSubBlocks(Item item, CreativeTabs tab, List list) {
        list.add(new ItemStack(item, 1, 0));
    }

    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister p_149651_1_){
        this.field_150167_a = new IIcon[field_150168_M.length];
        this.field_150166_b = new IIcon[field_150168_M.length];
        this.field_150167_a[0] = p_149651_1_.registerIcon(Reference.MODID.toLowerCase() + ":" + this.getUnlocalizedName().substring(5));
        this.field_150166_b[0] = p_149651_1_.registerIcon(Reference.MODID.toLowerCase() + ":" + this.getUnlocalizedName().substring(5)+ "_top");
    }
}
