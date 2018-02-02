package com.tencent.mm.plugin.appbrand.menu;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.plugin.appbrand.page.p;

class h$1 implements OnClickListener {
    final /* synthetic */ String fgU;
    final /* synthetic */ l jAD;
    final /* synthetic */ h jAE;
    final /* synthetic */ p jfB;

    h$1(h hVar, p pVar, String str, l lVar) {
        this.jAE = hVar;
        this.jfB = pVar;
        this.fgU = str;
        this.jAD = lVar;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        h.a(this.jfB, this.jAD);
    }
}
