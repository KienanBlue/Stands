package kienanblue.stands.util;

import net.minecraft.client.resources.IResource;
import net.minecraft.client.resources.IResourceManager;
import net.minecraft.client.resources.SimpleReloadableResourceManager;
import net.minecraft.client.resources.data.MetadataSerializer;
import net.minecraft.util.ResourceLocation;

import java.io.IOException;
import java.util.List;
import java.util.Set;

/**
 * Created by Kienan on 26/08/2017.
 */
public class ResManager extends SimpleReloadableResourceManager implements IResourceManager
{
    public ResManager(MetadataSerializer metaSerializer)
    {
        super(metaSerializer);
    }
    
    @Override
    public Set<String> getResourceDomains()
    {
        return null;
    }
    
    @Override
    public IResource getResource(ResourceLocation location) throws IOException
    {
        return null;
    }
    
    @Override
    public List<IResource> getAllResources(ResourceLocation location) throws IOException
    {
        return null;
    }
}
