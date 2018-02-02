package com.tencent.mm.plugin.appbrand.appcache;

import java.util.Locale;

public final class ak extends ab {
    private static String c(String str, String str2, int i, int i2) {
        return String.format(Locale.US, "WxaPage_%s_%d_%d_%d", new Object[]{str2, Integer.valueOf(i2), Integer.valueOf(i), Integer.valueOf(str.hashCode())});
    }

    ak(String str, String str2, int i, int i2) {
        String c = c(str, str2, i, i2);
        String c2 = c(str, str2, i, i2);
        super(c, aa.ZZ() + String.format("_%s.wxapkg", new Object[]{c2}), str, str2, i, i2);
    }
}
