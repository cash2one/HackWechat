package com.tencent.mm.ui.tools;

import android.os.Message;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

class ShareScreenImgUI$1 extends af {
    final /* synthetic */ ShareScreenImgUI zmS;

    ShareScreenImgUI$1(ShareScreenImgUI shareScreenImgUI) {
        this.zmS = shareScreenImgUI;
    }

    public final void handleMessage(Message message) {
        ShareScreenImgUI.a(this.zmS);
        if (bh.ov(this.zmS.filePath)) {
            x.e("MicroMsg.ShareScreenImgUI", "launch : fail, filePath is null");
            ShareScreenImgUI.b(this.zmS);
            this.zmS.finish();
            return;
        }
        ShareScreenImgUI.c(this.zmS);
    }
}
