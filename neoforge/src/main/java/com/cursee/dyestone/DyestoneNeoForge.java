package com.cursee.dyestone;

import com.cursee.dyestone.core.registry.RegistryNeoForge;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;

@Mod(Constants.MOD_ID)
public class DyestoneNeoForge {

    public static IEventBus EVENT_BUS = null;

    public DyestoneNeoForge(IEventBus modEventBus) {
        Dyestone.init();
        DyestoneNeoForge.EVENT_BUS = modEventBus;
        RegistryNeoForge.register(DyestoneNeoForge.EVENT_BUS);
    }
}