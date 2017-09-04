package kienanblue.stands.blocks;

import kienanblue.stands.Stands;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.ItemStackHelper;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.NonNullList;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.ItemStackHandler;

import javax.annotation.Nullable;

/**
 * Created by Kienan on 20/08/2017.
 */
public class TileEntityBasket extends TileEntity implements IInventory
{
    private NonNullList<ItemStack> content = NonNullList.withSize(6, ItemStack.EMPTY);
    private String customName;
    
    public TileEntityBasket()
    {
    
    }
    
    @Override
    public int getSizeInventory()
    {
        return 6;
    }
    
    @Override
    public boolean isEmpty()
    {
        for(ItemStack stack : content)
        {
            if(!stack.isEmpty())
            {
                return false;
            }
        }
        return this.isEmpty();
    }
    
    @Override
    public ItemStack getStackInSlot(int index)
    {
        return this.content.get(index);
    }
    
    @Override
    public ItemStack decrStackSize(int index, int count)
    {
        return ItemStackHelper.getAndSplit(this.content, index, count);
    }
    
    @Override
    public ItemStack removeStackFromSlot(int index)
    {
        return ItemStackHelper.getAndRemove(this.content, index);
    }
    
    @Override
    public void setInventorySlotContents(int index, ItemStack stack)
    {
    
    }
    
    @Override
    public int getInventoryStackLimit()
    {
        return 64;
    }
    
    @Override
    public boolean isUsableByPlayer(EntityPlayer player)
    {
        return true;
    }
    
    @Override
    public void openInventory(EntityPlayer player)
    {
    
    }
    
    @Override
    public void closeInventory(EntityPlayer player)
    {
    
    }
    
    @Override
    public boolean isItemValidForSlot(int index, ItemStack stack)
    {
        if(stack.getItem() instanceof ItemFood) return true;
        return false;
    }
    
    @Override
    public int getField(int id)
    {
        return 0;
    }
    
    @Override
    public void setField(int id, int value)
    {
    
    }
    
    @Override
    public int getFieldCount()
    {
        return 0;
    }
    
    @Override
    public void clear()
    {
    
    }
    
    @Override
    public String getName()
    {
        if(this.hasCustomName()) return this.customName;
        return I18n.format("gui."+Stands.MODID+".basket");
    }
    
    @Override
    public boolean hasCustomName()
    {
        if(this.customName != null && !this.customName.isEmpty())
        {
            return true;
        }
        return false;
    }
    
    @Override
    public void readFromNBT(NBTTagCompound compound)
    {
        super.readFromNBT(compound);
        
        this.content = NonNullList.withSize(this.getSizeInventory(), ItemStack.EMPTY);
        ItemStackHelper.loadAllItems(compound, this.content);
        
        if(compound.hasKey("CustomName", 8))
        {
            this.customName = compound.getString("CustomName");
        }
    }
    
    @Override
    public NBTTagCompound writeToNBT(NBTTagCompound compound)
    {
        super.writeToNBT(compound);
        
        ItemStackHelper.saveAllItems(compound, this.content);
        
        if(this.hasCustomName())
        {
            compound.setString("CustomName", this.customName);
        }
        
        return compound;
    }
    
    @SuppressWarnings("unchecked")
    @Override
    public <T> T getCapability(Capability<T> capability, @Nullable EnumFacing facing)
    {
        return super.getCapability(capability, facing);
    }
}
