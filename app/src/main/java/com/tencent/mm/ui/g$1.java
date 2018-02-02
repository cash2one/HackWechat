package com.tencent.mm.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

class g$1 implements OnClickListener {
    final /* synthetic */ int hLI;
    final /* synthetic */ Context val$context;
    final /* synthetic */ String xEU;

    g$1(Context context, String str, int i) {
        this.val$context = context;
        this.xEU = str;
        this.hLI = i;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        g.o(this.val$context, this.xEU, this.hLI);
    }
}
