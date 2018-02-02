package com.tencent.mm.plugin.voip.model;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

class l$5 implements OnClickListener {
    final /* synthetic */ Context val$context;

    l$5(Context context) {
        this.val$context = context;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        l.dB(this.val$context);
    }
}
