package com.djlead.leadmod.sys;

/** Generate Big Tree with lots of random sizes and treasure hidden in top
 * Created by Lead on 10-10-2015.
 */

import net.minecraft.block.Block;
import net.minecraft.block.BlockSapling;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntityChest;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;
import net.minecraftforge.common.util.ForgeDirection;

import java.util.Random;


/**
 * Created by Lead on 3-10-2015.
 */

public class WoodGen extends WorldGenAbstractTree {

    private final int minTreeHeight;
    private final boolean vinesGrow;
    private static final String __OBFID = "CL_00000438";

    public WoodGen(boolean p_i2027_1_)    {
        this(p_i2027_1_, 8, true);
    }

    public WoodGen(boolean p_i2028_1_, int minheight, boolean vinesgrow)    {
        super(p_i2028_1_);
        this.minTreeHeight = minheight;
        this.vinesGrow = vinesgrow;
    }

    public boolean generate(World world, Random random, int posX, int posY, int posZ)    {

        // height of tree
        int height = 3 + random.nextInt(12) + this.minTreeHeight;
        boolean flag = true;
        // If : tree has enough height between surface and upper world limit (256)
        if (posY >= 1 && posY + height + 1 <= 256){

            byte b0;
            int k1;
            Block block;

            // check if tree can grow at least to 2 block height (check is 2 trunk logs can be placed
            for (int i1 = posY; i1 <= posY + 2; ++i1){
                b0 = 1;
                if (i1 == posY){ b0 = 0; }
                if (i1 >= posY + 1 + height - 2) { b0 = 2; }

                for (int j1 = posX - b0; j1 <= posX + b0 && flag; ++j1){
                    for (k1 = posZ - b0; k1 <= posZ + b0 && flag; ++k1){
                        if (i1 >= 0 && i1 < 256){
                            block = world.getBlock(j1, i1, k1);
                            if (!this.isReplaceable(world, j1, i1, k1)){
                                flag = false;
                            }
                        } else {
                            flag = false;
                        }
                    }
                }
            }
            if (!flag) {
                return false;
            } else {

                Block block2 = world.getBlock(posX, posY - 1, posZ);
                boolean isSoil = block2.canSustainPlant(world, posX, posY - 1, posZ, ForgeDirection.UP, (BlockSapling) MyBlocks.sapplingBT);

                // grow tree only if on soil and at least 2 blocks below y upper limit of 256
                if (isSoil && posY < 256 - height - 1) {
                    block2.onPlantGrow(world, posX, posY - 1, posZ, posX, posY, posZ);

                    //////////////////////
                    // build lower section of the tree, widening
                    for (int lowersection = 0; lowersection <= height-this.minTreeHeight; ++lowersection) {

                        int putY = posY + this.minTreeHeight + lowersection;
                        RingSmallWood(world, posX, putY, posZ);         // wood core
                        if (height-this.minTreeHeight > 8) {            // if taller than 8, do extra layer of wood in small section
                            if (lowersection > 1 && lowersection < height-this.minTreeHeight-3) {
                                RingMediumWood(world, posX, putY, posZ);
                            } else {
                                RingMediumLeafs(world, posX, putY, posZ);
                            }
                        } else {
                            RingMediumLeafs(world, posX, putY, posZ);
                        }

                        ++putY;
                        RingLargeLeafs(world, posX, putY, posZ);

                        int chance = 50;    // randomizer for leaf spreading outer layer
                        if (random.nextInt(100)<chance) PlaceBlockLeafs(world, posX + 3, putY, posZ + 1);
                        if (random.nextInt(100)<chance) PlaceBlockLeafs(world, posX + 2, putY, posZ + 2);
                        if (random.nextInt(100)<chance) PlaceBlockLeafs(world, posX + 1, putY, posZ + 3);
                        if (random.nextInt(100)<chance) PlaceBlockLeafs(world, posX - 1, putY, posZ + 3);
                        if (random.nextInt(100)<chance) PlaceBlockLeafs(world, posX - 2, putY, posZ + 2);
                        if (random.nextInt(100)<chance) PlaceBlockLeafs(world, posX - 3, putY, posZ + 1);
                        if (random.nextInt(100)<chance) PlaceBlockLeafs(world, posX - 3, putY, posZ - 1);
                        if (random.nextInt(100)<chance) PlaceBlockLeafs(world, posX - 2, putY, posZ - 2);
                        if (random.nextInt(100)<chance) PlaceBlockLeafs(world, posX - 1, putY, posZ - 3);
                        if (random.nextInt(100)<chance) PlaceBlockLeafs(world, posX + 1, putY, posZ - 3);
                        if (random.nextInt(100)<chance) PlaceBlockLeafs(world, posX + 2, putY, posZ - 2);
                        if (random.nextInt(100)<chance) PlaceBlockLeafs(world, posX + 3, putY, posZ - 1);
                    }

                    ////////////////////////////////////
                    // Loot hidden in the mid-top of the tree
                    int putY = posY + height;
                    int rand = random.nextInt(100);
                    Block treasure;         // metal treasure, chance calculation
                    if (rand <50) {
                       treasure = Blocks.iron_block;
                    }else if (rand <75) {
                       treasure = Blocks.gold_block;
                    } else {
                       treasure = MyBlocks.blockWhish;
                    }
                    this.setBlockAndNotifyAdequately(world, posX, putY, posZ, treasure, 0);
                    // place chest with food items, you must be hungry from all that chopping
                    this.setBlockAndNotifyAdequately(world, posX, putY+1, posZ, Blocks.chest, 0);
                    TileEntityChest tile = (TileEntityChest)world.getTileEntity(posX, putY+1, posZ);
                    if(tile != null) {
                        // put in random slot a random amount, overwrites one if random is equal
                        tile.setInventorySlotContents(random.nextInt(18), new ItemStack(MyItems.whishApple, random.nextInt(4)));
                        tile.setInventorySlotContents(random.nextInt(18), new ItemStack(MyItems.thoughtFruit, random.nextInt(16)));
                    }
                    // Hide the loot chest
                    ++putY;
                    RingSmallWood(world, posX, putY, posZ);
                    RingMediumLeafs(world, posX, putY, posZ);
                    //////////////////
                    // Real top tippy
                    for (int i=0;i<1 + random.nextInt(3);++i) {
                        ++putY;
                        RingSmallWood(world, posX, putY, posZ);
                        PlaceBlockWood(world, posX, putY, posZ);
                        RingMediumLeafs(world, posX, putY, posZ);
                    }

                    for (int i=0;i< 2 + random.nextInt(4);++i) {
                        ++putY;
                        PlaceBlockWood(world, posX, putY, posZ);
                        PlaceBlockLeafs(world, posX - 1, putY, posZ);
                        PlaceBlockLeafs(world, posX + 1, putY, posZ);
                        PlaceBlockLeafs(world, posX, putY, posZ - 1);
                        PlaceBlockLeafs(world, posX, putY, posZ + 1);
                    }

                    for (int i=0;i< 1 + random.nextInt(4);++i) {
                        ++putY;
                        PlaceBlockLeafs(world, posX, putY, posZ);
                    }

                    ///////////
                    // vines + trunk
                    for (k1 = 0; k1 < height; ++k1) {
                        block = world.getBlock(posX, posY + k1, posZ);

                        if (block.isAir(world, posX, posY + k1, posZ) || block.isLeaves(world, posX, posY + k1, posZ))  {
                            this.setBlockAndNotifyAdequately(world, posX, posY + k1, posZ, MyBlocks.logBT, 0);      // tree trunk material

                            if (this.vinesGrow && k1 > 0)                            {
                                if (random.nextInt(3) > 0 && world.isAirBlock(posX - 1, posY + k1, posZ)) {
                                    this.setBlockAndNotifyAdequately(world, posX - 1, posY + k1, posZ, Blocks.vine, 8);
                                }
                                if (random.nextInt(3) > 0 && world.isAirBlock(posX + 1, posY + k1, posZ))  {
                                    this.setBlockAndNotifyAdequately(world, posX + 1, posY + k1, posZ, Blocks.vine, 2);
                                }
                                if (random.nextInt(3) > 0 && world.isAirBlock(posX, posY + k1, posZ - 1)) {
                                    this.setBlockAndNotifyAdequately(world, posX, posY + k1, posZ - 1, Blocks.vine, 1);
                                }
                                if (random.nextInt(3) > 0 && world.isAirBlock(posX, posY + k1, posZ + 1)) {
                                    this.setBlockAndNotifyAdequately(world, posX, posY + k1, posZ + 1, Blocks.vine, 4);
                                }
                            }
                        }
                    }
                    return true;
                } else {            // check soil below
                    return false;
                }
            }
        } else{
            return false;
        }
    }

    // create parts of the tree
    private void RingSmallWood (World world, int posX, int posY, int posZ){
        PlaceBlockWood(world, posX - 1, posY, posZ);
        PlaceBlockWood(world, posX + 1, posY, posZ);
        PlaceBlockWood(world, posX, posY, posZ - 1);
        PlaceBlockWood(world, posX, posY, posZ + 1);
    }
    private void RingMediumLeafs (World world, int posX, int posY, int posZ) {
        PlaceBlockLeafs(world, posX + 2, posY, posZ);
        PlaceBlockLeafs(world, posX + 1, posY, posZ + 1);
        PlaceBlockLeafs(world, posX - 2, posY, posZ);
        PlaceBlockLeafs(world, posX - 1, posY, posZ + 1);
        PlaceBlockLeafs(world, posX, posY, posZ - 2);
        PlaceBlockLeafs(world, posX + 1, posY, posZ - 1);
        PlaceBlockLeafs(world, posX, posY, posZ + 2);
        PlaceBlockLeafs(world, posX - 1, posY, posZ - 1);
    }
    private void RingMediumWood (World world, int posX, int posY, int posZ) {
        PlaceBlockWood(world, posX + 2, posY, posZ);
        PlaceBlockWood(world, posX + 1, posY, posZ + 1);
        PlaceBlockWood(world, posX - 2, posY, posZ);
        PlaceBlockWood(world, posX - 1, posY, posZ + 1);
        PlaceBlockWood(world, posX, posY, posZ - 2);
        PlaceBlockWood(world, posX + 1, posY, posZ - 1);
        PlaceBlockWood(world, posX, posY, posZ + 2);
        PlaceBlockWood(world, posX - 1, posY, posZ - 1);
    }

    private void RingLargeLeafs (World world, int posX, int posY, int posZ) {
        PlaceBlockLeafs(world, posX + 3, posY, posZ);
        PlaceBlockLeafs(world, posX + 2, posY, posZ + 1);
        PlaceBlockLeafs(world, posX + 1, posY, posZ + 2);
        PlaceBlockLeafs(world, posX, posY, posZ + 3);
        PlaceBlockLeafs(world, posX - 1, posY, posZ + 2);
        PlaceBlockLeafs(world, posX - 2, posY, posZ + 1);
        PlaceBlockLeafs(world, posX - 3, posY, posZ);
        PlaceBlockLeafs(world, posX - 2, posY, posZ - 1);
        PlaceBlockLeafs(world, posX - 1, posY, posZ - 2);
        PlaceBlockLeafs(world, posX, posY, posZ - 3);
        PlaceBlockLeafs(world, posX + 1, posY, posZ - 2);
        PlaceBlockLeafs(world, posX+2, posY, posZ-1);
    }


    private void PlaceBlockWood (World world, int posX, int posY, int posZ) {
        Block tempblock = world.getBlock(posX, posY, posZ);
        if (tempblock.isAir(world, posX, posY, posZ) || tempblock.isLeaves(world, posX, posY, posZ))  {
            this.setBlockAndNotifyAdequately(world, posX, posY, posZ, MyBlocks.logBT, 0);
        }
    }

    private void PlaceBlockLeafs (World world, int posX, int posY, int posZ) {
        Block tempblock = world.getBlock(posX, posY, posZ);
        if (tempblock.isAir(world, posX, posY, posZ) || tempblock.isLeaves(world, posX, posY, posZ))  {
            this.setBlockAndNotifyAdequately(world, posX, posY, posZ, MyBlocks.leavesBT, 0);
        }
    }
}