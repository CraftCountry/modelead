package com.djlead.leadmod.sys;

import net.minecraft.block.Block;
import net.minecraft.block.BlockSapling;
import net.minecraft.init.Blocks;
import net.minecraft.util.Direction;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;
import net.minecraftforge.common.util.ForgeDirection;

import java.util.Random;

/**
 * Created by Lead on 3-10-2015.
 */
public class TreeGen extends WorldGenAbstractTree {

    private final int minTreeHeight;
    private final boolean vinesGrow;
    private static final String __OBFID = "CL_00000438";

    public TreeGen(boolean p_i2027_1_)    {
        this(p_i2027_1_, 8, true);
    }

    public TreeGen(boolean p_i2028_1_, int minheight, boolean vinesgrow)    {
        super(p_i2028_1_);
        this.minTreeHeight = minheight;
        this.vinesGrow = vinesgrow;
    }

    public boolean generate(World world, Random random, int posX, int posY, int posZ)    {

        // height of tree
        int l = random.nextInt(15) + this.minTreeHeight;
        boolean flag = true;

        if (posY >= 1 && posY + l + 1 <= 256){
            byte b0;
            int k1;
            Block block;

            for (int i1 = posY; i1 <= posY + 1 + l; ++i1){
                b0 = 1;

                if (i1 == posY){
                    b0 = 0;
                }

                if (i1 >= posY + 1 + l - 2) {
                    b0 = 2;
                }

                for (int j1 = posX - b0; j1 <= posX + b0 && flag; ++j1){
                    for (k1 = posZ - b0; k1 <= posZ + b0 && flag; ++k1){
                        if (i1 >= 0 && i1 < 256){
                            block = world.getBlock(j1, i1, k1);

                            if (!this.isReplaceable(world, j1, i1, k1)){
                                flag = false;
                            }
                        }
                        else {
                            flag = false;
                        }
                    }
                }
            }

            if (!flag)
            {
                return false;
            }
            else
            {
                Block block2 = world.getBlock(posX, posY - 1, posZ);

                boolean isSoil = block2.canSustainPlant(world, posX, posY - 1, posZ, ForgeDirection.UP, (BlockSapling) MyBlocks.sapplingBT);
                if (isSoil && posY < 256 - l - 1)                {
                    block2.onPlantGrow(world, posX, posY - 1, posZ, posX, posY, posZ);
                    b0 = 3;         // leaves width
                    byte b1 = 0;
                    int l1;
                    int i2;
                    int j2;
                    int i3;

                    for (k1 = posY - b0 + l; k1 <= posY + l; ++k1) {
                        i3 = k1 - (posY + l);
                        l1 = b1 + 1 - i3 / 3;

                        for (i2 = posX - l1; i2 <= posX + l1; ++i2){
                            j2 = i2 - posX;

                            for (int k2 = posZ - l1; k2 <= posZ + l1; ++k2) {
                                int l2 = k2 - posZ;

                                if (Math.abs(j2) != l1 || Math.abs(l2) != l1 || random.nextInt(15) != 0 && i3 != 0){
                                    Block block1 = world.getBlock(i2, k1, k2);

                                    if (block1.isAir(world, i2, k1, k2) || block1.isLeaves(world, i2, k1, k2)){
                                        this.setBlockAndNotifyAdequately(world, i2, k1, k2, MyBlocks.logBT, 0);
                                    }
                                }
                            }
                        }
                    }


                    b0 = 2;         // leaves width round 2 !!
                    b1 = 0;
                    for (k1 = posY - b0 + 1; k1 <= posY + l; ++k1) {
                        i3 = k1 - (posY + l);
                        l1 = b1 + 1 - i3 / 2;

                        for (i2 = posX - l1; i2 <= posX + l1; ++i2){
                            j2 = i2 - posX;

                            for (int k2 = posZ - l1; k2 <= posZ + l1; ++k2) {
                                int l2 = k2 - posZ;

                                if (Math.abs(j2) != l1 || Math.abs(l2) != l1 || random.nextInt(5) != 0 && i3 != 0){
                                    Block block1 = world.getBlock(i2, k1+3, k2);

                                    if (block1.isAir(world, i2, k1+3, k2) && !block1.isWood(world, i2, k1+3, k2)){
//                                        if (block1.isAir(world, i2, k1+3, k2) ){
                                        this.setBlockAndNotifyAdequately(world, i2, k1+3, k2, MyBlocks.leavesBT, 0);
                                    }
                                }
                            }
                        }
                    }

                    for (k1 = 0; k1 < l; ++k1)
                    {
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

                    if (this.vinesGrow){
                        for (k1 = posY - 3 + l; k1 <= posY + l; ++k1){
                            i3 = k1 - (posY + l);
                            l1 = 2 - i3 / 2;

                            for (i2 = posX - l1; i2 <= posX + l1; ++i2){
                                for (j2 = posZ - l1; j2 <= posZ + l1; ++j2) {
                                    if (world.getBlock(i2, k1, j2).isLeaves(world, i2, k1, j2)) {
                                        if (random.nextInt(4) == 0 && world.getBlock(i2 - 1, k1, j2).isAir(world, i2 - 1, k1, j2)){
                                            this.growVines(world, i2 - 1, k1, j2, 8);
                                        }

                                        if (random.nextInt(4) == 0 && world.getBlock(i2 + 1, k1, j2).isAir(world, i2 + 1, k1, j2)) {
                                            this.growVines(world, i2 + 1, k1, j2, 2);
                                        }

                                        if (random.nextInt(4) == 0 && world.getBlock(i2, k1, j2 - 1).isAir(world, i2, k1, j2 - 1)) {
                                            this.growVines(world, i2, k1, j2 - 1, 1);
                                        }

                                        if (random.nextInt(4) == 0 && world.getBlock(i2, k1, j2 + 1).isAir(world, i2, k1, j2 + 1)){
                                            this.growVines(world, i2, k1, j2 + 1, 4);
                                        }
                                    }
                                }
                            }
                        }

                        if (random.nextInt(5) == 0 && l > 5){
                            for (k1 = 0; k1 < 2; ++k1) {
                                for (i3 = 0; i3 < 4; ++i3){
                                    if (random.nextInt(4 - k1) == 0) {
                                        l1 = random.nextInt(3);
                                        this.setBlockAndNotifyAdequately(world, posX + Direction.offsetX[Direction.rotateOpposite[i3]], posY + l - 5 + k1, posZ + Direction.offsetZ[Direction.rotateOpposite[i3]], Blocks.cocoa, l1 << 2 | i3);
                                    }
                                }
                            }
                        }
                    }

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
    private void growVines(World p_76529_1_, int p_76529_2_, int p_76529_3_, int p_76529_4_, int p_76529_5_) {
        this.setBlockAndNotifyAdequately(p_76529_1_, p_76529_2_, p_76529_3_, p_76529_4_, Blocks.vine, p_76529_5_);
        int i1 = 4;

        while (true) {
            --p_76529_3_;

            if (!p_76529_1_.getBlock(p_76529_2_, p_76529_3_, p_76529_4_).isAir(p_76529_1_, p_76529_2_, p_76529_3_, p_76529_4_) || i1 <= 0){
                return;
            }

            this.setBlockAndNotifyAdequately(p_76529_1_, p_76529_2_, p_76529_3_, p_76529_4_, Blocks.vine, p_76529_5_);
            --i1;
        }
    }

    }
