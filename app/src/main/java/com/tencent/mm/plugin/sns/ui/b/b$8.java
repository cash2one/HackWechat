package com.tencent.mm.plugin.sns.ui.b;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.g.a.gm;
import com.tencent.mm.plugin.sns.c.a;
import com.tencent.mm.plugin.sns.model.ae;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.e;
import com.tencent.mm.plugin.sns.ui.ag;
import com.tencent.mm.protocal.c.at;
import com.tencent.mm.protocal.c.bnp;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.x;

class b$8 implements OnClickListener {
    final /* synthetic */ b rPY;

    b$8(b bVar) {
        this.rPY = bVar;
    }

    public final void onClick(View view) {
        String str = (String) view.getTag();
        x.d("MicroMsg.TimelineClickListener", "onItemDelClick:" + str);
        bnp bxV = ae.bvv().Lm(str).bxV();
        at atVar = bxV.qYu;
        if (atVar.vFI != null) {
            String cy = a.ift.cy(atVar.vFI.ngo);
            int i = 0;
            if (bxV.wQo.vYc == 1) {
                i = 2;
            } else if (bxV.wQo.vYc == 3) {
                i = 5;
            } else if (bxV.wQo.vYc == 15) {
                i = 38;
            }
            if (e.a(bxV, this.rPY.activity)) {
                a.ift.a(this.rPY.activity, atVar.vFI.ngo, cy, bxV.ksU, i, 11, 9, atVar.vFI.vFC, bxV.nGJ);
                return;
            }
            b gmVar;
            switch (atVar.ktN) {
                case 4:
                    Intent intent = new Intent();
                    intent.putExtra("rawUrl", atVar.nfX);
                    a.ifs.j(intent, this.rPY.activity);
                    a.ift.a(this.rPY.activity, atVar.vFI.ngo, cy, bxV.ksU, i, 11, 1, atVar.vFI.vFC, bxV.nGJ);
                    return;
                case 5:
                    if (atVar.rYW == 1) {
                        gmVar = new gm();
                        gmVar.fwC.actionCode = 2;
                        gmVar.fwC.scene = 3;
                        gmVar.fwC.appId = atVar.vFI.ngo;
                        gmVar.fwC.context = this.rPY.activity;
                        com.tencent.mm.sdk.b.a.xef.m(gmVar);
                        a.ift.a(this.rPY.activity, atVar.vFI.ngo, cy, bxV.ksU, i, 11, 6, atVar.vFI.vFC, bxV.nGJ);
                        return;
                    }
                    return;
                case 6:
                    int a = ag.a(this.rPY.activity, atVar);
                    if (a == 1) {
                        gmVar = new gm();
                        gmVar.fwC.context = this.rPY.activity;
                        gmVar.fwC.actionCode = 2;
                        gmVar.fwC.appId = atVar.vFI.ngo;
                        gmVar.fwC.messageAction = atVar.vFI.vFE;
                        gmVar.fwC.messageExt = atVar.vFI.vFD;
                        gmVar.fwC.scene = 3;
                        com.tencent.mm.sdk.b.a.xef.m(gmVar);
                        a.ift.a(this.rPY.activity, atVar.vFI.ngo, cy, bxV.ksU, i, 11, 6, atVar.vFI.vFC, bxV.nGJ);
                        return;
                    } else if (a == 2) {
                        gmVar = new gm();
                        gmVar.fwC.context = this.rPY.activity;
                        gmVar.fwC.actionCode = 1;
                        gmVar.fwC.appId = atVar.vFI.ngo;
                        gmVar.fwC.messageAction = atVar.vFI.vFE;
                        gmVar.fwC.messageExt = atVar.vFI.vFD;
                        gmVar.fwC.scene = 3;
                        com.tencent.mm.sdk.b.a.xef.m(gmVar);
                        a.ift.a(this.rPY.activity, atVar.vFI.ngo, cy, bxV.ksU, i, 11, 3, atVar.vFI.vFC, bxV.nGJ);
                        return;
                    } else {
                        return;
                    }
                default:
                    return;
            }
        }
    }
}
