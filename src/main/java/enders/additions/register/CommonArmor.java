package enders.additions.register;

import net.minecraft.entity.Entity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;

public class CommonArmor extends ItemArmor {
	public CommonArmor(ArmorMaterial armormaterial, int renderID, int partID) {
		super(armormaterial, renderID, partID);
	}
	public String getArmorTexture(ItemStack itemStack, Entity entity, int slot, String layer) {
		String itemName = itemStack.getUnlocalizedName().replaceFirst("item.EndersAdditions_", "");
		switch (itemName) {
			case "armor": return "endersadditions:textures/models/armor/armor.png";
		}
		return null;
	}
	
}
