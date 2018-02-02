package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.R;
import com.tencent.mm.ui.base.h;

class g$82 implements Runnable {
    final /* synthetic */ i tIg;
    final /* synthetic */ g tIj;

    g$82(g gVar, i iVar) {
        this.tIj = gVar;
        this.tIg = iVar;
    }

    public final void run() {
        h.a(g.i(this.tIj), g.i(this.tIj).getString(R.l.exR), "", g.i(this.tIj).getString(R.l.exS), g.i(this.tIj).getString(R.l.dEn), new 1(this), new OnClickListener(this) {
            final /* synthetic */ g$82 tJi;

            {
                this.tJi = r1;
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
                g.a(this.tJi.tIj, this.tJi.tIg, "nfcCheckState:nfc_off", null);
            }
        });
    }
}
