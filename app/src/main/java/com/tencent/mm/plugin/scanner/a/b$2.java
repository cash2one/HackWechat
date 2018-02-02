package com.tencent.mm.plugin.scanner.a;

import android.content.Context;
import android.os.Bundle;
import com.tencent.mm.R;
import com.tencent.mm.ae.k;
import com.tencent.mm.g.a.bz;
import com.tencent.mm.plugin.scanner.util.a;
import com.tencent.mm.plugin.scanner.util.a.1;
import com.tencent.mm.plugin.scanner.util.e;
import com.tencent.mm.plugin.scanner.util.p;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.z.ar;

class b$2 extends c<bz> {
    final /* synthetic */ b pSJ;

    b$2(b bVar) {
        this.pSJ = bVar;
        this.xen = bz.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        int i = 2;
        bz bzVar = (bz) bVar;
        if (bzVar == null || !(bzVar instanceof bz)) {
            x.e("MicroMsg.ExternRequestDealQBarStrHandler", "event is null or not a DealQBarStrEvent instance");
        } else {
            this.pSJ.boC();
            this.pSJ.pSD = bzVar.fqa.fov;
            this.pSJ.mActivity = bzVar.fqa.activity;
            x.i("MicroMsg.ExternRequestDealQBarStrHandler", "request deal qbar, activity:%s, str:%s, codeType: %s, codeVersion: %s, from : %d", new Object[]{this.pSJ.mActivity, this.pSJ.pSD, Integer.valueOf(bzVar.fqa.fqb), Integer.valueOf(bzVar.fqa.fqc), Integer.valueOf(bzVar.fqa.fqe)});
            if (bzVar.fqa.fqb == 19 || bzVar.fqa.fqb == 22) {
                this.pSJ.pSE = new e();
                this.pSJ.pSE.fqd = bzVar.fqa.fqd;
                this.pSJ.pSE.imagePath = bzVar.fqa.imagePath;
                this.pSJ.pSE.fqg = bzVar.fqa.fqg;
                this.pSJ.pSE.bhd = bzVar.fqa.bhd;
                if (bzVar.fqa.fqe >= 0) {
                    i = 3;
                }
                if (bzVar.fqa.scene > 0) {
                    this.pSJ.pSE.moj = bzVar.fqa.scene;
                }
                if (i == 3) {
                    this.pSJ.pSE.appId = bzVar.fqa.fqf;
                }
                this.pSJ.pSE.a(this.pSJ.mActivity, this.pSJ.pSD, i, bzVar.fqa.fqb, bzVar.fqa.fqc, this.pSJ.pSG, bzVar.fqa.fqh);
            } else {
                this.pSJ.pSF = new a();
                a aVar = this.pSJ.pSF;
                Context context = this.pSJ.mActivity;
                String str = this.pSJ.pSD;
                int i2 = bzVar.fqa.fqb;
                int i3 = bzVar.fqa.fqc;
                Bundle bundle = bzVar.fqa.fqh;
                if (!bh.ov(str)) {
                    String[] split = str.split(",");
                    if (split == null || split.length < 2) {
                        x.e("MicroMsg.BarcodeStringHandler", "wrong zbar format");
                    } else {
                        aVar.fAF = context;
                        aVar.fqh = bundle;
                        k fVar = new f(p.IN(split[0]), split[1], i2, i3);
                        ar.CG().a(1061, aVar);
                        ar.CG().a(fVar, 0);
                        context.getString(R.l.dGO);
                        aVar.iln = h.a(context, context.getString(R.l.eBB), true, new 1(aVar, fVar));
                    }
                }
            }
        }
        return false;
    }
}
