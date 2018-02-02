package com.tencent.mm.plugin.luckymoney.sns.b;

import com.tencent.mm.kernel.g;

public final class a {
    public static int aXs() {
        g.Dk();
        return ((Integer) g.Dj().CU().get(com.tencent.mm.storage.w.a.xqS, Integer.valueOf(0))).intValue();
    }

    public static void sc(int i) {
        g.Dk();
        g.Dj().CU().a(com.tencent.mm.storage.w.a.xqS, Integer.valueOf(i));
        g.Dk();
        g.Dj().CU().lH(true);
    }

    public static String aXt() {
        g.Dk();
        return (String) g.Dj().CU().get(com.tencent.mm.storage.w.a.xqX, "");
    }

    public static String aXu() {
        g.Dk();
        return (String) g.Dj().CU().get(com.tencent.mm.storage.w.a.xqY, "");
    }
}
