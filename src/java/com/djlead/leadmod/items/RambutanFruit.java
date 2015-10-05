package com.djlead.leadmod.items;

import com.djlead.leadmod.Reference;
import com.djlead.leadmod.sys.MyTab;
import net.minecraft.item.ItemFood;

/**
 * Created by Lead on 4-10-2015.
 */
public class RambutanFruit extends ItemFood {
        public RambutanFruit() {

            super(4, 0.3F, false);
            //  healing , saturation , wolve food
            //  ---------------------------------
            //  Apple 	                4 	0.3f
            //  Raw Porkchop or Beef 	3 	0.3f
            //  Bread 	                5 	0.6f
            //  Cooked Porkchop or Beef 8 	0.8f
            //  Golden Apple 	        4 	1.2f

            this.setUnlocalizedName("rambutanfruit");
            this.setTextureName(Reference.MODID + ":" + "rambutanfruit");
            this.setCreativeTab(MyTab.CreaTab);
         //   this.setAlwaysEdible();
        }
}
