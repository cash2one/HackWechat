package com.tencent.mm.plugin.appbrand.appcache;

import com.tencent.mm.sdk.platformtools.x;

public final class f {
    public static boolean a(String str, int i, int i2, String str2, aj$a com_tencent_mm_plugin_appbrand_appcache_aj_a) {
        return aj.a(new x(str, i, i2, str2, com_tencent_mm_plugin_appbrand_appcache_aj_a), com_tencent_mm_plugin_appbrand_appcache_aj_a);
    }

    static int v(String str, String str2, String str3) {
        int i = 1;
        try {
            i = WABSPatch.bspatch(str, str2, str3);
        } catch (Exception e) {
            x.e("MicroMsg.AppBrand.IncrementalPkgLogic[incremental]", "mergeDiffPkg e = %s, old[%s], new[%s], diff[%s]", new Object[]{e, str, str2, str3});
        }
        return i;
    }
}
