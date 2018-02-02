package com.tencent.mm.ui.chatting.f.a;

import com.tencent.mm.g.b.cf;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.h;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.widget.MMTextView.a;

enum a$a implements a {
    ;

    private a$a(String str) {
    }

    public final void a(CharSequence charSequence, long j) {
        cf dH = ((h) g.h(h.class)).aZi().dH(j);
        if (bh.ov(dH.field_talker)) {
            x.w("MicroMsg.AAChattingHelper", "hy: not retrieving correct msg from db. try use old one. msg id: %d", new Object[]{Long.valueOf(j)});
        } else if ((dH.field_flag & 16) == 0) {
            a.b(charSequence, dH);
        } else {
            x.v("MicroMsg.AAChattingHelper", "hy: show already checked. msg id is: %d", new Object[]{Long.valueOf(j)});
        }
    }
}
