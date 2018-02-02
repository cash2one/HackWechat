package com.tencent.mm.plugin.sns.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.bh;

class bb$4 implements OnClickListener {
    final /* synthetic */ int iGh;
    final /* synthetic */ bb rLm;

    bb$4(bb bbVar, int i) {
        this.rLm = bbVar;
        this.iGh = i;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        g.Dk();
        int a = bh.a((Integer) g.Dj().CU().get(68386, null), 0) + 1;
        g.Dk();
        g.Dj().CU().set(68386, Integer.valueOf(a));
        this.rLm.xQ(this.iGh);
    }
}
