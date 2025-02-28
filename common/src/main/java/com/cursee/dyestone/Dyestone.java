package com.cursee.dyestone;

import net.minecraft.resources.ResourceLocation;

public class Dyestone {

    public static void init() {}

    public static ResourceLocation identifier(String value) {
        return ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, value);
    }
}