package com.tencent.mm.ui.tools;

import android.os.Message;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

class ShareImgUI$3 extends af {
    final /* synthetic */ ShareImgUI zmI;

    ShareImgUI$3(ShareImgUI shareImgUI) {
        this.zmI = shareImgUI;
    }

    public final void handleMessage(Message message) {
        ShareImgUI.d(this.zmI);
        if (bh.ov(this.zmI.filePath)) {
            x.e("MicroMsg.ShareImgUI", "launch : fail, filePath is null");
            ShareImgUI.e(this.zmI);
            this.zmI.finish();
            return;
        }
        ShareImgUI.c(this.zmI);
    }
}
