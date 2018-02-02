package com.tencent.mm.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.sdk.platformtools.ag;

class j$5 implements OnClickListener {
    final /* synthetic */ j xFL;

    j$5(j jVar) {
        this.xFL = jVar;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        ag.y(new 1(this, dialogInterface));
    }
}
