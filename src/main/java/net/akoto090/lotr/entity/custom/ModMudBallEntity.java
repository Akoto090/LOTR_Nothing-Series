package net.akoto090.lotr.entity.custom;

import net.akoto090.lotr.entity.ModEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.ThrowableItemProjectile;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items; // Placeholder, replace with your actual item
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.BlockHitResult;

public class ModMudBallEntity extends ThrowableItemProjectile {
    public ModMudBallEntity(EntityType<? extends ThrowableItemProjectile> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
    }

    public ModMudBallEntity(Level pLevel, LivingEntity livingEntity) {
        super(ModEntities.MUD_PROJECTILE.get(), livingEntity, pLevel);
    }

    public ModMudBallEntity(Level pLevel, double x, double y, double z) {
        super(ModEntities.MUD_PROJECTILE.get(), x, y, z, pLevel);
    }

    @Override
    protected Item getDefaultItem() {
        // Return the actual item that this entity represents
        return Items.SNOWBALL; // Placeholder, replace with your actual item
    }

    @Override
    protected void onHitBlock(BlockHitResult pResult) {
        if (!this.level().isClientSide) {
            // Example effect: create an explosion at the hit location
            this.level().explode(null, pResult.getBlockPos().getX(), pResult.getBlockPos().getY(), pResult.getBlockPos().getZ(), 1.0F, false, null);
        }

        super.onHitBlock(pResult);
    }
}