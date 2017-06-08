package com.dmonsters.main;

import com.dmonsters.entity.EntityBaby;
import com.dmonsters.entity.EntityClimber;
import com.dmonsters.entity.EntityEntrail;
import com.dmonsters.entity.EntityFreezer;
import com.dmonsters.entity.EntityMutantSteve;
import com.dmonsters.entity.EntityPresent;
import com.dmonsters.entity.EntityStranger;
import com.dmonsters.entity.EntityWideman;
import com.dmonsters.entity.EntityWoman;
import com.dmonsters.entity.EntityZombieChicken;
import com.dmonsters.entityProjectile.EntityDagon;
import com.dmonsters.entityProjectile.EntityLuckyEgg;
import com.dmonsters.render.RenderBaby;
import com.dmonsters.render.RenderClimber;
import com.dmonsters.render.RenderEntrail;
import com.dmonsters.render.RenderFreezer;
import com.dmonsters.render.RenderMutantSteve;
import com.dmonsters.render.RenderPresent;
import com.dmonsters.render.RenderStranger;
import com.dmonsters.render.RenderWideman;
import com.dmonsters.render.RenderWoman;
import com.dmonsters.render.RenderZombieChicken;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.RenderSnowball;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.init.Biomes;
import net.minecraft.init.Items;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.storage.loot.LootTableList;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.registry.EntityRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.Locale;

import static com.dmonsters.main.MainMod.instance;

public class ModEntities {

	static int startEntityId = 200;

	public static void init() {
		if (!ModConfig.mobsDisable) {
			//Zombie Steve
			if (!ModConfig.mutantSteveDisabled) {
				registerEntityWithEgg(EntityMutantSteve.class, "mutantSteve", 1, 64, 3, true, 1, 2);
				EntityRegistry.addSpawn(EntityMutantSteve.class, ModConfig.mutantSteveSawnRate, 1, 2, EnumCreatureType.MONSTER, BiomesProvider.getBiomes());
				LootTableList.register(EntityMutantSteve.LOOT);
			}

			//Freezer
			if (!ModConfig.freezerDisabled) {
				registerEntityWithEgg(EntityFreezer.class, "freezer", 2, 64,3,true, 1,3);
				EntityRegistry.addSpawn(EntityFreezer.class, ModConfig.freezerSawnRate, 1, 1, EnumCreatureType.MONSTER, BiomesProvider.getBiomes());
				LootTableList.register(EntityFreezer.LOOT);
			}

			//Climber
			if (!ModConfig.climberDisabled) {
				registerEntityWithEgg(EntityClimber.class, "climber", 3, 64, 3, true, 1,4);
				EntityRegistry.addSpawn(EntityClimber.class, ModConfig.climberSawnRate, 1, 5, EnumCreatureType.MONSTER, BiomesProvider.getBiomes());
				LootTableList.register(EntityClimber.LOOT);
			}

			//Zombie Chicken
			if (!ModConfig.zombieChickenDisabled) {
				registerEntityWithEgg(EntityZombieChicken.class, "zombieChicken",4,64,3,true,1,5);
				EntityRegistry.addSpawn(EntityZombieChicken.class, ModConfig.zombieChickenSawnRate, 2, 8, EnumCreatureType.MONSTER, BiomesProvider.getBiomes());
				LootTableList.register(EntityZombieChicken.LOOT);
			}

			//Baby
			if (!ModConfig.babyDisabled) {
				registerEntityWithEgg(EntityBaby.class, "baby",5,64,3,true,1,6);
				EntityRegistry.addSpawn(EntityBaby.class, ModConfig.babySawnRate, 2, 8, EnumCreatureType.MONSTER, BiomesProvider.getBiomes());
				LootTableList.register(EntityBaby.LOOT);
			}

			//Wideman
			if (!ModConfig.fallenLeaderDisabled) {
				registerEntityWithEgg(EntityWideman.class,"wideman",6,64,3,true,1,7);
				EntityRegistry.addSpawn(EntityWideman.class, ModConfig.fallenLeaderSawnRate, 2, 8, EnumCreatureType.MONSTER, BiomesProvider.getBiomes());
				LootTableList.register(EntityWideman.LOOT);
			}

			//Woman
			if (!ModConfig.bloodyMaidenDisabled) {
				registerEntityWithEgg(EntityWoman.class,"woman",7,64,3,true,1,8);
				EntityRegistry.addSpawn(EntityWoman.class, ModConfig.bloodyMaidenSawnRate, 2, 8, EnumCreatureType.MONSTER, BiomesProvider.getBiomes());
				LootTableList.register(EntityWoman.LOOT);
			}

			//Entrail
			if (!ModConfig.entrailDisabled) {
				registerEntityWithEgg(EntityEntrail.class,"entrail",8,64,3,true,1,9);
				EntityRegistry.addSpawn(EntityEntrail.class, ModConfig.entrailSawnRate, 2, 8, EnumCreatureType.MONSTER, BiomesProvider.getBiomes());
				LootTableList.register(EntityEntrail.LOOT);
			}

			//Present
			if (!ModConfig.presentDisabled) {
				registerEntityWithEgg(EntityPresent.class,"present",9,64,3,true,1,10);
				EntityRegistry.addSpawn(EntityPresent.class, ModConfig.presentSawnRate, 2, 8, EnumCreatureType.MONSTER, BiomesProvider.getSnowBiomes());
				LootTableList.register(EntityPresent.LOOT);
			}

			//Stranger
			if (!ModConfig.strangerDisabled) {
				registerEntityWithEgg(EntityStranger.class,"stranger",10,64,3,true,1,11);
				EntityRegistry.addSpawn(EntityStranger.class, ModConfig.strangerSawnRate, 2, 8, EnumCreatureType.MONSTER, BiomesProvider.getBiomes());
				LootTableList.register(EntityStranger.LOOT);
			}
		}

		//Lucky Egg
		EntityRegistry.registerModEntity(EntityLuckyEgg.class, "luckyEgg", 11, instance, 64, 3, true);
		//Dagon
		EntityRegistry.registerModEntity(EntityDagon.class, "dagon", 12, instance, 64, 3, true);
	}

	@SideOnly(Side.CLIENT)
	public static void initModels() {
		RenderingRegistry.registerEntityRenderingHandler(EntityMutantSteve.class, RenderMutantSteve.FACTORY);
		RenderingRegistry.registerEntityRenderingHandler(EntityFreezer.class, RenderFreezer.FACTORY);
		RenderingRegistry.registerEntityRenderingHandler(EntityClimber.class, RenderClimber.FACTORY);
		RenderingRegistry.registerEntityRenderingHandler(EntityZombieChicken.class, RenderZombieChicken.FACTORY);
		RenderingRegistry.registerEntityRenderingHandler(EntityBaby.class, RenderBaby.FACTORY);
		RenderingRegistry.registerEntityRenderingHandler(EntityWideman.class, RenderWideman.FACTORY);
		RenderingRegistry.registerEntityRenderingHandler(EntityWoman.class, RenderWoman.FACTORY);
		RenderingRegistry.registerEntityRenderingHandler(EntityEntrail.class, RenderEntrail.FACTORY);
		RenderingRegistry.registerEntityRenderingHandler(EntityPresent.class, RenderPresent.FACTORY);
		RenderingRegistry.registerEntityRenderingHandler(EntityStranger.class, RenderStranger.FACTORY);
	}

	@SideOnly(Side.CLIENT)
	public static void initHackModels() {
		RenderingRegistry.registerEntityRenderingHandler(EntityLuckyEgg.class, new RenderSnowball<EntityLuckyEgg>(Minecraft.getMinecraft().getRenderManager(), ModItems.luckyEgg, Minecraft.getMinecraft().getRenderItem()));
		RenderingRegistry.registerEntityRenderingHandler(EntityDagon.class, new RenderSnowball<EntityDagon>(Minecraft.getMinecraft().getRenderManager(), ModItems.flyingDagon, Minecraft.getMinecraft().getRenderItem()));
	}

	private static int getUniqueEntityId() {
		do
			startEntityId++;
		while (EntityList.ID_TO_CLASS.containsKey(startEntityId));

		return startEntityId;
	}

	@SuppressWarnings("unchecked")
	private static void registerEntityWithEgg(Class<? extends Entity> entity, String name, int modid, int trackingRange, int updateFrequency, boolean sendsVelocityUpdates, int primaryColor, int secondaryColor) {
		int id = getUniqueEntityId();
		EntityRegistry.registerModEntity(entity, name, modid, instance, trackingRange, updateFrequency, sendsVelocityUpdates, primaryColor, secondaryColor);
		EntityList.ID_TO_CLASS.put(id, entity);
	}
}