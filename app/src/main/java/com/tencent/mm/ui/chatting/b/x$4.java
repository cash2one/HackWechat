package com.tencent.mm.ui.chatting.b;

import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.s;
import com.tencent.mm.z.t;

class x$4 implements Runnable {
    final /* synthetic */ x yBJ;
    final /* synthetic */ String yBK;

    public x$4(x xVar, String str) {
        this.yBJ = xVar;
        this.yBK = str;
    }

    public final void run() {
        if (!bh.ov(this.yBK)) {
            x.a(this.yBJ, t.M(this.yBK, s.hfk));
            x.i("MicroMsg.ChattingUI.StatisticImp", "dkchatmsg:name:%s unRead:%s entryTime:%s(%s)", this.yBK, Integer.valueOf(x.a(this.yBJ)), bh.fI(x.b(this.yBJ)), Long.valueOf(x.b(this.yBJ)));
        }
    }
}
