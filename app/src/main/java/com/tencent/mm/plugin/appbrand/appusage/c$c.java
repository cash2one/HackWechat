package com.tencent.mm.plugin.appbrand.appusage;

public enum c$c {
    WXAPP(1),
    H5(2);
    
    private int boq;

    private c$c(int i) {
        this.boq = i;
    }

    public static c$c jD(int i) {
        for (c$c com_tencent_mm_plugin_appbrand_appusage_c_c : values()) {
            if (i == com_tencent_mm_plugin_appbrand_appusage_c_c.boq) {
                return com_tencent_mm_plugin_appbrand_appusage_c_c;
            }
        }
        return null;
    }
}
