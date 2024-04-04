package net.akoto090.lotr.item;

import net.akoto090.lotr.LotrMod;
import net.akoto090.lotr.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

import java.awt.*;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, LotrMod.MOD_ID);

    public static final RegistryObject<CreativeModeTab> LOTR_TAB = CREATIVE_MODE_TABS.register("lotr_blocks_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModBlocks.MITHRIL_BLOCK.get()))
                    .title(Component.translatable("creativetab.lotr_blocks_tab")).displayItems((DisplayParameters, output) -> {
                        output.accept(ModBlocks.MITHRIL_BLOCK.get());
                        output.accept(ModBlocks.RAW_MITHRIL_BLOCK.get());
                        output.accept(ModBlocks.MITHRIL_ORE.get());
                        output.accept(ModBlocks.DEEPSLATE_MITHRIL_ORE.get());
                    }).build());
    public static final RegistryObject<CreativeModeTab> LOTR_TAB2 = CREATIVE_MODE_TABS.register("lotr_utilities_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModBlocks.MITHRIL_BLOCK.get()))
                    .title(Component.translatable("creativetab.lotr_utilities_tab")).displayItems((DisplayParameters, output) -> {
                    }).build());

    public static final RegistryObject<CreativeModeTab> LOTR_TAB3 = CREATIVE_MODE_TABS.register("lotr_decorations_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModBlocks.MITHRIL_BLOCK.get()))
                    .title(Component.translatable("creativetab.lotr_decorations_tab")).displayItems((DisplayParameters, output) -> {
                    }).build());
    public static final RegistryObject<CreativeModeTab> LOTR_TAB4 = CREATIVE_MODE_TABS.register("lotr_food_and_drink_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModBlocks.MITHRIL_BLOCK.get()))
                    .title(Component.translatable("creativetab.lotr_food_and_drink_tab")).displayItems((DisplayParameters, output) -> {
                    }).build());
    public static final RegistryObject<CreativeModeTab> LOTR_TAB5 = CREATIVE_MODE_TABS.register("lotr_materials_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModBlocks.MITHRIL_BLOCK.get()))
                    .title(Component.translatable("creativetab.lotr_materials_tab")).displayItems((DisplayParameters, output) -> {
                        output.accept(ModItems.MITHRIL.get());
                        output.accept(ModItems.RAW_MITHRIL.get());
                    }).build());

    public static final RegistryObject<CreativeModeTab> LOTR_TAB6 = CREATIVE_MODE_TABS.register("lotr_miscellaneous_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.MUD_BALL.get()))
                    .title(Component.translatable("creativetab.lotr_miscellaneous_tab")).displayItems((DisplayParameters, output) -> {
                        output.accept(ModItems.MUD_BALL.get());
                        output.accept(ModItems.PEBBLE.get());
                    }).build());

    public static final RegistryObject<CreativeModeTab> LOTR_TAB7 = CREATIVE_MODE_TABS.register("lotr_tools_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModBlocks.MITHRIL_BLOCK.get()))
                    .title(Component.translatable("creativetab.lotr_tools_tab")).displayItems((DisplayParameters, output) -> {
                    }).build());

    public static final RegistryObject<CreativeModeTab> LOTR_TAB8 = CREATIVE_MODE_TABS.register("lotr_combat_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModBlocks.MITHRIL_BLOCK.get()))
                    .title(Component.translatable("creativetab.lotr_combat_tab")).displayItems((DisplayParameters, output) -> {
                    }).build());

    public static final RegistryObject<CreativeModeTab> LOTR_TAB9 = CREATIVE_MODE_TABS.register("lotr_story_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModBlocks.MITHRIL_BLOCK.get()))
                    .title(Component.translatable("creativetab.lotr_story_tab")).displayItems((DisplayParameters, output) -> {
                    }).build());

    public static final RegistryObject<CreativeModeTab> LOTR_TAB10 = CREATIVE_MODE_TABS.register("lotr_spawning_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModBlocks.MITHRIL_BLOCK.get()))
                    .title(Component.translatable("creativetab.lotr_spawning_tab")).displayItems((DisplayParameters, output) -> {
                    }).build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
