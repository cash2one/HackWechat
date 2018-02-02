package com.tencent.mm.plugin.d;

import com.tencent.mm.by.h;
import com.tencent.mm.by.h.d;
import com.tencent.mm.kernel.api.e;
import com.tencent.mm.kernel.b.c;
import com.tencent.mm.storage.g;
import java.util.HashMap;

public final class a implements com.tencent.mm.kernel.api.a, e, c {
    private static final HashMap<Integer, d> gwY;
    private static a ios;
    private g iot;

    private a() {
    }

    public static synchronized a XW() {
        a aVar;
        synchronized (a.class) {
            if (ios == null) {
                ios = new a();
            }
            aVar = ios;
        }
        return aVar;
    }

    public final g FI() {
        com.tencent.mm.kernel.g.Dh().Ct();
        return this.iot;
    }

    public final void onDataBaseOpened(h hVar, h hVar2) {
        this.iot = new g(hVar);
    }

    public final void onDataBaseClosed(h hVar, h hVar2) {
    }

    public final HashMap<Integer, d> collectDatabaseFactory() {
        return gwY;
    }

    static {
        HashMap hashMap = new HashMap();
        gwY = hashMap;
        hashMap.put(Integer.valueOf("AddContactAntispamTicket".hashCode()), new 1());
    }
}
