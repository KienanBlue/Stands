package kienanblue.stands.blocks;

import kienanblue.stands.Stands;
import kienanblue.stands.gui.GuiHandler;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nullable;

/**
 * Created by Kienan on 11/08/2017.
 */
public class BlockBasket extends BlockContainer
{
    public static final PropertyBool EW = PropertyBool.create("x");
    public static final AxisAlignedBB BASKET_EW_AABB = new AxisAlignedBB(0.0625, 0.0, 0.125, 0.9375, 0.5, 0.875);
    public static final AxisAlignedBB BASKET_NS_AABB = new AxisAlignedBB(0.125, 0.0, 0.0625, 0.875, 0.5, 0.9375);
    
    public BlockBasket(String id, Material material)
    {
        super(material);
        setRegistryName(id);
        setLightOpacity(5);
        setDefaultState(this.blockState.getBaseState().withProperty(EW, false));
        setCreativeTab(CreativeTabs.DECORATIONS);
    }
    
    @Override
    public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos)
    {
        if(state == this.getDefaultState().withProperty(EW, true)) return BASKET_EW_AABB;
        return BASKET_NS_AABB;
    }
    
    @Override
    public int getMetaFromState(IBlockState state)
    {
        if(state == this.blockState.getBaseState().withProperty(EW, true)) return 1;
        return 0;
    }
    
    @Override
    public IBlockState getStateFromMeta(int meta)
    {
        if(meta == 1) return this.getDefaultState().withProperty(EW, true);
        return this.getDefaultState().withProperty(EW, false);
    }
    
    @Override
    protected BlockStateContainer createBlockState()
    {
        return new BlockStateContainer(this, EW);
    }
    
    @Override
    public IBlockState getStateForPlacement(World world, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer, EnumHand hand)
    {
        if(placer.getHorizontalFacing().getHorizontalIndex() == 1 || placer.getHorizontalFacing().getHorizontalIndex() == 3) return this.getDefaultState().withProperty(EW, true);
        return this.getDefaultState();
    }
    
    @Override
    public boolean isNormalCube(IBlockState state, IBlockAccess world, BlockPos pos)
    {
        return false;
    }
    
    @Override
    public boolean isFullBlock(IBlockState state)
    {
        return false;
    }
    
    @Override
    public boolean isFullCube(IBlockState state)
    {
        return false;
    }
    
    @Override
    public boolean isOpaqueCube(IBlockState state)
    {
        return false;
    }
    
    @Override
    public EnumBlockRenderType getRenderType(IBlockState state)
    {
        return EnumBlockRenderType.MODEL;
    }
    
    @Override
    public boolean doesSideBlockRendering(IBlockState state, IBlockAccess world, BlockPos pos, EnumFacing face)
    {
        return false;
    }
    
    @Override
    public boolean canPlaceTorchOnTop(IBlockState state, IBlockAccess world, BlockPos pos)
    {
        return false;
    }
    
    @Override
    public boolean hasTileEntity(IBlockState state)
    {
        return true;
    }
    
    @Override
    public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ)
    {
        playerIn.openGui(Stands.instance, GuiHandler.BASKET, worldIn, pos.getX(), pos.getY(), pos.getZ());
        return true;
    }
    
    @Nullable
    @Override
    public TileEntity createNewTileEntity(World worldIn, int meta)
    {
        return new TileEntityBasket();
    }
    
    @Override
    public ItemStack getPickBlock(IBlockState state, RayTraceResult target, World world, BlockPos pos, EntityPlayer player)
    {
        return new ItemStack(this.getDefaultState().getBlock());
    }
}
