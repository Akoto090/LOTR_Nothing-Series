package net.akoto090.lotr.entity.custom;

import net.akoto090.lotr.entity.ModEntites;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.ThrowableItemProjectile;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.EntityHitResult;

public class MudProjectileEntity extends ThrowableItemProjectile {
    public MudProjectileEntity(EntityType<? extends ThrowableItemProjectile> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
    }

    public MudProjectileEntity(Level pLevel) {
        this(ModEntites.MUD_BALL.get(), pLevel);
    }

    public MudProjectileEntity(Level pLevel, LivingEntity livingEntity) {
        super(ModEntites.MUD_BALL.get(), livingEntity, pLevel);
    }

    @Override
    protected Item getDefaultItem() {
        return null;
    }

    @Override
    protected void onHitBlock(BlockHitResult pResult) {
        if (!this.level().isClientSide()) {
            this.level().broadcastEntityEvent(this, ((byte) 3));
        }

        this.discard();
        super.onHitBlock(pResult);
    }

    @Override
    protected void onHitEntity(EntityHitResult pResult) {
        if (!this.level().isClientSide()) {
            LivingEntity hitEntity = (LivingEntity) pResult.getEntity();
            MobEffectInstance effectInstance = new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 100, 3);
            hitEntity.addEffect(effectInstance);
        }

        this.discard();
        super.onHitEntity(pResult);
    }
}

