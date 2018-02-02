package com.tencent.mm.plugin.appbrand.widget.input;

import com.tencent.mm.plugin.appbrand.page.p;
import com.tencent.mm.plugin.appbrand.page.p.d;
import com.tencent.mm.plugin.appbrand.page.p.e;
import com.tencent.mm.ui.MMActivity;
import java.lang.ref.WeakReference;

final class j implements d, e {
    final WeakReference<p> jWK;

    j(p pVar) {
        this.jWK = new WeakReference(pVar);
        pVar.a(this);
        pVar.a(this);
    }

    public final void afA() {
        p pVar = (p) this.jWK.get();
        if (pVar != null) {
            m.n(pVar);
        }
    }

    public final void onDestroy() {
        p pVar = (p) this.jWK.get();
        if (pVar != null) {
            if (pVar.mContext instanceof MMActivity) {
                ((MMActivity) pVar.mContext).aWs();
            }
            m.n(pVar);
            m.p(pVar);
            pVar.b(this);
            pVar.b(this);
            if (pVar.jDS != null) {
                g.amA().n(pVar.jDS);
            }
        }
    }
}
