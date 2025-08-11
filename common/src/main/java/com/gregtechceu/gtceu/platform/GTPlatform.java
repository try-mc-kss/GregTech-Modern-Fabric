package com.gregtechceu.gtceu.platform;

import dev.architectury.injectables.annotations.ExpectPlatform;
import net.minecraft.world.item.CreativeModeTab;

/**
 * 平台抽象接口，用于处理不同平台的特定逻辑
 */
public class GTPlatform {
    
    @ExpectPlatform
    public static boolean isFabric() {
        throw new AssertionError();
    }
    
    @ExpectPlatform
    public static boolean isForge() {
        throw new AssertionError();
    }
    
    @ExpectPlatform
    public static CreativeModeTab.Builder newCreativeTabBuilder() {
        throw new AssertionError();
    }
}