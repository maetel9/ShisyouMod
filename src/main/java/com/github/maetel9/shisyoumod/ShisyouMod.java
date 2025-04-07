package com.github.maetel9.shisyoumod;

import com.github.maetel9.shisyoumod.event.ShisyouModEvents;
import com.github.maetel9.shisyoumod.item.tool.ShisyouModItems;
import com.github.maetel9.shisyoumod.item.ShisyouModTabs;
import com.mojang.logging.LogUtils;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;


@Mod(ShisyouMod.MOD_ID)
public class ShisyouMod {
    public static final String MOD_ID = "shisyoumod";
    private static final Logger LOGGER = LogUtils.getLogger();


    public ShisyouMod() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        modEventBus.addListener(this::commonSetup);

        //アイテムレジストリをイベントバスに登録
        ShisyouModItems.register(modEventBus);
        //クリエイティブタブをイベントバスに登録
        ShisyouModTabs.register(modEventBus);
        //耐性付与のイベントをイベントバスに登録
        MinecraftForge.EVENT_BUS.register(ShisyouModEvents.class);

        MinecraftForge.EVENT_BUS.register(this);

        modEventBus.addListener(this::addCreative);

    }

    private void commonSetup(final FMLCommonSetupEvent event) {

    }

    private void addCreative(BuildCreativeModeTabContentsEvent event) {

    }

    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {
        LOGGER.info("HELLO from server starting");
    }

    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {

        }
    }
}
