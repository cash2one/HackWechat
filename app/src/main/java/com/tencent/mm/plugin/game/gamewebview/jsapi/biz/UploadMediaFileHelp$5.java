package com.tencent.mm.plugin.game.gamewebview.jsapi.biz;

import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.UploadMediaFileHelp.a;
import com.tencent.mm.plugin.webview.model.c.b;
import com.tencent.mm.plugin.webview.modeltools.f;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

class UploadMediaFileHelp$5 implements b {
    final /* synthetic */ String mXv;
    final /* synthetic */ a mXw;

    UploadMediaFileHelp$5(String str, a aVar) {
        this.mXv = str;
        this.mXw = aVar;
    }

    public final void a(boolean z, String str, String str2, String str3) {
        x.i("MicroMsg.UploadMediaFileHelp", " on cdn finish,  is success : %s, mediaid : %s, local id is : %s, mediaUrl : %s", new Object[]{Boolean.valueOf(z), str2, str, str3});
        if (!bh.ov(str) && str.equals(this.mXv)) {
            f.bRA().a((b) this);
            if (UploadMediaFileHelp.aOQ() != null) {
                UploadMediaFileHelp.aOQ().dismiss();
                UploadMediaFileHelp.aOR();
            }
            this.mXw.b(z, str2, str3);
        }
    }
}
