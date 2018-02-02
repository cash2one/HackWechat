package com.tencent.e;

import android.content.Context;
import com.tencent.e.b.b;
import com.tencent.e.b.d;
import com.tencent.pb.common.c.c;

public final class i {
    private static i AmK;
    private boolean oO;
    private Context tI;

    private static i cHt() {
        if (AmK == null) {
            synchronized (i.class) {
                if (AmK == null) {
                    AmK = new i();
                }
            }
        }
        return AmK;
    }

    public static void iK(Context context) {
        i cHt = cHt();
        if (!cHt.oO) {
            cHt.tI = context;
            try {
                b a = f.a(new d("EventCenter", com.tencent.e.a.b.class.getName()));
                if (a != null) {
                    a.start();
                }
            } catch (Throwable th) {
                c.m("service", new Object[]{th});
            }
        }
    }
}
