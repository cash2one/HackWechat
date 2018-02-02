package com.tencent.mm.modelfriend;

import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashSet;

public final class a {
    public static final HashSet<b> huY = new HashSet();
    private static final b huZ = new 1();
    private static Thread thread = null;

    public static boolean Nm() {
        return a(huZ);
    }

    public static boolean a(b bVar) {
        long id = Thread.currentThread().getId();
        if (m.NQ()) {
            ag.y(new 2(id, bVar));
            return true;
        }
        x.e("MicroMsg.AddrBookSyncHelper", "canSync:%b, skip", new Object[]{Boolean.valueOf(m.NQ())});
        return false;
    }

    public static boolean Nn() {
        return a.huT;
    }
}
