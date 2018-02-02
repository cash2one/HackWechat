package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent;

public class y$a {
    public String label = "";
    public String rhx = "";
    public float value;

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof y$a)) {
            return false;
        }
        y$a com_tencent_mm_plugin_sns_storage_AdLandingPagesStorage_AdLandingPageComponent_y_a = (y$a) obj;
        if (com_tencent_mm_plugin_sns_storage_AdLandingPagesStorage_AdLandingPageComponent_y_a.label.equals(this.label) && com_tencent_mm_plugin_sns_storage_AdLandingPagesStorage_AdLandingPageComponent_y_a.rhx.equals(this.rhx) && com_tencent_mm_plugin_sns_storage_AdLandingPagesStorage_AdLandingPageComponent_y_a.value == this.value) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return (int) (((float) (this.label.hashCode() + this.rhx.hashCode())) + this.value);
    }
}
