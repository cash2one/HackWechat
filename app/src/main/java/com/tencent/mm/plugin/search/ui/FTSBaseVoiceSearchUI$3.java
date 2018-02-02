package com.tencent.mm.plugin.search.ui;

import android.os.Message;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.bh;

class FTSBaseVoiceSearchUI$3 extends af {
    final /* synthetic */ FTSBaseVoiceSearchUI qce;

    FTSBaseVoiceSearchUI$3(FTSBaseVoiceSearchUI fTSBaseVoiceSearchUI) {
        this.qce = fTSBaseVoiceSearchUI;
    }

    public final void handleMessage(Message message) {
        if (message.what == 1 && !bh.ov(FTSBaseVoiceSearchUI.b(this.qce))) {
            this.qce.bpV();
        }
    }
}
