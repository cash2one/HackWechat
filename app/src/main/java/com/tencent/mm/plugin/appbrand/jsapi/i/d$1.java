package com.tencent.mm.plugin.appbrand.jsapi.i;

import android.view.View;
import android.widget.LinearLayout;
import com.tencent.mm.plugin.appbrand.page.p;
import com.tencent.mm.plugin.appbrand.widget.input.l;
import com.tencent.mm.plugin.appbrand.widget.input.l.a;
import com.tencent.mm.sdk.platformtools.x;

class d$1 implements a {
    final /* synthetic */ p jfB;
    final /* synthetic */ d jqg;

    d$1(d dVar, p pVar) {
        this.jqg = dVar;
        this.jfB = pVar;
    }

    public final void agH() {
        if (this.jqg.jqe != null) {
            l bS = l.bS(this.jfB.aeM());
            if (bS == null) {
                x.e("MicroMsg.JsApiShowToast", "the page may be destroy");
                return;
            }
            View view = bS.jXB;
            if (view == null || !view.isShown()) {
                ((LinearLayout) this.jqg.jqe).setGravity(17);
            } else {
                ((LinearLayout) this.jqg.jqe).setGravity(80);
            }
        }
    }
}
