package net.akoto090.lotr.datagen.loot;

import net.akoto090.lotr.block.ModBlocks;
import net.akoto090.lotr.item.ModItems;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.RegistryObject;

import java.util.Set;

public class ModBlockLootTables extends BlockLootSubProvider {
    public ModBlockLootTables() {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());
    }

    @Override
    protected void generate() {
        this.dropSelf(ModBlocks.MITHRIL_BLOCK.get());
        this.dropSelf(ModBlocks.RAW_MITHRIL_BLOCK.get());

        this.add(ModBlocks.MITHRIL_ORE.get(),
                block -> createOreDrop(ModBlocks.MITHRIL_ORE.get(), ModItems.RAW_MITHRIL.get()));
        this.add(ModBlocks.DEEPSLATE_MITHRIL_ORE.get(),
                block -> createOreDrop(ModBlocks.DEEPSLATE_MITHRIL_ORE.get(), ModItems.RAW_MITHRIL.get()));

    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}
