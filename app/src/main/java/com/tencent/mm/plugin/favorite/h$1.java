package com.tencent.mm.plugin.favorite;

import android.content.Context;
import com.tencent.mm.g.a.ft;
import com.tencent.mm.plugin.fav.a.f;
import com.tencent.mm.plugin.favorite.a.j;
import com.tencent.mm.plugin.favorite.ui.b.e;
import com.tencent.mm.pluginsdk.ui.applet.e.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.bh;

class h$1 extends c<ft> {
    final /* synthetic */ h mps;

    h$1(h hVar) {
        this.mps = hVar;
        this.xen = ft.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        ft ftVar = (ft) bVar;
        if (ftVar != null && (ftVar instanceof ft)) {
            if (ftVar.fvl.fvm != null && (ftVar.fvl.fvm instanceof a) && ftVar.fvl.fnT != null && (ftVar.fvl.fnT instanceof Context)) {
                f db = h.getFavItemInfoStorage().db(ftVar.fvl.fqk);
                f Af = (db != null || bh.ov(ftVar.fvl.fvn)) ? db : j.Af(ftVar.fvl.fvn);
                a aVar = (a) ftVar.fvl.fvm;
                Context context = (Context) ftVar.fvl.fnT;
                e.a(aVar, context, Af);
                e.b(aVar, context, Af);
            }
            ftVar.fvl.fqk = 0;
            ftVar.fvl.fvm = null;
            ftVar.fvl.fnT = null;
        }
        return false;
    }
}
