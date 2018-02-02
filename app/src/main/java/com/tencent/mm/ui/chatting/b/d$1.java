package com.tencent.mm.ui.chatting.b;

import com.tencent.mm.plugin.messenger.a.f;
import com.tencent.mm.pluginsdk.ui.applet.o.a;

class d$1 implements a {
    final /* synthetic */ String hpU;
    final /* synthetic */ String yyW;
    final /* synthetic */ boolean yyX;
    final /* synthetic */ d yyY;

    public d$1(d dVar, String str, String str2, boolean z) {
        this.yyY = dVar;
        this.hpU = str;
        this.yyW = str2;
        this.yyX = z;
    }

    public final void a(boolean z, String str, int i) {
        this.yyY.fhr.csq().hideVKB();
        if (z) {
            f.aZh().k(this.hpU, this.yyW, this.yyX);
            f.aZh().dj(str, this.yyW);
        }
    }
}
