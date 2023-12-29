package io.github.javajump3r.jjcraftslotabuse;

import io.github.javajump3r.autocfg.CustomCategory;
import io.github.javajumper.lavajumper.LavaJumper;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.loader.api.FabricLoader;

public class CraftSlotAbuseInit implements ClientModInitializer {

	private static boolean isLavaJumperLoaded;
	public static boolean abuseEnabled(){
		if(isLavaJumperLoaded){
			return CraftSlotAbuseConfig.enabled;
			LavaJumper.LavaJumperConfig.addClassToConfig();
		}
		return true;
	}
	@Override
	public void onInitializeClient() {
		isLavaJumperLoaded = FabricLoader.getInstance().isModLoaded("lavajumper-core");
		if(isLavaJumperLoaded)
			new CraftSlotAbuseConfig();
	}
}
