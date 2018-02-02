package com.tencent.mm.plugin.search.ui;

import android.os.Message;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.bh;

class FTSBaseUI$3 extends af {
    final /* synthetic */ FTSBaseUI qcb;

    FTSBaseUI$3(FTSBaseUI fTSBaseUI) {
        this.qcb = fTSBaseUI;
    }

    public final void handleMessage(Message message) {
        if (message.what == 1 && !bh.ov(FTSBaseUI.b(this.qcb))) {
            this.qcb.bpV();
        }
    }
}
