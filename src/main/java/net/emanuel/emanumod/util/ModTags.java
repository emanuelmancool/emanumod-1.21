package net.emanuel.emanumod.util;

import net.emanuel.emanumod.Emanumod;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

public class ModTags {

    public static class Blocks {
        public static final TagKey<Block> NEEDS_GREEN_IRON_TOOL = createTag("needs_green_iron_tool");
        public static final TagKey<Block> INCORRECT_FOR_GREEN_IRON_TOOL = createTag("incorrect_for_green_iron_tool");


        private static TagKey<Block> createTag(String name) {
            return TagKey.of(RegistryKeys.BLOCK, Identifier.of(Emanumod.MOD_ID, name));
        }
    }
}
