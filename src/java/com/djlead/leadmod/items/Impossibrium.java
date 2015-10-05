package com.djlead.leadmod.items;

import net.minecraft.entity.monster.EntityEnderman;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

/**
 * Created by Lead on 27-9-2015.
 */
public class Impossibrium extends BaseItem {

    public Impossibrium() {
        super();
        this.maxStackSize = 16;
        this.setUnlocalizedName("Impossibrium");
    }

    public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player) {

        EntityEnderman enderman = new EntityEnderman(world);
        enderman.setLocationAndAngles(player.posX, player.posY, player.posZ,0,0);
        world.spawnEntityInWorld(enderman);

        if (!player.capabilities.isCreativeMode) {
            stack.stackSize--;
        }
        return stack;
    }
}
