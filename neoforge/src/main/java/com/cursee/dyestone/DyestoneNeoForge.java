package com.cursee.dyestone;

import com.cursee.dyestone.core.registry.RegistryNeoForge;
import com.cursee.monolib.core.sailing.Sailing;
import net.minecraft.world.level.gameevent.GameEvent;
import net.neoforged.bus.api.Event;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.level.BlockEvent;

import java.util.function.Consumer;

@Mod(Constants.MOD_ID)
public class DyestoneNeoForge {

    public static IEventBus EVENT_BUS = null;

    public DyestoneNeoForge(IEventBus modEventBus) {
        Dyestone.init();
        Sailing.register(Constants.MOD_ID, Constants.MOD_NAME, Constants.MOD_VERSION, Constants.MOD_PUBLISHER, Constants.MOD_URL);
        DyestoneNeoForge.EVENT_BUS = modEventBus;
        RegistryNeoForge.register(DyestoneNeoForge.EVENT_BUS);
    }
}