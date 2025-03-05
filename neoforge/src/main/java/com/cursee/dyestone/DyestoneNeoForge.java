package com.cursee.dyestone;

import com.cursee.dyestone.core.CommonConfigValues;
import com.cursee.dyestone.core.NeoForgeCommonConfigHandler;
import com.cursee.dyestone.core.registry.RegistryNeoForge;
import io.netty.buffer.ByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.entity.EntityJoinLevelEvent;
import net.neoforged.neoforge.network.PacketDistributor;
import net.neoforged.neoforge.network.event.RegisterPayloadHandlersEvent;
import net.neoforged.neoforge.network.handling.DirectionalPayloadHandler;
import net.neoforged.neoforge.network.handling.IPayloadContext;
import net.neoforged.neoforge.network.registration.PayloadRegistrar;

import java.util.function.Consumer;

@Mod(Constants.MOD_ID)
public class DyestoneNeoForge {

    public static IEventBus EVENT_BUS = null;

    public DyestoneNeoForge(IEventBus modEventBus) {
        Dyestone.init();
        DyestoneNeoForge.EVENT_BUS = modEventBus;
        RegistryNeoForge.register(DyestoneNeoForge.EVENT_BUS);
        NeoForgeCommonConfigHandler.onLoad();
        NeoForge.EVENT_BUS.addListener((Consumer<EntityJoinLevelEvent>) event -> {
            if (!(event.getEntity() instanceof ServerPlayer serverPlayer)) return;
            PacketDistributor.sendToPlayer(serverPlayer, new ConfigSyncS2CPacket(CommonConfigValues.all_dyestone_connects));
        });
    }

    public record ConfigSyncS2CPacket(boolean all_dyestone_connects) implements CustomPacketPayload {

        public static final CustomPacketPayload.Type<ConfigSyncS2CPacket> TYPE = new CustomPacketPayload.Type<>(ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "config_sync"));

        public static final StreamCodec<ByteBuf, ConfigSyncS2CPacket> STREAM_CODEC = StreamCodec.composite(
                ByteBufCodecs.BOOL,
                ConfigSyncS2CPacket::all_dyestone_connects,
                ConfigSyncS2CPacket::new
        );

        @Override
        public Type<? extends CustomPacketPayload> type() {
            return TYPE;
        }
    }

    public static void handleConfigSyncOnMain(final ConfigSyncS2CPacket packet, final IPayloadContext context) {
        // no-op
    }

    @EventBusSubscriber(modid = Constants.MOD_ID, bus = EventBusSubscriber.Bus.MOD)
    public static class CommonModBusEvents {

        @SubscribeEvent
        public static void onRegisterPayloadHandlers(final RegisterPayloadHandlersEvent event) {
            final PayloadRegistrar registrar = event.registrar("1");
            registrar.<ConfigSyncS2CPacket>playBidirectional(
                    ConfigSyncS2CPacket.TYPE,
                    ConfigSyncS2CPacket.STREAM_CODEC,
                    new DirectionalPayloadHandler<>(
                            DyestoneClientNeoForge::handleConfigSyncOnMain,
                            DyestoneNeoForge::handleConfigSyncOnMain
                    )
            );
        }
    }
}