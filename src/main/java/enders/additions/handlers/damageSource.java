package enders.additions.handlers;

import cpw.mods.fml.common.registry.LanguageRegistry;
import net.minecraft.util.DamageSource;

public class damageSource extends DamageSource {
// ta-da! now you've got a public constructor

	public static DamageSource bleach = (new damageSource("bleach")).setDamageBypassesArmor();
	public damageSource(String label) {
		super(label);
	}
}