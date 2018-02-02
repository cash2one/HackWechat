package com.tencent.mm.plugin.game.gamewebview.jsapi.biz;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

class UploadMediaFileHelp$2 implements OnClickListener {
    final /* synthetic */ UploadMediaFileHelp mXs;

    UploadMediaFileHelp$2(UploadMediaFileHelp uploadMediaFileHelp) {
        this.mXs = uploadMediaFileHelp;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        this.mXs.mXr.a(false, null);
    }
}
