package com.tencent.mm.ui.chatting.viewitems;

import com.tencent.mm.ui.chatting.viewitems.af.e;
import com.tencent.mm.ui.widget.MMNeatTextView.a;

class af$a$1 implements a {
    final /* synthetic */ e yNn;
    final /* synthetic */ af.a yNo;

    af$a$1(af.a aVar, e eVar) {
        this.yNo = aVar;
        this.yNn = eVar;
    }

    public final void T(CharSequence charSequence) {
        if (((Boolean) this.yNn.yNq.getTag(af.a.ts())).booleanValue()) {
            com.tencent.mm.ui.chatting.f.a.a.cvt();
            com.tencent.mm.ui.chatting.f.a.a.cvu().a(charSequence, ((Long) this.yNn.yNq.getTag(af.a.Td())).longValue());
        }
    }
}
