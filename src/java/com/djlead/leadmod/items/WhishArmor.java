package com.djlead.leadmod.items;


import com.djlead.leadmod.Reference;
import com.djlead.leadmod.sys.MyItems;
import com.djlead.leadmod.sys.MyTab;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;

/**
 * Created by Lead on 30-9-2015.
 */
public class WhishArmor extends ItemArmor {
    public String textureName;
    public WhishArmor(String unlocalizedName, int type) {
        super(MyItems.whishArmor, 0, type);
        this.textureName = "whisharmor";

        this.setTextureName(Reference.MODID + ":" + unlocalizedName);

        this.setUnlocalizedName(unlocalizedName);
        this.setCreativeTab(MyTab.CreaTab);


        this.isRepairable();
    }

    @Override
    public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type) {
        return Reference.MODID + ":textures/armor/" + this.textureName + "_" + (this.armorType == 2 ? "2" : "1") + ".png";
    }



}
