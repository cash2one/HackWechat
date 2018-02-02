package com.tencent.mm.plugin.game.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

class i$1 implements OnClickListener {
    final /* synthetic */ i nnz;

    i$1(i iVar) {
        this.nnz = iVar;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        i.a(this.nnz);
        dialogInterface.dismiss();
    }
}
