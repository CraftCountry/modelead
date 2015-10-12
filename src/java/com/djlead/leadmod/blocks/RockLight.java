package com.djlead.leadmod.blocks;

import com.djlead.leadmod.sys.LogOut;
import com.djlead.leadmod.sys.MyBlocks;
import com.djlead.leadmod.sys.MyItems;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.world.World;

import java.util.Random;

/**
 * Created by Lead on 26-9-2015.
 */
public class RockLight extends BaseBlock {

    private boolean field_150171_a;

    public RockLight() {
        super();
        this.setBlockName("rocklight");
        this.setHardness(3.0F);
        this.setResistance(10.0F);
//        this.setLightLevel(1.0F);

    }

    // response time after getting redstone signal
    public int tickRate(World world)
    {
        return 1;
    }


    /**
     * Called whenever the block is added into the world. Args: world, x, y, z
     */
    public void onBlockAdded(World world, int posX, int posY, int posZ)
    {
        if (!world.isRemote)
        {
//            if (this.field_150171_a && !world.isBlockIndirectlyGettingPowered(posX, posY, posZ)){
//                world.scheduleBlockUpdate(posX, posY, posZ, this, 4);
//            }
//            else
            if (!this.field_150171_a && world.isBlockIndirectlyGettingPowered(posX, posY, posZ)){
//                world.setBlock(posX, posY, posZ, Blocks.lit_redstone_lamp, 0, 2);
                LogOut.info("block added");
            }
            LogOut.info("added block?");
        }
    }


    public void onNeighborBlockChange(World world, int posX, int posY, int posZ, Block block){
        if (!world.isRemote){
            if (!world.isBlockIndirectlyGettingPowered(posX, posY, posZ))
            {
                world.scheduleBlockUpdate(posX, posY, posZ, this, 1);
                LogOut.info("placed added to blockupdate");
            }
            else

            if (world.isBlockIndirectlyGettingPowered(posX, posY, posZ)){

//               world.setBlock(posX, posY, posZ, Blocks.lit_redstone_lamp, 0, 2);

                this.setLightLevel(3F);
                setLightLevel(3F);
                MyBlocks.rocklight.setLightLevel(3.0F);
                LogOut.info("neightbour change (on) " + world.isBlockIndirectlyGettingPowered(posX, posY, posZ));

            } else {
                this.setLightLevel(0F);
                setLightLevel(0.0F);
                MyBlocks.rocklight.setLightLevel(0.0F);
                LogOut.info("neighbour change (off)" + world.isBlockIndirectlyGettingPowered(posX, posY, posZ));

            }
        }
    }

    /**
     * Ticks the block if it's been scheduled
     */

    public void updateTick(World world, int posX, int posY, int posZ, Random random){
        if (!world.isRemote && !world.isBlockIndirectlyGettingPowered(posX, posY, posZ)){

            world.setBlock(posX, posY, posZ, MyBlocks.rocklight, 0, 2);
            this.setLightLevel(0F);
            MyBlocks.rocklight.setLightLevel(0F);
            LogOut.info("Tick off");
        } else {

            this.setLightLevel(3F);
            MyBlocks.rocklight.setLightLevel(3F);
            LogOut.info("Tick on");
        }
    }

    @Override
    public boolean isOpaqueCube(){
        return false;
    }

    @Override
    public Item getItemDropped(int metadata, Random random, int fortune){
        return MyItems.impossibrium;
    }

    @Override
    public int quantityDropped(Random random) {
        return 2;
    } // give 2 items when mined
}
