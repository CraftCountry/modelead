package com.djlead.leadmod.items;

import com.djlead.leadmod.Reference;
import com.djlead.leadmod.sys.MyItems;
import com.djlead.leadmod.sys.MyTab;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemStack;

/**
 * Created by Lead on 28-9-2015.
 */
public class DjPickaxe extends ItemPickaxe {
    public DjPickaxe() {
        super(MyItems.whishAlloy);
        this.setUnlocalizedName("djpickaxe");
        this.setTextureName(Reference.MODID + ":" + "djpickaxe");
        this.setCreativeTab(MyTab.CreaTab);
    }
}
