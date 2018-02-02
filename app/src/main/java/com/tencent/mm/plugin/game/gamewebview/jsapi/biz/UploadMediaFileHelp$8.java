package com.tencent.mm.plugin.game.gamewebview.jsapi.biz;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.plugin.webview.model.ac;
import com.tencent.mm.plugin.webview.model.c.b;
import com.tencent.mm.plugin.webview.modeltools.f;

class UploadMediaFileHelp$8 implements OnCancelListener {
    final /* synthetic */ String mXv;
    final /* synthetic */ UploadMediaFileHelp$a mXw;
    final /* synthetic */ b mXx;

    UploadMediaFileHelp$8(b bVar, String str, UploadMediaFileHelp$a uploadMediaFileHelp$a) {
        this.mXx = bVar;
        this.mXv = str;
        this.mXw = uploadMediaFileHelp$a;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        f.bRA().a(this.mXx);
        f.bRA();
        ac.qh(this.mXv);
        this.mXw.b(false, "", "");
    }
}
