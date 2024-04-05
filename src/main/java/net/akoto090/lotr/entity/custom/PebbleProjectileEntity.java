package net.akoto090.lotr.entity.custom;

import net.akoto090.lotr.entity.ModEntites;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.ThrowableItemProjectile;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;


public class PebbleProjectileEntity extends ThrowableItemProjectile {

    public PebbleProjectileEntity(EntityType<? extends ThrowableItemProjectile> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
    }


    public PebbleProjectileEntity(Level pLevel) {
        this(ModEntites.PEBBLE.get(), pLevel);
    }

    public PebbleProjectileEntity(Level pLevel, LivingEntity livingEntity) {
        super(ModEntites.PEBBLE.get(), livingEntity, pLevel);
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
    protected void onHitEntity(EntityHitResult entityHitResult) {
        super.onHitEntity(entityHitResult);
        Entity entity = entityHitResult.getEntity();
        int i = 1;
        entity.hurt(this.level().damageSources().thrown(this, this.getOwner()), i);
    }

    protected void onHit(HitResult result) {
        super.onHit(result);
        if (!this.level().isClientSide) {
            Vec3 v = result.getLocation();
            this.level().playSound(null, v.x, v.y, v.z, SoundEvents.DRIPSTONE_BLOCK_BREAK, SoundSource.NEUTRAL, 0.75F, 1);
            this.level().broadcastEntityEvent(this, (byte) 3);
            this.remove(RemovalReason.DISCARDED);
        }
    }

    @Override
    public void tick() {
        super.tick();
        double speed = Math.sqrt(this.getDeltaMovement().x * this.getDeltaMovement().x + this.getDeltaMovement().z * this.getDeltaMovement().z);
        if (speed > 0.1 && this.getDeltaMovement().y < 0.0 && this.isInWater()) {
            double factor = Math.random() * (0.8 - 0.4) + 0.4;
            this.setDeltaMovement(this.getDeltaMovement().x * factor, this.getDeltaMovement().y + factor, this.getDeltaMovement().z * factor);
        }
    }


}