package com.cursee.dyestone;

import net.fabricmc.api.ClientModInitializer;

public class DyestoneClientFabric implements ClientModInitializer {
    
    @Override
    public void onInitializeClient() {
        DyestoneClient.init();
    }
}
