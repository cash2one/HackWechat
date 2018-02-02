package com.tencent.mm.plugin.emoji.a;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mm.aq.o;
import com.tencent.mm.plugin.emoji.a.a.a;
import com.tencent.mm.plugin.emoji.a.a.f;
import com.tencent.mm.pluginsdk.h.n;
import com.tencent.mm.protocal.c.so;

public final class d extends a {
    public d(Context context) {
        super(context);
    }

    protected final a c(Context context, View view) {
        a aVar = new a(this, context, view);
        aVar.a(this.luC);
        return aVar;
    }

    public final View b(int i, View view, ViewGroup viewGroup) {
        a aVar = (a) view.getTag();
        f oG = oG(i);
        if (!(aVar == null || oG == null)) {
            oG.luR = false;
            oG.luS = false;
            so soVar = oG.luN;
            if (soVar != null) {
                aVar.setTitle(soVar.war);
                o.PA().a(soVar.nfT, aVar.aAq(), com.tencent.mm.plugin.emoji.e.f.cg(soVar.vIR, soVar.nfT));
                aVar.xR(n.ah("yyyy-MM-dd", ((long) soVar.waZ) * 1000));
            }
        }
        return view;
    }

    public final int aAE() {
        return 0;
    }

    public final void oD(int i) {
    }

    public final int aAF() {
        return 0;
    }

    public final void oE(int i) {
    }

    public final int aAG() {
        return 0;
    }

    public final void oF(int i) {
    }
}
