package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

class g$61 implements OnClickListener {
    final /* synthetic */ String fgU;
    final /* synthetic */ String jBv;
    final /* synthetic */ String mXv;
    final /* synthetic */ int tIT;
    final /* synthetic */ int tIU;
    final /* synthetic */ int tIV;
    final /* synthetic */ boolean tIW;
    final /* synthetic */ i tIg;
    final /* synthetic */ g tIj;

    g$61(g gVar, i iVar, String str, String str2, int i, int i2, int i3, String str3, boolean z) {
        this.tIj = gVar;
        this.tIg = iVar;
        this.fgU = str;
        this.mXv = str2;
        this.tIT = i;
        this.tIU = i2;
        this.tIV = i3;
        this.jBv = str3;
        this.tIW = z;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        g.a(this.tIj, this.tIg, this.fgU, this.mXv, this.tIT, this.tIU, this.tIV, this.jBv, this.tIW);
    }
}
