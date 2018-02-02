package com.tencent.mm.app;

import android.app.Application;
import android.content.res.Resources;
import com.tencent.mm.R;
import com.tencent.mm.kiss.a.b;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.svg.a.e;
import com.tencent.mm.svg.b.c.a;

public final class m {
    private static Class<?> ffI = null;
    private static Application ffJ;
    private static Resources ffK;
    private static String mPackageName = null;

    public static void d(Class<?> cls) {
        ffI = cls;
    }

    public static void cu(String str) {
        mPackageName = str;
    }

    public static void tZ() {
        boolean z = true;
        x.i("MicroMsg.SVGInit", "SVG initSVGPreload");
        e.a(new a() {
            public final void i(String str, String str2, Object... objArr) {
                x.i(str, str2, objArr);
            }

            public final void e(String str, String str2, Object... objArr) {
                x.e(str, str2, objArr);
            }

            public final void d(String str, String str2, Object... objArr) {
                x.d(str, str2, objArr);
            }

            public final void printErrStackTrace(String str, Throwable th, String str2, Object... objArr) {
                x.printErrStackTrace(str, th, str2, objArr);
            }
        });
        e.d(ffI);
        e.a(ffJ, ffK, mPackageName);
        try {
            boolean z2 = ffJ.getBaseContext().getResources().getDrawable(R.k.duU) != null;
            b DY = b.DY();
            if (z2) {
                z = false;
            }
            DY.gSY = z;
        } catch (Throwable th) {
            x.printErrStackTrace("MicroMsg.SVGInit", th, "not support get svg from application context", new Object[0]);
        } finally {
            b.DY().gSY = true;
        }
    }

    public static void a(Application application, Resources resources) {
        e.b(application, mPackageName);
        ffJ = application;
        ffK = resources;
    }
}
