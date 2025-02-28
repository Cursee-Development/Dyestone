package com.cursee.dyestone;

import com.cursee.dyestone.core.registry.RegistryForge;
import com.cursee.monolib.core.sailing.Sailing;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(Constants.MOD_ID)
public class DyestoneForge {

    public static IEventBus EVENT_BUS = null;
    
    public DyestoneForge(FMLJavaModLoadingContext context) {
        Dyestone.init();
        Sailing.register(Constants.MOD_ID, Constants.MOD_NAME, Constants.MOD_VERSION, Constants.MOD_PUBLISHER, Constants.MOD_URL);
        DyestoneForge.EVENT_BUS = context.getModEventBus();
        RegistryForge.register(DyestoneForge.EVENT_BUS);
    }
}