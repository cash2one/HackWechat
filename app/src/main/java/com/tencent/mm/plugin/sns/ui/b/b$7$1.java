package com.tencent.mm.plugin.sns.ui.b;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.view.View;
import com.tencent.mm.g.a.nf;
import com.tencent.mm.modelsns.b;
import com.tencent.mm.plugin.sns.c.a;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.lucky.a.g;
import com.tencent.mm.plugin.sns.model.ae;
import com.tencent.mm.plugin.sns.model.q;
import com.tencent.mm.plugin.sns.storage.m;
import com.tencent.mm.plugin.sns.storage.u;
import com.tencent.mm.plugin.sns.ui.b.b.7;
import com.tencent.mm.protocal.c.bnp;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

class b$7$1 implements OnClickListener {
    final /* synthetic */ View jLA;
    final /* synthetic */ 7 rPZ;

    b$7$1(7 7, View view) {
        this.rPZ = 7;
        this.jLA = view;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        if (this.jLA.getTag() instanceof String) {
            String str = (String) this.jLA.getTag();
            x.d("MicroMsg.TimelineClickListener", "onItemDelClick:" + str);
            m Lm = ae.bvv().Lm(str);
            if (Lm == null) {
                x.d("MicroMsg.TimelineClickListener", "can not get snsinfo by localid %s then return it", new Object[]{str});
            } else if (Lm.bys()) {
                x.i("MicroMsg.TimelineClickListener", "dead item");
                ae.bvv().xp(Lm.roJ);
                if (this.rPZ.rPY.rPV != null) {
                    this.rPZ.rPY.rPV.bBE();
                }
                if (this.rPZ.rPY.scene == 0) {
                    r0 = b.iu(739);
                } else {
                    r0 = b.iv(739);
                }
                r3 = r0.mB(i.g(Lm)).ix(Lm.field_type);
                r1 = Lm.bys() ? "2" : Lm.field_snsId == 0 ? "1" : "0";
                r3.mB(r1);
                r0.Sx();
                if (Lm.field_type == 21) {
                    g.buo().buq();
                }
            } else if (Lm.bve()) {
                x.i("MicroMsg.TimelineClickListener", "cancel item " + Lm.byq());
                ae.bvr().r(Lm);
                this.rPZ.rPY.bzg();
            } else {
                x.i("MicroMsg.TimelineClickListener", "delete by server");
                str = Lm.bxW();
                ae.bvu().eD(u.LF(str));
                com.tencent.mm.kernel.g.Dk();
                com.tencent.mm.kernel.g.Di().gPJ.a(new q(u.LF(str), 1), 0);
                ae.bvv().delete(u.LF(str));
                ae.bvA().eM(u.LF(str));
                this.rPZ.rPY.bzg();
                bnp bxV = Lm.bxV();
                if (bxV != null) {
                    if (bxV.wQn == null) {
                        str = null;
                    } else {
                        str = bxV.wQn.nGJ;
                    }
                    if (!bh.ov(str) && a.ift.cA(str)) {
                        String cy = a.ift.cy(str);
                        com.tencent.mm.sdk.b.b nfVar = new nf();
                        nfVar.fFg.appId = str;
                        nfVar.fFg.fFh = bxV.ksU;
                        nfVar.fFg.ffw = cy;
                        nfVar.fFg.mediaTagName = bxV.wQs;
                        com.tencent.mm.sdk.b.a.xef.m(nfVar);
                    }
                }
                if (this.rPZ.rPY.scene == 0) {
                    r0 = b.iu(739);
                } else {
                    r0 = b.iv(739);
                }
                r3 = r0.mB(i.g(Lm)).ix(Lm.field_type);
                r1 = Lm.bys() ? "2" : Lm.field_snsId == 0 ? "1" : "0";
                r3.mB(r1);
                r0.Sx();
            }
        }
    }
}
