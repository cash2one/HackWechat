package com.tencent.mm.plugin.appbrand.launching;

public enum ae$a {
    Ok,
    Fail,
    Timeout,
    CgiFail,
    ResponseInvalid,
    AwaitFail;

    public static ae$a kQ(int i) {
        if (i < 0) {
            return null;
        }
        for (ae$a com_tencent_mm_plugin_appbrand_launching_ae_a : values()) {
            if (com_tencent_mm_plugin_appbrand_launching_ae_a.ordinal() == i) {
                return com_tencent_mm_plugin_appbrand_launching_ae_a;
            }
        }
        return null;
    }
}
