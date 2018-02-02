package com.tencent.mm.plugin.game.gamewebview.jsapi.biz;

import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.UploadMediaFileHelp.UploadMediaFileTask;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.UploadMediaFileHelp.a;
import com.tencent.mm.sdk.platformtools.x;

class UploadMediaFileHelp$UploadMediaFileTask$1 implements a {
    final /* synthetic */ UploadMediaFileTask mXF;

    UploadMediaFileHelp$UploadMediaFileTask$1(UploadMediaFileTask uploadMediaFileTask) {
        this.mXF = uploadMediaFileTask;
    }

    public final void b(boolean z, String str, String str2) {
        x.i("MicroMsg.UploadMediaTask", "success = %b, mediaId = %s, mediaUrl = %s", new Object[]{Boolean.valueOf(z), str, str2});
        this.mXF.success = z;
        this.mXF.mediaId = str;
        this.mXF.mXC = str2;
        UploadMediaFileTask.a(this.mXF);
    }
}
