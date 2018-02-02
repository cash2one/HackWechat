package com.tencent.mm.ui.chatting.b;

import com.tencent.mm.sdk.e.j.a;
import com.tencent.mm.sdk.e.l;
import com.tencent.mm.sdk.platformtools.x;

class b$1 implements a {
    final /* synthetic */ b yyH;

    b$1(b bVar) {
        this.yyH = bVar;
    }

    public final void a(String str, l lVar) {
        x.d("MicroMsg.ChattingUI.BackgroundImp", "onBGChange event:%s", new Object[]{str});
        if (str == null) {
            return;
        }
        if (str.equals(this.yyH.fhr.crz()) || str.equals("*")) {
            this.yyH.bSr();
        }
    }
}
