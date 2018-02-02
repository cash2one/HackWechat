package com.tencent.mm.plugin.sns.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.g.a.gm;
import com.tencent.mm.plugin.sns.c.a;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.e;
import com.tencent.mm.protocal.c.at;
import com.tencent.mm.protocal.c.bnp;
import com.tencent.mm.sdk.b.b;

class SnsBrowseUI$2 implements OnClickListener {
    final /* synthetic */ SnsBrowseUI rzl;
    final /* synthetic */ at rzm;
    final /* synthetic */ bnp rzn;

    SnsBrowseUI$2(SnsBrowseUI snsBrowseUI, at atVar, bnp com_tencent_mm_protocal_c_bnp) {
        this.rzl = snsBrowseUI;
        this.rzm = atVar;
        this.rzn = com_tencent_mm_protocal_c_bnp;
    }

    public final void onClick(View view) {
        if (this.rzm.vFI != null) {
            String cy = a.ift.cy(this.rzm.vFI.ngo);
            int i = 0;
            if (this.rzn.wQo.vYc == 1) {
                i = 2;
            } else if (this.rzn.wQo.vYc == 3) {
                i = 5;
            } else if (this.rzn.wQo.vYc == 15) {
                i = 4;
            }
            if (e.a(this.rzn, this.rzl)) {
                a.ift.a(this.rzl, this.rzm.vFI.ngo, cy, this.rzn.ksU, i, 18, 9, this.rzm.vFI.vFC, this.rzn.nGJ);
                return;
            }
            b gmVar;
            switch (this.rzm.ktN) {
                case 4:
                    Intent intent = new Intent();
                    intent.putExtra("rawUrl", this.rzm.nfX);
                    a.ifs.j(intent, this.rzl);
                    a.ift.a(this.rzl, this.rzm.vFI.ngo, cy, this.rzn.ksU, i, 18, 1, this.rzm.vFI.vFC, this.rzn.nGJ);
                    return;
                case 5:
                    if (this.rzm.rYW == 1) {
                        gmVar = new gm();
                        gmVar.fwC.actionCode = 2;
                        gmVar.fwC.scene = 3;
                        gmVar.fwC.appId = this.rzm.vFI.ngo;
                        gmVar.fwC.context = this.rzl;
                        com.tencent.mm.sdk.b.a.xef.m(gmVar);
                        a.ift.a(this.rzl, this.rzm.vFI.ngo, cy, this.rzn.ksU, i, 18, 6, this.rzm.vFI.vFC, this.rzn.nGJ);
                        return;
                    }
                    return;
                case 6:
                    int a = ag.a(this.rzl, this.rzm);
                    if (a == 1) {
                        gmVar = new gm();
                        gmVar.fwC.context = this.rzl;
                        gmVar.fwC.actionCode = 2;
                        gmVar.fwC.appId = this.rzm.vFI.ngo;
                        gmVar.fwC.messageAction = this.rzm.vFI.vFE;
                        gmVar.fwC.messageExt = this.rzm.vFI.vFD;
                        gmVar.fwC.scene = 3;
                        com.tencent.mm.sdk.b.a.xef.m(gmVar);
                        a.ift.a(this.rzl, this.rzm.vFI.ngo, cy, this.rzn.ksU, i, 18, 6, this.rzm.vFI.vFC, this.rzn.nGJ);
                        return;
                    } else if (a == 2) {
                        b gmVar2 = new gm();
                        gmVar2.fwC.context = this.rzl;
                        gmVar2.fwC.actionCode = 1;
                        gmVar2.fwC.appId = this.rzm.vFI.ngo;
                        gmVar2.fwC.messageAction = this.rzm.vFI.vFE;
                        gmVar2.fwC.messageExt = this.rzm.vFI.vFD;
                        gmVar2.fwC.scene = 3;
                        com.tencent.mm.sdk.b.a.xef.m(gmVar2);
                        a.ift.a(this.rzl, this.rzm.vFI.ngo, cy, this.rzn.ksU, i, 18, 3, this.rzm.vFI.vFC, this.rzn.nGJ);
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
