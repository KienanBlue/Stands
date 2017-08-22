package kienanblue.stands.proxy;

import kienanblue.stands.Stands;
import kienanblue.stands.blocks.ModBlocks;
import kienanblue.stands.gui.GuiHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;

/**
 * Created by Kienan on 11/08/2017.
 */
public class CommonProxy
{
    public void preInit(FMLPreInitializationEvent e)
    {
        ModBlocks.register();
    
        NetworkRegistry.INSTANCE.registerGuiHandler(Stands.instance, new GuiHandler());
    }
    
    public void init(FMLInitializationEvent e)
    {
    
    }
    
    public void postInit(FMLPostInitializationEvent e)
    {
    
    }
}
