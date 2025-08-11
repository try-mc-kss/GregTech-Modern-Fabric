package com.gregtechceu.gtceu.platform.forge;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraftforge.fml.loading.FMLLoader;

/**
 * Forge平台实现
 */
public class GTPlatformImpl {
    public static boolean isFabric() {
        return false;
    }
    
    public static boolean isForge() {
        return true;
    }
    
    public static CreativeModeTab.Builder newCreativeTabBuilder() {
        return CreativeModeTab.builder();
    }
}