package com.tencent.mm.plugin.game.gamewebview.jsapi.biz;

import com.tencent.mm.plugin.webview.model.c.b;
import com.tencent.mm.plugin.webview.modeltools.f;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

class UploadMediaFileHelp$7 implements b {
    final /* synthetic */ String mXv;
    final /* synthetic */ UploadMediaFileHelp$a mXw;

    UploadMediaFileHelp$7(String str, UploadMediaFileHelp$a uploadMediaFileHelp$a) {
        this.mXv = str;
        this.mXw = uploadMediaFileHelp$a;
    }

    public final void a(boolean z, String str, String str2, String str3) {
        x.i("MicroMsg.UploadMediaFileHelp", "on cdn finish,  is success : %s, mediaId : %s, local id is : %s, mediaUrl : %s", new Object[]{Boolean.valueOf(z), str2, str, str3});
        if (!bh.ov(str) && str.equals(this.mXv)) {
            f.bRA().a(this);
            if (UploadMediaFileHelp.aOQ() != null) {
                UploadMediaFileHelp.aOQ().dismiss();
                UploadMediaFileHelp.aOR();
            }
            this.mXw.b(z, str2, str3);
        }
    }
}
