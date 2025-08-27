package com.gregtechceu.gtceu.data.recipe.misc;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.gregtechceu.gtceu.api.data.chemical.material.Material;
import com.gregtechceu.gtceu.api.data.chemical.material.properties.PropertyKey;
import com.gregtechceu.gtceu.api.registry.GTRegistries;

import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.RecipeSerializer;

import javax.annotation.Nullable;
import javax.annotation.Nonnull;
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
        String RecipeType = "packing";
        for (Material material : GTRegistries.MATERIALS) {
            // Check if material has ingot property
            if (material.hasProperty(PropertyKey.INGOT) && material.getName() != null && !material.getName().isEmpty()) {
                // Generate pressing recipe for this material
                provider.accept(new FinishedRecipe() {
                    @Override
                    public void serializeRecipeData(@Nonnull JsonObject json) {
                        // Set recipe type
                        json.addProperty("type", "create:" + RecipeType);
                        
                        // Add ingredients - 3 ingots + plate mold
                        JsonArray ingredients = new JsonArray();
                        JsonObject ingotIngredient = new JsonObject();
                        ingotIngredient.addProperty("tag", "c:" + material.getName() + "_ingots");
                        ingotIngredient.addProperty("count", 3);
                        ingredients.add(ingotIngredient);
                        
                        // 添加板模具作为第四个输入
                        JsonObject moldIngredient = new JsonObject();
                        moldIngredient.addProperty("item", "gtceu:plate_mold");
                        ingredients.add(moldIngredient);
                        
                        json.add("ingredients", ingredients);
                        // Add results - 2 plates
                        JsonArray results = new JsonArray();
                        JsonObject result = new JsonObject();
                        result.addProperty("item", "gtceu:" + material.getName() + "_plate");
                        result.addProperty("count", 2);
                        results.add(result);
                        json.add("results", results);
                    }

                    @Override
                    public ResourceLocation getId() {
                        return new ResourceLocation("create", RecipeType + "/" + material.getName() + "_ingot_to_plate");
                    }

                    @Override
                    public RecipeSerializer<?> getType() {
                        return RecipeSerializer.SHAPELESS_RECIPE;
                    }

                    @Nullable
                    @Override
                    public JsonObject serializeAdvancement() {
                        return null;
                    }

                    @Nullable
                    @Override
                    public ResourceLocation getAdvancementId() {
                        return null;
                    }
                });
            }
        }
    }
}