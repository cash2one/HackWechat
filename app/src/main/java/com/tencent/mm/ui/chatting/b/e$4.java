package com.tencent.mm.ui.chatting.b;

import com.tencent.mm.sdk.e.j.a;
import com.tencent.mm.sdk.e.l;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.m;

class e$4 implements a {
    final /* synthetic */ e yzf;

    e$4(e eVar) {
        this.yzf = eVar;
    }

    public final void a(String str, l lVar) {
        x.v("MicroMsg.ChattingUI.ChatroomImp", "roommember watcher notify " + str);
        if (this.yzf.yyZ) {
            m.b(this.yzf.fhr.crz(), this.yzf.yza);
        } else {
            this.yzf.yza.clear();
        }
        if (!bh.ov(str)) {
            this.yzf.fhr.cqY();
            this.yzf.fhr.cpl();
            this.yzf.fhr.cqZ();
            this.yzf.yvM.mO(false);
        }
        this.yzf.fhr.csy().a(null, null);
    }
}
