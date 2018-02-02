package com.tencent.mm.ui.account.mobile;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.plugin.c.b;
import com.tencent.mm.z.ar;

class d$9 implements OnClickListener {
    final /* synthetic */ d xTS;

    d$9(d dVar) {
        this.xTS = dVar;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        b.b(true, ar.CB() + "," + getClass().getName() + ",R200_200," + ar.fH("R200_200") + ",2");
    }
}
