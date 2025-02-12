package me.Danker.features.loot;

import me.Danker.commands.MoveCommand;
import me.Danker.commands.ScaleCommand;
import me.Danker.commands.ToggleCommand;
import me.Danker.events.RenderOverlayEvent;
import me.Danker.handlers.ConfigHandler;
import me.Danker.handlers.TextRenderer;
import me.Danker.utils.Utils;
import net.minecraft.client.Minecraft;
import net.minecraft.util.EnumChatFormatting;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.text.NumberFormat;
import java.util.Locale;

public class LootDisplay {

    public static String display;
    public static boolean auto;

    @SubscribeEvent
    public void renderPlayerInfo(RenderOverlayEvent event) {
        if (!display.equals("off")) {
            Minecraft mc = Minecraft.getMinecraft();
            String dropsText = "";
            String countText = "";
            String dropsTextTwo;
            String countTextTwo;
            String timeBetween;
            String bossesBetween;
            String drop20;
            String runs;
            String runsCount;
            double timeNow = System.currentTimeMillis() / 1000;
            NumberFormat nf = NumberFormat.getIntegerInstance(Locale.US);

            switch (display) {
                case "wolf":
                    if (WolfTracker.time == -1) {
                        timeBetween = "Never";
                    } else {
                        timeBetween = Utils.getTimeBetween(WolfTracker.time, timeNow);
                    }
                    if (WolfTracker.bosses == -1) {
                        bossesBetween = "Never";
                    } else {
                        bossesBetween = nf.format(WolfTracker.bosses);
                    }
                    if (ToggleCommand.slayerCountTotal) {
                        drop20 = nf.format(WolfTracker.wheels);
                    } else {
                        drop20 = nf.format(WolfTracker.wheelsDrops) + " times";
                    }

                    dropsText = EnumChatFormatting.GOLD + "Svens Killed:\n" +
                            EnumChatFormatting.GREEN + "Wolf Teeth:\n" +
                            EnumChatFormatting.BLUE + "Hamster Wheels:\n" +
                            EnumChatFormatting.AQUA + "Spirit Runes:\n" +
                            EnumChatFormatting.WHITE + "Critical VI Books:\n" +
                            EnumChatFormatting.DARK_AQUA + "Furballs:\n" +
                            EnumChatFormatting.DARK_RED + "Red Claw Eggs:\n" +
                            EnumChatFormatting.GOLD + "Couture Runes:\n" +
                            EnumChatFormatting.AQUA + "Grizzly Baits:\n" +
                            EnumChatFormatting.DARK_PURPLE + "Overfluxes:\n" +
                            EnumChatFormatting.AQUA + "Time Since RNG:\n" +
                            EnumChatFormatting.AQUA + "Bosses Since RNG:";
                    countText = EnumChatFormatting.GOLD + nf.format(WolfTracker.svens) + "\n" +
                            EnumChatFormatting.GREEN + nf.format(WolfTracker.teeth) + "\n" +
                            EnumChatFormatting.BLUE + drop20 + "\n" +
                            EnumChatFormatting.AQUA + WolfTracker.spirits + "\n" +
                            EnumChatFormatting.WHITE + WolfTracker.books + "\n" +
                            EnumChatFormatting.DARK_AQUA + WolfTracker.furballs + "\n" +
                            EnumChatFormatting.DARK_RED + WolfTracker.eggs + "\n" +
                            EnumChatFormatting.GOLD + WolfTracker.coutures + "\n" +
                            EnumChatFormatting.AQUA + WolfTracker.baits + "\n" +
                            EnumChatFormatting.DARK_PURPLE + WolfTracker.fluxes + "\n" +
                            EnumChatFormatting.AQUA + timeBetween + "\n" +
                            EnumChatFormatting.AQUA + bossesBetween;
                    break;
                case "wolf_session":
                    if (WolfTracker.timeSession == -1) {
                        timeBetween = "Never";
                    } else {
                        timeBetween = Utils.getTimeBetween(WolfTracker.timeSession, timeNow);
                    }
                    if (WolfTracker.bossesSession == -1) {
                        bossesBetween = "Never";
                    } else {
                        bossesBetween = nf.format(WolfTracker.bossesSession);
                    }
                    if (ToggleCommand.slayerCountTotal) {
                        drop20 = nf.format(WolfTracker.wheelsSession);
                    } else {
                        drop20 = nf.format(WolfTracker.wheelsDropsSession) + " times";
                    }

                    dropsText = EnumChatFormatting.GOLD + "Svens Killed:\n" +
                            EnumChatFormatting.GREEN + "Wolf Teeth:\n" +
                            EnumChatFormatting.BLUE + "Hamster Wheels:\n" +
                            EnumChatFormatting.AQUA + "Spirit Runes:\n" +
                            EnumChatFormatting.WHITE + "Critical VI Books:\n" +
                            EnumChatFormatting.DARK_AQUA + "Furballs:\n" +
                            EnumChatFormatting.DARK_RED + "Red Claw Eggs:\n" +
                            EnumChatFormatting.GOLD + "Couture Runes:\n" +
                            EnumChatFormatting.AQUA + "Grizzly Baits:\n" +
                            EnumChatFormatting.DARK_PURPLE + "Overfluxes:\n" +
                            EnumChatFormatting.AQUA + "Time Since RNG:\n" +
                            EnumChatFormatting.AQUA + "Bosses Since RNG:";
                    countText = EnumChatFormatting.GOLD + nf.format(WolfTracker.svensSession) + "\n" +
                            EnumChatFormatting.GREEN + nf.format(WolfTracker.teethSession) + "\n" +
                            EnumChatFormatting.BLUE + drop20 + "\n" +
                            EnumChatFormatting.AQUA + WolfTracker.spiritsSession + "\n" +
                            EnumChatFormatting.WHITE + WolfTracker.booksSession + "\n" +
                            EnumChatFormatting.DARK_AQUA + WolfTracker.furballsSession + "\n" +
                            EnumChatFormatting.DARK_RED + WolfTracker.eggsSession + "\n" +
                            EnumChatFormatting.GOLD + WolfTracker.couturesSession + "\n" +
                            EnumChatFormatting.AQUA + WolfTracker.baitsSession + "\n" +
                            EnumChatFormatting.DARK_PURPLE + WolfTracker.fluxesSession + "\n" +
                            EnumChatFormatting.AQUA + timeBetween + "\n" +
                            EnumChatFormatting.AQUA + bossesBetween;
                    break;
                case "spider":
                    if (SpiderTracker.time == -1) {
                        timeBetween = "Never";
                    } else {
                        timeBetween = Utils.getTimeBetween(SpiderTracker.time, timeNow);
                    }
                    if (SpiderTracker.bosses == -1) {
                        bossesBetween = "Never";
                    } else {
                        bossesBetween = nf.format(SpiderTracker.bosses);
                    }
                    if (ToggleCommand.slayerCountTotal) {
                        drop20 = nf.format(SpiderTracker.TAP);
                    } else {
                        drop20 = nf.format(SpiderTracker.TAPDrops) + " times";
                    }

                    dropsText = EnumChatFormatting.GOLD + "Tarantulas Killed:\n" +
                            EnumChatFormatting.GREEN + "Tarantula Webs:\n" +
                            EnumChatFormatting.DARK_GREEN + "Arrow Poison:\n" +
                            EnumChatFormatting.DARK_GRAY + "Bite Runes:\n" +
                            EnumChatFormatting.WHITE + "Bane VI Books:\n" +
                            EnumChatFormatting.AQUA + "Spider Catalysts:\n" +
                            EnumChatFormatting.DARK_PURPLE + "Tarantula Talismans:\n" +
                            EnumChatFormatting.LIGHT_PURPLE + "Fly Swatters:\n" +
                            EnumChatFormatting.GOLD + "Digested Mosquitos:\n" +
                            EnumChatFormatting.AQUA + "Time Since RNG:\n" +
                            EnumChatFormatting.AQUA + "Bosses Since RNG:";
                    countText = EnumChatFormatting.GOLD + nf.format(SpiderTracker.tarantulas) + "\n" +
                            EnumChatFormatting.GREEN + nf.format(SpiderTracker.webs) + "\n" +
                            EnumChatFormatting.DARK_GREEN + drop20 + "\n" +
                            EnumChatFormatting.DARK_GRAY + SpiderTracker.bites + "\n" +
                            EnumChatFormatting.WHITE + SpiderTracker.books + "\n" +
                            EnumChatFormatting.AQUA + SpiderTracker.catalysts + "\n" +
                            EnumChatFormatting.DARK_PURPLE + SpiderTracker.talismans + "\n" +
                            EnumChatFormatting.LIGHT_PURPLE + SpiderTracker.swatters + "\n" +
                            EnumChatFormatting.GOLD + SpiderTracker.mosquitos + "\n" +
                            EnumChatFormatting.AQUA + timeBetween + "\n" +
                            EnumChatFormatting.AQUA + bossesBetween;
                    break;
                case "spider_session":
                    if (SpiderTracker.timeSession == -1) {
                        timeBetween = "Never";
                    } else {
                        timeBetween = Utils.getTimeBetween(SpiderTracker.timeSession, timeNow);
                    }
                    if (SpiderTracker.bossesSession == -1) {
                        bossesBetween = "Never";
                    } else {
                        bossesBetween = nf.format(SpiderTracker.bossesSession);
                    }
                    if (ToggleCommand.slayerCountTotal) {
                        drop20 = nf.format(SpiderTracker.TAPSession);
                    } else {
                        drop20 = nf.format(SpiderTracker.TAPDropsSession) + " times";
                    }

                    dropsText = EnumChatFormatting.GOLD + "Tarantulas Killed:\n" +
                            EnumChatFormatting.GREEN + "Tarantula Webs:\n" +
                            EnumChatFormatting.DARK_GREEN + "Arrow Poison:\n" +
                            EnumChatFormatting.DARK_GRAY + "Bite Runes:\n" +
                            EnumChatFormatting.WHITE + "Bane VI Books:\n" +
                            EnumChatFormatting.AQUA + "Spider Catalysts:\n" +
                            EnumChatFormatting.DARK_PURPLE + "Tarantula Talismans:\n" +
                            EnumChatFormatting.LIGHT_PURPLE + "Fly Swatters:\n" +
                            EnumChatFormatting.GOLD + "Digested Mosquitos:\n" +
                            EnumChatFormatting.AQUA + "Time Since RNG:\n" +
                            EnumChatFormatting.AQUA + "Bosses Since RNG:";
                    countText = EnumChatFormatting.GOLD + nf.format(SpiderTracker.tarantulasSession) + "\n" +
                            EnumChatFormatting.GREEN + nf.format(SpiderTracker.websSession) + "\n" +
                            EnumChatFormatting.DARK_GREEN + drop20 + "\n" +
                            EnumChatFormatting.DARK_GRAY + SpiderTracker.bitesSession + "\n" +
                            EnumChatFormatting.WHITE + SpiderTracker.booksSession + "\n" +
                            EnumChatFormatting.AQUA + SpiderTracker.catalystsSession + "\n" +
                            EnumChatFormatting.DARK_PURPLE + SpiderTracker.talismansSession + "\n" +
                            EnumChatFormatting.LIGHT_PURPLE + SpiderTracker.swattersSession + "\n" +
                            EnumChatFormatting.GOLD + SpiderTracker.mosquitosSession + "\n" +
                            EnumChatFormatting.AQUA + timeBetween + "\n" +
                            EnumChatFormatting.AQUA + bossesBetween;
                    break;
                case "zombie":
                    if (ZombieTracker.time == -1) {
                        timeBetween = "Never";
                    } else {
                        timeBetween = Utils.getTimeBetween(ZombieTracker.time, timeNow);
                    }
                    if (ZombieTracker.bosses == -1) {
                        bossesBetween = "Never";
                    } else {
                        bossesBetween = nf.format(ZombieTracker.bosses);
                    }
                    if (ToggleCommand.slayerCountTotal) {
                        drop20 = nf.format(ZombieTracker.foulFlesh);
                    } else {
                        drop20 = nf.format(ZombieTracker.foulFleshDrops) + " times";
                    }

                    dropsText = EnumChatFormatting.GOLD + "Revs Killed:\n" +
                            EnumChatFormatting.GREEN + "Revenant Flesh:\n" +
                            EnumChatFormatting.GREEN + "Revenant Viscera:\n" +
                            EnumChatFormatting.BLUE + "Foul Flesh:\n" +
                            EnumChatFormatting.DARK_GREEN + "Pestilence Runes:\n" +
                            EnumChatFormatting.WHITE + "Smite VI Books:\n" +
                            EnumChatFormatting.WHITE + "Smite VII Books:\n" +
                            EnumChatFormatting.AQUA + "Undead Catalysts:\n" +
                            EnumChatFormatting.DARK_PURPLE + "Beheaded Horrors:\n" +
                            EnumChatFormatting.RED + "Revenant Catalysts:\n" +
                            EnumChatFormatting.DARK_GREEN + "Snake Runes:\n" +
                            EnumChatFormatting.GOLD + "Scythe Blades:\n" +
                            EnumChatFormatting.RED + "Shard of Shreddeds:\n" +
                            EnumChatFormatting.RED + "Warden Hearts:\n" +
                            EnumChatFormatting.AQUA + "Time Since RNG:\n" +
                            EnumChatFormatting.AQUA + "Bosses Since RNG:";
                    countText = EnumChatFormatting.GOLD + nf.format(ZombieTracker.revs) + "\n" +
                            EnumChatFormatting.GREEN + nf.format(ZombieTracker.revFlesh) + "\n" +
                            EnumChatFormatting.GREEN + nf.format(ZombieTracker.revViscera) + "\n" +
                            EnumChatFormatting.BLUE + drop20 + "\n" +
                            EnumChatFormatting.DARK_GREEN + ZombieTracker.pestilences + "\n" +
                            EnumChatFormatting.WHITE + ZombieTracker.books + "\n" +
                            EnumChatFormatting.WHITE + ZombieTracker.booksT7 + "\n" +
                            EnumChatFormatting.AQUA + ZombieTracker.undeadCatas + "\n" +
                            EnumChatFormatting.DARK_PURPLE + ZombieTracker.beheadeds + "\n" +
                            EnumChatFormatting.RED + ZombieTracker.revCatas + "\n" +
                            EnumChatFormatting.DARK_GREEN + ZombieTracker.snakes + "\n" +
                            EnumChatFormatting.GOLD + ZombieTracker.scythes + "\n" +
                            EnumChatFormatting.RED + ZombieTracker.shards + "\n" +
                            EnumChatFormatting.RED + ZombieTracker.wardenHearts + "\n" +
                            EnumChatFormatting.AQUA + timeBetween + "\n" +
                            EnumChatFormatting.AQUA + bossesBetween;
                    break;
                case "zombie_session":
                    if (ZombieTracker.timeSession == -1) {
                        timeBetween = "Never";
                    } else {
                        timeBetween = Utils.getTimeBetween(ZombieTracker.timeSession, timeNow);
                    }
                    if (ZombieTracker.bossesSession == -1) {
                        bossesBetween = "Never";
                    } else {
                        bossesBetween = nf.format(ZombieTracker.bossesSession);
                    }
                    if (ToggleCommand.slayerCountTotal) {
                        drop20 = nf.format(ZombieTracker.foulFleshSession);
                    } else {
                        drop20 = nf.format(ZombieTracker.foulFleshDropsSession) + " times";
                    }

                    dropsText = EnumChatFormatting.GOLD + "Revs Killed:\n" +
                            EnumChatFormatting.GREEN + "Revenant Flesh:\n" +
                            EnumChatFormatting.GREEN + "Revenant Viscera:\n" +
                            EnumChatFormatting.BLUE + "Foul Flesh:\n" +
                            EnumChatFormatting.DARK_GREEN + "Pestilence Runes:\n" +
                            EnumChatFormatting.WHITE + "Smite VI Books:\n" +
                            EnumChatFormatting.WHITE + "Smite VII Books:\n" +
                            EnumChatFormatting.AQUA + "Undead Catalysts:\n" +
                            EnumChatFormatting.DARK_PURPLE + "Beheaded Horrors:\n" +
                            EnumChatFormatting.RED + "Revenant Catalysts:\n" +
                            EnumChatFormatting.DARK_GREEN + "Snake Runes:\n" +
                            EnumChatFormatting.GOLD + "Scythe Blades:\n" +
                            EnumChatFormatting.RED + "Shard of Shreddeds:\n" +
                            EnumChatFormatting.RED + "Warden Hearts:\n" +
                            EnumChatFormatting.AQUA + "Time Since RNG:\n" +
                            EnumChatFormatting.AQUA + "Bosses Since RNG:";
                    countText = EnumChatFormatting.GOLD + nf.format(ZombieTracker.revsSession) + "\n" +
                            EnumChatFormatting.GREEN + nf.format(ZombieTracker.revFleshSession) + "\n" +
                            EnumChatFormatting.GREEN + nf.format(ZombieTracker.revVisceraSession) + "\n" +
                            EnumChatFormatting.BLUE + drop20 + "\n" +
                            EnumChatFormatting.DARK_GREEN + ZombieTracker.pestilencesSession + "\n" +
                            EnumChatFormatting.WHITE + ZombieTracker.booksSession + "\n" +
                            EnumChatFormatting.WHITE + ZombieTracker.booksT7Session + "\n" +
                            EnumChatFormatting.AQUA + ZombieTracker.undeadCatasSession + "\n" +
                            EnumChatFormatting.DARK_PURPLE + ZombieTracker.beheadedsSession + "\n" +
                            EnumChatFormatting.RED + ZombieTracker.revCatasSession + "\n" +
                            EnumChatFormatting.DARK_GREEN + ZombieTracker.snakesSession + "\n" +
                            EnumChatFormatting.GOLD + ZombieTracker.scythes + "\n" +
                            EnumChatFormatting.RED + ZombieTracker.shardsSession + "\n" +
                            EnumChatFormatting.RED + ZombieTracker.wardenHeartsSession + "\n" +
                            EnumChatFormatting.AQUA + timeBetween + "\n" +
                            EnumChatFormatting.AQUA + bossesBetween;
                    break;
                case "enderman":
                    if (EndermanTracker.time == -1) {
                        timeBetween = "Never";
                    } else {
                        timeBetween = Utils.getTimeBetween(EndermanTracker.time, timeNow);
                    }
                    if (EndermanTracker.bosses == -1) {
                        bossesBetween = "Never";
                    } else {
                        bossesBetween = nf.format(EndermanTracker.bosses);
                    }
                    if (ToggleCommand.slayerCountTotal) {
                        drop20 = nf.format(EndermanTracker.TAP);
                    } else {
                        drop20 = nf.format(EndermanTracker.TAPDrops) + " times";
                    }
                    
                    dropsText = EnumChatFormatting.GOLD + "Voidglooms Killed:\n" +
                            EnumChatFormatting.DARK_GRAY + "Null Spheres:\n" +
                            EnumChatFormatting.DARK_PURPLE + "Arrow Poison:\n" +
                            EnumChatFormatting.LIGHT_PURPLE + "Endersnake Runes:\n" +
                            EnumChatFormatting.DARK_GREEN + "Summoning Eyes:\n" +
                            EnumChatFormatting.AQUA + "Mana Steal Books:\n" +
                            EnumChatFormatting.BLUE + "Transmission Tuners:\n" +
                            EnumChatFormatting.YELLOW + "Null Atoms:\n" +
                            EnumChatFormatting.YELLOW + "Hazmat Endermen:\n" +
                            EnumChatFormatting.AQUA + "Espresso Machines:\n" +
                            EnumChatFormatting.WHITE + "Smarty Pants Books:\n" +
                            EnumChatFormatting.LIGHT_PURPLE + "End Runes:\n" +
                            EnumChatFormatting.RED + "Blood Chalices:\n" +
                            EnumChatFormatting.RED + "Sinful Dice:\n" +
                            EnumChatFormatting.DARK_PURPLE + "Artifact Upgrader:\n" +
                            EnumChatFormatting.DARK_PURPLE + "Enderman Skins:\n" +
                            EnumChatFormatting.GRAY + "Enchant Runes:\n" +
                            EnumChatFormatting.GOLD + "Etherwarp Mergers:\n" +
                            EnumChatFormatting.GOLD + "Judgement Cores:\n" +
                            EnumChatFormatting.RED + "Ender Slayer Books:\n" +
                            EnumChatFormatting.AQUA + "Time Since RNG:\n" +
                            EnumChatFormatting.AQUA + "Bosses Since RNG:";
                    countText = EnumChatFormatting.GOLD + nf.format(EndermanTracker.voidglooms) + "\n" +
                            EnumChatFormatting.DARK_GRAY + nf.format(EndermanTracker.nullSpheres) + "\n" +
                            EnumChatFormatting.DARK_PURPLE + drop20 + "\n" +
                            EnumChatFormatting.LIGHT_PURPLE + EndermanTracker.endersnakes + "\n" +
                            EnumChatFormatting.DARK_GREEN + EndermanTracker.summoningEyes + "\n" +
                            EnumChatFormatting.AQUA + EndermanTracker.manaBooks + "\n" +
                            EnumChatFormatting.BLUE + EndermanTracker.tuners + "\n" +
                            EnumChatFormatting.YELLOW + EndermanTracker.atoms + "\n" +
                            EnumChatFormatting.YELLOW + EndermanTracker.hazmats + "\n" +
                            EnumChatFormatting.AQUA + EndermanTracker.espressoMachines + "\n" +
                            EnumChatFormatting.WHITE + EndermanTracker.smartyBooks + "\n" +
                            EnumChatFormatting.LIGHT_PURPLE + EndermanTracker.endRunes + "\n" +
                            EnumChatFormatting.RED + EndermanTracker.chalices + "\n" +
                            EnumChatFormatting.RED + EndermanTracker.dice + "\n" +
                            EnumChatFormatting.DARK_PURPLE + EndermanTracker.artifacts + "\n" +
                            EnumChatFormatting.DARK_PURPLE + EndermanTracker.skins + "\n" +
                            EnumChatFormatting.GRAY + EndermanTracker.enchantRunes + "\n" +
                            EnumChatFormatting.GOLD + EndermanTracker.mergers + "\n" +
                            EnumChatFormatting.GOLD + EndermanTracker.cores + "\n" +
                            EnumChatFormatting.RED + EndermanTracker.enderBooks + "\n" +
                            EnumChatFormatting.AQUA + timeBetween + "\n" +
                            EnumChatFormatting.AQUA + bossesBetween;
                    break;
                case "enderman_session":
                    if (EndermanTracker.timeSession == -1) {
                        timeBetween = "Never";
                    } else {
                        timeBetween = Utils.getTimeBetween(EndermanTracker.timeSession, timeNow);
                    }
                    if (EndermanTracker.bossesSession == -1) {
                        bossesBetween = "Never";
                    } else {
                        bossesBetween = nf.format(EndermanTracker.bossesSession);
                    }
                    if (ToggleCommand.slayerCountTotal) {
                        drop20 = nf.format(EndermanTracker.TAPSession);
                    } else {
                        drop20 = nf.format(EndermanTracker.TAPDropsSession) + " times";
                    }

                    dropsText = EnumChatFormatting.GOLD + "Voidglooms Killed:\n" +
                            EnumChatFormatting.DARK_GRAY + "Null Spheres:\n" +
                            EnumChatFormatting.DARK_PURPLE + "Arrow Poison:\n" +
                            EnumChatFormatting.LIGHT_PURPLE + "Endersnake Runes:\n" +
                            EnumChatFormatting.DARK_GREEN + "Summoning Eyes:\n" +
                            EnumChatFormatting.AQUA + "Mana Steal Books:\n" +
                            EnumChatFormatting.BLUE + "Transmission Tuners:\n" +
                            EnumChatFormatting.YELLOW + "Null Atoms:\n" +
                            EnumChatFormatting.YELLOW + "Hazmat Endermen:\n" +
                            EnumChatFormatting.AQUA + "Espresso Machines:\n" +
                            EnumChatFormatting.WHITE + "Smarty Pants Books:\n" +
                            EnumChatFormatting.LIGHT_PURPLE + "End Runes:\n" +
                            EnumChatFormatting.RED + "Blood Chalices:\n" +
                            EnumChatFormatting.RED + "Sinful Dice:\n" +
                            EnumChatFormatting.DARK_PURPLE + "Artifact Upgrader:\n" +
                            EnumChatFormatting.DARK_PURPLE + "Enderman Skins:\n" +
                            EnumChatFormatting.GRAY + "Enchant Runes:\n" +
                            EnumChatFormatting.GOLD + "Etherwarp Mergers:\n" +
                            EnumChatFormatting.GOLD + "Judgement Cores:\n" +
                            EnumChatFormatting.RED + "Ender Slayer Books:\n" +
                            EnumChatFormatting.AQUA + "Time Since RNG:\n" +
                            EnumChatFormatting.AQUA + "Bosses Since RNG:";
                    countText = EnumChatFormatting.GOLD + nf.format(EndermanTracker.voidgloomsSession) + "\n" +
                            EnumChatFormatting.DARK_GRAY + nf.format(EndermanTracker.nullSpheresSession) + "\n" +
                            EnumChatFormatting.DARK_PURPLE + drop20 + "\n" +
                            EnumChatFormatting.LIGHT_PURPLE + EndermanTracker.endersnakesSession + "\n" +
                            EnumChatFormatting.DARK_GREEN + EndermanTracker.summoningEyesSession + "\n" +
                            EnumChatFormatting.AQUA + EndermanTracker.manaBooksSession + "\n" +
                            EnumChatFormatting.BLUE + EndermanTracker.tunersSession + "\n" +
                            EnumChatFormatting.YELLOW + EndermanTracker.atomsSession + "\n" +
                            EnumChatFormatting.YELLOW + EndermanTracker.hazmatsSession + "\n" +
                            EnumChatFormatting.AQUA + EndermanTracker.espressoMachinesSession + "\n" +
                            EnumChatFormatting.WHITE + EndermanTracker.smartyBooksSession + "\n" +
                            EnumChatFormatting.LIGHT_PURPLE + EndermanTracker.endRunesSession + "\n" +
                            EnumChatFormatting.RED + EndermanTracker.chalicesSession + "\n" +
                            EnumChatFormatting.RED + EndermanTracker.diceSession + "\n" +
                            EnumChatFormatting.DARK_PURPLE + EndermanTracker.artifactsSession + "\n" +
                            EnumChatFormatting.DARK_PURPLE + EndermanTracker.skinsSession + "\n" +
                            EnumChatFormatting.GRAY + EndermanTracker.enchantRunesSession + "\n" +
                            EnumChatFormatting.GOLD + EndermanTracker.mergersSession + "\n" +
                            EnumChatFormatting.GOLD + EndermanTracker.coresSession + "\n" +
                            EnumChatFormatting.RED + EndermanTracker.enderBooksSession + "\n" +
                            EnumChatFormatting.AQUA + timeBetween + "\n" +
                            EnumChatFormatting.AQUA + bossesBetween;
                    break;
                case "blaze":
                    if (BlazeTracker.time == -1) {
                        timeBetween = "Never";
                    } else {
                        timeBetween = Utils.getTimeBetween(BlazeTracker.time, timeNow);
                    }
                    if (BlazeTracker.bosses == -1) {
                        bossesBetween = "Never";
                    } else {
                        bossesBetween = nf.format(BlazeTracker.bosses);
                    }

                    dropsText = EnumChatFormatting.GOLD + "Demonlords Killed:\n" +
                            EnumChatFormatting.GRAY + "Derelict Ashes:\n" +
                            EnumChatFormatting.RED + "Lavatear Runes:\n" +
                            EnumChatFormatting.AQUA + "Splash Potions:\n" +
                            EnumChatFormatting.DARK_RED + "Magma Arrows:\n" +
                            EnumChatFormatting.DARK_AQUA + "Mana Disintegrators:\n" +
                            EnumChatFormatting.LIGHT_PURPLE + "Scorched Books:\n" +
                            EnumChatFormatting.WHITE + "Kelvin Inverters:\n" +
                            EnumChatFormatting.BLUE + "Blaze Rod Distillates:\n" +
                            EnumChatFormatting.BLUE + "Glowstone Distillates:\n" +
                            EnumChatFormatting.BLUE + "Magma Distillates:\n" +
                            EnumChatFormatting.BLUE + "Wart Distillates:\n" +
                            EnumChatFormatting.BLUE + "Gabagool Distillates:\n" +
                            EnumChatFormatting.RED + "Power Crystals:\n" +
                            EnumChatFormatting.RED + "Fire Aspect Books:\n" +
                            EnumChatFormatting.GOLD + "Fiery Burst Runes:\n" +
                            EnumChatFormatting.WHITE + "Opal Gems:\n" +
                            EnumChatFormatting.RED + "Archfiend Dice:\n" +
                            EnumChatFormatting.LIGHT_PURPLE + "Duplex Books:\n" +
                            EnumChatFormatting.GOLD + "High Class Dice:\n" +
                            EnumChatFormatting.GOLD + "Engineering Plans:\n" +
                            EnumChatFormatting.GOLD + "Subzero Inverters:\n" +
                            EnumChatFormatting.AQUA + "Time Since RNG:\n" +
                            EnumChatFormatting.AQUA + "Bosses Since RNG:";
                    countText = EnumChatFormatting.GOLD + nf.format(BlazeTracker.demonlords) + "\n" +
                            EnumChatFormatting.GRAY + nf.format(BlazeTracker.derelictAshes) + "\n" +
                            EnumChatFormatting.RED + nf.format(BlazeTracker.lavatearRunes) + "\n" +
                            EnumChatFormatting.AQUA + nf.format(BlazeTracker.splashPotions) + "\n" +
                            EnumChatFormatting.DARK_RED + nf.format(BlazeTracker.magmaArrows) + "\n" +
                            EnumChatFormatting.DARK_AQUA + nf.format(BlazeTracker.manaDisintegrators) + "\n" +
                            EnumChatFormatting.LIGHT_PURPLE + nf.format(BlazeTracker.scorchedBooks) + "\n" +
                            EnumChatFormatting.WHITE + nf.format(BlazeTracker.kelvinInverters) + "\n" +
                            EnumChatFormatting.BLUE + nf.format(BlazeTracker.blazeRodDistillates) + "\n" +
                            EnumChatFormatting.BLUE + nf.format(BlazeTracker.glowstoneDistillates) + "\n" +
                            EnumChatFormatting.BLUE + nf.format(BlazeTracker.magmaCreamDistillates) + "\n" +
                            EnumChatFormatting.BLUE + nf.format(BlazeTracker.netherWartDistillates) + "\n" +
                            EnumChatFormatting.BLUE + nf.format(BlazeTracker.gabagoolDistillates) + "\n" +
                            EnumChatFormatting.RED + nf.format(BlazeTracker.scorchedPowerCrystals) + "\n" +
                            EnumChatFormatting.RED + nf.format(BlazeTracker.fireAspectBooks) + "\n" +
                            EnumChatFormatting.GOLD + nf.format(BlazeTracker.fieryBurstRunes) + "\n" +
                            EnumChatFormatting.WHITE + nf.format(BlazeTracker.opalGems) + "\n" +
                            EnumChatFormatting.RED + nf.format(BlazeTracker.archfiendDice) + "\n" +
                            EnumChatFormatting.LIGHT_PURPLE + nf.format(BlazeTracker.duplexBooks) + "\n" +
                            EnumChatFormatting.GOLD + nf.format(BlazeTracker.highClassArchfiendDice) + "\n" +
                            EnumChatFormatting.GOLD + nf.format(BlazeTracker.engineeringPlans) + "\n" +
                            EnumChatFormatting.GOLD + nf.format(BlazeTracker.subzeroInverters) + "\n" +
                            EnumChatFormatting.AQUA + timeBetween + "\n" +
                            EnumChatFormatting.AQUA + bossesBetween;
                    break;
                case "blaze_session":
                    if (BlazeTracker.timeSession == -1) {
                        timeBetween = "Never";
                    } else {
                        timeBetween = Utils.getTimeBetween(BlazeTracker.timeSession, timeNow);
                    }
                    if (BlazeTracker.bossesSession == -1) {
                        bossesBetween = "Never";
                    } else {
                        bossesBetween = nf.format(BlazeTracker.bossesSession);
                    }

                    dropsText = EnumChatFormatting.GOLD + "Demonlords Killed:\n" +
                            EnumChatFormatting.GRAY + "Derelict Ashes:\n" +
                            EnumChatFormatting.RED + "Lavatear Runes:\n" +
                            EnumChatFormatting.AQUA + "Splash Potions:\n" +
                            EnumChatFormatting.DARK_RED + "Magma Arrows:\n" +
                            EnumChatFormatting.DARK_AQUA + "Mana Disintegrators:\n" +
                            EnumChatFormatting.LIGHT_PURPLE + "Scorched Books:\n" +
                            EnumChatFormatting.WHITE + "Kelvin Inverters:\n" +
                            EnumChatFormatting.BLUE + "Blaze Rod Distillates:\n" +
                            EnumChatFormatting.BLUE + "Glowstone Distillates:\n" +
                            EnumChatFormatting.BLUE + "Magma Distillates:\n" +
                            EnumChatFormatting.BLUE + "Wart Distillates:\n" +
                            EnumChatFormatting.BLUE + "Gabagool Distillates:\n" +
                            EnumChatFormatting.RED + "Power Crystals:\n" +
                            EnumChatFormatting.RED + "Fire Aspect Books:\n" +
                            EnumChatFormatting.GOLD + "Fiery Burst Runes:\n" +
                            EnumChatFormatting.WHITE + "Opal Gems:\n" +
                            EnumChatFormatting.RED + "Archfiend Dice:\n" +
                            EnumChatFormatting.LIGHT_PURPLE + "Duplex Books:\n" +
                            EnumChatFormatting.GOLD + "High Class Dice:\n" +
                            EnumChatFormatting.GOLD + "Engineering Plans:\n" +
                            EnumChatFormatting.GOLD + "Subzero Inverters:\n" +
                            EnumChatFormatting.AQUA + "Time Since RNG:\n" +
                            EnumChatFormatting.AQUA + "Bosses Since RNG:";
                    countText = EnumChatFormatting.GOLD + nf.format(BlazeTracker.demonlordsSession) + "\n" +
                            EnumChatFormatting.GRAY + nf.format(BlazeTracker.derelictAshesSession) + "\n" +
                            EnumChatFormatting.RED + nf.format(BlazeTracker.lavatearRunesSession) + "\n" +
                            EnumChatFormatting.AQUA + nf.format(BlazeTracker.splashPotionsSession) + "\n" +
                            EnumChatFormatting.DARK_RED + nf.format(BlazeTracker.magmaArrowsSession) + "\n" +
                            EnumChatFormatting.DARK_AQUA + nf.format(BlazeTracker.manaDisintegratorsSession) + "\n" +
                            EnumChatFormatting.LIGHT_PURPLE + nf.format(BlazeTracker.scorchedBooksSession) + "\n" +
                            EnumChatFormatting.WHITE + nf.format(BlazeTracker.kelvinInvertersSession) + "\n" +
                            EnumChatFormatting.BLUE + nf.format(BlazeTracker.blazeRodDistillatesSession) + "\n" +
                            EnumChatFormatting.BLUE + nf.format(BlazeTracker.glowstoneDistillatesSession) + "\n" +
                            EnumChatFormatting.BLUE + nf.format(BlazeTracker.magmaCreamDistillatesSession) + "\n" +
                            EnumChatFormatting.BLUE + nf.format(BlazeTracker.netherWartDistillatesSession) + "\n" +
                            EnumChatFormatting.BLUE + nf.format(BlazeTracker.gabagoolDistillatesSession) + "\n" +
                            EnumChatFormatting.RED + nf.format(BlazeTracker.scorchedPowerCrystalsSession) + "\n" +
                            EnumChatFormatting.RED + nf.format(BlazeTracker.fireAspectBooksSession) + "\n" +
                            EnumChatFormatting.GOLD + nf.format(BlazeTracker.fieryBurstRunesSession) + "\n" +
                            EnumChatFormatting.WHITE + nf.format(BlazeTracker.opalGemsSession) + "\n" +
                            EnumChatFormatting.RED + nf.format(BlazeTracker.archfiendDiceSession) + "\n" +
                            EnumChatFormatting.LIGHT_PURPLE + nf.format(BlazeTracker.duplexBooksSession) + "\n" +
                            EnumChatFormatting.GOLD + nf.format(BlazeTracker.highClassArchfiendDiceSession) + "\n" +
                            EnumChatFormatting.GOLD + nf.format(BlazeTracker.engineeringPlansSession) + "\n" +
                            EnumChatFormatting.GOLD + nf.format(BlazeTracker.subzeroInvertersSession) + "\n" +
                            EnumChatFormatting.AQUA + timeBetween + "\n" +
                            EnumChatFormatting.AQUA + bossesBetween;
                    break;
                case "fishing":
                    if (FishingTracker.empTime == -1) {
                        timeBetween = "Never";
                    } else {
                        timeBetween = Utils.getTimeBetween(FishingTracker.empTime, timeNow);
                    }
                    if (FishingTracker.empSCs == -1) {
                        bossesBetween = "Never";
                    } else {
                        bossesBetween = nf.format(FishingTracker.empSCs);
                    }

                    dropsText = EnumChatFormatting.AQUA + "Creatures Caught:\n" +
                            EnumChatFormatting.AQUA + "Fishing Milestone:\n" +
                            EnumChatFormatting.GOLD + "Good Catches:\n" +
                            EnumChatFormatting.DARK_PURPLE + "Great Catches:\n" +
                            EnumChatFormatting.GRAY + "Squids:\n" +
                            EnumChatFormatting.GREEN + "Sea Walkers:\n" +
                            EnumChatFormatting.DARK_GRAY + "Night Squids:\n" +
                            EnumChatFormatting.DARK_AQUA + "Sea Guardians:\n" +
                            EnumChatFormatting.BLUE + "Sea Witches:\n" +
                            EnumChatFormatting.GREEN + "Sea Archers:";
                    countText = EnumChatFormatting.AQUA + nf.format(FishingTracker.seaCreatures) + "\n" +
                            EnumChatFormatting.AQUA + nf.format(FishingTracker.fishingMilestone) + "\n" +
                            EnumChatFormatting.GOLD + nf.format(FishingTracker.goodCatches) + "\n" +
                            EnumChatFormatting.DARK_PURPLE + nf.format(FishingTracker.greatCatches) + "\n" +
                            EnumChatFormatting.GRAY + nf.format(FishingTracker.squids) + "\n" +
                            EnumChatFormatting.GREEN + nf.format(FishingTracker.seaWalkers) + "\n" +
                            EnumChatFormatting.DARK_GRAY + nf.format(FishingTracker.nightSquids) + "\n" +
                            EnumChatFormatting.DARK_AQUA + nf.format(FishingTracker.seaGuardians) + "\n" +
                            EnumChatFormatting.BLUE + nf.format(FishingTracker.seaWitches) + "\n" +
                            EnumChatFormatting.GREEN + nf.format(FishingTracker.seaArchers);
                    // Seperated to save vertical space
                    dropsTextTwo = EnumChatFormatting.GREEN + "Monster of Deeps:\n" +
                            EnumChatFormatting.YELLOW + "Catfishes:\n" +
                            EnumChatFormatting.GOLD + "Carrot Kings:\n" +
                            EnumChatFormatting.GRAY + "Sea Leeches:\n" +
                            EnumChatFormatting.DARK_PURPLE + "Guardian Defenders:\n" +
                            EnumChatFormatting.DARK_PURPLE + "Deep Sea Protectors:\n" +
                            EnumChatFormatting.GOLD + "Hydras:\n" +
                            EnumChatFormatting.GOLD + "Sea Emperors:\n" +
                            EnumChatFormatting.AQUA + "Time Since Emp:\n" +
                            EnumChatFormatting.AQUA + "Creatures Since Emp:";
                    countTextTwo = EnumChatFormatting.GREEN + nf.format(FishingTracker.monsterOfTheDeeps) + "\n" +
                            EnumChatFormatting.YELLOW + nf.format(FishingTracker.catfishes) + "\n" +
                            EnumChatFormatting.GOLD + nf.format(FishingTracker.carrotKings) + "\n" +
                            EnumChatFormatting.GRAY + nf.format(FishingTracker.seaLeeches) + "\n" +
                            EnumChatFormatting.DARK_PURPLE + nf.format(FishingTracker.guardianDefenders) + "\n" +
                            EnumChatFormatting.DARK_PURPLE + nf.format(FishingTracker.deepSeaProtectors) + "\n" +
                            EnumChatFormatting.GOLD + nf.format(FishingTracker.hydras) + "\n" +
                            EnumChatFormatting.GOLD + nf.format(FishingTracker.seaEmperors) + "\n" +
                            EnumChatFormatting.AQUA + timeBetween + "\n" +
                            EnumChatFormatting.AQUA + bossesBetween;

                    if (ToggleCommand.splitFishing) {
                        new TextRenderer(mc, dropsTextTwo, (int) (MoveCommand.displayXY[0] + (160 * ScaleCommand.displayScale)), MoveCommand.displayXY[1], ScaleCommand.displayScale);
                        new TextRenderer(mc, countTextTwo, (int) (MoveCommand.displayXY[0] + (270 * ScaleCommand.displayScale)), MoveCommand.displayXY[1], ScaleCommand.displayScale);
                    } else {
                        dropsText += "\n" + dropsTextTwo;
                        countText += "\n" + countTextTwo;
                    }
                    break;
                case "fishing_session":
                    if (FishingTracker.empTimeSession == -1) {
                        timeBetween = "Never";
                    } else {
                        timeBetween = Utils.getTimeBetween(FishingTracker.empTimeSession, timeNow);
                    }
                    if (FishingTracker.empSCsSession == -1) {
                        bossesBetween = "Never";
                    } else {
                        bossesBetween = nf.format(FishingTracker.empSCsSession);
                    }

                    dropsText = EnumChatFormatting.AQUA + "Creatures Caught:\n" +
                            EnumChatFormatting.AQUA + "Fishing Milestone:\n" +
                            EnumChatFormatting.GOLD + "Good Catches:\n" +
                            EnumChatFormatting.DARK_PURPLE + "Great Catches:\n" +
                            EnumChatFormatting.GRAY + "Squids:\n" +
                            EnumChatFormatting.GREEN + "Sea Walkers:\n" +
                            EnumChatFormatting.DARK_GRAY + "Night Squids:\n" +
                            EnumChatFormatting.DARK_AQUA + "Sea Guardians:\n" +
                            EnumChatFormatting.BLUE + "Sea Witches:\n" +
                            EnumChatFormatting.GREEN + "Sea Archers:";
                    countText = EnumChatFormatting.AQUA + nf.format(FishingTracker.seaCreaturesSession) + "\n" +
                            EnumChatFormatting.AQUA + nf.format(FishingTracker.fishingMilestoneSession) + "\n" +
                            EnumChatFormatting.GOLD + nf.format(FishingTracker.goodCatchesSession) + "\n" +
                            EnumChatFormatting.DARK_PURPLE + nf.format(FishingTracker.greatCatchesSession) + "\n" +
                            EnumChatFormatting.GRAY + nf.format(FishingTracker.squidsSession) + "\n" +
                            EnumChatFormatting.GREEN + nf.format(FishingTracker.seaWalkersSession) + "\n" +
                            EnumChatFormatting.DARK_GRAY + nf.format(FishingTracker.nightSquidsSession) + "\n" +
                            EnumChatFormatting.DARK_AQUA + nf.format(FishingTracker.seaGuardiansSession) + "\n" +
                            EnumChatFormatting.BLUE + nf.format(FishingTracker.seaWitchesSession) + "\n" +
                            EnumChatFormatting.GREEN + nf.format(FishingTracker.seaArchersSession);
                    // Seperated to save vertical space
                    dropsTextTwo = EnumChatFormatting.GREEN + "Monster of Deeps:\n" +
                            EnumChatFormatting.YELLOW + "Catfishes:\n" +
                            EnumChatFormatting.GOLD + "Carrot Kings:\n" +
                            EnumChatFormatting.GRAY + "Sea Leeches:\n" +
                            EnumChatFormatting.DARK_PURPLE + "Guardian Defenders:\n" +
                            EnumChatFormatting.DARK_PURPLE + "Deep Sea Protectors:\n" +
                            EnumChatFormatting.GOLD + "Hydras:\n" +
                            EnumChatFormatting.GOLD + "Sea Emperors:\n" +
                            EnumChatFormatting.AQUA + "Time Since Emp:\n" +
                            EnumChatFormatting.AQUA + "Creatures Since Emp:";
                    countTextTwo = EnumChatFormatting.GREEN + nf.format(FishingTracker.monsterOfTheDeepsSession) + "\n" +
                            EnumChatFormatting.YELLOW + nf.format(FishingTracker.catfishesSession) + "\n" +
                            EnumChatFormatting.GOLD + nf.format(FishingTracker.carrotKingsSession) + "\n" +
                            EnumChatFormatting.GRAY + nf.format(FishingTracker.seaLeechesSession) + "\n" +
                            EnumChatFormatting.DARK_PURPLE + nf.format(FishingTracker.guardianDefendersSession) + "\n" +
                            EnumChatFormatting.DARK_PURPLE + nf.format(FishingTracker.deepSeaProtectorsSession) + "\n" +
                            EnumChatFormatting.GOLD + nf.format(FishingTracker.hydrasSession) + "\n" +
                            EnumChatFormatting.GOLD + nf.format(FishingTracker.seaEmperorsSession) + "\n" +
                            EnumChatFormatting.AQUA + timeBetween + "\n" +
                            EnumChatFormatting.AQUA + bossesBetween;

                    if (ToggleCommand.splitFishing) {
                        new TextRenderer(mc, dropsTextTwo, (int) (MoveCommand.displayXY[0] + (160 * ScaleCommand.displayScale)), MoveCommand.displayXY[1], ScaleCommand.displayScale);
                        new TextRenderer(mc, countTextTwo, (int) (MoveCommand.displayXY[0] + (270 * ScaleCommand.displayScale)), MoveCommand.displayXY[1], ScaleCommand.displayScale);
                    } else {
                        dropsText += "\n" + dropsTextTwo;
                        countText += "\n" + countTextTwo;
                    }
                    break;
                case "fishing_winter":
                    if (FishingTracker.yetiTime == -1) {
                        timeBetween = "Never";
                    } else {
                        timeBetween = Utils.getTimeBetween(FishingTracker.yetiTime, timeNow);
                    }
                    if (FishingTracker.yetiSCs == -1) {
                        bossesBetween = "Never";
                    } else {
                        bossesBetween = nf.format(FishingTracker.yetiSCs);
                    }

                    dropsText = EnumChatFormatting.AQUA + "Creatures Caught:\n" +
                            EnumChatFormatting.AQUA + "Fishing Milestone:\n" +
                            EnumChatFormatting.GOLD + "Good Catches:\n" +
                            EnumChatFormatting.DARK_PURPLE + "Great Catches:\n" +
                            EnumChatFormatting.AQUA + "Frozen Steves:\n" +
                            EnumChatFormatting.WHITE + "Snowmans:\n" +
                            EnumChatFormatting.DARK_GREEN + "Grinches:\n" +
                            EnumChatFormatting.GOLD + "Yetis:\n" +
                            EnumChatFormatting.AQUA + "Time Since Yeti:\n" +
                            EnumChatFormatting.AQUA + "Creatures Since Yeti:";
                    countText = EnumChatFormatting.AQUA + nf.format(FishingTracker.seaCreatures) + "\n" +
                            EnumChatFormatting.AQUA + nf.format(FishingTracker.fishingMilestone) + "\n" +
                            EnumChatFormatting.GOLD + nf.format(FishingTracker.goodCatches) + "\n" +
                            EnumChatFormatting.DARK_PURPLE + nf.format(FishingTracker.greatCatches) + "\n" +
                            EnumChatFormatting.AQUA + nf.format(FishingTracker.frozenSteves) + "\n" +
                            EnumChatFormatting.WHITE + nf.format(FishingTracker.frostyTheSnowmans) + "\n" +
                            EnumChatFormatting.DARK_GREEN + nf.format(FishingTracker.grinches) + "\n" +
                            EnumChatFormatting.GOLD + nf.format(FishingTracker.yetis) + "\n" +
                            EnumChatFormatting.AQUA + timeBetween + "\n" +
                            EnumChatFormatting.AQUA + bossesBetween;
                    break;
                case "fishing_winter_session":
                    if (FishingTracker.yetiTimeSession == -1) {
                        timeBetween = "Never";
                    } else {
                        timeBetween = Utils.getTimeBetween(FishingTracker.yetiTimeSession, timeNow);
                    }
                    if (FishingTracker.yetiSCsSession == -1) {
                        bossesBetween = "Never";
                    } else {
                        bossesBetween = nf.format(FishingTracker.yetiSCsSession);
                    }

                    dropsText = EnumChatFormatting.AQUA + "Creatures Caught:\n" +
                            EnumChatFormatting.AQUA + "Fishing Milestone:\n" +
                            EnumChatFormatting.GOLD + "Good Catches:\n" +
                            EnumChatFormatting.DARK_PURPLE + "Great Catches:\n" +
                            EnumChatFormatting.AQUA + "Frozen Steves:\n" +
                            EnumChatFormatting.WHITE + "Snowmans:\n" +
                            EnumChatFormatting.DARK_GREEN + "Grinches:\n" +
                            EnumChatFormatting.GOLD + "Yetis:\n" +
                            EnumChatFormatting.AQUA + "Time Since Yeti:\n" +
                            EnumChatFormatting.AQUA + "Creatures Since Yeti:";
                    countText = EnumChatFormatting.AQUA + nf.format(FishingTracker.seaCreaturesSession) + "\n" +
                            EnumChatFormatting.AQUA + nf.format(FishingTracker.fishingMilestoneSession) + "\n" +
                            EnumChatFormatting.GOLD + nf.format(FishingTracker.goodCatchesSession) + "\n" +
                            EnumChatFormatting.DARK_PURPLE + nf.format(FishingTracker.greatCatchesSession) + "\n" +
                            EnumChatFormatting.AQUA + nf.format(FishingTracker.frozenStevesSession) + "\n" +
                            EnumChatFormatting.WHITE + nf.format(FishingTracker.frostyTheSnowmansSession) + "\n" +
                            EnumChatFormatting.DARK_GREEN + nf.format(FishingTracker.grinchesSession) + "\n" +
                            EnumChatFormatting.GOLD + nf.format(FishingTracker.yetisSession) + "\n" +
                            EnumChatFormatting.AQUA + timeBetween + "\n" +
                            EnumChatFormatting.AQUA + bossesBetween;
                    break;
                case "fishing_festival":
                    dropsText = EnumChatFormatting.AQUA + "Creatures Caught:\n" +
                            EnumChatFormatting.AQUA + "Fishing Milestone:\n" +
                            EnumChatFormatting.GOLD + "Good Catches:\n" +
                            EnumChatFormatting.DARK_PURPLE + "Great Catches:\n" +
                            EnumChatFormatting.LIGHT_PURPLE + "Nurse Sharks:\n" +
                            EnumChatFormatting.BLUE + "Blue Sharks:\n" +
                            EnumChatFormatting.GOLD + "Tiger Sharks:\n" +
                            EnumChatFormatting.WHITE + "Great White Sharks:";
                    countText = EnumChatFormatting.AQUA + nf.format(FishingTracker.seaCreatures) + "\n" +
                            EnumChatFormatting.AQUA + nf.format(FishingTracker.fishingMilestone) + "\n" +
                            EnumChatFormatting.GOLD + nf.format(FishingTracker.goodCatches) + "\n" +
                            EnumChatFormatting.DARK_PURPLE + nf.format(FishingTracker.greatCatches) + "\n" +
                            EnumChatFormatting.LIGHT_PURPLE + nf.format(FishingTracker.nurseSharks) + "\n" +
                            EnumChatFormatting.BLUE + nf.format(FishingTracker.blueSharks) + "\n" +
                            EnumChatFormatting.GOLD + nf.format(FishingTracker.tigerSharks) + "\n" +
                            EnumChatFormatting.WHITE + nf.format(FishingTracker.greatWhiteSharks);
                    break;
                case "fishing_festival_session":
                    dropsText = EnumChatFormatting.AQUA + "Creatures Caught:\n" +
                            EnumChatFormatting.AQUA + "Fishing Milestone:\n" +
                            EnumChatFormatting.GOLD + "Good Catches:\n" +
                            EnumChatFormatting.DARK_PURPLE + "Great Catches:\n" +
                            EnumChatFormatting.LIGHT_PURPLE + "Nurse Sharks:\n" +
                            EnumChatFormatting.BLUE + "Blue Sharks:\n" +
                            EnumChatFormatting.GOLD + "Tiger Sharks:\n" +
                            EnumChatFormatting.WHITE + "Great White Sharks:";
                    countText = EnumChatFormatting.AQUA + nf.format(FishingTracker.seaCreaturesSession) + "\n" +
                            EnumChatFormatting.AQUA + nf.format(FishingTracker.fishingMilestoneSession) + "\n" +
                            EnumChatFormatting.GOLD + nf.format(FishingTracker.goodCatchesSession) + "\n" +
                            EnumChatFormatting.DARK_PURPLE + nf.format(FishingTracker.greatCatchesSession) + "\n" +
                            EnumChatFormatting.LIGHT_PURPLE + nf.format(FishingTracker.nurseSharksSession) + "\n" +
                            EnumChatFormatting.BLUE + nf.format(FishingTracker.blueSharksSession) + "\n" +
                            EnumChatFormatting.GOLD + nf.format(FishingTracker.tigerSharksSession) + "\n" +
                            EnumChatFormatting.WHITE + nf.format(FishingTracker.greatWhiteSharksSession);
                    break;
                case "fishing_spooky":
                    dropsText = EnumChatFormatting.AQUA + "Creatures Caught:\n" +
                            EnumChatFormatting.AQUA + "Fishing Milestone:\n" +
                            EnumChatFormatting.GOLD + "Good Catches:\n" +
                            EnumChatFormatting.DARK_PURPLE + "Great Catches:\n" +
                            EnumChatFormatting.BLUE + "Scarecrows:\n" +
                            EnumChatFormatting.GRAY + "Nightmares:\n" +
                            EnumChatFormatting.DARK_PURPLE + "Werewolves:\n" +
                            EnumChatFormatting.GOLD + "Phantom Fishers:\n" +
                            EnumChatFormatting.GOLD + "Grim Reapers:";
                    countText = EnumChatFormatting.AQUA + nf.format(FishingTracker.seaCreatures) + "\n" +
                            EnumChatFormatting.AQUA + nf.format(FishingTracker.fishingMilestone) + "\n" +
                            EnumChatFormatting.GOLD + nf.format(FishingTracker.goodCatches) + "\n" +
                            EnumChatFormatting.DARK_PURPLE + nf.format(FishingTracker.greatCatches) + "\n" +
                            EnumChatFormatting.BLUE + nf.format(FishingTracker.scarecrows) + "\n" +
                            EnumChatFormatting.GRAY + nf.format(FishingTracker.nightmares) + "\n" +
                            EnumChatFormatting.DARK_PURPLE + nf.format(FishingTracker.werewolfs) + "\n" +
                            EnumChatFormatting.GOLD + nf.format(FishingTracker.phantomFishers) + "\n" +
                            EnumChatFormatting.GOLD + nf.format(FishingTracker.grimReapers);
                    break;
                case "fishing_spooky_session":
                    dropsText = EnumChatFormatting.AQUA + "Creatures Caught:\n" +
                            EnumChatFormatting.AQUA + "Fishing Milestone:\n" +
                            EnumChatFormatting.GOLD + "Good Catches:\n" +
                            EnumChatFormatting.DARK_PURPLE + "Great Catches:\n" +
                            EnumChatFormatting.BLUE + "Scarecrows:\n" +
                            EnumChatFormatting.GRAY + "Nightmares:\n" +
                            EnumChatFormatting.DARK_PURPLE + "Werewolves:\n" +
                            EnumChatFormatting.GOLD + "Phantom Fishers:\n" +
                            EnumChatFormatting.GOLD + "Grim Reapers:";
                    countText = EnumChatFormatting.AQUA + nf.format(FishingTracker.seaCreaturesSession) + "\n" +
                            EnumChatFormatting.AQUA + nf.format(FishingTracker.fishingMilestoneSession) + "\n" +
                            EnumChatFormatting.GOLD + nf.format(FishingTracker.goodCatchesSession) + "\n" +
                            EnumChatFormatting.DARK_PURPLE + nf.format(FishingTracker.greatCatchesSession) + "\n" +
                            EnumChatFormatting.BLUE + nf.format(FishingTracker.scarecrowsSession) + "\n" +
                            EnumChatFormatting.GRAY + nf.format(FishingTracker.nightmaresSession) + "\n" +
                            EnumChatFormatting.DARK_PURPLE + nf.format(FishingTracker.werewolfsSession) + "\n" +
                            EnumChatFormatting.GOLD + nf.format(FishingTracker.phantomFishersSession) + "\n" +
                            EnumChatFormatting.GOLD + nf.format(FishingTracker.grimReapersSession);
                    break;
                case "fishing_ch":
                    dropsText = EnumChatFormatting.AQUA + "Creatures Caught:\n" +
                            EnumChatFormatting.AQUA + "Fishing Milestone:\n" +
                            EnumChatFormatting.GOLD + "Good Catches:\n" +
                            EnumChatFormatting.DARK_PURPLE + "Great Catches:\n" +
                            EnumChatFormatting.BLUE + "Water Worms:\n" +
                            EnumChatFormatting.GREEN + "Poison Water Worms:\n" +
                            EnumChatFormatting.RED + "Flaming Worms:\n" +
                            EnumChatFormatting.DARK_PURPLE + "Lava Blazes:\n" +
                            EnumChatFormatting.DARK_PURPLE + "Lava Pigmen:\n" +
                            EnumChatFormatting.GOLD + "Zombie Miners:";
                    countText = EnumChatFormatting.AQUA + nf.format(FishingTracker.seaCreatures) + "\n" +
                            EnumChatFormatting.AQUA + nf.format(FishingTracker.fishingMilestone) + "\n" +
                            EnumChatFormatting.GOLD + nf.format(FishingTracker.goodCatches) + "\n" +
                            EnumChatFormatting.DARK_PURPLE + nf.format(FishingTracker.greatCatches) + "\n" +
                            EnumChatFormatting.BLUE + nf.format(FishingTracker.waterWorms) + "\n" +
                            EnumChatFormatting.GREEN + nf.format(FishingTracker.poisonedWaterWorms) + "\n" +
                            EnumChatFormatting.RED + nf.format(FishingTracker.flamingWorms) + "\n" +
                            EnumChatFormatting.DARK_PURPLE + nf.format(FishingTracker.lavaBlazes) + "\n" +
                            EnumChatFormatting.DARK_PURPLE + nf.format(FishingTracker.lavaPigmen) + "\n" +
                            EnumChatFormatting.GOLD + nf.format(FishingTracker.zombieMiners);
                    break;
                case "fishing_ch_session":
                    dropsText = EnumChatFormatting.AQUA + "Creatures Caught:\n" +
                            EnumChatFormatting.AQUA + "Fishing Milestone:\n" +
                            EnumChatFormatting.GOLD + "Good Catches:\n" +
                            EnumChatFormatting.DARK_PURPLE + "Great Catches:\n" +
                            EnumChatFormatting.BLUE + "Water Worms:\n" +
                            EnumChatFormatting.GREEN + "Poison Water Worms:\n" +
                            EnumChatFormatting.RED + "Flaming Worms:\n" +
                            EnumChatFormatting.DARK_PURPLE + "Lava Blazes:\n" +
                            EnumChatFormatting.DARK_PURPLE + "Lava Pigmen:\n" +
                            EnumChatFormatting.GOLD + "Zombie Miners:";
                    countText = EnumChatFormatting.AQUA + nf.format(FishingTracker.seaCreaturesSession) + "\n" +
                            EnumChatFormatting.AQUA + nf.format(FishingTracker.fishingMilestoneSession) + "\n" +
                            EnumChatFormatting.GOLD + nf.format(FishingTracker.goodCatchesSession) + "\n" +
                            EnumChatFormatting.DARK_PURPLE + nf.format(FishingTracker.greatCatchesSession) + "\n" +
                            EnumChatFormatting.BLUE + nf.format(FishingTracker.waterWormsSession) + "\n" +
                            EnumChatFormatting.GREEN + nf.format(FishingTracker.poisonedWaterWormsSession) + "\n" +
                            EnumChatFormatting.RED + nf.format(FishingTracker.flamingWormsSession) + "\n" +
                            EnumChatFormatting.DARK_PURPLE + nf.format(FishingTracker.lavaBlazesSession) + "\n" +
                            EnumChatFormatting.DARK_PURPLE + nf.format(FishingTracker.lavaPigmenSession) + "\n" +
                            EnumChatFormatting.GOLD + nf.format(FishingTracker.zombieMinersSession);
                    break;
                case "fishing_lava":
                    if (FishingTracker.jawbusTime == -1) {
                        timeBetween = "Never";
                    } else {
                        timeBetween = Utils.getTimeBetween(FishingTracker.jawbusTime, timeNow);
                    }
                    if (FishingTracker.jawbusSCs == -1) {
                        bossesBetween = "Never";
                    } else {
                        bossesBetween = nf.format(FishingTracker.jawbusSCs);
                    }

                    dropsText = EnumChatFormatting.AQUA + "Creatures Caught:\n" +
                            EnumChatFormatting.AQUA + "Fishing Milestone:\n" +
                            EnumChatFormatting.GOLD + "Good Catches:\n" +
                            EnumChatFormatting.DARK_PURPLE + "Great Catches:\n" +
                            EnumChatFormatting.BLUE + "Plhlegblasts:\n" +
                            EnumChatFormatting.DARK_RED + "Magma Slugs:\n" +
                            EnumChatFormatting.RED + "Moogmas:\n" +
                            EnumChatFormatting.RED + "Lava Leeches:\n" +
                            EnumChatFormatting.RED + "Pyroclastic Worms:\n" +
                            EnumChatFormatting.DARK_RED + "Lava Flames:\n" +
                            EnumChatFormatting.RED + "Fire Eels:\n" +
                            EnumChatFormatting.GOLD + "Tauruses:\n" +
                            EnumChatFormatting.LIGHT_PURPLE + "Thunders:\n" +
                            EnumChatFormatting.LIGHT_PURPLE + "Lord Jawbuses:\n" +
                            EnumChatFormatting.AQUA + "Time Since Jawbus:\n" +
                            EnumChatFormatting.AQUA + "SC Since Jawbus:";
                    countText = EnumChatFormatting.AQUA + nf.format(FishingTracker.seaCreatures) + "\n" +
                            EnumChatFormatting.AQUA + nf.format(FishingTracker.fishingMilestone) + "\n" +
                            EnumChatFormatting.GOLD + nf.format(FishingTracker.goodCatches) + "\n" +
                            EnumChatFormatting.DARK_PURPLE + nf.format(FishingTracker.greatCatches) + "\n" +
                            EnumChatFormatting.BLUE + nf.format(FishingTracker.plhlegblasts) + "\n" +
                            EnumChatFormatting.DARK_RED + nf.format(FishingTracker.magmaSlugs) + "\n" +
                            EnumChatFormatting.RED + nf.format(FishingTracker.moogmas) + "\n" +
                            EnumChatFormatting.RED + nf.format(FishingTracker.lavaLeeches) + "\n" +
                            EnumChatFormatting.RED + nf.format(FishingTracker.pyroclasticWorms) + "\n" +
                            EnumChatFormatting.DARK_RED + nf.format(FishingTracker.lavaFlames) + "\n" +
                            EnumChatFormatting.RED + nf.format(FishingTracker.fireEels) + "\n" +
                            EnumChatFormatting.GOLD + nf.format(FishingTracker.tauruses) + "\n" +
                            EnumChatFormatting.LIGHT_PURPLE + nf.format(FishingTracker.thunders) + "\n" +
                            EnumChatFormatting.LIGHT_PURPLE + nf.format(FishingTracker.lordJawbuses) + "\n" +
                            EnumChatFormatting.AQUA + timeBetween + "\n" +
                            EnumChatFormatting.AQUA + bossesBetween;
                    break;
                case "fishing_lava_session":
                    if (FishingTracker.jawbusTimeSession == -1) {
                        timeBetween = "Never";
                    } else {
                        timeBetween = Utils.getTimeBetween(FishingTracker.jawbusTimeSession, timeNow);
                    }
                    if (FishingTracker.jawbusSCsSession == -1) {
                        bossesBetween = "Never";
                    } else {
                        bossesBetween = nf.format(FishingTracker.jawbusSCsSession);
                    }

                    dropsText = EnumChatFormatting.AQUA + "Creatures Caught:\n" +
                            EnumChatFormatting.AQUA + "Fishing Milestone:\n" +
                            EnumChatFormatting.GOLD + "Good Catches:\n" +
                            EnumChatFormatting.DARK_PURPLE + "Great Catches:\n" +
                            EnumChatFormatting.BLUE + "Plhlegblasts:\n" +
                            EnumChatFormatting.DARK_RED + "Magma Slugs:\n" +
                            EnumChatFormatting.RED + "Moogmas:\n" +
                            EnumChatFormatting.RED + "Lava Leeches:\n" +
                            EnumChatFormatting.RED + "Pyroclastic Worms:\n" +
                            EnumChatFormatting.DARK_RED + "Lava Flames:\n" +
                            EnumChatFormatting.RED + "Fire Eels:\n" +
                            EnumChatFormatting.GOLD + "Tauruses:\n" +
                            EnumChatFormatting.LIGHT_PURPLE + "Thunders:\n" +
                            EnumChatFormatting.LIGHT_PURPLE + "Lord Jawbuses:\n" +
                            EnumChatFormatting.AQUA + "Time Since Jawbus:\n" +
                            EnumChatFormatting.AQUA + "SC Since Jawbus:";
                    countText = EnumChatFormatting.AQUA + nf.format(FishingTracker.seaCreaturesSession) + "\n" +
                            EnumChatFormatting.AQUA + nf.format(FishingTracker.fishingMilestoneSession) + "\n" +
                            EnumChatFormatting.GOLD + nf.format(FishingTracker.goodCatchesSession) + "\n" +
                            EnumChatFormatting.DARK_PURPLE + nf.format(FishingTracker.greatCatchesSession) + "\n" +
                            EnumChatFormatting.BLUE + nf.format(FishingTracker.plhlegblastsSession) + "\n" +
                            EnumChatFormatting.DARK_RED + nf.format(FishingTracker.magmaSlugsSession) + "\n" +
                            EnumChatFormatting.RED + nf.format(FishingTracker.moogmasSession) + "\n" +
                            EnumChatFormatting.RED + nf.format(FishingTracker.lavaLeechesSession) + "\n" +
                            EnumChatFormatting.RED + nf.format(FishingTracker.pyroclasticWormsSession) + "\n" +
                            EnumChatFormatting.DARK_RED + nf.format(FishingTracker.lavaFlamesSession) + "\n" +
                            EnumChatFormatting.RED + nf.format(FishingTracker.fireEelsSession) + "\n" +
                            EnumChatFormatting.GOLD + nf.format(FishingTracker.taurusesSession) + "\n" +
                            EnumChatFormatting.LIGHT_PURPLE + nf.format(FishingTracker.thundersSession) + "\n" +
                            EnumChatFormatting.LIGHT_PURPLE + nf.format(FishingTracker.lordJawbusesSession) + "\n" +
                            EnumChatFormatting.AQUA + timeBetween + "\n" +
                            EnumChatFormatting.AQUA + bossesBetween;
                    break;
                case "fishing_trophy":
                    dropsText = EnumChatFormatting.WHITE + "Sulpher Skitter:\n" +
                            EnumChatFormatting.WHITE + "Obfuscated 1:\n" +
                            EnumChatFormatting.WHITE + "Steaminghot Flounder:\n" +
                            EnumChatFormatting.WHITE + "Gusher:\n" +
                            EnumChatFormatting.WHITE + "Blobfish:\n" +
                            EnumChatFormatting.GREEN + "Obfuscated 2:\n" +
                            EnumChatFormatting.GREEN + "Slugfish:\n" +
                            EnumChatFormatting.GREEN + "Flyfish:\n" +
                            EnumChatFormatting.BLUE + "Obfuscated 3:\n" +
                            EnumChatFormatting.BLUE + "Lavahorse:\n" +
                            EnumChatFormatting.BLUE + "Mana Ray:\n" +
                            EnumChatFormatting.BLUE + "Volcanic Stonefish:\n" +
                            EnumChatFormatting.BLUE + "Vanille:\n" +
                            EnumChatFormatting.DARK_PURPLE + "Skeleton Fish:\n" +
                            EnumChatFormatting.DARK_PURPLE + "Moldfin:\n" +
                            EnumChatFormatting.DARK_PURPLE + "Soul Fish:\n" +
                            EnumChatFormatting.DARK_PURPLE + "Karate Fish:\n" +
                            EnumChatFormatting.GOLD + "Golden Fish:";
                    if (!ToggleCommand.showTrophyCompletion) countText = EnumChatFormatting.WHITE + TrophyFishTracker.getTierCount(TrophyFishTracker.fish, "Sulpher Skitter") + "\n" +
                            EnumChatFormatting.WHITE + TrophyFishTracker.getTierCount(TrophyFishTracker.fish, "Obfuscated 1") + "\n" +
                            EnumChatFormatting.WHITE + TrophyFishTracker.getTierCount(TrophyFishTracker.fish, "Steaming-Hot Flounder") + "\n" +
                            EnumChatFormatting.WHITE + TrophyFishTracker.getTierCount(TrophyFishTracker.fish, "Gusher") + "\n" +
                            EnumChatFormatting.WHITE + TrophyFishTracker.getTierCount(TrophyFishTracker.fish, "Blobfish") + "\n" +
                            EnumChatFormatting.GREEN + TrophyFishTracker.getTierCount(TrophyFishTracker.fish, "Obfuscated 2") + "\n" +
                            EnumChatFormatting.GREEN + TrophyFishTracker.getTierCount(TrophyFishTracker.fish, "Slugfish") + "\n" +
                            EnumChatFormatting.GREEN + TrophyFishTracker.getTierCount(TrophyFishTracker.fish, "Flyfish") + "\n" +
                            EnumChatFormatting.BLUE + TrophyFishTracker.getTierCount(TrophyFishTracker.fish, "Obfuscated 3") + "\n" +
                            EnumChatFormatting.BLUE + TrophyFishTracker.getTierCount(TrophyFishTracker.fish, "Lavahorse") + "\n" +
                            EnumChatFormatting.BLUE + TrophyFishTracker.getTierCount(TrophyFishTracker.fish, "Mana Ray") + "\n" +
                            EnumChatFormatting.BLUE + TrophyFishTracker.getTierCount(TrophyFishTracker.fish, "Volcanic Stonefish") + "\n" +
                            EnumChatFormatting.BLUE + TrophyFishTracker.getTierCount(TrophyFishTracker.fish, "Vanille") + "\n" +
                            EnumChatFormatting.DARK_PURPLE + TrophyFishTracker.getTierCount(TrophyFishTracker.fish, "Skeleton Fish") + "\n" +
                            EnumChatFormatting.DARK_PURPLE + TrophyFishTracker.getTierCount(TrophyFishTracker.fish, "Moldfin") + "\n" +
                            EnumChatFormatting.DARK_PURPLE + TrophyFishTracker.getTierCount(TrophyFishTracker.fish, "Soul Fish") + "\n" +
                            EnumChatFormatting.DARK_PURPLE + TrophyFishTracker.getTierCount(TrophyFishTracker.fish, "Karate Fish") + "\n" +
                            EnumChatFormatting.GOLD + TrophyFishTracker.getTierCount(TrophyFishTracker.fish, "Golden Fish");

                    if (ToggleCommand.showTrophyCompletion) {
                        TrophyFishTracker.drawCompletion(TrophyFishTracker.fish, "Sulpher Skitter", (int) (MoveCommand.displayXY[0] + (110 * ScaleCommand.displayScale)), MoveCommand.displayXY[1], ScaleCommand.displayScale);
                        TrophyFishTracker.drawCompletion(TrophyFishTracker.fish, "Obfuscated 1", (int) (MoveCommand.displayXY[0] + (110 * ScaleCommand.displayScale)), (int) (MoveCommand.displayXY[1] + (mc.fontRendererObj.FONT_HEIGHT * ScaleCommand.displayScale)), ScaleCommand.displayScale);
                        TrophyFishTracker.drawCompletion(TrophyFishTracker.fish, "Steaming-Hot Flounder", (int) (MoveCommand.displayXY[0] + (110 * ScaleCommand.displayScale)), (int) (MoveCommand.displayXY[1] + (2 * mc.fontRendererObj.FONT_HEIGHT * ScaleCommand.displayScale)), ScaleCommand.displayScale);
                        TrophyFishTracker.drawCompletion(TrophyFishTracker.fish, "Gusher", (int) (MoveCommand.displayXY[0] + (110 * ScaleCommand.displayScale)), (int) (MoveCommand.displayXY[1] + (3 * mc.fontRendererObj.FONT_HEIGHT * ScaleCommand.displayScale)), ScaleCommand.displayScale);
                        TrophyFishTracker.drawCompletion(TrophyFishTracker.fish, "Blobfish", (int) (MoveCommand.displayXY[0] + (110 * ScaleCommand.displayScale)), (int) (MoveCommand.displayXY[1] + (4 * mc.fontRendererObj.FONT_HEIGHT * ScaleCommand.displayScale)), ScaleCommand.displayScale);
                        TrophyFishTracker.drawCompletion(TrophyFishTracker.fish, "Obfuscated 2", (int) (MoveCommand.displayXY[0] + (110 * ScaleCommand.displayScale)), (int) (MoveCommand.displayXY[1] + (5 * mc.fontRendererObj.FONT_HEIGHT * ScaleCommand.displayScale)), ScaleCommand.displayScale);
                        TrophyFishTracker.drawCompletion(TrophyFishTracker.fish, "Slugfish", (int) (MoveCommand.displayXY[0] + (110 * ScaleCommand.displayScale)), (int) (MoveCommand.displayXY[1] + (6 * mc.fontRendererObj.FONT_HEIGHT * ScaleCommand.displayScale)), ScaleCommand.displayScale);
                        TrophyFishTracker.drawCompletion(TrophyFishTracker.fish, "Flyfish", (int) (MoveCommand.displayXY[0] + (110 * ScaleCommand.displayScale)), (int) (MoveCommand.displayXY[1] + (7 * mc.fontRendererObj.FONT_HEIGHT * ScaleCommand.displayScale)), ScaleCommand.displayScale);
                        TrophyFishTracker.drawCompletion(TrophyFishTracker.fish, "Obfuscated 3", (int) (MoveCommand.displayXY[0] + (110 * ScaleCommand.displayScale)), (int) (MoveCommand.displayXY[1] + (8 * mc.fontRendererObj.FONT_HEIGHT * ScaleCommand.displayScale)), ScaleCommand.displayScale);
                        TrophyFishTracker.drawCompletion(TrophyFishTracker.fish, "Lavahorse", (int) (MoveCommand.displayXY[0] + (110 * ScaleCommand.displayScale)), (int) (MoveCommand.displayXY[1] + (9 * mc.fontRendererObj.FONT_HEIGHT * ScaleCommand.displayScale)), ScaleCommand.displayScale);
                        TrophyFishTracker.drawCompletion(TrophyFishTracker.fish, "Mana Ray", (int) (MoveCommand.displayXY[0] + (110 * ScaleCommand.displayScale)), (int) (MoveCommand.displayXY[1] + (10 * mc.fontRendererObj.FONT_HEIGHT * ScaleCommand.displayScale)), ScaleCommand.displayScale);
                        TrophyFishTracker.drawCompletion(TrophyFishTracker.fish, "Volcanic Stonefish", (int) (MoveCommand.displayXY[0] + (110 * ScaleCommand.displayScale)), (int) (MoveCommand.displayXY[1] + (11 * mc.fontRendererObj.FONT_HEIGHT * ScaleCommand.displayScale)), ScaleCommand.displayScale);
                        TrophyFishTracker.drawCompletion(TrophyFishTracker.fish, "Vanille", (int) (MoveCommand.displayXY[0] + (110 * ScaleCommand.displayScale)), (int) (MoveCommand.displayXY[1] + (12 * mc.fontRendererObj.FONT_HEIGHT * ScaleCommand.displayScale)), ScaleCommand.displayScale);
                        TrophyFishTracker.drawCompletion(TrophyFishTracker.fish, "Skeleton Fish", (int) (MoveCommand.displayXY[0] + (110 * ScaleCommand.displayScale)), (int) (MoveCommand.displayXY[1] + (13 * mc.fontRendererObj.FONT_HEIGHT * ScaleCommand.displayScale)), ScaleCommand.displayScale);
                        TrophyFishTracker.drawCompletion(TrophyFishTracker.fish, "Moldfin", (int) (MoveCommand.displayXY[0] + (110 * ScaleCommand.displayScale)), (int) (MoveCommand.displayXY[1] + (14 * mc.fontRendererObj.FONT_HEIGHT * ScaleCommand.displayScale)), ScaleCommand.displayScale);
                        TrophyFishTracker.drawCompletion(TrophyFishTracker.fish, "Soul Fish", (int) (MoveCommand.displayXY[0] + (110 * ScaleCommand.displayScale)), (int) (MoveCommand.displayXY[1] + (15 * mc.fontRendererObj.FONT_HEIGHT * ScaleCommand.displayScale)), ScaleCommand.displayScale);
                        TrophyFishTracker.drawCompletion(TrophyFishTracker.fish, "Karate Fish", (int) (MoveCommand.displayXY[0] + (110 * ScaleCommand.displayScale)), (int) (MoveCommand.displayXY[1] + (16 * mc.fontRendererObj.FONT_HEIGHT * ScaleCommand.displayScale)), ScaleCommand.displayScale);
                        TrophyFishTracker.drawCompletion(TrophyFishTracker.fish, "Golden Fish", (int) (MoveCommand.displayXY[0] + (110 * ScaleCommand.displayScale)), (int) (MoveCommand.displayXY[1] + (17 * mc.fontRendererObj.FONT_HEIGHT * ScaleCommand.displayScale)), ScaleCommand.displayScale);
                    }
                    break;
                case "fishing_trophy_session":
                    dropsText = EnumChatFormatting.WHITE + "Sulpher Skitter:\n" +
                            EnumChatFormatting.WHITE + "Obfuscated 1:\n" +
                            EnumChatFormatting.WHITE + "Steaminghot Flounder:\n" +
                            EnumChatFormatting.WHITE + "Gusher:\n" +
                            EnumChatFormatting.WHITE + "Blobfish:\n" +
                            EnumChatFormatting.GREEN + "Obfuscated 2:\n" +
                            EnumChatFormatting.GREEN + "Slugfish:\n" +
                            EnumChatFormatting.GREEN + "Flyfish:\n" +
                            EnumChatFormatting.BLUE + "Obfuscated 3:\n" +
                            EnumChatFormatting.BLUE + "Lavahorse:\n" +
                            EnumChatFormatting.BLUE + "Mana Ray:\n" +
                            EnumChatFormatting.BLUE + "Volcanic Stonefish:\n" +
                            EnumChatFormatting.BLUE + "Vanille:\n" +
                            EnumChatFormatting.DARK_PURPLE + "Skeleton Fish:\n" +
                            EnumChatFormatting.DARK_PURPLE + "Moldfin:\n" +
                            EnumChatFormatting.DARK_PURPLE + "Soul Fish:\n" +
                            EnumChatFormatting.DARK_PURPLE + "Karate Fish:\n" +
                            EnumChatFormatting.GOLD + "Golden Fish:";
                    if (!ToggleCommand.showTrophyCompletion) countText = EnumChatFormatting.WHITE + TrophyFishTracker.getTierCount(TrophyFishTracker.fishSession, "Sulpher Skitter") + "\n" +
                            EnumChatFormatting.WHITE + TrophyFishTracker.getTierCount(TrophyFishTracker.fishSession, "Obfuscated 1") + "\n" +
                            EnumChatFormatting.WHITE + TrophyFishTracker.getTierCount(TrophyFishTracker.fishSession, "Steaming-Hot Flounder") + "\n" +
                            EnumChatFormatting.WHITE + TrophyFishTracker.getTierCount(TrophyFishTracker.fishSession, "Gusher") + "\n" +
                            EnumChatFormatting.WHITE + TrophyFishTracker.getTierCount(TrophyFishTracker.fishSession, "Blobfish") + "\n" +
                            EnumChatFormatting.GREEN + TrophyFishTracker.getTierCount(TrophyFishTracker.fishSession, "Obfuscated 2") + "\n" +
                            EnumChatFormatting.GREEN + TrophyFishTracker.getTierCount(TrophyFishTracker.fishSession, "Slugfish") + "\n" +
                            EnumChatFormatting.GREEN + TrophyFishTracker.getTierCount(TrophyFishTracker.fishSession, "Flyfish") + "\n" +
                            EnumChatFormatting.BLUE + TrophyFishTracker.getTierCount(TrophyFishTracker.fishSession, "Obfuscated 3") + "\n" +
                            EnumChatFormatting.BLUE + TrophyFishTracker.getTierCount(TrophyFishTracker.fishSession, "Lavahorse") + "\n" +
                            EnumChatFormatting.BLUE + TrophyFishTracker.getTierCount(TrophyFishTracker.fishSession, "Mana Ray") + "\n" +
                            EnumChatFormatting.BLUE + TrophyFishTracker.getTierCount(TrophyFishTracker.fishSession, "Volcanic Stonefish") + "\n" +
                            EnumChatFormatting.BLUE + TrophyFishTracker.getTierCount(TrophyFishTracker.fishSession, "Vanille") + "\n" +
                            EnumChatFormatting.DARK_PURPLE + TrophyFishTracker.getTierCount(TrophyFishTracker.fishSession, "Skeleton Fish") + "\n" +
                            EnumChatFormatting.DARK_PURPLE + TrophyFishTracker.getTierCount(TrophyFishTracker.fishSession, "Moldfin") + "\n" +
                            EnumChatFormatting.DARK_PURPLE + TrophyFishTracker.getTierCount(TrophyFishTracker.fishSession, "Soul Fish") + "\n" +
                            EnumChatFormatting.DARK_PURPLE + TrophyFishTracker.getTierCount(TrophyFishTracker.fishSession, "Karate Fish") + "\n" +
                            EnumChatFormatting.GOLD + TrophyFishTracker.getTierCount(TrophyFishTracker.fishSession, "Golden Fish");

                    if (ToggleCommand.showTrophyCompletion) {
                        TrophyFishTracker.drawCompletion(TrophyFishTracker.fishSession, "Sulpher Skitter", (int) (MoveCommand.displayXY[0] + (110 * ScaleCommand.displayScale)), MoveCommand.displayXY[1], ScaleCommand.displayScale);
                        TrophyFishTracker.drawCompletion(TrophyFishTracker.fishSession, "Obfuscated 1", (int) (MoveCommand.displayXY[0] + (110 * ScaleCommand.displayScale)), (int) (MoveCommand.displayXY[1] + (mc.fontRendererObj.FONT_HEIGHT * ScaleCommand.displayScale)), ScaleCommand.displayScale);
                        TrophyFishTracker.drawCompletion(TrophyFishTracker.fishSession, "Steaming-Hot Flounder", (int) (MoveCommand.displayXY[0] + (110 * ScaleCommand.displayScale)), (int) (MoveCommand.displayXY[1] + (2 * mc.fontRendererObj.FONT_HEIGHT * ScaleCommand.displayScale)), ScaleCommand.displayScale);
                        TrophyFishTracker.drawCompletion(TrophyFishTracker.fishSession, "Gusher", (int) (MoveCommand.displayXY[0] + (110 * ScaleCommand.displayScale)), (int) (MoveCommand.displayXY[1] + (3 * mc.fontRendererObj.FONT_HEIGHT * ScaleCommand.displayScale)), ScaleCommand.displayScale);
                        TrophyFishTracker.drawCompletion(TrophyFishTracker.fishSession, "Blobfish", (int) (MoveCommand.displayXY[0] + (110 * ScaleCommand.displayScale)), (int) (MoveCommand.displayXY[1] + (4 * mc.fontRendererObj.FONT_HEIGHT * ScaleCommand.displayScale)), ScaleCommand.displayScale);
                        TrophyFishTracker.drawCompletion(TrophyFishTracker.fishSession, "Obfuscated 2", (int) (MoveCommand.displayXY[0] + (110 * ScaleCommand.displayScale)), (int) (MoveCommand.displayXY[1] + (5 * mc.fontRendererObj.FONT_HEIGHT * ScaleCommand.displayScale)), ScaleCommand.displayScale);
                        TrophyFishTracker.drawCompletion(TrophyFishTracker.fishSession, "Slugfish", (int) (MoveCommand.displayXY[0] + (110 * ScaleCommand.displayScale)), (int) (MoveCommand.displayXY[1] + (6 * mc.fontRendererObj.FONT_HEIGHT * ScaleCommand.displayScale)), ScaleCommand.displayScale);
                        TrophyFishTracker.drawCompletion(TrophyFishTracker.fishSession, "Flyfish", (int) (MoveCommand.displayXY[0] + (110 * ScaleCommand.displayScale)), (int) (MoveCommand.displayXY[1] + (7 * mc.fontRendererObj.FONT_HEIGHT * ScaleCommand.displayScale)), ScaleCommand.displayScale);
                        TrophyFishTracker.drawCompletion(TrophyFishTracker.fishSession, "Obfuscated 3", (int) (MoveCommand.displayXY[0] + (110 * ScaleCommand.displayScale)), (int) (MoveCommand.displayXY[1] + (8 * mc.fontRendererObj.FONT_HEIGHT * ScaleCommand.displayScale)), ScaleCommand.displayScale);
                        TrophyFishTracker.drawCompletion(TrophyFishTracker.fishSession, "Lavahorse", (int) (MoveCommand.displayXY[0] + (110 * ScaleCommand.displayScale)), (int) (MoveCommand.displayXY[1] + (9 * mc.fontRendererObj.FONT_HEIGHT * ScaleCommand.displayScale)), ScaleCommand.displayScale);
                        TrophyFishTracker.drawCompletion(TrophyFishTracker.fishSession, "Mana Ray", (int) (MoveCommand.displayXY[0] + (110 * ScaleCommand.displayScale)), (int) (MoveCommand.displayXY[1] + (10 * mc.fontRendererObj.FONT_HEIGHT * ScaleCommand.displayScale)), ScaleCommand.displayScale);
                        TrophyFishTracker.drawCompletion(TrophyFishTracker.fishSession, "Volcanic Stonefish", (int) (MoveCommand.displayXY[0] + (110 * ScaleCommand.displayScale)), (int) (MoveCommand.displayXY[1] + (11 * mc.fontRendererObj.FONT_HEIGHT * ScaleCommand.displayScale)), ScaleCommand.displayScale);
                        TrophyFishTracker.drawCompletion(TrophyFishTracker.fishSession, "Vanille", (int) (MoveCommand.displayXY[0] + (110 * ScaleCommand.displayScale)), (int) (MoveCommand.displayXY[1] + (12 * mc.fontRendererObj.FONT_HEIGHT * ScaleCommand.displayScale)), ScaleCommand.displayScale);
                        TrophyFishTracker.drawCompletion(TrophyFishTracker.fishSession, "Skeleton Fish", (int) (MoveCommand.displayXY[0] + (110 * ScaleCommand.displayScale)), (int) (MoveCommand.displayXY[1] + (13 * mc.fontRendererObj.FONT_HEIGHT * ScaleCommand.displayScale)), ScaleCommand.displayScale);
                        TrophyFishTracker.drawCompletion(TrophyFishTracker.fishSession, "Moldfin", (int) (MoveCommand.displayXY[0] + (110 * ScaleCommand.displayScale)), (int) (MoveCommand.displayXY[1] + (14 * mc.fontRendererObj.FONT_HEIGHT * ScaleCommand.displayScale)), ScaleCommand.displayScale);
                        TrophyFishTracker.drawCompletion(TrophyFishTracker.fishSession, "Soul Fish", (int) (MoveCommand.displayXY[0] + (110 * ScaleCommand.displayScale)), (int) (MoveCommand.displayXY[1] + (15 * mc.fontRendererObj.FONT_HEIGHT * ScaleCommand.displayScale)), ScaleCommand.displayScale);
                        TrophyFishTracker.drawCompletion(TrophyFishTracker.fishSession, "Karate Fish", (int) (MoveCommand.displayXY[0] + (110 * ScaleCommand.displayScale)), (int) (MoveCommand.displayXY[1] + (16 * mc.fontRendererObj.FONT_HEIGHT * ScaleCommand.displayScale)), ScaleCommand.displayScale);
                        TrophyFishTracker.drawCompletion(TrophyFishTracker.fishSession, "Golden Fish", (int) (MoveCommand.displayXY[0] + (110 * ScaleCommand.displayScale)), (int) (MoveCommand.displayXY[1] + (17 * mc.fontRendererObj.FONT_HEIGHT * ScaleCommand.displayScale)), ScaleCommand.displayScale);
                    }
                    break;
                case "mythological":
                    dropsText = EnumChatFormatting.GOLD + "Coins:\n" +
                            EnumChatFormatting.WHITE + "Griffin Feathers:\n" +
                            EnumChatFormatting.GOLD + "Crown of Greeds:\n" +
                            EnumChatFormatting.AQUA + "Washed up Souvenirs:\n" +
                            EnumChatFormatting.RED + "Minos Hunters:\n" +
                            EnumChatFormatting.GRAY + "Siamese Lynxes:\n" +
                            EnumChatFormatting.RED + "Minotaurs:\n" +
                            EnumChatFormatting.WHITE + "Gaia Constructs:\n" +
                            EnumChatFormatting.DARK_PURPLE + "Minos Champions:\n" +
                            EnumChatFormatting.GOLD + "Minos Inquisitors:";
                    countText = EnumChatFormatting.GOLD + nf.format(MythologicalTracker.mythCoins) + "\n" +
                            EnumChatFormatting.WHITE + nf.format(MythologicalTracker.griffinFeathers) + "\n" +
                            EnumChatFormatting.GOLD + nf.format(MythologicalTracker.crownOfGreeds) + "\n" +
                            EnumChatFormatting.AQUA + nf.format(MythologicalTracker.washedUpSouvenirs) + "\n" +
                            EnumChatFormatting.RED + nf.format(MythologicalTracker.minosHunters) + "\n" +
                            EnumChatFormatting.GRAY + nf.format(MythologicalTracker.siameseLynxes) + "\n" +
                            EnumChatFormatting.RED + nf.format(MythologicalTracker.minotaurs) + "\n" +
                            EnumChatFormatting.WHITE + nf.format(MythologicalTracker.gaiaConstructs) + "\n" +
                            EnumChatFormatting.DARK_PURPLE + nf.format(MythologicalTracker.minosChampions) + "\n" +
                            EnumChatFormatting.GOLD + nf.format(MythologicalTracker.minosInquisitors);
                    break;
                case "mythological_session":
                    dropsText = EnumChatFormatting.GOLD + "Coins:\n" +
                            EnumChatFormatting.WHITE + "Griffin Feathers:\n" +
                            EnumChatFormatting.GOLD + "Crown of Greeds:\n" +
                            EnumChatFormatting.AQUA + "Washed up Souvenirs:\n" +
                            EnumChatFormatting.RED + "Minos Hunters:\n" +
                            EnumChatFormatting.GRAY + "Siamese Lynxes:\n" +
                            EnumChatFormatting.RED + "Minotaurs:\n" +
                            EnumChatFormatting.WHITE + "Gaia Constructs:\n" +
                            EnumChatFormatting.DARK_PURPLE + "Minos Champions:\n" +
                            EnumChatFormatting.GOLD + "Minos Inquisitors:";
                    countText = EnumChatFormatting.GOLD + nf.format(MythologicalTracker.mythCoinsSession) + "\n" +
                            EnumChatFormatting.WHITE + nf.format(MythologicalTracker.griffinFeathersSession) + "\n" +
                            EnumChatFormatting.GOLD + nf.format(MythologicalTracker.crownOfGreedsSession) + "\n" +
                            EnumChatFormatting.AQUA + nf.format(MythologicalTracker.washedUpSouvenirsSession) + "\n" +
                            EnumChatFormatting.RED + nf.format(MythologicalTracker.minosHuntersSession) + "\n" +
                            EnumChatFormatting.GRAY + nf.format(MythologicalTracker.siameseLynxesSession) + "\n" +
                            EnumChatFormatting.RED + nf.format(MythologicalTracker.minotaursSession) + "\n" +
                            EnumChatFormatting.WHITE + nf.format(MythologicalTracker.gaiaConstructsSession) + "\n" +
                            EnumChatFormatting.DARK_PURPLE + nf.format(MythologicalTracker.minosChampionsSession) + "\n" +
                            EnumChatFormatting.GOLD + nf.format(MythologicalTracker.minosInquisitorsSession);
                    break;
                case "catacombs_floor_one":
                    dropsText = EnumChatFormatting.GOLD + "S+ Runs:\n" +
                            EnumChatFormatting.GOLD + "Recombobulators:\n" +
                            EnumChatFormatting.DARK_PURPLE + "Fuming Potato Books:\n" +
                            EnumChatFormatting.BLUE + "Bonzo's Staffs:\n" +
                            EnumChatFormatting.AQUA + "Coins Spent:\n" +
                            EnumChatFormatting.AQUA + "Time Spent:";
                    countText = EnumChatFormatting.GOLD + nf.format(CatacombsTracker.f1SPlus) + "\n" +
                            EnumChatFormatting.GOLD + nf.format(CatacombsTracker.recombobulators) + "\n" +
                            EnumChatFormatting.DARK_PURPLE + nf.format(CatacombsTracker.fumingPotatoBooks) + "\n" +
                            EnumChatFormatting.BLUE + nf.format(CatacombsTracker.bonzoStaffs) + "\n" +
                            EnumChatFormatting.AQUA + Utils.getMoneySpent(CatacombsTracker.f1CoinsSpent) + "\n" +
                            EnumChatFormatting.AQUA + Utils.getTimeBetween(0, CatacombsTracker.f1TimeSpent);
                    break;
                case "catacombs_floor_one_session":
                    dropsText = EnumChatFormatting.GOLD + "S+ Runs:\n" +
                            EnumChatFormatting.GOLD + "Recombobulators:\n" +
                            EnumChatFormatting.DARK_PURPLE + "Fuming Potato Books:\n" +
                            EnumChatFormatting.BLUE + "Bonzo's Staffs:\n" +
                            EnumChatFormatting.AQUA + "Coins Spent:\n" +
                            EnumChatFormatting.AQUA + "Time Spent:";
                    countText = EnumChatFormatting.GOLD + nf.format(CatacombsTracker.f1SPlusSession) + "\n" +
                            EnumChatFormatting.GOLD + nf.format(CatacombsTracker.recombobulatorsSession) + "\n" +
                            EnumChatFormatting.DARK_PURPLE + nf.format(CatacombsTracker.fumingPotatoBooksSession) + "\n" +
                            EnumChatFormatting.BLUE + nf.format(CatacombsTracker.bonzoStaffsSession) + "\n" +
                            EnumChatFormatting.AQUA + Utils.getMoneySpent(CatacombsTracker.f1CoinsSpentSession) + "\n" +
                            EnumChatFormatting.AQUA + Utils.getTimeBetween(0, CatacombsTracker.f1TimeSpentSession);
                    break;
                case "catacombs_floor_two":
                    dropsText = EnumChatFormatting.GOLD + "S+ Runs:\n" +
                            EnumChatFormatting.GOLD + "Recombobulators:\n" +
                            EnumChatFormatting.DARK_PURPLE + "Fuming Potato Books:\n" +
                            EnumChatFormatting.BLUE + "Scarf's Studies:\n" +
                            EnumChatFormatting.DARK_PURPLE + "Adaptive Blades:\n" +
                            EnumChatFormatting.AQUA + "Coins Spent:\n" +
                            EnumChatFormatting.AQUA + "Time Spent:";
                    countText = EnumChatFormatting.GOLD + nf.format(CatacombsTracker.f2SPlus) + "\n" +
                            EnumChatFormatting.GOLD + nf.format(CatacombsTracker.recombobulators) + "\n" +
                            EnumChatFormatting.DARK_PURPLE + nf.format(CatacombsTracker.fumingPotatoBooks) + "\n" +
                            EnumChatFormatting.BLUE + nf.format(CatacombsTracker.scarfStudies) + "\n" +
                            EnumChatFormatting.DARK_PURPLE + nf.format(CatacombsTracker.adaptiveSwords) + "\n" +
                            EnumChatFormatting.AQUA + Utils.getMoneySpent(CatacombsTracker.f2CoinsSpent) + "\n" +
                            EnumChatFormatting.AQUA + Utils.getTimeBetween(0, CatacombsTracker.f2TimeSpent);
                    break;
                case "catacombs_floor_two_session":
                    dropsText = EnumChatFormatting.GOLD + "S+ Runs:\n" +
                            EnumChatFormatting.GOLD + "Recombobulators:\n" +
                            EnumChatFormatting.DARK_PURPLE + "Fuming Potato Books:\n" +
                            EnumChatFormatting.BLUE + "Scarf's Studies:\n" +
                            EnumChatFormatting.DARK_PURPLE + "Adaptive Blades:\n" +
                            EnumChatFormatting.AQUA + "Coins Spent:\n" +
                            EnumChatFormatting.AQUA + "Time Spent:";
                    countText = EnumChatFormatting.GOLD + nf.format(CatacombsTracker.f2SPlusSession) + "\n" +
                            EnumChatFormatting.GOLD + nf.format(CatacombsTracker.recombobulatorsSession) + "\n" +
                            EnumChatFormatting.DARK_PURPLE + nf.format(CatacombsTracker.fumingPotatoBooksSession) + "\n" +
                            EnumChatFormatting.BLUE + nf.format(CatacombsTracker.scarfStudiesSession) + "\n" +
                            EnumChatFormatting.DARK_PURPLE + nf.format(CatacombsTracker.adaptiveSwordsSession) + "\n" +
                            EnumChatFormatting.AQUA + Utils.getMoneySpent(CatacombsTracker.f2CoinsSpentSession) + "\n" +
                            EnumChatFormatting.AQUA + Utils.getTimeBetween(0, CatacombsTracker.f2TimeSpentSession);
                    break;
                case "catacombs_floor_three":
                    dropsText = EnumChatFormatting.GOLD + "S+ Runs:\n" +
                            EnumChatFormatting.GOLD + "Recombobulators:\n" +
                            EnumChatFormatting.DARK_PURPLE + "Fuming Potato Books:\n" +
                            EnumChatFormatting.DARK_PURPLE + "Adaptive Helmets:\n" +
                            EnumChatFormatting.DARK_PURPLE + "Adaptive Chestplates:\n" +
                            EnumChatFormatting.DARK_PURPLE + "Adaptive Leggings:\n" +
                            EnumChatFormatting.DARK_PURPLE + "Adaptive Boots:\n" +
                            EnumChatFormatting.AQUA + "Coins Spent:\n" +
                            EnumChatFormatting.AQUA + "Time Spent:";
                    countText = EnumChatFormatting.GOLD + nf.format(CatacombsTracker.f3SPlus) + "\n" +
                            EnumChatFormatting.GOLD + nf.format(CatacombsTracker.recombobulators) + "\n" +
                            EnumChatFormatting.DARK_PURPLE + nf.format(CatacombsTracker.fumingPotatoBooks) + "\n" +
                            EnumChatFormatting.DARK_PURPLE + nf.format(CatacombsTracker.adaptiveHelms) + "\n" +
                            EnumChatFormatting.DARK_PURPLE + nf.format(CatacombsTracker.adaptiveChests) + "\n" +
                            EnumChatFormatting.DARK_PURPLE + nf.format(CatacombsTracker.adaptiveLegs) + "\n" +
                            EnumChatFormatting.DARK_PURPLE + nf.format(CatacombsTracker.adaptiveBoots) + "\n" +
                            EnumChatFormatting.AQUA + Utils.getMoneySpent(CatacombsTracker.f3CoinsSpent) + "\n" +
                            EnumChatFormatting.AQUA + Utils.getTimeBetween(0, CatacombsTracker.f3TimeSpent);
                    break;
                case "catacombs_floor_three_session":
                    dropsText = EnumChatFormatting.GOLD + "S+ Runs:\n" +
                            EnumChatFormatting.GOLD + "Recombobulators:\n" +
                            EnumChatFormatting.DARK_PURPLE + "Fuming Potato Books:\n" +
                            EnumChatFormatting.DARK_PURPLE + "Adaptive Helmets:\n" +
                            EnumChatFormatting.DARK_PURPLE + "Adaptive Chestplates:\n" +
                            EnumChatFormatting.DARK_PURPLE + "Adaptive Leggings:\n" +
                            EnumChatFormatting.DARK_PURPLE + "Adaptive Boots:\n" +
                            EnumChatFormatting.AQUA + "Coins Spent:\n" +
                            EnumChatFormatting.AQUA + "Time Spent:";
                    countText = EnumChatFormatting.GOLD + nf.format(CatacombsTracker.f3SPlusSession) + "\n" +
                            EnumChatFormatting.GOLD + nf.format(CatacombsTracker.recombobulatorsSession) + "\n" +
                            EnumChatFormatting.DARK_PURPLE + nf.format(CatacombsTracker.fumingPotatoBooksSession) + "\n" +
                            EnumChatFormatting.DARK_PURPLE + nf.format(CatacombsTracker.adaptiveHelmsSession) + "\n" +
                            EnumChatFormatting.DARK_PURPLE + nf.format(CatacombsTracker.adaptiveChestsSession) + "\n" +
                            EnumChatFormatting.DARK_PURPLE + nf.format(CatacombsTracker.adaptiveLegsSession) + "\n" +
                            EnumChatFormatting.DARK_PURPLE + nf.format(CatacombsTracker.adaptiveBootsSession) + "\n" +
                            EnumChatFormatting.AQUA + Utils.getMoneySpent(CatacombsTracker.f3CoinsSpentSession) + "\n" +
                            EnumChatFormatting.AQUA + Utils.getTimeBetween(0, CatacombsTracker.f3TimeSpentSession);
                    break;
                case "catacombs_floor_four":
                    dropsText = EnumChatFormatting.GOLD + "S+ Runs:\n" +
                            EnumChatFormatting.GOLD + "Recombobulators:\n" +
                            EnumChatFormatting.DARK_PURPLE + "Fuming Potato Books:\n" +
                            EnumChatFormatting.DARK_PURPLE + "Spirit Wings:\n" +
                            EnumChatFormatting.DARK_PURPLE + "Spirit Bones:\n" +
                            EnumChatFormatting.DARK_PURPLE + "Spirit Boots:\n" +
                            EnumChatFormatting.DARK_PURPLE + "Spirit Swords:\n" +
                            EnumChatFormatting.GOLD + "Spirit Bows:\n" +
                            EnumChatFormatting.DARK_PURPLE + "Epic Spirit Pets:\n" +
                            EnumChatFormatting.GOLD + "Leg Spirit Pets:\n" +
                            EnumChatFormatting.AQUA + "Coins Spent:\n" +
                            EnumChatFormatting.AQUA + "Time Spent:";
                    countText = EnumChatFormatting.GOLD + nf.format(CatacombsTracker.f4SPlus) + "\n" +
                            EnumChatFormatting.GOLD + nf.format(CatacombsTracker.recombobulators) + "\n" +
                            EnumChatFormatting.DARK_PURPLE + nf.format(CatacombsTracker.fumingPotatoBooks) + "\n" +
                            EnumChatFormatting.DARK_PURPLE + nf.format(CatacombsTracker.spiritWings) + "\n" +
                            EnumChatFormatting.DARK_PURPLE + nf.format(CatacombsTracker.spiritBones) + "\n" +
                            EnumChatFormatting.DARK_PURPLE + nf.format(CatacombsTracker.spiritBoots) + "\n" +
                            EnumChatFormatting.DARK_PURPLE + nf.format(CatacombsTracker.spiritSwords) + "\n" +
                            EnumChatFormatting.GOLD + nf.format(CatacombsTracker.spiritBows) + "\n" +
                            EnumChatFormatting.DARK_PURPLE + nf.format(CatacombsTracker.epicSpiritPets) + "\n" +
                            EnumChatFormatting.GOLD + nf.format(CatacombsTracker.legSpiritPets) + "\n" +
                            EnumChatFormatting.AQUA + Utils.getMoneySpent(CatacombsTracker.f4CoinsSpent) + "\n" +
                            EnumChatFormatting.AQUA + Utils.getTimeBetween(0, CatacombsTracker.f4TimeSpent);
                    break;
                case "catacombs_floor_four_session":
                    dropsText = EnumChatFormatting.GOLD + "S+ Runs:\n" +
                            EnumChatFormatting.GOLD + "Recombobulators:\n" +
                            EnumChatFormatting.DARK_PURPLE + "Fuming Potato Books:\n" +
                            EnumChatFormatting.DARK_PURPLE + "Spirit Wings:\n" +
                            EnumChatFormatting.DARK_PURPLE + "Spirit Bones:\n" +
                            EnumChatFormatting.DARK_PURPLE + "Spirit Boots:\n" +
                            EnumChatFormatting.DARK_PURPLE + "Spirit Swords:\n" +
                            EnumChatFormatting.GOLD + "Spirit Bows:\n" +
                            EnumChatFormatting.DARK_PURPLE + "Epic Spirit Pets:\n" +
                            EnumChatFormatting.GOLD + "Leg Spirit Pets:\n" +
                            EnumChatFormatting.AQUA + "Coins Spent:\n" +
                            EnumChatFormatting.AQUA + "Time Spent:";
                    countText = EnumChatFormatting.GOLD + nf.format(CatacombsTracker.f4SPlusSession) + "\n" +
                            EnumChatFormatting.GOLD + nf.format(CatacombsTracker.recombobulatorsSession) + "\n" +
                            EnumChatFormatting.DARK_PURPLE + nf.format(CatacombsTracker.fumingPotatoBooksSession) + "\n" +
                            EnumChatFormatting.DARK_PURPLE + nf.format(CatacombsTracker.spiritWingsSession) + "\n" +
                            EnumChatFormatting.DARK_PURPLE + nf.format(CatacombsTracker.spiritBonesSession) + "\n" +
                            EnumChatFormatting.DARK_PURPLE + nf.format(CatacombsTracker.spiritBootsSession) + "\n" +
                            EnumChatFormatting.DARK_PURPLE + nf.format(CatacombsTracker.spiritSwordsSession) + "\n" +
                            EnumChatFormatting.GOLD + nf.format(CatacombsTracker.spiritBowsSession) + "\n" +
                            EnumChatFormatting.DARK_PURPLE + nf.format(CatacombsTracker.epicSpiritPetsSession) + "\n" +
                            EnumChatFormatting.GOLD + nf.format(CatacombsTracker.legSpiritPetsSession) + "\n" +
                            EnumChatFormatting.AQUA + Utils.getMoneySpent(CatacombsTracker.f4CoinsSpentSession) + "\n" +
                            EnumChatFormatting.AQUA + Utils.getTimeBetween(0, CatacombsTracker.f4TimeSpentSession);
                    break;
                case "catacombs_floor_five":
                    dropsText = EnumChatFormatting.GOLD + "S+ Runs:\n" +
                            EnumChatFormatting.GOLD + "Recombobulators:\n" +
                            EnumChatFormatting.DARK_PURPLE + "Fuming Potato Books:\n" +
                            EnumChatFormatting.BLUE + "Warped Stones:\n" +
                            EnumChatFormatting.DARK_PURPLE + "Shadow Helmets:\n" +
                            EnumChatFormatting.DARK_PURPLE + "Shadow Chestplates:\n" +
                            EnumChatFormatting.DARK_PURPLE + "Shadow Leggings:\n" +
                            EnumChatFormatting.DARK_PURPLE + "Shadow Boots:\n" +
                            EnumChatFormatting.GOLD + "Last Breaths:\n" +
                            EnumChatFormatting.GOLD + "Livid Daggers:\n" +
                            EnumChatFormatting.GOLD + "Shadow Furys:\n" +
                            EnumChatFormatting.AQUA + "Coins Spent:\n" +
                            EnumChatFormatting.AQUA + "Time Spent:";
                    countText = EnumChatFormatting.GOLD + nf.format(CatacombsTracker.f5SPlus) + "\n" +
                            EnumChatFormatting.GOLD + nf.format(CatacombsTracker.recombobulators) + "\n" +
                            EnumChatFormatting.DARK_PURPLE + nf.format(CatacombsTracker.fumingPotatoBooks) + "\n" +
                            EnumChatFormatting.BLUE + nf.format(CatacombsTracker.warpedStones) + "\n" +
                            EnumChatFormatting.DARK_PURPLE + nf.format(CatacombsTracker.shadowAssHelms) + "\n" +
                            EnumChatFormatting.DARK_PURPLE + nf.format(CatacombsTracker.shadowAssChests) + "\n" +
                            EnumChatFormatting.DARK_PURPLE + nf.format(CatacombsTracker.shadowAssLegs) + "\n" +
                            EnumChatFormatting.DARK_PURPLE + nf.format(CatacombsTracker.shadowAssBoots) + "\n" +
                            EnumChatFormatting.GOLD + nf.format(CatacombsTracker.lastBreaths) + "\n" +
                            EnumChatFormatting.GOLD + nf.format(CatacombsTracker.lividDaggers) + "\n" +
                            EnumChatFormatting.GOLD + nf.format(CatacombsTracker.shadowFurys) + "\n" +
                            EnumChatFormatting.AQUA + Utils.getMoneySpent(CatacombsTracker.f5CoinsSpent) + "\n" +
                            EnumChatFormatting.AQUA + Utils.getTimeBetween(0, CatacombsTracker.f5TimeSpent);
                    break;
                case "catacombs_floor_five_session":
                    dropsText = EnumChatFormatting.GOLD + "S+ Runs:\n" +
                            EnumChatFormatting.GOLD + "Recombobulators:\n" +
                            EnumChatFormatting.DARK_PURPLE + "Fuming Potato Books:\n" +
                            EnumChatFormatting.BLUE + "Warped Stones:\n" +
                            EnumChatFormatting.DARK_PURPLE + "Shadow Helmets:\n" +
                            EnumChatFormatting.DARK_PURPLE + "Shadow Chestplates:\n" +
                            EnumChatFormatting.DARK_PURPLE + "Shadow Leggings:\n" +
                            EnumChatFormatting.DARK_PURPLE + "Shadow Boots:\n" +
                            EnumChatFormatting.GOLD + "Last Breaths:\n" +
                            EnumChatFormatting.GOLD + "Livid Daggers:\n" +
                            EnumChatFormatting.GOLD + "Shadow Furys:\n" +
                            EnumChatFormatting.AQUA + "Coins Spent:\n" +
                            EnumChatFormatting.AQUA + "Time Spent:";
                    countText = EnumChatFormatting.GOLD + nf.format(CatacombsTracker.f5SPlusSession) + "\n" +
                            EnumChatFormatting.GOLD + nf.format(CatacombsTracker.recombobulatorsSession) + "\n" +
                            EnumChatFormatting.DARK_PURPLE + nf.format(CatacombsTracker.fumingPotatoBooksSession) + "\n" +
                            EnumChatFormatting.BLUE + nf.format(CatacombsTracker.warpedStonesSession) + "\n" +
                            EnumChatFormatting.DARK_PURPLE + nf.format(CatacombsTracker.shadowAssHelmsSession) + "\n" +
                            EnumChatFormatting.DARK_PURPLE + nf.format(CatacombsTracker.shadowAssChestsSession) + "\n" +
                            EnumChatFormatting.DARK_PURPLE + nf.format(CatacombsTracker.shadowAssLegsSession) + "\n" +
                            EnumChatFormatting.DARK_PURPLE + nf.format(CatacombsTracker.shadowAssBootsSession) + "\n" +
                            EnumChatFormatting.GOLD + nf.format(CatacombsTracker.lastBreathsSession) + "\n" +
                            EnumChatFormatting.GOLD + nf.format(CatacombsTracker.lividDaggersSession) + "\n" +
                            EnumChatFormatting.GOLD + nf.format(CatacombsTracker.shadowFurysSession) + "\n" +
                            EnumChatFormatting.AQUA + Utils.getMoneySpent(CatacombsTracker.f5CoinsSpentSession) + "\n" +
                            EnumChatFormatting.AQUA + Utils.getTimeBetween(0, CatacombsTracker.f5TimeSpentSession);
                    break;
                case "catacombs_floor_six":
                    dropsText = EnumChatFormatting.GOLD + "S+ Runs:\n" +
                            EnumChatFormatting.GOLD + "Recombobulators:\n" +
                            EnumChatFormatting.DARK_PURPLE + "Fuming Potato Books:\n" +
                            EnumChatFormatting.BLUE + "Ancient Roses:\n" +
                            EnumChatFormatting.GOLD + "Precursor Eyes:\n" +
                            EnumChatFormatting.GOLD + "Giant's Swords:\n" +
                            EnumChatFormatting.GOLD + "Necro Lord Helmets:\n" +
                            EnumChatFormatting.GOLD + "Necro Lord Chests:\n" +
                            EnumChatFormatting.GOLD + "Necro Lord Leggings:\n" +
                            EnumChatFormatting.GOLD + "Necro Lord Boots:\n" +
                            EnumChatFormatting.GOLD + "Necro Swords:\n" +
                            EnumChatFormatting.WHITE + "Rerolls:\n" +
                            EnumChatFormatting.AQUA + "Coins Spent:\n" +
                            EnumChatFormatting.AQUA + "Time Spent:";
                    countText = EnumChatFormatting.GOLD + nf.format(CatacombsTracker.f6SPlus) + "\n" +
                            EnumChatFormatting.GOLD + nf.format(CatacombsTracker.recombobulators) + "\n" +
                            EnumChatFormatting.DARK_PURPLE + nf.format(CatacombsTracker.fumingPotatoBooks) + "\n" +
                            EnumChatFormatting.BLUE + nf.format(CatacombsTracker.ancientRoses) + "\n" +
                            EnumChatFormatting.GOLD + nf.format(CatacombsTracker.precursorEyes) + "\n" +
                            EnumChatFormatting.GOLD + nf.format(CatacombsTracker.giantsSwords) + "\n" +
                            EnumChatFormatting.GOLD + nf.format(CatacombsTracker.necroLordHelms) + "\n" +
                            EnumChatFormatting.GOLD + nf.format(CatacombsTracker.necroLordChests) + "\n" +
                            EnumChatFormatting.GOLD + nf.format(CatacombsTracker.necroLordLegs) + "\n" +
                            EnumChatFormatting.GOLD + nf.format(CatacombsTracker.necroLordBoots) + "\n" +
                            EnumChatFormatting.GOLD + nf.format(CatacombsTracker.necroSwords) + "\n" +
                            EnumChatFormatting.WHITE + nf.format(CatacombsTracker.f6Rerolls) + "\n" +
                            EnumChatFormatting.AQUA + Utils.getMoneySpent(CatacombsTracker.f6CoinsSpent) + "\n" +
                            EnumChatFormatting.AQUA + Utils.getTimeBetween(0, CatacombsTracker.f6TimeSpent);
                    break;
                case "catacombs_floor_six_session":
                    dropsText = EnumChatFormatting.GOLD + "S+ Runs:\n" +
                            EnumChatFormatting.GOLD + "Recombobulators:\n" +
                            EnumChatFormatting.DARK_PURPLE + "Fuming Potato Books:\n" +
                            EnumChatFormatting.BLUE + "Ancient Roses:\n" +
                            EnumChatFormatting.GOLD + "Precursor Eyes:\n" +
                            EnumChatFormatting.GOLD + "Giant's Swords:\n" +
                            EnumChatFormatting.GOLD + "Necro Lord Helmets:\n" +
                            EnumChatFormatting.GOLD + "Necro Lord Chests:\n" +
                            EnumChatFormatting.GOLD + "Necro Lord Leggings:\n" +
                            EnumChatFormatting.GOLD + "Necro Lord Boots:\n" +
                            EnumChatFormatting.GOLD + "Necro Swords:\n" +
                            EnumChatFormatting.WHITE + "Rerolls:\n" +
                            EnumChatFormatting.AQUA + "Coins Spent:\n" +
                            EnumChatFormatting.AQUA + "Time Spent:";
                    countText = EnumChatFormatting.GOLD + nf.format(CatacombsTracker.f6SPlusSession) + "\n" +
                            EnumChatFormatting.GOLD + nf.format(CatacombsTracker.recombobulatorsSession) + "\n" +
                            EnumChatFormatting.DARK_PURPLE + nf.format(CatacombsTracker.fumingPotatoBooksSession) + "\n" +
                            EnumChatFormatting.BLUE + nf.format(CatacombsTracker.ancientRosesSession) + "\n" +
                            EnumChatFormatting.GOLD + nf.format(CatacombsTracker.precursorEyesSession) + "\n" +
                            EnumChatFormatting.GOLD + nf.format(CatacombsTracker.giantsSwordsSession) + "\n" +
                            EnumChatFormatting.GOLD + nf.format(CatacombsTracker.necroLordHelmsSession) + "\n" +
                            EnumChatFormatting.GOLD + nf.format(CatacombsTracker.necroLordChestsSession) + "\n" +
                            EnumChatFormatting.GOLD + nf.format(CatacombsTracker.necroLordLegsSession) + "\n" +
                            EnumChatFormatting.GOLD + nf.format(CatacombsTracker.necroLordBootsSession) + "\n" +
                            EnumChatFormatting.GOLD + nf.format(CatacombsTracker.necroSwordsSession) + "\n" +
                            EnumChatFormatting.WHITE + nf.format(CatacombsTracker.f6RerollsSession) + "\n" +
                            EnumChatFormatting.AQUA + Utils.getMoneySpent(CatacombsTracker.f6CoinsSpentSession) + "\n" +
                            EnumChatFormatting.AQUA + Utils.getTimeBetween(0, CatacombsTracker.f6TimeSpentSession);
                    break;
                case "catacombs_floor_seven":
                    dropsText = EnumChatFormatting.GOLD + "S+ Runs:\n" +
                            EnumChatFormatting.GOLD + "Recombobulators:\n" +
                            EnumChatFormatting.DARK_PURPLE + "Fuming Potato Books:\n" +
                            EnumChatFormatting.DARK_PURPLE + "Wither Bloods:\n" +
                            EnumChatFormatting.DARK_PURPLE + "Wither Cloaks:\n" +
                            EnumChatFormatting.DARK_PURPLE + "Implosions:\n" +
                            EnumChatFormatting.DARK_PURPLE + "Wither Shields:\n" +
                            EnumChatFormatting.DARK_PURPLE + "Shadow Warps:\n" +
                            EnumChatFormatting.DARK_PURPLE + "Necron's Handles:\n" +
                            EnumChatFormatting.GOLD + "Auto Recombobs:\n" +
                            EnumChatFormatting.GOLD + "Wither Helmets:\n" +
                            EnumChatFormatting.GOLD + "Wither Chests:\n" +
                            EnumChatFormatting.GOLD + "Wither Leggings:\n" +
                            EnumChatFormatting.GOLD + "Wither Boots:\n" +
                            EnumChatFormatting.WHITE + "Rerolls:\n" +
                            EnumChatFormatting.AQUA + "Coins Spent:\n" +
                            EnumChatFormatting.AQUA + "Time Spent:";
                    countText = EnumChatFormatting.GOLD + nf.format(CatacombsTracker.f7SPlus) + "\n" +
                            EnumChatFormatting.GOLD + nf.format(CatacombsTracker.recombobulators) + "\n" +
                            EnumChatFormatting.DARK_PURPLE + nf.format(CatacombsTracker.fumingPotatoBooks) + "\n" +
                            EnumChatFormatting.DARK_PURPLE + nf.format(CatacombsTracker.witherBloods) + "\n" +
                            EnumChatFormatting.DARK_PURPLE + nf.format(CatacombsTracker.witherCloaks) + "\n" +
                            EnumChatFormatting.DARK_PURPLE + nf.format(CatacombsTracker.implosions) + "\n" +
                            EnumChatFormatting.DARK_PURPLE + nf.format(CatacombsTracker.witherShields) + "\n" +
                            EnumChatFormatting.DARK_PURPLE + nf.format(CatacombsTracker.shadowWarps) + "\n" +
                            EnumChatFormatting.DARK_PURPLE + nf.format(CatacombsTracker.necronsHandles) + "\n" +
                            EnumChatFormatting.GOLD + nf.format(CatacombsTracker.autoRecombs) + "\n" +
                            EnumChatFormatting.GOLD + nf.format(CatacombsTracker.witherHelms) + "\n" +
                            EnumChatFormatting.GOLD + nf.format(CatacombsTracker.witherChests) + "\n" +
                            EnumChatFormatting.GOLD + nf.format(CatacombsTracker.witherLegs) + "\n" +
                            EnumChatFormatting.GOLD + nf.format(CatacombsTracker.witherBoots) + "\n" +
                            EnumChatFormatting.WHITE + nf.format(CatacombsTracker.f7Rerolls) + "\n" +
                            EnumChatFormatting.AQUA + Utils.getMoneySpent(CatacombsTracker.f7CoinsSpent) + "\n" +
                            EnumChatFormatting.AQUA + Utils.getTimeBetween(0, CatacombsTracker.f7TimeSpent);
                    break;
                case "catacombs_floor_seven_session":
                    dropsText = EnumChatFormatting.GOLD + "S+ Runs:\n" +
                            EnumChatFormatting.GOLD + "Recombobulators:\n" +
                            EnumChatFormatting.DARK_PURPLE + "Fuming Potato Books:\n" +
                            EnumChatFormatting.DARK_PURPLE + "Wither Bloods:\n" +
                            EnumChatFormatting.DARK_PURPLE + "Wither Cloaks:\n" +
                            EnumChatFormatting.DARK_PURPLE + "Implosions:\n" +
                            EnumChatFormatting.DARK_PURPLE + "Wither Shields:\n" +
                            EnumChatFormatting.DARK_PURPLE + "Shadow Warps:\n" +
                            EnumChatFormatting.DARK_PURPLE + "Necron's Handles:\n" +
                            EnumChatFormatting.GOLD + "Auto Recombobulators:\n" +
                            EnumChatFormatting.GOLD + "Wither Helmets:\n" +
                            EnumChatFormatting.GOLD + "Wither Chests:\n" +
                            EnumChatFormatting.GOLD + "Wither Leggings:\n" +
                            EnumChatFormatting.GOLD + "Wither Boots:\n" +
                            EnumChatFormatting.WHITE + "Rerolls:\n" +
                            EnumChatFormatting.AQUA + "Coins Spent:\n" +
                            EnumChatFormatting.AQUA + "Time Spent:";
                    countText = EnumChatFormatting.GOLD + nf.format(CatacombsTracker.f7SPlusSession) + "\n" +
                            EnumChatFormatting.GOLD + nf.format(CatacombsTracker.recombobulatorsSession) + "\n" +
                            EnumChatFormatting.DARK_PURPLE + nf.format(CatacombsTracker.fumingPotatoBooksSession) + "\n" +
                            EnumChatFormatting.DARK_PURPLE + nf.format(CatacombsTracker.witherBloodsSession) + "\n" +
                            EnumChatFormatting.DARK_PURPLE + nf.format(CatacombsTracker.witherCloaksSession) + "\n" +
                            EnumChatFormatting.DARK_PURPLE + nf.format(CatacombsTracker.implosionsSession) + "\n" +
                            EnumChatFormatting.DARK_PURPLE + nf.format(CatacombsTracker.witherShieldsSession) + "\n" +
                            EnumChatFormatting.DARK_PURPLE + nf.format(CatacombsTracker.shadowWarpsSession) + "\n" +
                            EnumChatFormatting.DARK_PURPLE + nf.format(CatacombsTracker.necronsHandlesSession) + "\n" +
                            EnumChatFormatting.GOLD + nf.format(CatacombsTracker.autoRecombsSession) + "\n" +
                            EnumChatFormatting.GOLD + nf.format(CatacombsTracker.witherHelmsSession) + "\n" +
                            EnumChatFormatting.GOLD + nf.format(CatacombsTracker.witherChestsSession) + "\n" +
                            EnumChatFormatting.GOLD + nf.format(CatacombsTracker.witherLegsSession) + "\n" +
                            EnumChatFormatting.GOLD + nf.format(CatacombsTracker.witherBootsSession) + "\n" +
                            EnumChatFormatting.WHITE + nf.format(CatacombsTracker.f7RerollsSession) + "\n" +
                            EnumChatFormatting.AQUA + Utils.getMoneySpent(CatacombsTracker.f7CoinsSpentSession) + "\n" +
                            EnumChatFormatting.AQUA + Utils.getTimeBetween(0, CatacombsTracker.f7TimeSpentSession);
                    break;
                case "catacombs_master":
                    if (ToggleCommand.masterSPlusDisplay) {
                        runs = EnumChatFormatting.GOLD + "Master One S+:\n" +
                            EnumChatFormatting.GOLD + "Master Two S+:\n" +
                            EnumChatFormatting.GOLD + "Master Three S+:\n" +
                            EnumChatFormatting.GOLD + "Master Four S+:\n" +
                            EnumChatFormatting.GOLD + "Master Five S+:\n" +
                            EnumChatFormatting.GOLD + "Master Six S+:\n" +
                            EnumChatFormatting.GOLD + "Master Seven S+:\n";
                        runsCount = EnumChatFormatting.GOLD + nf.format(CatacombsTracker.m1SPlus) + "\n" +
                            EnumChatFormatting.GOLD + nf.format(CatacombsTracker.m2SPlus) + "\n" +
                            EnumChatFormatting.GOLD + nf.format(CatacombsTracker.m3SPlus) + "\n" +
                            EnumChatFormatting.GOLD + nf.format(CatacombsTracker.m4SPlus) + "\n" +
                            EnumChatFormatting.GOLD + nf.format(CatacombsTracker.m5SPlus) + "\n" +
                            EnumChatFormatting.GOLD + nf.format(CatacombsTracker.m6SPlus) + "\n" +
                            EnumChatFormatting.GOLD + nf.format(CatacombsTracker.m7SPlus) + "\n";
                    } else {
                        runs = EnumChatFormatting.GOLD + "Master One S:\n" +
                                EnumChatFormatting.GOLD + "Master Two S:\n" +
                                EnumChatFormatting.GOLD + "Master Three S:\n" +
                                EnumChatFormatting.GOLD + "Master Four S:\n" +
                                EnumChatFormatting.GOLD + "Master Five S:\n" +
                                EnumChatFormatting.GOLD + "Master Six S:\n" +
                                EnumChatFormatting.GOLD + "Master Seven S:\n";
                        runsCount = EnumChatFormatting.GOLD + nf.format(CatacombsTracker.m1S) + "\n" +
                                EnumChatFormatting.GOLD + nf.format(CatacombsTracker.m2S) + "\n" +
                                EnumChatFormatting.GOLD + nf.format(CatacombsTracker.m3S) + "\n" +
                                EnumChatFormatting.GOLD + nf.format(CatacombsTracker.m4S) + "\n" +
                                EnumChatFormatting.GOLD + nf.format(CatacombsTracker.m5S) + "\n" +
                                EnumChatFormatting.GOLD + nf.format(CatacombsTracker.m6S) + "\n" +
                                EnumChatFormatting.GOLD + nf.format(CatacombsTracker.m7S) + "\n";
                    }

                    dropsText = runs +
                            EnumChatFormatting.GOLD + "Recombobulators:\n" +
                            EnumChatFormatting.DARK_PURPLE + "Fuming Potato Books:\n" +
                            EnumChatFormatting.DARK_PURPLE + "1st Master Stars:\n" +
                            EnumChatFormatting.DARK_PURPLE + "2nd Master Stars:\n" +
                            EnumChatFormatting.DARK_PURPLE + "3rd Master Stars:\n" +
                            EnumChatFormatting.DARK_PURPLE + "4th Master Stars:\n" +
                            EnumChatFormatting.DARK_PURPLE + "5th Master Stars:\n" +
                            EnumChatFormatting.GOLD + "Necron Dyes:\n" +
                            EnumChatFormatting.GOLD + "Dark Claymores:\n" +
                            EnumChatFormatting.WHITE + "Rerolls:\n" +
                            EnumChatFormatting.AQUA + "Coins Spent:\n" +
                            EnumChatFormatting.AQUA + "Time Spent:";
                    countText = runsCount +
                            EnumChatFormatting.GOLD + nf.format(CatacombsTracker.recombobulators) + "\n" +
                            EnumChatFormatting.DARK_PURPLE + nf.format(CatacombsTracker.fumingPotatoBooks) + "\n" +
                            EnumChatFormatting.DARK_PURPLE + nf.format(CatacombsTracker.firstStars) + "\n" +
                            EnumChatFormatting.DARK_PURPLE + nf.format(CatacombsTracker.secondStars) + "\n" +
                            EnumChatFormatting.DARK_PURPLE + nf.format(CatacombsTracker.thirdStars) + "\n" +
                            EnumChatFormatting.DARK_PURPLE + nf.format(CatacombsTracker.fourthStars) + "\n" +
                            EnumChatFormatting.DARK_PURPLE + nf.format(CatacombsTracker.fifthStars) + "\n" +
                            EnumChatFormatting.GOLD + nf.format(CatacombsTracker.necronDyes) + "\n" +
                            EnumChatFormatting.GOLD + nf.format(CatacombsTracker.darkClaymores) + "\n" +
                            EnumChatFormatting.WHITE + nf.format(CatacombsTracker.masterRerolls) + "\n" +
                            EnumChatFormatting.AQUA + Utils.getMoneySpent(CatacombsTracker.masterCoinsSpent) + "\n" +
                            EnumChatFormatting.AQUA + Utils.getTimeBetween(0, CatacombsTracker.masterTimeSpent);
                    break;
                case "catacombs_master_session":
                    if (ToggleCommand.masterSPlusDisplay) {
                        runs = EnumChatFormatting.GOLD + "Master One S+:\n" +
                                EnumChatFormatting.GOLD + "Master Two S+:\n" +
                                EnumChatFormatting.GOLD + "Master Three S+:\n" +
                                EnumChatFormatting.GOLD + "Master Four S+:\n" +
                                EnumChatFormatting.GOLD + "Master Five S+:\n" +
                                EnumChatFormatting.GOLD + "Master Six S+:\n" +
                                EnumChatFormatting.GOLD + "Master Seven S+:\n";
                        runsCount = EnumChatFormatting.GOLD + nf.format(CatacombsTracker.m1SPlusSession) + "\n" +
                                EnumChatFormatting.GOLD + nf.format(CatacombsTracker.m2SPlusSession) + "\n" +
                                EnumChatFormatting.GOLD + nf.format(CatacombsTracker.m3SPlusSession) + "\n" +
                                EnumChatFormatting.GOLD + nf.format(CatacombsTracker.m4SPlusSession) + "\n" +
                                EnumChatFormatting.GOLD + nf.format(CatacombsTracker.m5SPlusSession) + "\n" +
                                EnumChatFormatting.GOLD + nf.format(CatacombsTracker.m6SPlusSession) + "\n" +
                                EnumChatFormatting.GOLD + nf.format(CatacombsTracker.m7SPlusSession) + "\n";
                    } else {
                        runs = EnumChatFormatting.GOLD + "Master One S:\n" +
                                EnumChatFormatting.GOLD + "Master Two S:\n" +
                                EnumChatFormatting.GOLD + "Master Three S:\n" +
                                EnumChatFormatting.GOLD + "Master Four S:\n" +
                                EnumChatFormatting.GOLD + "Master Five S:\n" +
                                EnumChatFormatting.GOLD + "Master Six S:\n" +
                                EnumChatFormatting.GOLD + "Master Seven S:\n";
                        runsCount = EnumChatFormatting.GOLD + nf.format(CatacombsTracker.m1SSession) + "\n" +
                                EnumChatFormatting.GOLD + nf.format(CatacombsTracker.m2SSession) + "\n" +
                                EnumChatFormatting.GOLD + nf.format(CatacombsTracker.m3SSession) + "\n" +
                                EnumChatFormatting.GOLD + nf.format(CatacombsTracker.m4SSession) + "\n" +
                                EnumChatFormatting.GOLD + nf.format(CatacombsTracker.m5SSession) + "\n" +
                                EnumChatFormatting.GOLD + nf.format(CatacombsTracker.m6SSession) + "\n" +
                                EnumChatFormatting.GOLD + nf.format(CatacombsTracker.m7SSession) + "\n";
                    }

                    dropsText = runs +
                            EnumChatFormatting.GOLD + "Recombobulators:\n" +
                            EnumChatFormatting.DARK_PURPLE + "Fuming Potato Books:\n" +
                            EnumChatFormatting.DARK_PURPLE + "1st Master Stars:\n" +
                            EnumChatFormatting.DARK_PURPLE + "2nd Master Stars:\n" +
                            EnumChatFormatting.DARK_PURPLE + "3rd Master Stars:\n" +
                            EnumChatFormatting.DARK_PURPLE + "4th Master Stars:\n" +
                            EnumChatFormatting.DARK_PURPLE + "5th Master Stars:\n" +
                            EnumChatFormatting.GOLD + "Necron Dyes:\n" +
                            EnumChatFormatting.GOLD + "Dark Claymores:\n" +
                            EnumChatFormatting.WHITE + "Rerolls:\n" +
                            EnumChatFormatting.AQUA + "Coins Spent:\n" +
                            EnumChatFormatting.AQUA + "Time Spent:";
                    countText = runsCount +
                            EnumChatFormatting.GOLD + nf.format(CatacombsTracker.recombobulatorsSession) + "\n" +
                            EnumChatFormatting.DARK_PURPLE + nf.format(CatacombsTracker.fumingPotatoBooksSession) + "\n" +
                            EnumChatFormatting.DARK_PURPLE + nf.format(CatacombsTracker.firstStarsSession) + "\n" +
                            EnumChatFormatting.DARK_PURPLE + nf.format(CatacombsTracker.secondStarsSession) + "\n" +
                            EnumChatFormatting.DARK_PURPLE + nf.format(CatacombsTracker.thirdStarsSession) + "\n" +
                            EnumChatFormatting.DARK_PURPLE + nf.format(CatacombsTracker.fourthStarsSession) + "\n" +
                            EnumChatFormatting.DARK_PURPLE + nf.format(CatacombsTracker.fifthStarsSession) + "\n" +
                            EnumChatFormatting.GOLD + nf.format(CatacombsTracker.necronDyesSession) + "\n" +
                            EnumChatFormatting.GOLD + nf.format(CatacombsTracker.darkClaymoresSession) + "\n" +
                            EnumChatFormatting.WHITE + nf.format(CatacombsTracker.masterRerollsSession) + "\n" +
                            EnumChatFormatting.AQUA + Utils.getMoneySpent(CatacombsTracker.masterCoinsSpentSession) + "\n" +
                            EnumChatFormatting.AQUA + Utils.getTimeBetween(0, CatacombsTracker.masterTimeSpentSession);
                    break;
                case "ghost_session":
                    dropsText = EnumChatFormatting.GOLD + "Bags of Cash:\n" +
                            EnumChatFormatting.BLUE + "Sorrows:\n" +
                            EnumChatFormatting.DARK_PURPLE + "Ghosty Boots:\n" +
                            EnumChatFormatting.DARK_PURPLE + "Voltas:\n" +
                            EnumChatFormatting.DARK_PURPLE + "Plasmas:" ; // + \n
                           // EnumChatFormatting.AQUA + "Time Spent:" +
                    countText = EnumChatFormatting.GOLD + nf.format(GhostTracker.bagOfCashSession) + "\n" +
                            EnumChatFormatting.BLUE + nf.format(GhostTracker.sorrowSession) + "\n" +
                            EnumChatFormatting.DARK_PURPLE + nf.format(GhostTracker.ghostlyBootsSession) + "\n" +
                            EnumChatFormatting.DARK_PURPLE + nf.format(GhostTracker.voltaSession) + "\n" +
                            EnumChatFormatting.DARK_PURPLE + nf.format(GhostTracker.plasmaSession); //+ "\n" +
                         //   EnumChatFormatting.AQUA + nf.format(GhostTracker.ghostsTimeSpentSession);
                    break;
                case "ghost":
                    dropsText = EnumChatFormatting.GOLD + "Bags of Cash:\n" +
                            EnumChatFormatting.BLUE + "Sorrows:\n" +
                            EnumChatFormatting.DARK_PURPLE + "Ghosty Boots:\n" +
                            EnumChatFormatting.DARK_PURPLE + "Voltas:\n" +
                            EnumChatFormatting.DARK_PURPLE + "Plasmas:" ; // + \n
                    // EnumChatFormatting.AQUA + "Time Spent:" +
                    countText = EnumChatFormatting.GOLD + nf.format(GhostTracker.bagOfCashSession) + "\n" +
                            EnumChatFormatting.BLUE + nf.format(GhostTracker.sorrowSession) + "\n" +
                            EnumChatFormatting.DARK_PURPLE + nf.format(GhostTracker.ghostlyBootsSession) + "\n" +
                            EnumChatFormatting.DARK_PURPLE + nf.format(GhostTracker.voltaSession) + "\n" +
                            EnumChatFormatting.DARK_PURPLE + nf.format(GhostTracker.plasmaSession); //+ "\n" +
                    //   EnumChatFormatting.AQUA + nf.format(GhostTracker.ghostsTimeSpentSession);
                    break;


                default:
                    System.out.println("Display was an unknown value, turning off.");
                    display = "off";
                    ConfigHandler.writeStringConfig("misc", "display", "off");
            }
            new TextRenderer(mc, dropsText, MoveCommand.displayXY[0], MoveCommand.displayXY[1], ScaleCommand.displayScale);
            new TextRenderer(mc, countText, (int) (MoveCommand.displayXY[0] + (110 * ScaleCommand.displayScale)), MoveCommand.displayXY[1], ScaleCommand.displayScale);
        }
    }

}
