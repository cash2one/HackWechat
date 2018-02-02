package com.tencent.mm.plugin.webview.fts;

import com.tencent.mm.plugin.aj.a.d;
import com.tencent.mm.plugin.webview.fts.l.a;
import com.tencent.mm.plugin.webview.modeltools.f;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ar;

class l$a$a implements Runnable {
    d hjF;
    public volatile boolean kpn;
    final /* synthetic */ a tne;

    private l$a$a(a aVar) {
        this.tne = aVar;
    }

    public final void run() {
        if (!Thread.interrupted()) {
            if (bh.ov(this.hjF.fod)) {
                x.i("RecommendLogic", "error query %d %d %d %d %s %d", new Object[]{Integer.valueOf(this.hjF.hKY), Integer.valueOf(this.hjF.scene), Integer.valueOf(this.hjF.tjP), Integer.valueOf(this.hjF.tjR), this.hjF.lEK, Integer.valueOf(this.hjF.offset)});
                return;
            }
            x.i("RecommendLogic", "start New NetScene %s ,  %d", new Object[]{this.hjF.fod, Integer.valueOf(this.hjF.fDl)});
            if (a.a(this.tne) != null) {
                ar.CG().c(a.a(this.tne));
            }
            if (this.kpn) {
                x.i("RecommendLogic", "was cancelled");
                return;
            }
            f.bRy().tmo.f(this.hjF.scene, this.hjF.fod, this.hjF.hKY);
            a.a(this.tne, a.c(this.hjF));
            ar.CG().a(a.a(this.tne).getType(), this.tne.tmZ);
            ar.CG().a(a.a(this.tne), 0);
            x.i("RecommendLogic", "doScene(type : %s)", new Object[]{Integer.valueOf(a.a(this.tne).getType())});
        }
    }
}
