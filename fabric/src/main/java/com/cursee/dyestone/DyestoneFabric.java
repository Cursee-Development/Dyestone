package com.cursee.dyestone;

import com.cursee.dyestone.core.registry.RegistryFabric;
import com.cursee.monolib.core.sailing.Sailing;
import net.fabricmc.api.ModInitializer;

public class DyestoneFabric implements ModInitializer {
    
    @Override
    public void onInitialize() {
        Dyestone.init();
        Sailing.register(Constants.MOD_ID, Constants.MOD_NAME, Constants.MOD_VERSION, Constants.MOD_PUBLISHER, Constants.MOD_URL);
        RegistryFabric.register();
    }
}
