package trinsdar.ic2c_extras.blocks;

import ic2.core.block.base.BlockMultiID;
import ic2.core.block.base.tile.TileEntityBlock;
import ic2.core.platform.textures.Ic2Icons;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import trinsdar.ic2c_extras.Ic2cExtras;
import trinsdar.ic2c_extras.tileentity.TileEntityAdvancedSteamTurbine;
import trinsdar.ic2c_extras.util.RegistryBlock;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BlockIc2cEGenerator extends BlockMultiID {
    public BlockIc2cEGenerator(String blockName)
    {
        super(Material.IRON);
        this.setHardness(4.0F);
        this.setResistance(20.0F);
        this.setSoundType(SoundType.METAL);
        this.setCreativeTab(Ic2cExtras.creativeTab);
        this.setRegistryName(Ic2cExtras.MODID, blockName);
        this.setUnlocalizedName(Ic2cExtras.MODID + "." + blockName);
    }

    public List<Integer> getValidMetas() {
        return Arrays.asList(0);
    }

    @Override
    public TileEntityBlock createNewTileEntity(World worldIn, int meta)
    {
        if (this == RegistryBlock.advancedSteamTurbine) {
            return new TileEntityAdvancedSteamTurbine();
        }else {
            return new TileEntityBlock();
        }
    }

    @SideOnly(Side.CLIENT)
    @Override
    public TextureAtlasSprite[] getIconSheet(int meta)
    {
        if (this == RegistryBlock.advancedSteamTurbine){
            return Ic2Icons.getTextures("advancedsteamturbine");
        }else if (this == RegistryBlock.solidFuelFirebox){
            return Ic2Icons.getTextures("solidfuelfirebox");
        }else if (this == RegistryBlock.liquidFuelFirebox){
            return Ic2Icons.getTextures("liquidfuelfirebox");
        }else if (this == RegistryBlock.electricHeater){
            return Ic2Icons.getTextures("electricheater");
        }else{
            return Ic2Icons.getTextures("advancedsteamturbine");
        }
    }
    @Override
    public int getMaxSheetSize(int meta)
    {
        return 1;
    }

    @Override
    public List<IBlockState> getValidStateList()
    {
        IBlockState def = getDefaultState();
        List<IBlockState> states = new ArrayList<IBlockState>();
        for(EnumFacing side : EnumFacing.VALUES)
        {
            states.add(def.withProperty(getMetadataProperty(), 0).withProperty(allFacings, side).withProperty(active, false));
            states.add(def.withProperty(getMetadataProperty(), 0).withProperty(allFacings, side).withProperty(active, true));
        }
        return states;
    }

    @Override
    public List<IBlockState> getValidStates()
    {
        return getBlockState().getValidStates();
    }
}
