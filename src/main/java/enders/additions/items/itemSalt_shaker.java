package enders.additions.items;

import java.util.Random;

import enders.additions.endersadditions;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;

public class itemSalt_shaker extends Item {
		public itemSalt_shaker() {
			setUnlocalizedName("EndersAdditions" + "_" + "salt_shaker").setMaxStackSize(1);	
			setCreativeTab(endersadditions.tabEnder);
			setTextureName("endersadditions" + ":" + "salt_shaker");
	    }
	@Override
	public ItemStack onItemRightClick(ItemStack itemStack, World world, EntityPlayer player) {
		if (!world.isRemote) {
	    	if(player.inventory.hasItem(enders.additions.register.items.salt_shaker)) {
	    	player.attackEntityFrom(DamageSource.magic, 1f);
	    	String SaltyQuote = null;
	    	
	        //randomizer code
	    	Random rand = new Random();
	    	int randomnum = rand.nextInt(20) + 1;
	    	if (randomnum == 1) {SaltyQuote = "Minecraft HungerGames is the orignal Battle Royale."; }
	    	if (randomnum == 2) {SaltyQuote = "<Fortnite> Oh wow! Look at you! Playing Minecraft! Loser."; }
	    	if (randomnum == 3) {SaltyQuote = "Its almost like there are better things you could be doing right now..."; }
	    	if (randomnum == 4) {SaltyQuote = "Stop treating me like a disposable. I will not always dispense salty things."; }
	    	if (randomnum == 5) {SaltyQuote = "Something Salty and orignal goes here"; }
	    	if (randomnum == 6) {SaltyQuote = "Both tears and sweat are salty, but they render a different result. Tears will get you sympathy; sweat will get you change."; }
	    	if (randomnum == 7) {SaltyQuote = "Is the ocean salty because the land never waves back?"; }
	    	if (randomnum == 8) {SaltyQuote = "Wit is the salt of conversation, not the food."; }
	    	if (randomnum == 9) {SaltyQuote = "This could be salt, or sugar. Only Ender will know."; }
	    	if (randomnum == 10) {SaltyQuote = "Noah."; }
	    	if (randomnum == 11) {SaltyQuote = "\"Commit die weeb.\""; }
	    	if (randomnum == 12) {SaltyQuote = "\"Do you are have the stupid?\""; }
	    	if (randomnum == 13) {SaltyQuote = "They say salt is not the thing to pour onto a wound, but after looking at you I think salt would be the pain reliever."; }
	    	if (randomnum == 14) {SaltyQuote = "https://www.youtube.com/watch?v=dQw4w9WgXcQ"; }
	    	if (randomnum == 15) {SaltyQuote = "I think its time you moved out of the basement."; }
	    	if (randomnum == 16) {SaltyQuote = "<EnderVampire> Noah is only salty because i'm toooooootaaaaalllllllllyyyyyyyyyyyyyyyy the better mod dev"; }
	    	if (randomnum == 17) {SaltyQuote = "Cokekiwi#5861 is pretty salty if you ask me"; }
	    	if (randomnum == 18) {SaltyQuote = "Thanks Cokekiwi#5861 for the best thing ill ever make"; }
	    	if (randomnum == 19) {SaltyQuote = "If you listen to a seashell some say it calls for Cokekiwi#5861"; }
	    	if (randomnum == 20) {SaltyQuote = "<salt> Cokekiwi#5861 gave birth to me."; }
	    	//if (randomnum == 0) {SaltyQuote = ""; }
	 	   
	    	//message LOC
	    	player.addChatComponentMessage(new ChatComponentTranslation(SaltyQuote));
	    	}
		}
		return itemStack;
	}

}
