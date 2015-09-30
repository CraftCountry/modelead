package com.djlead.leadmod.items;

import com.djlead.leadmod.Reference;
import com.djlead.leadmod.sys.MyTab;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

/** Food Item Wish Apple, the top tear apple
 * Created by Lead on 28-9-2015.
 */


public class WhishApple extends ItemFood {

    public WhishApple() {
        super(10, 1.4F, true);
        //  healing , saturation , wolve food
        //  ---------------------------------
        //  Apple 	                4 	0.3f
        //  Raw Porkchop or Beef 	3 	0.3f
        //  Bread 	                5 	0.6f
        //  Cooked Porkchop or Beef 8 	0.8f
        //  Golden Apple 	        4 	1.2f

        this.setUnlocalizedName("whishapple");
        this.setTextureName(Reference.MODID + ":" + "whishapple");
        this.setCreativeTab(MyTab.CreaTab);
        this.maxStackSize  = 16;
        this.setAlwaysEdible();
    }

    @Override
    protected void onFoodEaten(ItemStack stack, World world, EntityPlayer player) {
        super.onFoodEaten(stack, world, player);

        // apply potion effects                 potion name , time in ticks , powerlevel (0-3) , getAmbient()
        player.addPotionEffect(new PotionEffect(Potion.moveSpeed.id, 1200, 3, true));
        player.addPotionEffect(new PotionEffect(Potion.jump.id, 1200, 3, false));
        player.addPotionEffect(new PotionEffect(Potion.resistance.id, 3600, 3, false));
        player.addPotionEffect(new PotionEffect(Potion.regeneration.id, 3600, 3, false));


    }
}

