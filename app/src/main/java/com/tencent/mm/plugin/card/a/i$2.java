package com.tencent.mm.plugin.card.a;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

class i$2 implements OnClickListener {
    final /* synthetic */ i kJj;

    i$2(i iVar) {
        this.kJj = iVar;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        this.kJj.kIZ = true;
        i.a(this.kJj.kIw, new byte[0], -85.0f, -1000.0f, 0, false, true);
    }
}
