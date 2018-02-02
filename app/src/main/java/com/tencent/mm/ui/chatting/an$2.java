package com.tencent.mm.ui.chatting;

import com.tencent.mm.opensdk.modelmsg.ShowMessageFromWX.Req;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.pluginsdk.model.app.g;

class an$2 implements Runnable {
    final /* synthetic */ String fgU;
    final /* synthetic */ String mGO;
    final /* synthetic */ WXMediaMessage nbw;
    final /* synthetic */ String uN;
    final /* synthetic */ an yye;

    an$2(an anVar, WXMediaMessage wXMediaMessage, String str, String str2, String str3) {
        this.yye = anVar;
        this.nbw = wXMediaMessage;
        this.mGO = str;
        this.uN = str2;
        this.fgU = str3;
    }

    public final void run() {
        Req c = g.c(an.a(this.yye), this.nbw, this.mGO);
        g.a(an.a(this.yye), this.uN, this.fgU, c, 0, new 1(this, c), null);
    }
}
