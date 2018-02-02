package com.tencent.mm.api;

import com.tencent.mm.a.g;
import com.tencent.mm.plugin.n.c;
import com.tencent.mm.sdk.platformtools.bh;

public final class a {
    public static String bZ(String str) {
        if (bh.ov(str)) {
            str = "tempConv";
        }
        StringBuilder stringBuilder = new StringBuilder(c.Fj());
        stringBuilder.append(g.s(str.getBytes())).append("/");
        stringBuilder.append("conv/");
        return stringBuilder.toString();
    }
}
