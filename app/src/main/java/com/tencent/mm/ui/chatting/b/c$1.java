package com.tencent.mm.ui.chatting.b;

import com.tencent.mm.ag.m.a.a;
import com.tencent.mm.sdk.platformtools.x;

class c$1 implements a {
    final /* synthetic */ c yyQ;

    c$1(c cVar) {
        this.yyQ = cVar;
    }

    public final void ki(String str) {
        if (str == null) {
            x.i("MicroMsg.ChattingUI.BizMgr", "brand is null");
            return;
        }
        x.i("MicroMsg.ChattingUI.BizMgr", "BrandLogic.BrandIconService.BrandIconUpdateListener onUpdate");
        this.yyQ.fhr.cpl();
    }
}
