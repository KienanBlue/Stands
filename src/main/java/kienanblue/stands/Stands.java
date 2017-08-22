package kienanblue.stands;

import kienanblue.stands.proxy.CommonProxy;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

/**
 * Created by Kienan on 11/08/2017.
 */
@Mod(modid = Stands.MODID, name = Stands.NAME, version = Stands.VERSION, dependencies = Stands.DEPENDENCIES, acceptedMinecraftVersions = Stands.MINECRAFT_VERSIONS)
public class Stands
{
    public static final String MODID = "stands";
    public static final String NAME = "Stands";
    public static final String VERSION = "0.0.0-dev";
    public static final String DEPENDENCIES = "required-after:forge@[14.22.0.2444,)";
    public static final String MINECRAFT_VERSIONS = "[1.12.1]";
    
    @SidedProxy(clientSide = "kienanblue.stands.proxy.ClientProxy", serverSide = "kienanblue.stands.proxy.ServerProxy", modId = Stands.MODID)
    public static CommonProxy proxy;
    
    @Mod.Instance
    public static Stands instance;
    
    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent e)
    {
        proxy.preInit(e);
    }
    
    @Mod.EventHandler
    public void init(FMLInitializationEvent e)
    {
        proxy.init(e);
    }
    
    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent e)
    {
        proxy.postInit(e);
    }
}
