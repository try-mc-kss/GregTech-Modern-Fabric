package com.gregtechceu.gtceu.platform.fabric;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.world.item.CreativeModeTab;
import net.fabricmc.loader.api.FabricLoader;

/**
 * Fabric平台实现
 */
public class GTPlatformImpl {
    public static boolean isFabric() {
        return true;
    }
    
    public static boolean isForge() {
        return false;
    }
    
    public static CreativeModeTab.Builder newCreativeTabBuilder() {
        // Fabric使用不同的方式处理创造模式物品栏
        return FabricItemGroup.builder();
    }
}