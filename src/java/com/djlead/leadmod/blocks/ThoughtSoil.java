package com.djlead.leadmod.blocks;

import com.djlead.leadmod.Reference;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.EnumPlantType;
import net.minecraftforge.common.IPlantable;
import net.minecraftforge.common.util.ForgeDirection;

import java.util.List;
import java.util.Random;

/**
 * Created by Lead on 4-10-2015.
 */
public class ThoughtSoil extends BaseBlock {

    public static final String[] field_149838_a = new String[] {"default"};
    @SideOnly(Side.CLIENT)
    private static IIcon field_149837_b;
    @SideOnly(Side.CLIENT)
    private static IIcon field_149839_N;
    private static final String __OBFID = "CL_00000303";

    public ThoughtSoil() {
        super();
        this.setBlockName("thoughtsoil");
        this.setHardness(1.0F);
        this.setResistance(2.0F);
        this.setHarvestLevel("shovel", 1);
        this.setTickRandomly(true);
    }

    /**
     * Gets the block's texture. Args: side, meta
     */
    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int p_149691_1_, int p_149691_2_)
    {
        return p_149691_2_ == 1 ? field_149839_N : field_149837_b;
    }

    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister p_149651_1_)
    {
        field_149837_b = p_149651_1_.registerIcon(Reference.MODID.toLowerCase() + ":thoughtsoil");
    }

    /**
     * Determines the damage on the item the block drops. Used in cloth and wood.
     */
    public int damageDropped(int p_149692_1_)
    {
        return p_149692_1_;
    }

    /**
     * returns a list of blocks with the same ID, but different meta (eg: wood returns 4 blocks)
     */
    @SideOnly(Side.CLIENT)
    public void getSubBlocks(Item p_149666_1_, CreativeTabs p_149666_2_, List p_149666_3_)
    {
        p_149666_3_.add(new ItemStack(p_149666_1_, 1, 0));
    }

    ////////////////////////////////////
    // Sligthly more fertile than dirt, like tilled dirt near water
    @Override
    public boolean isFertile(World world, int x, int y, int z){
        return true;
    }

    // better soil : all plans grow directly on it, no tilling required
    @Override
    public boolean canSustainPlant(IBlockAccess world, int x, int y, int z, ForgeDirection direction, IPlantable plantable) {
        Block plant = plantable.getPlant(world, x, y + 1, z);
        EnumPlantType plantType = plantable.getPlantType(world, x, y + 1, z);
        return true;
    }

    //////////////////////////////////////
    // pass on Random Tick to block above, WhishSoil effect stacks
    @Override
    public void updateTick(World world, int x, int y, int z, Random random) {
        Block block = world.getBlock(x, y, z);
        if(block.getTickRandomly() && random.nextInt(5)== 0){
            block.updateTick(world, x, y + 1, z, random);
        }
    }
}
