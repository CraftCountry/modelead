package com.djlead.leadmod.items;

import com.djlead.leadmod.Reference;
import com.djlead.leadmod.sys.MyItems;
import com.djlead.leadmod.sys.MyTab;
import net.minecraft.item.ItemPickaxe;

/**
 * Created by Lead on 28-9-2015.
 */
public class WhishPickaxe extends ItemPickaxe {
    public WhishPickaxe() {
        super(MyItems.whishAlloy);
        this.setUnlocalizedName("djpickaxe");
        this.setTextureName(Reference.MODID + ":" + "djpickaxe");
        this.setCreativeTab(MyTab.CreaTab);
     }
}
