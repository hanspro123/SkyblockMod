package me.Danker.commands;

import me.Danker.DankersSkyblockMod;
import me.Danker.handlers.ConfigHandler;
import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.BlockPos;
import net.minecraft.util.ChatComponentText;

import java.util.List;

public class ScaleCommand extends CommandBase {

	public static double coordsScale;
	public static double displayScale;
	public static double dungeonTimerScale;
	public static double skill50Scale;
	public static double lividHpScale;
	public static double cakeTimerScale;
	public static double skillTrackerScale;
	public static double waterAnswerScale;
	public static double bonzoTimerScale;
	public static double golemTimerScale;
	public static double teammatesInRadiusScale;
	public static double giantHPScale;
	public static double abilityCooldownsScale;
	public static double dungeonScoreScale;
	public static double firePillarScale;
	
	@Override
	public String getCommandName() {
		return "scale";
	}

	@Override
	public String getCommandUsage(ICommandSender arg0) {
		return "/" + getCommandName() + " <coords/display/dungeontimer/skill50/lividhp/caketimer/skilltracker/wateranswer/" +
										"bonzotimer/golemtimer/teammatesinradius/gianthp/abilitycooldown/dungeonscore/firepillar> <size (0.1 - 10)>";
	}

	public static String usage(ICommandSender arg0) {
		return new ScaleCommand().getCommandUsage(arg0);
	}
	
	@Override
	public int getRequiredPermissionLevel() {
		return 0;
	}
	
	@Override
	public List<String> addTabCompletionOptions(ICommandSender sender, String[] args, BlockPos pos) {
		if (args.length == 1) {
			return getListOfStringsMatchingLastWord(args, "coords", "display", "dungeontimer", "skill50", "lividhp", "caketimer",
														  "skilltracker", "wateranswer", "bonzotimer", "golemtimer", "teammatesinradius",
														  "gianthp", "abilitycooldowns", "dungeonscore", "firepillar");
		}
		return null;
	}

	@Override
	public void processCommand(ICommandSender arg0, String[] arg1) throws CommandException {
		final EntityPlayer player = (EntityPlayer) arg0;
		
		if (arg1.length < 2) {
			player.addChatMessage(new ChatComponentText(DankersSkyblockMod.ERROR_COLOUR + "Usage: " + getCommandUsage(arg0)));
			return;
		}
		
		double scaleAmount = Math.floor(Double.parseDouble(arg1[1]) * 100.0) / 100.0;
		if (scaleAmount < 0.1 || scaleAmount > 10.0) {
			player.addChatMessage(new ChatComponentText(DankersSkyblockMod.ERROR_COLOUR + "Scale multipler can only be between 0.1x and 10x."));
			return;
		}
		
		switch (arg1[0].toLowerCase()) {
			case "coords":
				coordsScale = scaleAmount;
				ConfigHandler.writeDoubleConfig("scales", "coordsScale", coordsScale);
				player.addChatMessage(new ChatComponentText(DankersSkyblockMod.MAIN_COLOUR + "Coords have been scaled to " + DankersSkyblockMod.SECONDARY_COLOUR + coordsScale + "x"));
				break;
			case "display":
				displayScale = scaleAmount;
				ConfigHandler.writeDoubleConfig("scales", "displayScale", displayScale);
				player.addChatMessage(new ChatComponentText(DankersSkyblockMod.MAIN_COLOUR + "Display has been scaled to " + DankersSkyblockMod.SECONDARY_COLOUR + displayScale + "x"));
				break;
			case "dungeontimer":
				dungeonTimerScale = scaleAmount;
				ConfigHandler.writeDoubleConfig("scales", "dungeonTimerScale", dungeonTimerScale);
				player.addChatMessage(new ChatComponentText(DankersSkyblockMod.MAIN_COLOUR + "Dungeon timer has been scaled to " + DankersSkyblockMod.SECONDARY_COLOUR + dungeonTimerScale + "x"));
				break;
			case "skill50":
				skill50Scale = scaleAmount;
				ConfigHandler.writeDoubleConfig("scales", "skill50Scale", skill50Scale);
				player.addChatMessage(new ChatComponentText(DankersSkyblockMod.MAIN_COLOUR + "Skill 50 display has been scaled to " + DankersSkyblockMod.SECONDARY_COLOUR + skill50Scale + "x"));
				break;
			case "lividhp":
				lividHpScale = scaleAmount;
				ConfigHandler.writeDoubleConfig("scales", "lividHpScale", lividHpScale);
				player.addChatMessage(new ChatComponentText(DankersSkyblockMod.MAIN_COLOUR + "Livid HP has been scaled to " + DankersSkyblockMod.SECONDARY_COLOUR + lividHpScale + "x"));
				break;
			case "caketimer":
				cakeTimerScale = scaleAmount;
				ConfigHandler.writeDoubleConfig("scales", "cakeTimerScale", cakeTimerScale);
				player.addChatMessage(new ChatComponentText(DankersSkyblockMod.MAIN_COLOUR + "Cake timer has been scaled to " + DankersSkyblockMod.SECONDARY_COLOUR + cakeTimerScale + "x"));
				break;
			case "skilltracker":
				skillTrackerScale = scaleAmount;
				ConfigHandler.writeDoubleConfig("scales", "skillTrackerScale", skillTrackerScale);
				player.addChatMessage(new ChatComponentText(DankersSkyblockMod.MAIN_COLOUR + "Skill tracker has been scaled to " + DankersSkyblockMod.SECONDARY_COLOUR + skillTrackerScale + "x"));
				break;
			case "wateranswer":
				waterAnswerScale = scaleAmount;
				ConfigHandler.writeDoubleConfig("scales", "waterAnswerScale", waterAnswerScale);
				player.addChatMessage(new ChatComponentText(DankersSkyblockMod.MAIN_COLOUR + "Water solver answer has been scaled to " + DankersSkyblockMod.SECONDARY_COLOUR + waterAnswerScale + "x"));
				break;
			case "bonzotimer":
				bonzoTimerScale = scaleAmount;
				ConfigHandler.writeDoubleConfig("scales", "bonzoTimerScale", bonzoTimerScale);
				player.addChatMessage(new ChatComponentText(DankersSkyblockMod.MAIN_COLOUR + "Bonzo's Mask timer has been scaled to " + DankersSkyblockMod.SECONDARY_COLOUR + bonzoTimerScale + "x"));
				break;
			case "golemtimer":
				golemTimerScale = scaleAmount;
				ConfigHandler.writeDoubleConfig("scales", "golemTimerScale", golemTimerScale);
				player.addChatMessage(new ChatComponentText(DankersSkyblockMod.MAIN_COLOUR + "Golem timer has been scaled to " + DankersSkyblockMod.SECONDARY_COLOUR + golemTimerScale + "x"));
				break;
			case "teammatesinradius":
				teammatesInRadiusScale = scaleAmount;
				ConfigHandler.writeDoubleConfig("scales", "teammatesInRadiusScale", teammatesInRadiusScale);
				player.addChatMessage(new ChatComponentText(DankersSkyblockMod.MAIN_COLOUR + "Teammates in radius has been scaled to " + DankersSkyblockMod.SECONDARY_COLOUR + teammatesInRadiusScale + "x"));
				break;
			case "gianthp":
				giantHPScale = scaleAmount;
				ConfigHandler.writeDoubleConfig("scales", "giantHPScale", giantHPScale);
				player.addChatMessage(new ChatComponentText(DankersSkyblockMod.MAIN_COLOUR + "Giant hp has been scaled to " + DankersSkyblockMod.SECONDARY_COLOUR + giantHPScale + "x"));
				break;
			case "abilitycooldowns":
				abilityCooldownsScale = scaleAmount;
				ConfigHandler.writeDoubleConfig("scales", "abilityCooldownsScale", abilityCooldownsScale);
				player.addChatMessage(new ChatComponentText(DankersSkyblockMod.MAIN_COLOUR + "Ability cooldowns has been scaled to " + DankersSkyblockMod.SECONDARY_COLOUR + abilityCooldownsScale + "x"));
				break;
			case "dungeonscore":
				dungeonScoreScale = scaleAmount;
				ConfigHandler.writeDoubleConfig("scales", "dungeonScoreScale", dungeonScoreScale);
				player.addChatMessage(new ChatComponentText(DankersSkyblockMod.MAIN_COLOUR + "Dungeon score has been scaled to " + DankersSkyblockMod.SECONDARY_COLOUR + dungeonScoreScale + "x"));
				break;
			case "firepillar":
				firePillarScale = scaleAmount;
				ConfigHandler.writeDoubleConfig("scales", "firePillarScale", firePillarScale);
				player.addChatMessage(new ChatComponentText(DankersSkyblockMod.MAIN_COLOUR + "Fire pillar has been scaled to " + DankersSkyblockMod.SECONDARY_COLOUR + firePillarScale + "x"));
				break;
			default:
				player.addChatMessage(new ChatComponentText(DankersSkyblockMod.ERROR_COLOUR + "Usage: " + getCommandUsage(arg0)));
		}	
	}

}
