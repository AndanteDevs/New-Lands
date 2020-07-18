package com.newlanders.new_lands.registry;

import com.newlanders.new_lands.CreativeTabs;
import com.newlanders.new_lands.NewLands;
import com.newlanders.new_lands.blocks.LayerBlock;
import com.newlanders.new_lands.utils.BiRegistry;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Rarity;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import javax.annotation.Nullable;

//GiantLuigi4:Copy general methods from another one of my mods, because it's another one of my mods that I copied from, so why shouldn't I?
public class Blocks {
	public static final DeferredRegister<Block> BLOCKS = new DeferredRegister<>(ForgeRegistries.BLOCKS, NewLands.ModID);
	
	public static final BiRegistry<RegistryObject<Block>, RegistryObject<Item>> SAND_LAYER = registerBlockWithItem("sand_layer", new LayerBlock(), 64, CreativeTabs.WORLD_GEN,null);
	
	public static BiRegistry<RegistryObject<Block>, RegistryObject<Item>> registerBlockWithItem(String name, Block block, int maxStack, @Nullable ItemGroup group, @Nullable Rarity rarity) {
		Item.Properties properties = new Item.Properties();
		if (group!=null) properties.group(group);
		if (rarity!=null) properties.rarity(rarity);
		properties.maxStackSize(maxStack);
		return new BiRegistry<>(
				BLOCKS.register(name,()->block),
				Items.ITEMS.register(name,()->(new BlockItem(block, properties)))
		);
	}
}