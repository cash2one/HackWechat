package com.tencent.mm.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ag;

class j$4 implements OnClickListener {
    final /* synthetic */ j xFL;

    j$4(j jVar) {
        this.xFL = jVar;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        ag.y(new Runnable(this) {
            final /* synthetic */ j$4 xFM;

            {
                this.xFM = r1;
            }

            public final void run() {
                g.Dk().fM("");
                MMAppMgr.lW(true);
            }
        });
    }
}
