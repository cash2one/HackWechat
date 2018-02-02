package com.tencent.mm.plugin.record.ui;

import android.app.Dialog;
import com.tencent.mm.plugin.record.b.h;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.storage.au;

class RecordMsgDetailUI$4 implements Runnable {
    final /* synthetic */ String fgO;
    final /* synthetic */ au heZ;
    final /* synthetic */ Dialog msk;
    final /* synthetic */ RecordMsgDetailUI pGl;
    final /* synthetic */ String pGn;

    RecordMsgDetailUI$4(RecordMsgDetailUI recordMsgDetailUI, String str, String str2, au auVar, Dialog dialog) {
        this.pGl = recordMsgDetailUI;
        this.fgO = str;
        this.pGn = str2;
        this.heZ = auVar;
        this.msk = dialog;
    }

    public final void run() {
        h.a(this.fgO, this.pGn, this.heZ);
        ag.y(new 1(this));
    }

    public final String toString() {
        return super.toString() + "|onActivityResult";
    }
}
