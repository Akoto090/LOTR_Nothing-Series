package net.akoto090.lotr.entity;

import net.akoto090.lotr.LotrMod;
import net.akoto090.lotr.entity.custom.ModMudBallEntity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModEntities {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
            DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, LotrMod.MOD_ID);


public static final RegistryObject<EntityType<ModMudBallEntity>> MUD_PROJECTILE =
        ENTITY_TYPES.register("mud_projectile", () -> EntityType.Builder.<ModMudBallEntity>of(ModMudBallEntity::new, MobCategory.MISC)
                .sized(0.5f, 0.5f).build("mud_projectile"));

public static void register(IEventBus eventBus) { ENTITY_TYPES.register(eventBus); }
}