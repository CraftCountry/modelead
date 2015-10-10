package com.djlead.leadmod.blocks;


import com.djlead.leadmod.Reference;
import com.djlead.leadmod.sys.MyTab;
import com.djlead.leadmod.sys.WoodGen;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.BlockSapling;
import net.minecraft.block.IGrowable;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.*;

import java.util.List;
import java.util.Random;

/**
 * Created by Lead on 3-10-2015.
 */

//public class SaplingBT extends BlockSapling {
public class SaplingBT extends BlockSapling implements IGrowable {

    public static final String[] sapplings = new String[] {"saplingbt"};
    private static final IIcon[] iconLength = new IIcon[sapplings.length];
    private static final String __OBFID = "CL_00000305";

    public SaplingBT()
    {
        float f = 0.4F;         // size
        this.setBlockBounds(0.5F - f, 0.0F, 0.5F - f, 0.5F + f, f * 2.0F, 0.5F + f);
        this.setBlockName("saplingbt");
        this.setCreativeTab(MyTab.CreaTab);

    }

    /**
     * Ticks the block if it's been scheduled
     */
    public void updateTick(World world, int posX, int posY, int posZ, Random random)
    {
        if (!world.isRemote)
        {
            super.updateTick(world, posX, posY, posZ, random);

            if (world.getBlockLightValue(posX, posY + 1, posZ) >= 9 && random.nextInt(7) == 0)
            {
                this.func_149879_c(world, posX, posY, posZ, random);
            }
        }
    }

    /**
     * Gets the block's texture. Args: side, meta
     */
    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int side, int meta)
    {
        meta &= 7;
        return iconLength[MathHelper.clamp_int(meta, 0, 5)];
    }

    // markOrGrowMarked (1.6.4)
    public void func_149879_c(World world, int posX, int posY, int posZ, Random random)
    {
        int l = world.getBlockMetadata(posX, posY, posZ);

        if ((l & 8) == 0)
        {
            world.setBlockMetadataWithNotify(posX, posY, posZ, l | 8, 4);
        }
        else
        {
            this.func_149878_d(world, posX, posY, posZ, random);
        }
    }

    // growTree
    public void func_149878_d(World world, int posX, int posY, int posZ, Random random)
    {
        if (!net.minecraftforge.event.terraingen.TerrainGen.saplingGrowTree(world, random, posX, posY, posZ)) return;
        int l = world.getBlockMetadata(posX, posY, posZ) & 7;
        Object object = random.nextInt(3) == 0 ? new WoodGen(true,12,true) : new WoodGen(true);
        int i1 = 0;                                     // ^ some randomness in height, default is 8
        int j1 = 0;
        boolean flag = false;

        switch (l)
        {
            case 0:
                object = new WoodGen(true);
                break;
            case 1:
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                break;
            case 5:
                break;
            default:
                break;
        }

        Block block = Blocks.air;

        if (flag)
        {
            world.setBlock(posX + i1, posY, posZ + j1, block, 0, 4);
            world.setBlock(posX + i1 + 1, posY, posZ + j1, block, 0, 4);
            world.setBlock(posX + i1, posY, posZ + j1 + 1, block, 0, 4);
            world.setBlock(posX + i1 + 1, posY, posZ + j1 + 1, block, 0, 4);
        }
        else
        {
            world.setBlock(posX, posY, posZ, block, 0, 4);
        }

        if (!((WorldGenerator)object).generate(world, random, posX + i1, posY, posZ + j1))
        {
            if (flag)
            {
                world.setBlock(posX + i1, posY, posZ + j1, this, l, 4);
                world.setBlock(posX + i1 + 1, posY, posZ + j1, this, l, 4);
                world.setBlock(posX + i1, posY, posZ + j1 + 1, this, l, 4);
                world.setBlock(posX + i1 + 1, posY, posZ + j1 + 1, this, l, 4);
            }
            else
            {
                world.setBlock(posX, posY, posZ, this, l, 4);
            }
        }
    }

    // isSameSappling
    public boolean func_149880_a(World world, int posX, int posY, int posZ, int p_149880_5_)
    {
        return world.getBlock(posX, posY, posZ) == this && (world.getBlockMetadata(posX, posY, posZ) & 7) == p_149880_5_;
    }

    /**
     * Determines the damage on the item the block drops. Used in cloth and wood.
     */
    public int damageDropped(int p_149692_1_)
    {
        return MathHelper.clamp_int(p_149692_1_ & 7, 0, 5);
    }

    /**
     * returns a list of blocks with the same ID, but different meta (eg: wood returns 4 blocks)
     */
    @SideOnly(Side.CLIENT)
    public void getSubBlocks(Item item, CreativeTabs p_149666_2_, List p_149666_3_){
        p_149666_3_.add(new ItemStack(item, 1, 0));
    }

    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister p_149651_1_)
    {
        iconLength[0] = p_149651_1_.registerIcon(Reference.MODID.toLowerCase() + ":" + sapplings[0]);
    }


    public boolean func_149851_a(World p_149851_1_, int p_149851_2_, int p_149851_3_, int p_149851_4_, boolean p_149851_5_)
    {
        return true;
    }

    public boolean func_149852_a(World p_149852_1_, Random p_149852_2_, int p_149852_3_, int p_149852_4_, int p_149852_5_)
    {
        return (double)p_149852_1_.rand.nextFloat() < 0.45D;
    }

    public void func_149853_b(World p_149853_1_, Random p_149853_2_, int p_149853_3_, int p_149853_4_, int p_149853_5_)
    {
        this.func_149879_c(p_149853_1_, p_149853_3_, p_149853_4_, p_149853_5_, p_149853_2_);
    }
}

