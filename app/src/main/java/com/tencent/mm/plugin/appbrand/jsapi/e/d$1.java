package com.tencent.mm.plugin.appbrand.jsapi.e;

import com.tencent.mm.plugin.appbrand.page.p;
import com.tencent.mm.plugin.appbrand.widget.input.m;
import com.tencent.mm.ui.MMActivity;
import java.lang.ref.WeakReference;

class d$1 implements Runnable {
    final /* synthetic */ int gOK;
    final /* synthetic */ WeakReference jjX;
    final /* synthetic */ int jjZ;
    final /* synthetic */ d jka;

    d$1(d dVar, WeakReference weakReference, int i, int i2) {
        this.jka = dVar;
        this.jjX = weakReference;
        this.jjZ = i;
        this.gOK = i2;
    }

    public final void run() {
        if (((p) this.jjX.get()).mContext instanceof MMActivity) {
            ((MMActivity) ((p) this.jjX.get()).mContext).aWs();
        }
        String str = m.lW(this.jjZ) ? "ok" : "fail";
        if (this.jjX.get() != null) {
            ((p) this.jjX.get()).E(this.gOK, this.jka.e(str, null));
        }
    }
}
