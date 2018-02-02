package com.tencent.mm.plugin.voip.model;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

class l$1 implements OnClickListener {
    final /* synthetic */ String gIx;
    final /* synthetic */ Context val$context;

    l$1(Context context, String str) {
        this.val$context = context;
        this.gIx = str;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        l.bHk();
        d.bGj().aG(this.val$context, this.gIx);
    }
}
