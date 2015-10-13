package com.djlead.leadmod.blocks;

import com.djlead.leadmod.Reference;
import com.djlead.leadmod.sys.LogOut;
import com.djlead.leadmod.sys.MyBlocks;
import com.djlead.leadmod.sys.MyTab;
import com.sun.scenario.effect.Crop;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.EnumPlantType;
import net.minecraftforge.common.IPlantable;
import net.minecraftforge.common.util.ForgeDirection;

import java.util.Random;

/**
 * Created by Lead on 5-10-2015.
 */

public class WhishSoil extends BaseBlock {
    @SideOnly(Side.CLIENT)
    private IIcon field_149824_a;
    @SideOnly(Side.CLIENT)
    private IIcon field_149823_b;
    private static final String __OBFID = "CL_00000241";

    public WhishSoil(){
        super(Material.ground);
        this.setTickRandomly(true);
//        this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 0.9375F, 1.0F);
//        this.setLightOpacity(255);
        this.setBlockTextureName("whishsoil");
        this.setBlockName("whishsoil");
        this.setHardness(1.0F);
        this.setResistance(2.0F);
        this.setHarvestLevel("shovel", 1);
        this.setCreativeTab(MyTab.CreaTab);

    }

    /**
     * Returns a bounding box from the pool of bounding boxes (this means this box can change after the pool has been
     * cleared to be reused)
     */
//    public AxisAlignedBB getCollisionBoundingBoxFromPool(World p_149668_1_, int p_149668_2_, int p_149668_3_, int p_149668_4_){
//        return AxisAlignedBB.getBoundingBox((double)(p_149668_2_ + 0), (double)(p_149668_3_ + 0), (double)(p_149668_4_ + 0), (double)(p_149668_2_ + 1), (double)(p_149668_3_ + 1), (double)(p_149668_4_ + 1));
//    }

    /**
     * Is this block (a) opaque and (b) a full 1m cube?  This determines whether or not to render the shared face of two
     * adjacent blocks and also whether the player can attach torches, redstone wire, etc to this block.
     */
    public boolean isOpaqueCube()
    {
        return false;
    }

    /**
     * If this block doesn't render as an ordinary block it will return False (examples: signs, buttons, stairs, etc)
     */
    public boolean renderAsNormalBlock()
    {
        return false;
    }

    /**
     * Gets the block's texture. Args: side, meta
     */
    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int p_149691_1_, int p_149691_2_){

        return p_149691_1_ == 1 ? (p_149691_2_ > 0 ? this.field_149824_a : this.field_149823_b) : Blocks.dirt.getBlockTextureFromSide(p_149691_1_);

    }

    /**
     * Ticks the block if it's been scheduled
     */
    public void updateTick(World world, int posX, int posY, int posZ, Random random) {

        Block block = world.getBlock(posX, posY, posZ);
        if(block.getTickRandomly()){
            block.updateTick(world, posX, posY + 1, posZ, random);
        }
        if (!this.func_149821_m(world, posX, posY, posZ) && !world.canLightningStrikeAt(posX, posY + 1, posZ)){
            int l = world.getBlockMetadata(posX, posY, posZ);

            if (l > 0){
                world.setBlockMetadataWithNotify(posX, posY, posZ, l - 1, 2);
            }else if (!this.func_149822_e(world, posX, posY, posZ)) {

                // if no water around, change block in dirt
//                world.setBlock(posX, posY, posZ, Blocks.dirt);
            }
        } else{
           world.setBlockMetadataWithNotify(posX, posY, posZ, 7, 2);
        }
    }

    /**
     * Block's chance to react to an entity falling on it.
     */
//    public void onFallenUpon(World p_149746_1_, int p_149746_2_, int p_149746_3_, int p_149746_4_, Entity p_149746_5_, float p_149746_6_){
//        if (!p_149746_1_.isRemote && p_149746_1_.rand.nextFloat() < p_149746_6_ - 0.5F)
//        {
//            if (!(p_149746_5_ instanceof EntityPlayer) && !p_149746_1_.getGameRules().getGameRuleBooleanValue("mobGriefing"))
//            {
//                return;
//            }
//
//       //     p_149746_1_.setBlock(p_149746_2_, p_149746_3_, p_149746_4_, Blocks.dirt);
//        }
//    }

    private boolean func_149822_e(World p_149822_1_, int p_149822_2_, int p_149822_3_, int p_149822_4_){

        byte b0 = 0;
        for (int l = p_149822_2_ - b0; l <= p_149822_2_ + b0; ++l){
            for (int i1 = p_149822_4_ - b0; i1 <= p_149822_4_ + b0; ++i1){
                Block block = p_149822_1_.getBlock(l, p_149822_3_ + 1, i1);

                if (block instanceof IPlantable && canSustainPlant(p_149822_1_, p_149822_2_, p_149822_3_, p_149822_4_, ForgeDirection.UP, (IPlantable)block)){
                    return true;
                }
            }
        }
        return false;
    }

    private boolean func_149821_m(World world, int posX, int posY, int posZ) {
        for (int l = posX - 4; l <= posX + 4; ++l) {
            for (int i1 = posY; i1 <= posY + 1; ++i1){
                for (int j1 = posZ - 4; j1 <= posZ + 4; ++j1) {
                    if (world.getBlock(l, i1, j1).getMaterial() == Material.water){
                        return true;
                    }
                }
            }
        }

        return false;
//        return true;        // always act like water in area
    }

    /**
     * Lets the block know when one of its neighbor changes. Doesn't know which neighbor changed (coordinates passed are
     * their own) Args: x, y, z, neighbor Block
     */
    public void onNeighborBlockChange(World world, int posX, int posY, int posZ, Block block){

        // replace farmland with dirt when a solid block placed on top
        super.onNeighborBlockChange(world, posX, posY, posZ, block);
        Material material = world.getBlock(posX, posY + 1, posZ).getMaterial();
        if (material.isSolid()){
//            world.setBlock(posX, posY, posZ, Blocks.dirt);
        }
    }

    public Item getItemDropped(int p_149650_1_, Random random, int p_149650_3_){
        return MyBlocks.whishSoil.getItemDropped(0, random, p_149650_3_);
    }

    /**
     * Gets an item for the block being called on. Args: world, x, y, z
     */
    @SideOnly(Side.CLIENT)
    public Item getItem(World world, int posX, int posY, int posZ)
    {
        return Item.getItemFromBlock(MyBlocks.whishSoil);
    }

    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister icon)
    {
        this.field_149824_a = icon.registerIcon(Reference.MODID + ":" + this.getTextureName());
        this.field_149823_b = icon.registerIcon(Reference.MODID + ":" + this.getTextureName()); // top part
    }


    ////////////////////////////////////
    // Sligthly more fertile than dirt, like tilled dirt near water
    @Override
    public boolean isFertile(World world, int posX, int posY, int posZ){
        return true;
    }

    // better soil : all plans grow directly on it, no tilling required
    @Override
    public boolean canSustainPlant(IBlockAccess world, int posX, int posY, int posZ, ForgeDirection direction, IPlantable plantable) {
        Block plant = plantable.getPlant(world, posX, posY + 1, posZ);
        EnumPlantType plantType = plantable.getPlantType(world, posX, posY + 1, posZ);


        /////
//        switch (plantType) {
//            case Crop:
//                return true;
//            default:
            //     return super.canSustainPlant(world, posX, posY, posZ, direction, plantable);
            return true; // otherwise seed gets popped out
//
//        }
    }
}

