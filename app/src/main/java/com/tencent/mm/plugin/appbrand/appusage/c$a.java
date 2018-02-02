package com.tencent.mm.plugin.appbrand.appusage;

public enum c$a {
    FORCE_OFF(0),
    FORCE_ON(1);
    
    int boq;

    private c$a(int i) {
        this.boq = i;
    }

    public static c$a jC(int i) {
        for (c$a com_tencent_mm_plugin_appbrand_appusage_c_a : values()) {
            if (com_tencent_mm_plugin_appbrand_appusage_c_a.boq == i) {
                return com_tencent_mm_plugin_appbrand_appusage_c_a;
            }
        }
        return null;
    }
}
