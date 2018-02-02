package com.tencent.mm.plugin.sns.ui;

import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.View;
import android.view.View.OnCreateContextMenuListener;
import com.tencent.mm.bm.d;
import com.tencent.mm.g.a.dh;
import com.tencent.mm.k.g;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

class SnsSightPlayerUI$5 implements OnCreateContextMenuListener {
    final /* synthetic */ SnsSightPlayerUI rGv;

    SnsSightPlayerUI$5(SnsSightPlayerUI snsSightPlayerUI) {
        this.rGv = snsSightPlayerUI;
    }

    public final void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
        int i;
        b dhVar;
        if (bh.VI(g.zY().getValue("SIGHTCannotTransmitForFav")) == 0) {
            x.i("MicroMsg.SnsSightPlayerUI", "config can forward sight, thumb existed %B, video existed %B", new Object[]{Boolean.valueOf(FileOp.bO(SnsSightPlayerUI.c(this.rGv))), Boolean.valueOf(FileOp.bO(SnsSightPlayerUI.t(this.rGv)))});
            if (FileOp.bO(SnsSightPlayerUI.c(this.rGv)) && r3) {
                contextMenu.add(0, 3, 0, this.rGv.getString(j.qKc));
                i = 1;
                if (d.OQ("favorite")) {
                    contextMenu.add(0, 2, 0, this.rGv.getString(j.eAd));
                }
                if (i != 0) {
                    dhVar = new dh();
                    dhVar.frQ.frH = SnsSightPlayerUI.d(this.rGv);
                    a.xef.m(dhVar);
                    if (dhVar.frR.frp) {
                        contextMenu.add(0, 4, 0, this.rGv.getString(j.qJu));
                    }
                }
                if (!SnsSightPlayerUI.i(this.rGv)) {
                    contextMenu.add(0, 1, 0, this.rGv.mController.xIM.getString(j.qMt));
                }
            }
        }
        i = 0;
        if (d.OQ("favorite")) {
            contextMenu.add(0, 2, 0, this.rGv.getString(j.eAd));
        }
        if (i != 0) {
            dhVar = new dh();
            dhVar.frQ.frH = SnsSightPlayerUI.d(this.rGv);
            a.xef.m(dhVar);
            if (dhVar.frR.frp) {
                contextMenu.add(0, 4, 0, this.rGv.getString(j.qJu));
            }
        }
        if (!SnsSightPlayerUI.i(this.rGv)) {
            contextMenu.add(0, 1, 0, this.rGv.mController.xIM.getString(j.qMt));
        }
    }
}
