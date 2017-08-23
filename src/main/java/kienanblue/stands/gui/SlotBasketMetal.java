package kienanblue.stands.gui;

import net.minecraft.init.Items;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

/**
 * Created by Kienan on 23/08/2017.
 */
public class SlotBasketMetal extends Slot
{
    public SlotBasketMetal(IInventory inventory, int index, int x, int y)
    {
        super(inventory, index, x, y);
    }
    
    @Override
    public boolean isItemValid(ItemStack stack)
    {
        return (stack.getItem() == Items.MUSHROOM_STEW || stack.getItem() == Items.RABBIT_STEW) || stack.getItem() == Items.BEETROOT_SOUP || stack.getItem() == Items.BUCKET
                || stack.getItem() == Items.WATER_BUCKET || stack.getItem() == Items.LAVA_BUCKET || stack.getItem() == Items.MILK_BUCKET;
    }
}
