package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage;

class e$a {
    int roa;
    int rob;
    int roc;

    private e$a() {
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof e$a)) {
            return false;
        }
        e$a com_tencent_mm_plugin_sns_storage_AdLandingPagesStorage_e_a = (e$a) obj;
        if (com_tencent_mm_plugin_sns_storage_AdLandingPagesStorage_e_a.roa == this.roa && com_tencent_mm_plugin_sns_storage_AdLandingPagesStorage_e_a.rob == this.rob && com_tencent_mm_plugin_sns_storage_AdLandingPagesStorage_e_a.roc == this.roc) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return (this.roa + this.rob) + this.roc;
    }

    public final String toString() {
        return "[nodeType=" + this.roa + ",compType=" + this.rob + ",subCompType=" + this.roc + "]";
    }
}
