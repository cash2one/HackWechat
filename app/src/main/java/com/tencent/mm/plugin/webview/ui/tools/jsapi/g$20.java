package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import android.app.Activity;
import android.content.Context;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.g.c;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.j.2;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.j.3;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.j.4;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.j.d;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.j.e;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.ui.MMActivity;
import java.lang.ref.WeakReference;

class g$20 implements Runnable {
    final /* synthetic */ double hyj;
    final /* synthetic */ double hyk;
    final /* synthetic */ String tIA;
    final /* synthetic */ int tIB;
    final /* synthetic */ g tIj;
    final /* synthetic */ int tIz;

    g$20(g gVar, int i, double d, double d2, String str, int i2) {
        this.tIj = gVar;
        this.tIz = i;
        this.hyj = d;
        this.hyk = d2;
        this.tIA = str;
        this.tIB = i2;
    }

    public final void run() {
        byte b = (byte) 0;
        if (!(g.i(this.tIj) == null || !(g.i(this.tIj) instanceof Activity) || ((Activity) g.i(this.tIj)).isFinishing())) {
            j E = g.E(this.tIj);
            Context i = g.i(this.tIj);
            int i2 = this.tIz;
            double d = this.hyj;
            double d2 = this.hyk;
            String str = this.tIA;
            int i3 = this.tIB;
            d 1 = new 1(this);
            if (!(i == null || !(i instanceof MMActivity) || ((MMActivity) i).isFinishing())) {
                E.ttB = i3;
                E.tJJ = true;
                E.tJK = i2;
                E.tJM = new e(d, d2, (byte) 0);
                E.tJN = str;
                E.fqH = new WeakReference(i);
                E.tJO = 1;
                E.hpO = null;
                if (E.hpO == null) {
                    E.bUO();
                } else {
                    E.tJR = new 2(E);
                    if (E.nVX != null) {
                        E.tJQ = new 3(E);
                        E.nVX.a(E.tJM.latitude, E.tJM.longitude, E.tJQ);
                    }
                    ag.y(new 4(E));
                    E.hpO.b(E.tJR);
                    ag.h(E.tJS, 4000);
                }
                b = (byte) 1;
            }
        }
        if (b == (byte) 0) {
            c a = g.a(this.tIj, this.tIB);
            if (a.fBH != null && a.tHp != null) {
                g.a(this.tIj, a.fBH, a.tHp, "openMapNavigateMenu:fail");
            }
        }
    }
}
