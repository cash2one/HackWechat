package com.tencent.mm.plugin.game.gamewebview.jsapi.biz;

import com.tencent.mm.plugin.game.gamewebview.jsapi.a;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.UploadMediaFileHelp.b;
import com.tencent.mm.plugin.game.gamewebview.ui.d;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;

class bd$1 implements b {
    final /* synthetic */ int gOK;
    final /* synthetic */ d mWr;
    final /* synthetic */ bd mXn;

    bd$1(bd bdVar, d dVar, int i) {
        this.mXn = bdVar;
        this.mWr = dVar;
        this.gOK = i;
    }

    public final void a(boolean z, HashMap<String, Object> hashMap) {
        x.i("MicroMsg.GameJsApiUploadMediaFile", "sucess = %b", new Object[]{Boolean.valueOf(z)});
        if (z) {
            this.mWr.E(this.gOK, bd.e("uploadMediaFile:ok", hashMap));
        } else {
            d dVar = this.mWr;
            int i = this.gOK;
            bd bdVar = this.mXn;
            dVar.E(i, a.e("uploadMediaFile:fail", null));
        }
        UploadMediaFileHelp uploadMediaFileHelp = this.mXn.mXm;
        uploadMediaFileHelp.iqt = null;
        uploadMediaFileHelp.mWG = null;
        uploadMediaFileHelp.mAppId = null;
        uploadMediaFileHelp.mXp = null;
        uploadMediaFileHelp.mXr = null;
    }
}
