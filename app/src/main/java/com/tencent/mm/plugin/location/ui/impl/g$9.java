package com.tencent.mm.plugin.location.ui.impl;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.plugin.location.ui.k;

class g$9 implements OnClickListener {
    final /* synthetic */ g nYb;

    g$9(g gVar) {
        this.nYb = gVar;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        this.nYb.nXO.gq(false);
        this.nYb.nXP.stop();
        this.nYb.nXP.rM(2);
        k.aWa();
        this.nYb.activity.finish();
    }
}
