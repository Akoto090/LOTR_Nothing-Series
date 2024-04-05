package net.akoto090.lotr.event;

import net.akoto090.lotr.LotrMod;
import net.akoto090.lotr.block.ModBlocks;
import net.akoto090.lotr.entity.custom.PlateProjectileEntity;
import net.minecraft.stats.Stats;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = LotrMod.MOD_ID)
public class EventHandler {
    @SubscribeEvent
    public static void onRightclickItem(PlayerInteractEvent.RightClickItem event){
        if(!event.getEntity().level().isClientSide) {
            if ((event.getEntity() instanceof Player)
                    && (event.getEntity().getItemInHand(event.getEntity().getUsedItemHand()).getItem()
                    == ModBlocks.PLATE_BLOCK.get().asItem())) {

                Player p = event.getEntity();
                Level l = event.getLevel();
                PlateProjectileEntity PlateProjectile = new PlateProjectileEntity(l,p);
                ItemStack item = p.getItemInHand(p.getUsedItemHand());
                PlateProjectile.setItem(item);
                PlateProjectile.shootFromRotation(p, p.getXRot(), p.getYRot(), 0.0F, 0.5F, 0.0F);
                event.getLevel().addFreshEntity(PlateProjectile);

                p.awardStat(Stats.ITEM_USED.get(p.getUseItem().getItem()));
                if (!p.getAbilities().instabuild) {
                    item.shrink(1);
                }
            }
        }
    }
}