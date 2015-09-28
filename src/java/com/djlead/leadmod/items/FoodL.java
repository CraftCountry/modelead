package com.djlead.leadmod.items;

import com.djlead.leadmod.Reference;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

/**
 * Created by Lead on 28-9-2015.
 */


public class FoodL extends ItemFood {

    private PotionEffect[] effects;

    public FoodL(String unlocalizedName, int healing, float saturation, boolean wolves, PotionEffect... effects) {
        super(healing, saturation, wolves);
        this.setUnlocalizedName(unlocalizedName);
        this.setTextureName(Reference.MODID + ":" + unlocalizedName);
        this.setCreativeTab(CreativeTabs.tabFood);
        this.effects = effects;
    }

    @Override
    protected void onFoodEaten(ItemStack stack, World world, EntityPlayer player) {
        super.onFoodEaten(stack, world, player);

        // apply potion effects
        for (int i=0;i<effects.length;i++) {
            if (!world.isRemote && effects[i] != null && effects[i].getPotionID() > 0){
                player.addPotionEffect(new PotionEffect(this.effects[i].getPotionID(), this.effects[i].getDuration(), this.effects[i].getAmplifier(), this.effects[i].getIsAmbient()));
            }
        }
    }
}

