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
        addSlotToContainer(new SlotBasket(basket, 0, 1, 1));
    
        for (int i = 0; i < 3; ++i)
        {
            for (int j = 0; j < 9; ++j)
            {
                this.addSlotToContainer(new Slot(inv, j + i * 9 + 9, 8 + j * 18, 84 + i * 18));
            }
        }
    
        for (int k = 0; k < 9; ++k)
        {
            this.addSlotToContainer(new Slot(inv, k, 8 + k * 18, 142));
        }
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
}
