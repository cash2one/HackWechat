package com.tencent.xweb;

import android.content.Context;
import com.tencent.xweb.c.b.b;

public final class c {
    private static c ApM;
    static b ApN;

    public static synchronized c iO(Context context) {
        c cVar;
        synchronized (c.class) {
            if (ApM == null) {
                ApM = new c(context.getApplicationContext());
            }
            cVar = ApM;
        }
        return cVar;
    }

    public static synchronized c cIl() {
        c cVar;
        synchronized (c.class) {
            if (ApM == null) {
                throw new IllegalStateException("CookieSyncManager::createInstance() needs to be called before CookieSyncManager::getInstance()");
            }
            cVar = ApM;
        }
        return cVar;
    }

    private c(Context context) {
        if (ApN != null) {
            ApN.init(context);
        }
    }

    public static void sync() {
        if (ApN != null) {
            ApN.sync();
        }
    }
}
