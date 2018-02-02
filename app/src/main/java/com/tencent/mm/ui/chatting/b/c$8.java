package com.tencent.mm.ui.chatting.b;

import com.tencent.mm.ag.a.c;
import com.tencent.mm.ag.a.e;
import com.tencent.mm.ag.a.h;
import com.tencent.mm.ag.a.j;
import com.tencent.mm.ag.n;
import com.tencent.mm.ag.y;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelsimple.aj;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

class c$8 implements Runnable {
    final /* synthetic */ c yyQ;

    public c$8(c cVar) {
        this.yyQ = cVar;
    }

    public final void run() {
        long currentTimeMillis = System.currentTimeMillis();
        if (!this.yyQ.vnK || this.yyQ.ync == null || this.yyQ.fhr.csi() == null) {
            x.i("MicroMsg.ChattingUI.BizMgr", "bizChatInfo:%s  talker:%s", new Object[]{this.yyQ.ync, this.yyQ.fhr.csi()});
        } else {
            this.yyQ.ctk();
            y.Mq();
            c cVar = this.yyQ.ync;
            if (a.gB(g.Dh().gPs)) {
                aj.a(cVar.field_brandUserName, 7, "EnterpriseChatStatus", String.format("%s;%s;%d", new Object[]{cVar.field_brandUserName, cVar.field_bizChatServId, Long.valueOf(System.currentTimeMillis() / 1000)}));
                x.d("MicroMsg.BizChatStatusNotifyService", "enterChat:arg:%s", new Object[]{r3});
            }
            if (this.yyQ.yyK) {
                if (this.yyQ.ync.Mu()) {
                    y.Ml();
                    h.ak(this.yyQ.ync.field_bizChatServId, this.yyQ.fhr.csi().field_username);
                } else {
                    e.f(this.yyQ.ync);
                }
            }
            n nVar = this.yyQ;
            if (!(!nVar.vnK || nVar.ync == null || bh.ov(nVar.ync.field_brandUserName))) {
                String cb = y.Mj().cb(nVar.ync.field_brandUserName);
                j ca = y.Mj().ca(cb);
                String str = "MicroMsg.ChattingUI.BizMgr";
                String str2 = "updateBizChatMyUserInfo: %s:%s,myBizChatUserInfo is null:%s";
                Object[] objArr = new Object[3];
                objArr[0] = nVar.ync.field_brandUserName;
                objArr[1] = cb;
                objArr[2] = Boolean.valueOf(ca == null);
                x.i(str, str2, objArr);
                if (bh.ov(cb) || ca == null || ca.Mu() || bh.ov(ca.field_addMemberUrl)) {
                    y.Ml();
                    h.a(nVar.ync.field_brandUserName, nVar);
                }
            }
        }
        x.d("MicroMsg.ChattingUI.BizMgr", "willen test  updateBizChatInfo use time:%s", new Object[]{Long.valueOf(System.currentTimeMillis() - currentTimeMillis)});
    }
}
