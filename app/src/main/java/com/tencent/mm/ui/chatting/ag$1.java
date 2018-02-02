package com.tencent.mm.ui.chatting;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

class ag$1 implements OnClickListener {
    final /* synthetic */ ag yxv;

    ag$1(ag agVar) {
        this.yxv = agVar;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        dialogInterface.dismiss();
        this.yxv.activity.finish();
    }
}
