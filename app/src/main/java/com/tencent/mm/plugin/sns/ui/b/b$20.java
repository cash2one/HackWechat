package com.tencent.mm.plugin.sns.ui.b;

import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.View;
import com.tencent.mm.bm.d;
import com.tencent.mm.g.a.dh;
import com.tencent.mm.k.g;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.plugin.sns.model.ae;
import com.tencent.mm.plugin.sns.model.am;
import com.tencent.mm.plugin.sns.model.ap;
import com.tencent.mm.plugin.sns.ui.ak;
import com.tencent.mm.protocal.c.aqr;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

class b$20 extends c {
    final /* synthetic */ b rPY;

    b$20(b bVar) {
        this.rPY = bVar;
    }

    public final void a(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
        if (view.getTag() instanceof ak) {
            int i;
            b dhVar;
            ak akVar = (ak) view.getTag();
            if (!akVar.qQH) {
                contextMenu.add(0, 19, 0, this.rPY.activity.getString(j.dRL));
            }
            if (bh.VI(g.zY().getValue("SIGHTCannotTransmitForFav")) == 0) {
                if (akVar.rxf.wQo.vYd.size() > 0) {
                    aqr com_tencent_mm_protocal_c_aqr = (aqr) akVar.rxf.wQo.vYd.get(0);
                    String str = am.r(ae.getAccSnsPath(), com_tencent_mm_protocal_c_aqr.nGJ) + i.e(com_tencent_mm_protocal_c_aqr);
                    String a = ap.a(akVar.frH, com_tencent_mm_protocal_c_aqr);
                    x.i("MicroMsg.TimelineOnCreateContextMenuListener", "config can forward sight, thumb existed %B, video existed %B", new Object[]{Boolean.valueOf(FileOp.bO(str)), Boolean.valueOf(FileOp.bO(a))});
                    if (FileOp.bO(str) && r1) {
                        i = 1;
                        if (d.OQ("favorite")) {
                            contextMenu.add(0, 10, 0, this.rPY.activity.getString(j.eAd));
                        }
                        if (i != 0) {
                            dhVar = new dh();
                            dhVar.frQ.frH = akVar.frH;
                            a.xef.m(dhVar);
                            if (dhVar.frR.frp) {
                                contextMenu.add(0, 18, 0, this.rPY.activity.getString(j.qJu));
                            }
                        }
                    }
                }
                x.w("MicroMsg.TimelineOnCreateContextMenuListener", "sight item had not attch.");
            }
            i = 0;
            if (d.OQ("favorite")) {
                contextMenu.add(0, 10, 0, this.rPY.activity.getString(j.eAd));
            }
            if (i != 0) {
                dhVar = new dh();
                dhVar.frQ.frH = akVar.frH;
                a.xef.m(dhVar);
                if (dhVar.frR.frp) {
                    contextMenu.add(0, 18, 0, this.rPY.activity.getString(j.qJu));
                }
            }
        }
    }

    public final boolean cL(View view) {
        if (!(view.getTag() instanceof ak)) {
            return false;
        }
        String str = ((ak) view.getTag()).frH;
        this.rPY.rPp.a(view, str, ae.bvv().Lm(str).bxV());
        return true;
    }
}
