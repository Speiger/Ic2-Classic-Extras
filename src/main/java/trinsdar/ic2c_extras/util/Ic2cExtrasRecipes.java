package trinsdar.ic2c_extras.util;

import ic2.api.classic.recipe.ClassicRecipes;
import ic2.api.classic.recipe.crafting.ICraftingRecipeList;
import ic2.api.classic.recipe.machine.MachineOutput;
import ic2.core.item.recipe.entry.RecipeInputItemStack;
import ic2.core.item.recipe.entry.RecipeInputOreDict;
import ic2.core.platform.registry.Ic2Items;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import trinsdar.ic2c_extras.tileentity.TileEntityOreWashingPlant;
import trinsdar.ic2c_extras.tileentity.TileEntityThermalCentrifuge;

import java.util.Arrays;

import static ic2.api.classic.recipe.ClassicRecipes.macerator;

public class Ic2cExtrasRecipes {
    public static void init(){
        initShapedRecipes();
        initReplaceRecipes();
        initReplaceMaceratorRecipes();
        initOreWashingPlantRecipes();
        initThermalCentrifugeRecipes();
    }

    static ICraftingRecipeList recipes = ClassicRecipes.advCrafting;
    public static void initShapedRecipes(){
        recipes.addRecipe(new ItemStack(RegistryBlock.advancedSteamTurbine, 1),
                " S ", "STS", " S ", 'S', Ic2Items.basicTurbine,'T', Ic2Items.transformerMV);

    }
    public static void initReplaceRecipes(){
    }
    public static void initReplaceMaceratorRecipes(){
        macerator.removeRecipe(new RecipeInputOreDict("oreIron"));
        macerator.addRecipe(new RecipeInputOreDict("oreIron"), new ItemStack(RegistryItem.ironCrushedOre,2), 0.7F, "ironOre");
        macerator.removeRecipe(new RecipeInputOreDict("oreGold"));
        macerator.addRecipe(new RecipeInputOreDict("oreGold"), new ItemStack(RegistryItem.goldCrushedOre,2), 1.0F, "goldOre");
        macerator.removeRecipe(new RecipeInputOreDict("oreCopper"));
        macerator.addRecipe(new RecipeInputOreDict("oreCopper"), new ItemStack(RegistryItem.copperCrushedOre,2), 0.3F, "copperOre");
        macerator.removeRecipe(new RecipeInputOreDict("oreTin"));
        macerator.addRecipe(new RecipeInputOreDict("oreTin"), new ItemStack(RegistryItem.tinCrushedOre,2), 0.4F, "tinOre");
        macerator.removeRecipe(new RecipeInputOreDict("oreSilver"));
        macerator.addRecipe(new RecipeInputOreDict("oreSilver"), new ItemStack(RegistryItem.silverCrushedOre,2), 0.8F, "silverOre");
        macerator.removeRecipe(new RecipeInputOreDict("oreLead"));
        macerator.addRecipe(new RecipeInputOreDict("oreLead"), new ItemStack(RegistryItem.leadCrushedOre,2), 0.8F, "leadOre");
        macerator.removeRecipe(new RecipeInputOreDict("oreUranium"));
        macerator.addRecipe(new RecipeInputOreDict("oreUranium"), new ItemStack(RegistryItem.uraniumCrushedOre,2), 1.0F, "uraniumOre");
    }
    public static void initOreWashingPlantRecipes(){
        TileEntityOreWashingPlant.addRecipe((new RecipeInputOreDict("crushedIron", 1)), new MachineOutput(null, Arrays.asList(new ItemStack(RegistryItem.ironPurifiedCrushedOre, 1), new ItemStack(RegistryItem.ironTinyDust, 2), new ItemStack(RegistryItem.stoneDust, 1))), "crushedIronOre");
        TileEntityOreWashingPlant.addRecipe((new RecipeInputOreDict("crushedGold", 1)), new MachineOutput(null, Arrays.asList(new ItemStack(RegistryItem.goldPurifiedCrushedOre, 1), new ItemStack(RegistryItem.goldTinyDust, 2), new ItemStack(RegistryItem.stoneDust, 1))), "crushedGoldOre");
        TileEntityOreWashingPlant.addRecipe((new RecipeInputOreDict("crushedCopper", 1)), new MachineOutput(null, Arrays.asList(new ItemStack(RegistryItem.copperPurifiedCrushedOre, 1), new ItemStack(RegistryItem.copperTinyDust, 2), new ItemStack(RegistryItem.stoneDust, 1))), "crushedCopperOre");
        TileEntityOreWashingPlant.addRecipe((new RecipeInputOreDict("crushedTin", 1)), new MachineOutput(null, Arrays.asList(new ItemStack(RegistryItem.tinPurifiedCrushedOre, 1), new ItemStack(RegistryItem.tinTinyDust, 2, 3), new ItemStack(RegistryItem.stoneDust, 1))), "crushedTinOre");
        TileEntityOreWashingPlant.addRecipe((new RecipeInputOreDict("crushedSilver", 1)), new MachineOutput(null, Arrays.asList(new ItemStack(RegistryItem.silverPurifiedCrushedOre, 1), new ItemStack(RegistryItem.silverTinyDust, 2), new ItemStack(RegistryItem.stoneDust, 1))), "crushedSilverOre");
        TileEntityOreWashingPlant.addRecipe((new RecipeInputOreDict("crushedLead", 1)), new MachineOutput(null, Arrays.asList(new ItemStack(RegistryItem.leadPurifiedCrushedOre, 1), new ItemStack(RegistryItem.leadTinyDust, 3), new ItemStack(RegistryItem.stoneDust, 1))), "crushedLeadOre");
        TileEntityOreWashingPlant.addRecipe((new RecipeInputOreDict("crushedUranium", 1)), new MachineOutput(null, Arrays.asList(new ItemStack(RegistryItem.uraniumPurifiedCrushedOre, 1), new ItemStack(RegistryItem.uranium235TinyDust, 1), new ItemStack(RegistryItem.stoneDust, 1))), "crushedUraniumOre");
        TileEntityOreWashingPlant.addRecipe((new RecipeInputItemStack(new ItemStack(Blocks.GRAVEL, 1))), new MachineOutput(null, Arrays.asList(new ItemStack(RegistryItem.stoneDust, 1))), "stoneDust");
    }
    public static void initThermalCentrifugeRecipes(){
        TileEntityThermalCentrifuge.addRecipe((new RecipeInputOreDict("crushedPurifiedIron", 1)), new MachineOutput(null, Arrays.asList((Ic2Items.ironDust), new ItemStack(RegistryItem.goldTinyDust, 1))), "purifiedCrushedIronOre");
        TileEntityThermalCentrifuge.addRecipe((new RecipeInputOreDict("crushedPurifiedGold", 1)), new MachineOutput(null, Arrays.asList((Ic2Items.goldDust), new ItemStack(RegistryItem.silverTinyDust, 1))), "purifiedCrushedGoldOre");
        TileEntityThermalCentrifuge.addRecipe((new RecipeInputOreDict("crushedPurifiedCopper", 1)), new MachineOutput(null, Arrays.asList((Ic2Items.copperDust), new ItemStack(RegistryItem.tinTinyDust, 1))), "purifiedCrushedCopperOre");
        TileEntityThermalCentrifuge.addRecipe((new RecipeInputOreDict("crushedPurifiedTin", 1)), new MachineOutput(null, Arrays.asList((Ic2Items.tinDust), new ItemStack(RegistryItem.ironTinyDust, 1))), "purifiedCrushedTinOre");
        TileEntityThermalCentrifuge.addRecipe((new RecipeInputOreDict("crushedPurifiedSilver", 1)), new MachineOutput(null, Arrays.asList((Ic2Items.silverDust), new ItemStack(RegistryItem.leadTinyDust, 1))), "purifiedCrushedSilverOre");
        TileEntityThermalCentrifuge.addRecipe((new RecipeInputOreDict("crushedPurifiedLead", 1)), new MachineOutput(null, Arrays.asList(new ItemStack(RegistryItem.leadDust, 1), new ItemStack(RegistryItem.copperTinyDust, 1))), "purifiedCrushedLeadOre");
        TileEntityThermalCentrifuge.addRecipe((new RecipeInputOreDict("crushedPurifiedUranium", 1)), new MachineOutput(null, Arrays.asList(new ItemStack(RegistryItem.uranium238, 6), new ItemStack(RegistryItem.uranium235TinyDust, 1))), "purifiedCrushedUraniumOre");
        TileEntityThermalCentrifuge.addRecipe((new RecipeInputOreDict("crushedIron", 1)), new MachineOutput(null, Arrays.asList((Ic2Items.ironDust), new ItemStack(RegistryItem.goldTinyDust, 1), new ItemStack(RegistryItem.stoneDust, 1))), "crushedIronOre");
        TileEntityThermalCentrifuge.addRecipe((new RecipeInputOreDict("crushedGold", 1)), new MachineOutput(null, Arrays.asList((Ic2Items.goldDust), new ItemStack(RegistryItem.silverTinyDust, 1), new ItemStack(RegistryItem.stoneDust, 1))), "crushedGoldOre");
        TileEntityThermalCentrifuge.addRecipe((new RecipeInputOreDict("crushedCopper", 1)), new MachineOutput(null, Arrays.asList((Ic2Items.copperDust), new ItemStack(RegistryItem.tinTinyDust, 1), new ItemStack(RegistryItem.stoneDust, 1))), "crushedCopperOre");
        TileEntityThermalCentrifuge.addRecipe((new RecipeInputOreDict("crushedTin", 1)), new MachineOutput(null, Arrays.asList((Ic2Items.tinDust), new ItemStack(RegistryItem.ironTinyDust, 1), new ItemStack(RegistryItem.stoneDust, 1))), "crushedTinOre");
        TileEntityThermalCentrifuge.addRecipe((new RecipeInputOreDict("crushedSilver", 1)), new MachineOutput(null, Arrays.asList((Ic2Items.silverDust), new ItemStack(RegistryItem.stoneDust, 1))), "crushedSilverOre");
        TileEntityThermalCentrifuge.addRecipe((new RecipeInputOreDict("crushedLead", 1)), new MachineOutput(null, Arrays.asList(new ItemStack(RegistryItem.leadDust, 1), new ItemStack(RegistryItem.stoneDust, 1))), "crushedLeadOre");
        TileEntityThermalCentrifuge.addRecipe((new RecipeInputOreDict("crushedUranium", 1)), new MachineOutput(null, Arrays.asList(new ItemStack(RegistryItem.uranium238, 4), new ItemStack(RegistryItem.uranium235TinyDust, 1), new ItemStack(RegistryItem.stoneDust, 1))), "crushedUraniumOre");
    }
}
