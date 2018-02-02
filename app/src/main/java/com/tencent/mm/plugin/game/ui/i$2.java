package com.tencent.mm.plugin.game.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.sdk.platformtools.x;

class i$2 implements OnClickListener {
    final /* synthetic */ i nnz;

    i$2(i iVar) {
        this.nnz = iVar;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        dialogInterface.dismiss();
        x.i("MicsoMsg.GameClickListener", "resumeDownloadTask not wifi, user cancel");
    }
}
