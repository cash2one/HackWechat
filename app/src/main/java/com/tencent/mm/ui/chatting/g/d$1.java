package com.tencent.mm.ui.chatting.g;

import android.view.View;
import com.tencent.mm.plugin.messenger.a.a;
import com.tencent.mm.ui.chatting.g.a.b;

class d$1 extends a {
    final /* synthetic */ a.a yIa;
    final /* synthetic */ d yIb;

    d$1(d dVar, a.a aVar) {
        this.yIb = dVar;
        this.yIa = aVar;
        super(1, null);
    }

    public final void bJ(View view) {
        a aVar = this.yIb;
        a.a aVar2 = this.yIa;
        if (aVar.yHV != null && aVar.yHV.get() != null) {
            ((b) aVar.yHV.get()).a(view, aVar2);
        }
    }
}
