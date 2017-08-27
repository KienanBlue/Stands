package kienanblue.stands.util;

import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.block.model.BakedQuad;
import net.minecraft.client.renderer.block.model.IBakedModel;
import net.minecraft.client.renderer.block.model.ItemCameraTransforms;
import net.minecraft.client.renderer.block.model.ItemOverrideList;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.client.model.ModelLoaderRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nullable;
import java.util.List;

/**
 * Created by Kienan on 27/08/2017.
 */
@SideOnly(Side.CLIENT)
public class ModModelRegistry extends ModelLoaderRegistry implements IBakedModel
{
    @Override
    public ItemCameraTransforms getItemCameraTransforms()
    {
        return null;
    }
    
    @Override
    public List<BakedQuad> getQuads(@Nullable IBlockState state, @Nullable EnumFacing side, long rand)
    {
        return null;
    }
    
    @Override
    public boolean isAmbientOcclusion()
    {
        return false;
    }
    
    @Override
    public boolean isGui3d()
    {
        return false;
    }
    
    @Override
    public boolean isBuiltInRenderer()
    {
        return false;
    }
    
    @Override
    public TextureAtlasSprite getParticleTexture()
    {
        return null;
    }
    
    @Override
    public ItemOverrideList getOverrides()
    {
        return null;
    }
}
