package com.tencent.mm.plugin.record.ui.b;

import android.graphics.Bitmap;
import android.widget.ImageView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.record.b.h;
import com.tencent.mm.plugin.record.ui.a.a;
import com.tencent.mm.plugin.record.ui.a.b;
import com.tencent.mm.plugin.record.ui.h.a.c;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bh;

class a$3 implements Runnable {
    final /* synthetic */ a pGF;
    final /* synthetic */ b pGJ;
    final /* synthetic */ ImageView pGK;

    a$3(a aVar, b bVar, ImageView imageView) {
        this.pGF = aVar;
        this.pGJ = bVar;
        this.pGK = imageView;
    }

    public final void run() {
        int i;
        int i2;
        Bitmap a;
        a aVar = (a) this.pGJ;
        if (aVar.bjS == 0) {
            if (h.g(aVar.fve, aVar.fqm)) {
                i = R.k.dAt;
            }
            i = -1;
        } else {
            if (aVar.bjS == 1 && bh.ov(aVar.fve.wcJ)) {
                i = R.k.dAt;
            }
            i = -1;
        }
        if (i == -1) {
            i2 = R.k.dyy;
        } else {
            i2 = i;
        }
        aVar = (a) this.pGJ;
        com.tencent.mm.plugin.record.ui.h.a aVar2 = this.pGF.pGb;
        int i3 = this.pGF.pGE;
        com.tencent.mm.plugin.record.ui.h.a.b bVar = new com.tencent.mm.plugin.record.ui.h.a.b();
        bVar.fve = aVar.fve;
        bVar.fvh = false;
        bVar.maxWidth = i3;
        c cVar = new c();
        cVar.fve = aVar.fve;
        Bitmap a2;
        if (aVar.bjS == 0) {
            if (!h.g(aVar.fve, aVar.fqm)) {
                bVar.pGd = aVar.fqm;
                a2 = aVar2.a(bVar);
                if (a2 == null) {
                    cVar.pGd = aVar.fqm;
                    a = aVar2.a(cVar);
                }
                a = a2;
            }
            a = null;
        } else {
            if (aVar.bjS == 1) {
                bVar.pGd = aVar.pFG.field_localId;
                bVar.fvi = false;
                a2 = aVar2.a(bVar);
                if (a2 == null) {
                    cVar.pGd = aVar.pFG.field_localId;
                    a = aVar2.a(cVar);
                }
                a = a2;
            }
            a = null;
        }
        ag.y(new Runnable(this) {
            final /* synthetic */ a$3 pGM;

            public final void run() {
                this.pGM.pGF.a(this.pGM.pGK, a, i2, this.pGM.pGJ.fve.mvG);
            }
        });
    }

    public final String toString() {
        return super.toString() + "|fillView";
    }
}
