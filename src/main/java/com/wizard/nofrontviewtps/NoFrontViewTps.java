package com.wizard.nofrontviewtps;

import net.minecraft.client.CameraType;
import net.minecraft.client.Minecraft;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod(NoFrontViewTps.MODID)
public class NoFrontViewTps {
    public static final String MODID = "nofrontviewtps";

    public NoFrontViewTps() {
    }

    @Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.FORGE, value = Dist.CLIENT)
    public static class ClientEvents {
        @SubscribeEvent
        public static void onClientTick(TickEvent.ClientTickEvent event) {
            if (event.phase != TickEvent.Phase.END) return;
//if player is in third person front view, it will automatically switch to first person view
            Minecraft mc = Minecraft.getInstance();
            if (mc.options.getCameraType() == CameraType.THIRD_PERSON_FRONT) {
                mc.options.setCameraType(CameraType.FIRST_PERSON);
            }
        }
    }
}