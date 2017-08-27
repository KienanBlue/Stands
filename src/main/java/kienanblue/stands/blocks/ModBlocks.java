package kienanblue.stands.blocks;

import kienanblue.stands.Stands;
import kienanblue.stands.util.GenerateBlockStateJson;
import kienanblue.stands.util.ReadOriginalBlockModelJson;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.oredict.OreIngredient;
import net.minecraftforge.registries.IForgeRegistry;

import java.nio.file.Files;
import java.nio.file.attribute.FileAttribute;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Kienan on 11/08/2017.
 */
@Mod.EventBusSubscriber
public class ModBlocks
{
    public static ArrayList<Block> blocks = new ArrayList<>();
    
    public static GenerateBlockStateJson wood_json;
    
    public static Block wood_basket, oak_basket, spruce_basket, birch_basket, jungle_basket, acacia_basket, dark_oak_basket, metal_basket;
    
    public static void register()
    {
        Arrays.asList(new OreIngredient("plankWood").getMatchingStacks()).forEach(itemStack ->
        {
            Block block = Block.getBlockFromItem(itemStack.getItem());
            String mod = block.getRegistryName().getResourceDomain();
            String blockName = String.valueOf(block.getRegistryName()).substring(mod.length()+1);
            String id = String.valueOf(block.getRegistryName()).replace(':', '_') ;
            int meta = itemStack.getMetadata();
            String basketId = Stands.MODID+':'+id+"_basket_"+meta;
            blocks.add(wood_basket = new BlockBasketWood(basketId).setUnlocalizedName("basket_wood"));
            wood_json = new GenerateBlockStateJson("resourcepacks/dev/assets/"+Stands.MODID+"/blockstates/", basketId.substring(Stands.MODID.length()+1));
        });
        //blocks.add(metal_basket = new BlockBasketMetal("metal_basket"));
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
            ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(blocks.get(i)), 0, new ModelResourceLocation(Stands.MODID+":basket"));
        }
    }
}
