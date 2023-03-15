package io.github.javajump3r.jjcraftslotabuse;

import io.github.javajump3r.autocfg.Configurable;
import io.github.javajump3r.autocfg.CustomCategory;
import io.github.javajumper.lavajumper.common.Feature;

public class CraftSlotAbuseConfig extends Feature {
    @CustomCategory(category = CustomCategory.TOGGLE_FEATURES)
    @Configurable(defaultValue = "true")
    public static boolean enabled=true;
}
