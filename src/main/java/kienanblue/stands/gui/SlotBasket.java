package kienanblue.stands.gui;

import kienanblue.stands.blocks.TileEntityBasket;
import net.minecraft.init.Items;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;

/**
 * Created by Kienan on 23/08/2017.
 */
public class SlotBasket extends Slot
{
    public SlotBasket(IInventory inventory, int index, int x, int y)
    {
        super(inventory, index, x, y);
    }
    
    @Override
    public boolean isItemValid(ItemStack stack)
    {
        if(stack.getItem() instanceof ItemFood && !(stack.getItem() == Items.MUSHROOM_STEW || stack.getItem() == Items.RABBIT_STEW || stack.getItem() == Items.BEETROOT_SOUP)) return true;
        return false;
    }
    
    
}
