package net.akoto090.lotr.entity.custom;

import net.akoto090.lotr.entity.ModEntites;
import net.minecraft.core.particles.ParticleType;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.ThrowableItemProjectile;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;

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
        if (!this.level().isClientSide() && pResult.getEntity() instanceof LivingEntity) {
            LivingEntity hitEntity = (LivingEntity) pResult.getEntity();

            MobEffectInstance effectInstance = new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 100, 3);
            if (hitEntity.canBeAffected(effectInstance))  hitEntity.addEffect(effectInstance);
        }

        this.discard();
        super.onHitEntity(pResult);
    }

    @Override
    protected void onHit(HitResult result) {
        super.onHit(result);
        if (!this.level().isClientSide) {
            Vec3 v = result.getLocation();
            this.level().playSound(null, v.x, v.y, v.z, SoundEvents.MUD_HIT, SoundSource.NEUTRAL, 0.75F, 1);
            this.level().addParticle(ParticleTypes.ITEM_SNOWBALL, v.x, v.y, v.z, 0, 0.1, 0);
            this.level().broadcastEntityEvent(this, (byte) 3);
            this.remove(RemovalReason.DISCARDED);
        }
    }
}