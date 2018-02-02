package com.tencent.mm.plugin.scanner.util;

import android.content.Intent;
import android.widget.Toast;
import com.tencent.mm.g.a.ol;
import com.tencent.mm.plugin.scanner.b;
import com.tencent.mm.pluginsdk.wallet.h;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

class e$5 implements Runnable {
    final /* synthetic */ int fgK;
    final /* synthetic */ int hLI;
    final /* synthetic */ ol lji;
    final /* synthetic */ e qab;
    final /* synthetic */ String qad;

    e$5(e eVar, ol olVar, int i, String str, int i2) {
        this.qab = eVar;
        this.lji = olVar;
        this.fgK = i;
        this.qad = str;
        this.hLI = i2;
    }

    public final void run() {
        if (!bh.ov(this.lji.fGr.fnL)) {
            Toast.makeText(this.qab.getContext(), this.lji.fGr.fnL, 1).show();
        } else if (bh.ov(this.lji.fGr.fGt)) {
            x.w("MicroMsg.QBarStringHandler", "resp url is null!");
        } else if (this.lji.fGr.actionType == 1) {
            h.a(this.qab.getContext(), this.lji.fGr.fGt, this.fgK, this.qad, this.hLI);
        } else {
            Intent intent = new Intent();
            intent.putExtra("rawUrl", this.lji.fGr.fGt);
            b.ifs.j(intent, this.qab.getContext());
        }
        if (this.qab.pZY != null) {
            this.qab.pZY.m(3, null);
        }
    }
}
