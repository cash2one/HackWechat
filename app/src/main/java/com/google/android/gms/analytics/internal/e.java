package com.google.android.gms.analytics.internal;

import com.google.android.gms.analytics.b;

@Deprecated
public final class e {
    private static volatile b aFj = new ad();

    public static void b(String str, Object obj) {
        Object obj2 = null;
        f mn = f.mn();
        if (mn != null) {
            mn.f(str, obj);
        } else {
            if (aFj != null && aFj.getLogLevel() <= 3) {
                obj2 = 1;
            }
            if (obj2 != null) {
                if (obj != null) {
                    new StringBuilder().append(str).append(":").append(obj);
                }
                aj.aHu.get();
            }
        }
        b bVar = aFj;
    }

    public static b mm() {
        return aFj;
    }
}
