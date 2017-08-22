package kienanblue.stands.gui;

import kienanblue.stands.blocks.ModBlocks;
import kienanblue.stands.blocks.TileEntityBasket;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.init.Items;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraftforge.items.ItemStackHandler;
import net.minecraftforge.items.SlotItemHandler;

/**
 * Created by Kienan on 20/08/2017.
 */
public class ContainerBasket extends Container
{
    public ContainerBasket(InventoryPlayer inv, TileEntityBasket basket)
    {
        if(basket.getBlockType() == ModBlocks.metal_basket)
        {
            addSlotToContainer(new SlotBasketMetal(basket, 0, 1, 1));
        }
        addSlotToContainer(new SlotBasket(basket, 0, 1, 1));
    }
    
    @Override
    public ItemStack transferStackInSlot(EntityPlayer playerIn, int index)
    {
        return ItemStack.EMPTY;
    }
    
    @Override
    public boolean canInteractWith(EntityPlayer playerIn)
    {
        return true;
    }
    
    private class SlotBasket extends Slot
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
    
    private class SlotBasketMetal extends Slot
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
}
