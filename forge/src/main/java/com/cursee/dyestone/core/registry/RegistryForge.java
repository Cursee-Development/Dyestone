package com.cursee.dyestone.core.registry;

import com.cursee.dyestone.DyestoneForge;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.RegisterEvent;

import java.util.LinkedHashSet;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class RegistryForge {

    public static void register(IEventBus modEventBus) {
    }

    private static <T> void bind(ResourceKey<Registry<T>> registry, Consumer<BiConsumer<T, ResourceLocation>> source) {
        DyestoneForge.EVENT_BUS.addListener((RegisterEvent event) -> {
            if (registry.equals(event.getRegistryKey())) {
                source.accept((t, rl) -> event.register(registry, rl, () -> t));
            }
        });
    }

    private static final Set<Item> CREATIVE_MODE_TAB_ITEMS = new LinkedHashSet<>();
    private static void bindForItems(Consumer<BiConsumer<Item, ResourceLocation>> source) {
        DyestoneForge.EVENT_BUS.addListener((RegisterEvent event) -> {
            if (event.getRegistryKey().equals(Registries.ITEM)) {
                source.accept((t, rl) -> {
                    CREATIVE_MODE_TAB_ITEMS.add(t);
                    event.register(Registries.ITEM, rl, () -> t);
                });
            }
        });
    }
}
