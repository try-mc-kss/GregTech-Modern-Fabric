package com.gregtechceu.gtceu.data.recipe.misc;

import com.gregtechceu.gtceu.api.data.chemical.material.Material;
import com.gregtechceu.gtceu.api.data.chemical.material.info.MaterialFlags;
import com.gregtechceu.gtceu.api.data.chemical.material.properties.PropertyKey;
import com.gregtechceu.gtceu.api.registry.GTRegistries;
import com.gregtechceu.gtceu.api.recipe.GTRecipeAddon;

import net.minecraft.data.recipes.FinishedRecipe;

import java.util.function.Consumer;

public class CreateRecipeAddon {

    public static void init(Consumer<FinishedRecipe> provider) {
        registerPressingRecipes(provider);
    }
    
    /**
     * Registers pressing recipes for ingots to plates for all materials that support it
     * @param provider recipe provider
     */
    public static void registerPressingRecipes(Consumer<FinishedRecipe> provider) {
        for (Material material : GTRegistries.MATERIALS) {
            // Check if material has ingot property and can generate plates
            if (material.hasProperty(PropertyKey.INGOT) && material.hasFlag(MaterialFlags.GENERATE_PLATE) && material.getName() != null && !material.getName().isEmpty()) {
                // Generate pressing recipe for this material
                provider.accept(new GTRecipeAddon("create", "pressing", 1, "gtceu", material, "ingot", 1, "gtceu", material, "plate"));
                provider.accept(new GTRecipeAddon("createaddition", "rolling", 1, "gtceu", material, "ingot", 2, "gtceu", material, "rod"));
            }
        }
    }
}