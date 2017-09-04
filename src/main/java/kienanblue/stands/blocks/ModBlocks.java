package kienanblue.stands.blocks;

import kienanblue.stands.Stands;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.registries.IForgeRegistry;

import java.util.ArrayList;

/**
 * Created by Kienan on 11/08/2017.
 */
@Mod.EventBusSubscriber
public class ModBlocks
{
    public static ArrayList<Block> blocks = new ArrayList<>();
    
    public static Block wood_basket, metal_basket;
    
    public static void register()
    {
        blocks.add(wood_basket = new BlockBasketWood("wood_basket"));
        blocks.add(metal_basket = new BlockBasketMetal("metal_basket"));
    }
    
    @SubscribeEvent
    public static void registerBlock(RegistryEvent.Register<Block> e)
    {
        IForgeRegistry<Block> registry = e.getRegistry();
        for(int i = 0; i < blocks.size(); i++)
        {
            if(blocks.get(i) instanceof BlockBasket)
            {
                GameRegistry.registerTileEntity(TileEntityBasket.class, Stands.MODID + ":basket");
            }
            registry.register(blocks.get(i));
            blocks.get(i).setUnlocalizedName(blocks.get(i).getRegistryName().toString().replace(':', '.'));
        }
    }
    
    @SubscribeEvent
    public static void registerItemBlock(RegistryEvent.Register<Item> e)
    {
        IForgeRegistry<Item> registry = e.getRegistry();
        for(int i = 0; i < blocks.size(); i++)
        {
            registry.register(new ItemBlock(blocks.get(i)).setRegistryName(String.valueOf(blocks.get(i).getRegistryName()).substring(Stands.MODID.length() + 1)));
        }
    }
    
    @SubscribeEvent
    @SideOnly(Side.CLIENT)
    public static void render(ModelRegistryEvent e)
    {
        for(int i = 0; i < blocks.size(); i++)
        {
            ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(blocks.get(i)), 0, new ModelResourceLocation(blocks.get(i).getRegistryName().toString()));
        }
    }
}
