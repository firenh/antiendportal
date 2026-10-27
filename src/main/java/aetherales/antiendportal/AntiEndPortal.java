package aetherales.antiendportal;

import com.mojang.brigadier.arguments.ArgumentType;
import com.mojang.brigadier.arguments.BoolArgumentType;
import com.mojang.serialization.Codec;
import net.fabricmc.api.ModInitializer;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;

import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraft.world.level.gamerules.GameRule;
import net.minecraft.world.level.gamerules.GameRuleCategory;
import net.minecraft.world.level.gamerules.GameRuleType;
import net.minecraft.world.level.gamerules.GameRuleTypeVisitor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AntiEndPortal implements ModInitializer {
	public static final String MOD_ID = "antiendportal";

	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.

		LOGGER.info("Hello Fabric world!");
	}

	public static final GameRule<Boolean> END_PORTAL_WORKS =
		Registry.register(BuiltInRegistries.GAME_RULE, id("end_portal_works"),
			new GameRule<Boolean>(
				GameRuleCategory.PLAYER,
				GameRuleType.BOOL,
				BoolArgumentType.bool(),
				GameRuleTypeVisitor::visitBoolean,
				Codec.BOOL,
				b -> b ? 1 : 0,
				false,
				FeatureFlagSet.of()
			)
		);

	public static Identifier id(String path) {
		return Identifier.fromNamespaceAndPath(MOD_ID, path);
	}
}
