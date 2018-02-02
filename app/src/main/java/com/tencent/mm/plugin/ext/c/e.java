package com.tencent.mm.plugin.ext.c;

import android.content.Context;
import android.database.Cursor;
import android.os.Looper;
import com.tencent.mm.plugin.ext.c.d.b;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.pluginsdk.e.a.a;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.x;

public class e {
    public static e mbn = null;
    public Context mContext = null;

    public static e aFX() {
        if (mbn != null) {
            return mbn;
        }
        e eVar;
        synchronized (e.class) {
            if (mbn == null) {
                mbn = new e();
            }
            eVar = mbn;
        }
        return eVar;
    }

    private e() {
    }

    public static void D(String str, int i, int i2) {
        g.pQN.h(14869, new Object[]{str, Integer.valueOf(i), Integer.valueOf(i2)});
    }

    public static void E(String str, int i, int i2) {
        g.pQN.h(14868, new Object[]{str, Integer.valueOf(i), Integer.valueOf(i2)});
    }

    public static Cursor aFY() {
        x.i("MicroMsg.ExtQrCodeHandler", "hy: release temp mapping");
        c.clearCache();
        return a.By(1);
    }

    public static b al(String str, boolean z) {
        return d.aFW().ak(str, z);
    }

    public final a a(b bVar) {
        long currentTimeMillis = System.currentTimeMillis();
        a aVar = (a) new 1(this, new a(), bVar).b(aFZ());
        String str = "MicroMsg.ExtQrCodeHandler";
        String str2 = "hy: resolved qrcode: %s, using: %d ms";
        Object[] objArr = new Object[2];
        objArr[0] = aVar != null ? aVar.toString() : "null";
        objArr[1] = Long.valueOf(System.currentTimeMillis() - currentTimeMillis);
        x.i(str, str2, objArr);
        return aVar;
    }

    public static af aFZ() {
        return new af(Looper.getMainLooper());
    }
}
