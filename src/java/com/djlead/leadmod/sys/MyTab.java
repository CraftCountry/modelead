package com.djlead.leadmod.sys;

import com.djlead.leadmod.Reference;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

/** Creative Tab Creation
 * Created by Lead on 22-9-2015.
 */
public class MyTab {
    public static final CreativeTabs CreaTab = new CreativeTabs(Reference.MODID) {

        @Override
        public Item getTabIconItem() {
            return MyItems.impossibrium;
        }

        @Override
            public String getTranslatedTabLabel() {
            return Reference.MODNAME;
        }
    };
}
