package com.tencent.mm.plugin.appbrand.appusage;

import com.tencent.mm.plugin.appbrand.q.c;
import com.tencent.mm.plugin.appbrand.task.d;
import com.tencent.mm.sdk.platformtools.bh;

public enum s {
    ;

    public static void i(String str, String str2, int i) {
        if (!bh.ov(str2)) {
            d.aJ(str2, i);
            c.Dm().F(new 1(str, str2, i));
        }
    }
}
