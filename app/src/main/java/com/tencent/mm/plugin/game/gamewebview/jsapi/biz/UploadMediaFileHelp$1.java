package com.tencent.mm.plugin.game.gamewebview.jsapi.biz;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

class UploadMediaFileHelp$1 implements OnClickListener {
    final /* synthetic */ UploadMediaFileHelp mXs;

    UploadMediaFileHelp$1(UploadMediaFileHelp uploadMediaFileHelp) {
        this.mXs = uploadMediaFileHelp;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        UploadMediaFileHelp.a(this.mXs);
    }
}
