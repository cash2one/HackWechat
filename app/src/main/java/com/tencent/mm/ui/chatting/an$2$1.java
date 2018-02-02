package com.tencent.mm.ui.chatting;

import com.tencent.mm.opensdk.modelmsg.ShowMessageFromWX.Req;
import com.tencent.mm.pluginsdk.model.app.g.a;
import com.tencent.mm.ui.chatting.an.2;

class an$2$1 implements a {
    final /* synthetic */ Req vej;
    final /* synthetic */ 2 yyf;

    an$2$1(2 2, Req req) {
        this.yyf = 2;
        this.vej = req;
    }

    public final void cG(boolean z) {
        if (z) {
            an.b(this.yyf.yye).put(this.vej.transaction, this.vej);
        }
    }
}
