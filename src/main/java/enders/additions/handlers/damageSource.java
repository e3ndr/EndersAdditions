package enders.additions.handlers;

import cpw.mods.fml.common.registry.LanguageRegistry;
import net.minecraft.util.DamageSource;

public class damageSource extends DamageSource {
	public static DamageSource bleach = (new damageSource("bleach")).setDamageBypassesArmor();
	public static DamageSource salt = (new damageSource("salt")).setDamageBypassesArmor();
	public damageSource(String label) {
		super(label);
	}
}