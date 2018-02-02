package com.tencent.mm.ui.transmit;

import android.os.Message;
import com.tencent.mm.sdk.platformtools.af;

class ShareImageSelectorUI$2 extends af {
    final /* synthetic */ ShareImageSelectorUI zpM;

    ShareImageSelectorUI$2(ShareImageSelectorUI shareImageSelectorUI) {
        this.zpM = shareImageSelectorUI;
    }

    public final void handleMessage(Message message) {
        this.zpM.finish();
    }
}
