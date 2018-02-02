package com.tencent.xweb.x5;

import android.content.Context;
import com.tencent.smtt.sdk.QbSdk;
import com.tencent.smtt.sdk.QbSdk$a;
import com.tencent.xweb.WebView.b;
import org.xwalk.core.Log;

class X5WebFactory$b {
    private static boolean ArZ = false;
    private static boolean lVG = false;

    public static boolean hasInited() {
        return lVG;
    }

    public static boolean isCoreReady() {
        return ArZ;
    }

    public static void a(Context context, final b bVar) {
        if (!lVG) {
            Log.i("X5WebFactory.preIniter", "preInit");
            lVG = true;
            QbSdk.preInit(context, new QbSdk$a() {
                private boolean Asa = false;
                private boolean Asb = false;

                public final void tH() {
                    this.Asa = true;
                    if (this.Asa && this.Asb && bVar != null) {
                        bVar.tH();
                        X5WebFactory$b.ArZ = true;
                    }
                }

                public final void kQ(boolean z) {
                    this.Asb = true;
                    if (this.Asa && this.Asb && bVar != null) {
                        bVar.tH();
                        X5WebFactory$b.ArZ = true;
                    }
                }
            });
        }
    }
}
