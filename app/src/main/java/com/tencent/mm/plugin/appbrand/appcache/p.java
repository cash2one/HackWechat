package com.tencent.mm.plugin.appbrand.appcache;

import java.util.HashSet;
import java.util.Set;

public final class p {
    private static final Set<b> iEH = new HashSet();

    public static void a(b bVar) {
        synchronized (iEH) {
            iEH.add(bVar);
        }
    }

    static a a(ab abVar) {
        synchronized (iEH) {
        }
        for (Object obj : iEH.toArray()) {
            a a = ((b) obj).a(abVar);
            if (a != null) {
                return a;
            }
        }
        return null;
    }
}
