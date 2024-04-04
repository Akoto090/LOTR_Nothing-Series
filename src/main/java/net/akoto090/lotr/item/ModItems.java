package net.akoto090.lotr.item;

import net.akoto090.lotr.LotrMod;
import net.akoto090.lotr.entity.custom.MudItem;
import net.akoto090.lotr.entity.custom.PebbleItem;
import net.akoto090.lotr.entity.custom.PlateItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, LotrMod.MOD_ID);

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }

    public static final RegistryObject<Item> MITHRIL = ITEMS.register("mithril_ingot",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> RAW_MITHRIL = ITEMS.register("raw_mithril",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> MUD_BALL = ITEMS.register("mud_ball",
            () -> new MudItem(new Item.Properties().stacksTo(16)));

    public static final RegistryObject<Item> PEBBLE = ITEMS.register("pebble",
            () -> new PebbleItem(new Item.Properties().stacksTo(16)));

    public static final RegistryObject<Item> PLATE = ITEMS.register("plate",
            () -> new PlateItem(new Item.Properties().stacksTo(16)));
}
