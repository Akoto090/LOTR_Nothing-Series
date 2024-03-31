package net.akoto090.lotr.datagen;

import net.akoto090.lotr.LotrMod;
import net.akoto090.lotr.block.ModBlocks;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagGenerator extends BlockTagsProvider {
    public ModBlockTagGenerator(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider,
                                @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, LotrMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
        this.tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(ModBlocks.MITHRIL_BLOCK.get(),
                        ModBlocks.RAW_MITHRIL_BLOCK.get(),
                        ModBlocks.MITHRIL_ORE.get(),
                        ModBlocks.DEEPSLATE_MITHRIL_ORE.get());

        this.tag(BlockTags.NEEDS_IRON_TOOL)
                .add(ModBlocks.MITHRIL_BLOCK.get(),
                        ModBlocks.RAW_MITHRIL_BLOCK.get());

        this.tag(BlockTags.NEEDS_DIAMOND_TOOL)
                .add(ModBlocks.MITHRIL_ORE.get(),
                        ModBlocks.DEEPSLATE_MITHRIL_ORE.get());
    }

    @Override
    public String getName() {
        return "Block Tags";
    }
}