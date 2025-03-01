package com.cursee.dyestone.core.registry;

import com.cursee.dyestone.DyestoneNeoForge;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.RegisterEvent;

import java.util.LinkedHashSet;
import java.util.Set;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class RegistryNeoForge {

    public static void register(IEventBus modEventBus) {

        bind(Registries.BLOCK, consumer -> {
            ModBlocks.register(consumer);
        });
        bindForItems(ModItems::register);
        bind(Registries.CREATIVE_MODE_TAB, ModTabs::register);

    }

    private static <T> void bind(ResourceKey<Registry<T>> registry, Consumer<BiConsumer<T, ResourceLocation>> source) {
        DyestoneNeoForge.EVENT_BUS.addListener((RegisterEvent event) -> {
            if (registry.equals(event.getRegistryKey())) {
                source.accept((t, rl) -> event.register(registry, rl, () -> t));
            }
        });
    }

    private static final Set<Item> CREATIVE_MODE_TAB_ITEMS = new LinkedHashSet<>();
    private static void bindForItems(Consumer<BiConsumer<Item, ResourceLocation>> source) {
        DyestoneNeoForge.EVENT_BUS.addListener((RegisterEvent event) -> {
            if (event.getRegistryKey().equals(Registries.ITEM)) {
                source.accept((t, rl) -> {
                    CREATIVE_MODE_TAB_ITEMS.add(t);
                    event.register(Registries.ITEM, rl, () -> t);
                });
            }
        });
    }
}
