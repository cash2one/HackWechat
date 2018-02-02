package com.tencent.mm.bh;

import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.w.a;
import com.tencent.mm.z.ar;

public enum c {
    ;

    private c(String str) {
    }

    public static boolean Vb() {
        return !bh.ov(Ve());
    }

    public static String Ve() {
        ar.Hg();
        x.i("MicroMsg.WebviewKeepManager", "getLastPage : %s", new Object[]{(String) com.tencent.mm.z.c.CU().get(a.xtB, String.valueOf(""))});
        return (String) com.tencent.mm.z.c.CU().get(a.xtB, String.valueOf(""));
    }

    public static String Vd() {
        ar.Hg();
        x.i("MicroMsg.WebviewKeepManager", "getLastPageTitle : %s", new Object[]{(String) com.tencent.mm.z.c.CU().get(a.xtC, String.valueOf(""))});
        return (String) com.tencent.mm.z.c.CU().get(a.xtC, String.valueOf(""));
    }

    public static int Vf() {
        ar.Hg();
        x.i("MicroMsg.WebviewKeepManager", "getLastPageKeepTopScene : %d", new Object[]{Integer.valueOf(bh.a((Integer) com.tencent.mm.z.c.CU().get(a.xtN, null), 0))});
        return bh.a((Integer) com.tencent.mm.z.c.CU().get(a.xtN, null), 0);
    }

    public static void f(String str, String str2, int i) {
        x.i("MicroMsg.WebviewKeepManager", "saveLastPage : url=%s title=%s scene=%d", new Object[]{str, str2, Integer.valueOf(i)});
        ar.Hg();
        com.tencent.mm.z.c.CU().a(a.xtB, bh.ou(str));
        ar.Hg();
        com.tencent.mm.z.c.CU().a(a.xtC, bh.ou(str2));
        ar.Hg();
        com.tencent.mm.z.c.CU().a(a.xtN, Integer.valueOf(i));
    }
}
