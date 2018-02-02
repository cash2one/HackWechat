package com.tencent.mm.plugin.appbrand.appcache;

import android.annotation.SuppressLint;

@SuppressLint({"DefaultLocale"})
public class aa$b extends ab {
    aa$b(String str, String str2, int i) {
        super(String.format("WxaDebugPkg_%s_%d_%d", new Object[]{str, Integer.valueOf(i), Integer.valueOf(str2.hashCode())}), aa.ZZ() + String.format("debug_%d_%d_%d.wxapkg", new Object[]{Integer.valueOf(str.hashCode()), Integer.valueOf(i), Integer.valueOf(str2.hashCode())}), str2, str, String.format("%d-%s", new Object[]{Integer.valueOf(i), str2}).hashCode(), i);
    }
}
