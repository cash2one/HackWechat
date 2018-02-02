package com.tencent.mm.plugin.webview.fts.ui;

import android.view.View;
import android.view.ViewGroup;
import com.tencent.mm.plugin.webview.fts.ui.b.a;
import com.tencent.mm.sdk.platformtools.bc;

class b$2 extends bc<Boolean> {
    final /* synthetic */ int jhi;
    final /* synthetic */ b trB;

    public b$2(b bVar, Boolean bool, int i) {
        this.trB = bVar;
        this.jhi = i;
        super(1000, bool);
    }

    protected final /* synthetic */ Object run() {
        boolean z;
        b bVar = this.trB;
        int i = this.jhi;
        a Ag = bVar.Ag(i);
        if (Ag != null) {
            bVar.ls(i);
            bVar.a(Ag);
            ViewGroup lj = bVar.lj(Ag.jFB);
            if (lj != null) {
                bVar.jFl.remove(Ag);
                lj.removeView((View) Ag.jFA.get());
                z = true;
                return Boolean.valueOf(z);
            }
        }
        z = false;
        return Boolean.valueOf(z);
    }
}
