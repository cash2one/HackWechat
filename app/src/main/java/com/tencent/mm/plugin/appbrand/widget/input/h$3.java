package com.tencent.mm.plugin.appbrand.widget.input;

import com.tencent.mm.plugin.appbrand.p.f;
import com.tencent.mm.plugin.appbrand.page.p;
import com.tencent.mm.v.g;
import java.lang.ref.WeakReference;

class h$3 implements aa {
    final /* synthetic */ h jXi;
    final /* synthetic */ WeakReference jjX;
    final /* synthetic */ int jjZ;

    public h$3(h hVar, WeakReference weakReference, int i) {
        this.jXi = hVar;
        this.jjX = weakReference;
        this.jjZ = i;
    }

    public final void lT(int i) {
        try {
            p pVar = (p) this.jjX.get();
            if (pVar != null) {
                pVar.h("onKeyboardShow", g.Cd().C("inputId", this.jjZ).C("height", f.lH(i)).toString(), 0);
            }
        } catch (Exception e) {
        }
    }
}
