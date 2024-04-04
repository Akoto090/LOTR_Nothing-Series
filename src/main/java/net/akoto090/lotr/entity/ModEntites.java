package net.akoto090.lotr.entity;

import net.akoto090.lotr.LotrMod;
import net.akoto090.lotr.entity.custom.MudProjectileEntity;
import net.akoto090.lotr.entity.custom.PebbleProjectileEntity;
import net.akoto090.lotr.entity.custom.PlateProjectileEntity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModEntites {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
            DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, LotrMod.MOD_ID);

    public static final RegistryObject<EntityType<MudProjectileEntity>> MUD_BALL =
            ENTITY_TYPES.register("mud_projectile", () -> EntityType.Builder.<MudProjectileEntity>of(MudProjectileEntity::new, MobCategory.MISC)
                    .sized(0.5f, 0.5f)
                    .clientTrackingRange(4)
                    .updateInterval(20)
                    .setCustomClientFactory((spawnEntity, level) -> new MudProjectileEntity(level))
                    .build("mud_projectile"));

    public static final RegistryObject<EntityType<PebbleProjectileEntity>> PEBBLE =
            ENTITY_TYPES.register("pebble_projectile", () -> EntityType.Builder.<PebbleProjectileEntity>of(PebbleProjectileEntity::new, MobCategory.MISC)
                    .sized(0.5f, 0.5f)
                    .clientTrackingRange(4)
                    .updateInterval(20)
                    .setCustomClientFactory((spawnEntity, level) -> new PebbleProjectileEntity(level))
                    .build("pebble_projectile"));

    public static final RegistryObject<EntityType<PlateProjectileEntity>> PLATE =
            ENTITY_TYPES.register("plate_projectile", () -> EntityType.Builder.<PlateProjectileEntity>of(PlateProjectileEntity::new, MobCategory.MISC)
                    .sized(0.5f, 0.5f)
                    .clientTrackingRange(4)
                    .updateInterval(20)
                    .setCustomClientFactory((spawnEntity, level) -> new PlateProjectileEntity(level))
                    .build("plate_projectile"));

    public static void register(IEventBus eventBus) {
        ENTITY_TYPES.register(eventBus);
    }


}
