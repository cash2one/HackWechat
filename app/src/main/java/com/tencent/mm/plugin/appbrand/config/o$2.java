package com.tencent.mm.plugin.appbrand.config;

import android.os.Looper;
import com.tencent.mm.plugin.appbrand.config.r.b;
import com.tencent.mm.plugin.appbrand.m.b.a;
import com.tencent.mm.sdk.platformtools.ag;

class o$2 implements Runnable {
    final /* synthetic */ String gIT;
    final /* synthetic */ a iOX = null;
    final /* synthetic */ o iOY;
    final /* synthetic */ ag iOZ;

    o$2(o oVar, String str, a aVar, ag agVar) {
        this.iOY = oVar;
        this.gIT = str;
        this.iOZ = agVar;
    }

    public final void run() {
        if (r.qV(this.gIT)) {
            r.a(this.gIT, new b<WxaAttributes>(this) {
                final /* synthetic */ o$2 iPa;

                {
                    this.iPa = r1;
                }

                public final /* synthetic */ void d(int i, Object obj) {
                    WxaAttributes wxaAttributes = (WxaAttributes) obj;
                    if (this.iPa.iOX != null) {
                        this.iPa.iOX.b(wxaAttributes);
                    }
                }
            });
        } else if (this.iOX != null) {
            this.iOX.b(this.iOY.qK(this.gIT));
        }
        Looper.myQueue().addIdleHandler(new 2(this));
    }
}
