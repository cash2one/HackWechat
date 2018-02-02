package com.tencent.mm.plugin.base.model;

import android.os.Process;
import com.tencent.mm.a.g;
import com.tencent.mm.compatible.d.q;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

public final class c {
    public static String vG(String str) {
        if (str == null || str.length() <= 0) {
            return null;
        }
        String r = bh.r(ac.getContext(), Process.myPid());
        x.i("MicroMsg.ShortcutUtil", "process name: %s", new Object[]{r});
        if (!str.startsWith("shortcut_") || str.length() <= 9) {
            return str;
        }
        r = str.substring(9);
        if (r == null || r.length() <= 0) {
            return str;
        }
        return b.bI(new String(b.vF(r)), q.yE());
    }

    public static String bJ(String str, String str2) {
        return g.s((g.s(str.getBytes()) + b.bI(str2, str)).getBytes());
    }

    public static String vH(String str) {
        if (str == null || str.length() <= 0) {
            return null;
        }
        String r = bh.r(ac.getContext(), Process.myPid());
        x.i("MicroMsg.ShortcutUtil", "process name: %s", new Object[]{r});
        r = b.bI(str, q.yE());
        if (bh.ov(r)) {
            return null;
        }
        return "shortcut_" + b.aa(r.getBytes());
    }
}
