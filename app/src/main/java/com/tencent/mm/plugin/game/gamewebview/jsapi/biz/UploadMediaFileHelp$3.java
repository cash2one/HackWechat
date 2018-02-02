package com.tencent.mm.plugin.game.gamewebview.jsapi.biz;

import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.UploadMediaFileHelp.UploadMediaFileActivity;
import com.tencent.mm.sdk.platformtools.bh;
import java.util.HashMap;

class UploadMediaFileHelp$3 implements Runnable {
    final /* synthetic */ UploadMediaFileHelp mXs;
    final /* synthetic */ UploadMediaFileActivity mXt;

    UploadMediaFileHelp$3(UploadMediaFileHelp uploadMediaFileHelp, UploadMediaFileActivity uploadMediaFileActivity) {
        this.mXs = uploadMediaFileHelp;
        this.mXt = uploadMediaFileActivity;
    }

    public final void run() {
        UploadMediaFileHelp.b(this.mXs);
        if (this.mXt.mXD) {
            HashMap hashMap = new HashMap();
            hashMap.put("serverId", bh.ou(this.mXt.mediaId));
            hashMap.put("mediaUrl", bh.ou(this.mXt.mXC));
            this.mXs.mXr.a(true, hashMap);
            return;
        }
        this.mXs.mXr.a(false, null);
    }
}
