package com.tencent.mm.plugin.offline.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

class c$6 implements OnClickListener {
    final /* synthetic */ c oXK;

    c$6(c cVar) {
        this.oXK = cVar;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        dialogInterface.dismiss();
        this.oXK.mActivity.finish();
    }
}
