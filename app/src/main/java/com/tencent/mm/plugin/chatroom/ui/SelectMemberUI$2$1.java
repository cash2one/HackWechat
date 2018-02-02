package com.tencent.mm.plugin.chatroom.ui;

import com.tencent.mm.plugin.chatroom.ui.SelectMemberUI.2;
import com.tencent.mm.plugin.chatroom.ui.SelectMemberUI.b;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.ak.a;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

class SelectMemberUI$2$1 implements a {
    final /* synthetic */ 2 ldR;

    SelectMemberUI$2$1(2 2) {
        this.ldR = 2;
    }

    public final boolean uF() {
        x.d("MicroMsg.SelectMemberUI", "searchEvent onTimerExpired");
        b b = SelectMemberUI.b(this.ldR.ldP);
        String obj = SelectMemberUI.c(this.ldR.ldP).getText().toString();
        x.i("MicroMsg.SelectMemberAdapter", "search:%s isLoading:%s", new Object[]{bh.VT(obj), Boolean.valueOf(b.acS)});
        if (!b.acS) {
            b.ldh = obj;
            b.xi(obj);
            ag.y(new b.2(b));
        }
        return false;
    }
}
