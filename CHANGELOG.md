# ChangeLog

Version: 1.1.0-a

- add recipe addon for GTCEu.
- function name:GTRecipeAddon
- function arguments:GTRecipeAddon(String RecipeModId, @Nonnull String RecipeType, int InputAmount, String InputModId, Material InputMaterial, @Nonnull String InputType, int OutputAmount, String OutputModId, Material OutputMaterial, @Nonnull String OutputType)
- Among them, RecipeType, InputAmount, InputType, OutputAmount, and OutputType are required parameters.
- RecipeModId is the mod ID of the mod that added the recipe of that type.
- InputModId and OutputModId are mod IDs that contain input and output materials and types.
- InputMaterial and OutputMaterial are the materials of the input and output items.
- InputType and OutputType are the types of the input and output items.
