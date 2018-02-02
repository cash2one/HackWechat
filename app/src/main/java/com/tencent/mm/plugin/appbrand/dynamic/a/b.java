package com.tencent.mm.plugin.appbrand.dynamic.a;

import android.os.Bundle;
import android.view.View;
import com.tencent.mm.ipcinvoker.f;
import com.tencent.mm.ipcinvoker.g;
import com.tencent.mm.modelappbrand.c;
import com.tencent.mm.modelappbrand.d;
import com.tencent.mm.plugin.appbrand.dynamic.widget.IPCDynamicPageView;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Set;

final class b implements d {
    Runnable iSA = new 3(this);
    c iSx;
    Runnable iSy = new 1(this);
    Runnable iSz = new Runnable(this) {
        final /* synthetic */ b iSB;

        {
            this.iSB = r1;
        }

        public final void run() {
            if (g.fk("com.tencent.mm:support")) {
                f.a("com.tencent.mm:support", null, a.class, new com.tencent.mm.ipcinvoker.c(this) {
                    final /* synthetic */ AnonymousClass2 iSC;

                    {
                        this.iSC = r1;
                    }

                    public final void i(Bundle bundle) {
                        x.i("MicroMsg.DynamicPagePerformance", "exitTask onCallback");
                        g.fj("com.tencent.mm:support");
                    }
                });
            }
        }
    };

    b(c cVar) {
        this.iSx = cVar;
    }

    public final void exit() {
        com.tencent.mm.plugin.appbrand.dynamic.b.m(this.iSz);
    }

    public final void restart() {
        com.tencent.mm.plugin.appbrand.dynamic.b.m(this.iSA);
        com.tencent.mm.plugin.appbrand.dynamic.b.d(this.iSy, 2000);
    }

    public final void iv(String str) {
        Set<View> aS = this.iSx.aS(str);
        if (aS != null && !aS.isEmpty()) {
            for (View view : aS) {
                if (view != null && (view instanceof IPCDynamicPageView)) {
                    x.v("MicroMsg.DynamicPagePerformance", "pauseAllView, do pause view(%s)", new Object[]{Integer.valueOf(view.hashCode())});
                    ((IPCDynamicPageView) view).onPause();
                }
            }
        }
    }

    public final void iw(String str) {
        Set<View> aS = this.iSx.aS(str);
        if (aS != null && !aS.isEmpty()) {
            for (View view : aS) {
                if (view != null && (view instanceof IPCDynamicPageView)) {
                    x.v("MicroMsg.DynamicPagePerformance", "pauseAllView, do resume view(%s)", new Object[]{Integer.valueOf(view.hashCode())});
                    ((IPCDynamicPageView) view).onResume();
                }
            }
        }
    }
}
