package com.djlead.leadmod.sys;

/**
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

                    // if all criteria are ok
                    block2.onPlantGrow(world, posX, posY - 1, posZ, posX, posY, posZ);

                    // build mid section of the tree, widening
                    for (int midsection = 0; midsection <= height-this.minTreeHeight; ++midsection) {
                        int putY = posY + this.minTreeHeight + midsection;
                        this.setBlockAndNotifyAdequately(world, posX-1, putY, posZ, MyBlocks.logBT, 0);
                        this.setBlockAndNotifyAdequately(world, posX+1, putY, posZ, MyBlocks.logBT, 0);
                        this.setBlockAndNotifyAdequately(world, posX, putY, posZ-1, MyBlocks.logBT, 0);
                        this.setBlockAndNotifyAdequately(world, posX, putY, posZ + 1, MyBlocks.logBT, 0);

                        // Leafs
                        //                    // Outer roow
                        this.setBlockAndNotifyAdequately(world, posX+2, putY, posZ, MyBlocks.leavesBT, 0);
                        this.setBlockAndNotifyAdequately(world, posX+1, putY, posZ+1, MyBlocks.leavesBT, 0);
                        this.setBlockAndNotifyAdequately(world, posX-2, putY, posZ, MyBlocks.leavesBT, 0);
                        this.setBlockAndNotifyAdequately(world, posX-1, putY, posZ+1, MyBlocks.leavesBT, 0);
                        this.setBlockAndNotifyAdequately(world, posX, putY, posZ-2, MyBlocks.leavesBT, 0);
                        this.setBlockAndNotifyAdequately(world, posX+1, putY, posZ-1, MyBlocks.leavesBT, 0);
                        this.setBlockAndNotifyAdequately(world, posX, putY, posZ+2, MyBlocks.leavesBT, 0);
                        this.setBlockAndNotifyAdequately(world, posX-1, putY, posZ-1, MyBlocks.leavesBT, 0);

                        if (random.nextInt(1) == 1) {
                            this.setBlockAndNotifyAdequately(world, posX+3, putY, posZ, MyBlocks.leavesBT, 0);
                            this.setBlockAndNotifyAdequately(world, posX+2, putY, posZ+1, MyBlocks.leavesBT, 0);
                            this.setBlockAndNotifyAdequately(world, posX+1, putY, posZ+2, MyBlocks.leavesBT, 0);
                            this.setBlockAndNotifyAdequately(world, posX, putY, posZ+3, MyBlocks.leavesBT, 0);
                            this.setBlockAndNotifyAdequately(world, posX-1, putY, posZ+2, MyBlocks.leavesBT, 0);
                            this.setBlockAndNotifyAdequately(world, posX-2, putY, posZ+1, MyBlocks.leavesBT, 0);
                            this.setBlockAndNotifyAdequately(world, posX-3, putY, posZ, MyBlocks.leavesBT, 0);
                            this.setBlockAndNotifyAdequately(world, posX-2, putY, posZ-1, MyBlocks.leavesBT, 0);
                            this.setBlockAndNotifyAdequately(world, posX-1, putY, posZ-2, MyBlocks.leavesBT, 0);
                            this.setBlockAndNotifyAdequately(world, posX, putY, posZ-3, MyBlocks.leavesBT, 0);
                            this.setBlockAndNotifyAdequately(world, posX+1, putY, posZ-2, MyBlocks.leavesBT, 0);
                            this.setBlockAndNotifyAdequately(world, posX+2, putY, posZ-1, MyBlocks.leavesBT, 0);
                        }
                        if (height-this.minTreeHeight > 8) {
                            if (midsection > 1 && midsection < height-this.minTreeHeight-3) {

                                this.setBlockAndNotifyAdequately(world, posX+2, putY, posZ, MyBlocks.logBT, 0);
                                this.setBlockAndNotifyAdequately(world, posX+1, putY, posZ+1, MyBlocks.logBT, 0);
                                this.setBlockAndNotifyAdequately(world, posX-2, putY, posZ, MyBlocks.logBT, 0);
                                this.setBlockAndNotifyAdequately(world, posX-1, putY, posZ+1, MyBlocks.logBT, 0);
                                this.setBlockAndNotifyAdequately(world, posX, putY, posZ-2, MyBlocks.logBT, 0);
                                this.setBlockAndNotifyAdequately(world, posX+1, putY, posZ-1, MyBlocks.logBT, 0);
                                this.setBlockAndNotifyAdequately(world, posX, putY, posZ+2, MyBlocks.logBT, 0);
                                this.setBlockAndNotifyAdequately(world, posX-1, putY, posZ-1, MyBlocks.logBT, 0);

                                // Leafs
                                this.setBlockAndNotifyAdequately(world, posX + 3, putY, posZ, MyBlocks.leavesBT, 0);
                                if (random.nextInt(2)==1) {
                                    this.setBlockAndNotifyAdequately(world, posX + 4, putY, posZ, MyBlocks.leavesBT, 0);
                                }
                                this.setBlockAndNotifyAdequately(world, posX+2, putY, posZ+1, MyBlocks.leavesBT, 0);
                                this.setBlockAndNotifyAdequately(world, posX+1, putY, posZ+2, MyBlocks.leavesBT, 0);
                                this.setBlockAndNotifyAdequately(world, posX, putY, posZ + 3, MyBlocks.leavesBT, 0);
                                if (random.nextInt(2)==1) {
                                    this.setBlockAndNotifyAdequately(world, posX+1, putY, posZ + 2, MyBlocks.leavesBT, 0);
                                }
                                this.setBlockAndNotifyAdequately(world, posX-1, putY, posZ+2, MyBlocks.leavesBT, 0);
                                this.setBlockAndNotifyAdequately(world, posX-2, putY, posZ+1, MyBlocks.leavesBT, 0);
                                if (random.nextInt(2)==1) {
                                    this.setBlockAndNotifyAdequately(world, posX - 3, putY, posZ, MyBlocks.leavesBT, 0);
                                }
                                this.setBlockAndNotifyAdequately(world, posX-2, putY, posZ-1, MyBlocks.leavesBT, 0);
                                this.setBlockAndNotifyAdequately(world, posX-1, putY, posZ-2, MyBlocks.leavesBT, 0);
                                this.setBlockAndNotifyAdequately(world, posX, putY, posZ - 3, MyBlocks.leavesBT, 0);
                                if (random.nextInt(2)==1) {
                                    this.setBlockAndNotifyAdequately(world, posX+1, putY, posZ - 3, MyBlocks.leavesBT, 0);
                                }
                                this.setBlockAndNotifyAdequately(world, posX+1, putY, posZ-2, MyBlocks.leavesBT, 0);
                                this.setBlockAndNotifyAdequately(world, posX+2, putY, posZ-1, MyBlocks.leavesBT, 0);
                            }
                        }
                        ++putY;
                        if (random.nextInt(3)==1) {
                            this.setBlockAndNotifyAdequately(world, posX + 3, putY, posZ, MyBlocks.leavesBT, 0);
                        }
                        this.setBlockAndNotifyAdequately(world, posX+2, putY, posZ+1, MyBlocks.leavesBT, 0);
                        this.setBlockAndNotifyAdequately(world, posX+1, putY, posZ+2, MyBlocks.leavesBT, 0);
                        if (random.nextInt(5)==1) {
                            this.setBlockAndNotifyAdequately(world, posX, putY, posZ + 3, MyBlocks.leavesBT, 0);
                        }
                        this.setBlockAndNotifyAdequately(world, posX-1, putY, posZ+2, MyBlocks.leavesBT, 0);
                        this.setBlockAndNotifyAdequately(world, posX-2, putY, posZ+1, MyBlocks.leavesBT, 0);
                        if (random.nextInt(4)==1) {
                            this.setBlockAndNotifyAdequately(world, posX - 3, putY, posZ, MyBlocks.leavesBT, 0);
                        }
                        this.setBlockAndNotifyAdequately(world, posX-2, putY, posZ-1, MyBlocks.leavesBT, 0);
                        this.setBlockAndNotifyAdequately(world, posX-1, putY, posZ-2, MyBlocks.leavesBT, 0);
                        if (random.nextInt(6)==1) {
                            this.setBlockAndNotifyAdequately(world, posX, putY, posZ - 3, MyBlocks.leavesBT, 0);
                        }
                        this.setBlockAndNotifyAdequately(world, posX+1, putY, posZ-2, MyBlocks.leavesBT, 0);
                        this.setBlockAndNotifyAdequately(world, posX+2, putY, posZ-1, MyBlocks.leavesBT, 0);
                    }

                    // Loot hidden in the top of the tree
                    int putY = posY + height;


                    this.setBlockAndNotifyAdequately(world, posX, putY, posZ, Blocks.gold_block, 0);

                    this.setBlockAndNotifyAdequately(world, posX, putY+1, posZ, Blocks.chest, 0);
                    TileEntityChest tile = (TileEntityChest)world.getTileEntity(posX, putY+1, posZ);
                    if(tile != null) {
                        tile.setInventorySlotContents(random.nextInt(18), new ItemStack(MyItems.whishApple, random.nextInt(4)));
                        tile.setInventorySlotContents(random.nextInt(18), new ItemStack(MyItems.thoughtFruit, random.nextInt(16)));
                    }
                    /////////////////
                    // build Top section
                    /////////////////////
                    // Inner row
                    ++putY;
                    this.setBlockAndNotifyAdequately(world, posX-1, putY, posZ, MyBlocks.logBT, 0);
                    this.setBlockAndNotifyAdequately(world, posX+1, putY, posZ, MyBlocks.logBT, 0);
                    this.setBlockAndNotifyAdequately(world, posX, putY, posZ-1, MyBlocks.logBT, 0);
                    this.setBlockAndNotifyAdequately(world, posX, putY, posZ + 1, MyBlocks.logBT, 0);

                    // Leafs
                    //                    // Outer roow
                    this.setBlockAndNotifyAdequately(world, posX+2, putY, posZ, MyBlocks.leavesBT, 0);
                    this.setBlockAndNotifyAdequately(world, posX+1, putY, posZ+1, MyBlocks.leavesBT, 0);
                    this.setBlockAndNotifyAdequately(world, posX-2, putY, posZ, MyBlocks.leavesBT, 0);
                    this.setBlockAndNotifyAdequately(world, posX-1, putY, posZ+1, MyBlocks.leavesBT, 0);
                    this.setBlockAndNotifyAdequately(world, posX, putY, posZ-2, MyBlocks.leavesBT, 0);
                    this.setBlockAndNotifyAdequately(world, posX+1, putY, posZ-1, MyBlocks.leavesBT, 0);
                    this.setBlockAndNotifyAdequately(world, posX, putY, posZ+2, MyBlocks.leavesBT, 0);
                    this.setBlockAndNotifyAdequately(world, posX-1, putY, posZ-1, MyBlocks.leavesBT, 0);

                    // Real top tippy
                    for (int i=0;i<1 + random.nextInt(3);++i) {
                        ++putY;
                        this.setBlockAndNotifyAdequately(world, posX, putY, posZ, MyBlocks.logBT, 0);
                        this.setBlockAndNotifyAdequately(world, posX - 1, putY, posZ, MyBlocks.logBT, 0);
                        this.setBlockAndNotifyAdequately(world, posX + 1, putY, posZ, MyBlocks.logBT, 0);
                        this.setBlockAndNotifyAdequately(world, posX, putY, posZ - 1, MyBlocks.logBT, 0);
                        this.setBlockAndNotifyAdequately(world, posX, putY, posZ + 1, MyBlocks.logBT, 0);

                        // Leafs
                        //                    // Outer roow
                        this.setBlockAndNotifyAdequately(world, posX+2, putY, posZ, MyBlocks.leavesBT, 0);
                        this.setBlockAndNotifyAdequately(world, posX+1, putY, posZ+1, MyBlocks.leavesBT, 0);
                        this.setBlockAndNotifyAdequately(world, posX-2, putY, posZ, MyBlocks.leavesBT, 0);
                        this.setBlockAndNotifyAdequately(world, posX-1, putY, posZ+1, MyBlocks.leavesBT, 0);
                        this.setBlockAndNotifyAdequately(world, posX, putY, posZ-2, MyBlocks.leavesBT, 0);
                        this.setBlockAndNotifyAdequately(world, posX+1, putY, posZ-1, MyBlocks.leavesBT, 0);
                        this.setBlockAndNotifyAdequately(world, posX, putY, posZ+2, MyBlocks.leavesBT, 0);
                        this.setBlockAndNotifyAdequately(world, posX-1, putY, posZ-1, MyBlocks.leavesBT, 0);
                    }

                    for (int i=0;i< 2 + random.nextInt(4);++i) {
                        ++putY;
                        this.setBlockAndNotifyAdequately(world, posX, putY, posZ, MyBlocks.logBT, 0);

                        this.setBlockAndNotifyAdequately(world, posX-1, putY, posZ, MyBlocks.leavesBT, 0);
                        this.setBlockAndNotifyAdequately(world, posX+1, putY, posZ, MyBlocks.leavesBT, 0);
                        this.setBlockAndNotifyAdequately(world, posX, putY, posZ-1, MyBlocks.leavesBT, 0);
                        this.setBlockAndNotifyAdequately(world, posX, putY, posZ + 1, MyBlocks.leavesBT, 0);
                    }

                    for (int i=0;i< 2 + random.nextInt(4);++i) {
                        ++putY;
                        this.setBlockAndNotifyAdequately(world, posX, putY, posZ, MyBlocks.leavesBT, 0);
                    }

                    ///////////
                    // vines + trunk
                    int l1;
                    int i2;
                    int j2;
                    int i3;
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

//                    if (this.vinesGrow){
//                        for (k1 = posY - 3 + height; k1 <= posY + height; ++k1){
//                            i3 = k1 - (posY + height);
//                            l1 = 2 - i3 / 2;
//
//                            for (i2 = posX - l1; i2 <= posX + l1; ++i2){
//                                for (j2 = posZ - l1; j2 <= posZ + l1; ++j2) {
//                                    if (world.getBlock(i2, k1, j2).isLeaves(world, i2, k1, j2)) {
//                                        if (random.nextInt(4) == 0 && world.getBlock(i2 - 1, k1, j2).isAir(world, i2 - 1, k1, j2)){
//                                            this.growVines(world, i2 - 1, k1, j2, 8);
//                                        }
//                                        if (random.nextInt(4) == 0 && world.getBlock(i2 + 1, k1, j2).isAir(world, i2 + 1, k1, j2)) {
//                                            this.growVines(world, i2 + 1, k1, j2, 2);
//                                        }
//                                        if (random.nextInt(4) == 0 && world.getBlock(i2, k1, j2 - 1).isAir(world, i2, k1, j2 - 1)) {
//                                            this.growVines(world, i2, k1, j2 - 1, 1);
//                                        }
//                                        if (random.nextInt(4) == 0 && world.getBlock(i2, k1, j2 + 1).isAir(world, i2, k1, j2 + 1)){
//                                            this.growVines(world, i2, k1, j2 + 1, 4);
//                                        }
//                                    }
//                                }
//                            }
//                        }
//                    }
                    return true;
                } else {
                    return false;
                }
            }
        } else{
            return false;
        }
    }

    /**
     * Grows vines downward from the given block for a given length. Args: World, x, starty, z, vine-length
     */
    private void growVines(World world, int posX, int posY, int posZ, int vinesgrow) {
        this.setBlockAndNotifyAdequately(world, posX, posY, posZ, Blocks.vine, vinesgrow);
        int i1 = 4;
        while (true) {
            --posY;
            if (!world.getBlock(posX, posY, posZ).isAir(world, posX, posY, posZ) || i1 <= 0){
                return;
            }
            this.setBlockAndNotifyAdequately(world, posX, posY, posZ, Blocks.vine, vinesgrow);
            --i1;
        }
    }
}

