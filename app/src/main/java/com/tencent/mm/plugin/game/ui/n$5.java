package com.tencent.mm.plugin.game.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

class n$5 implements OnClickListener {
    final /* synthetic */ n nsH;

    n$5(n nVar) {
        this.nsH = nVar;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        this.nsH.notifyDataSetChanged();
    }
}
