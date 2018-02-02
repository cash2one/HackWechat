package com.tencent.mm.ui.bizchat;

import android.os.MessageQueue.IdleHandler;
import com.tencent.mm.ag.b;
import com.tencent.mm.ag.y;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.bizchat.BizChatConversationUI.a;

class BizChatConversationUI$a$1 implements IdleHandler {
    final /* synthetic */ a ynJ;

    BizChatConversationUI$a$1(a aVar) {
        this.ynJ = aVar;
    }

    public final boolean queueIdle() {
        a.a(this.ynJ, y.Mf().jK(a.a(this.ynJ)).Lm());
        int intExtra = this.ynJ.thisActivity().getIntent().getIntExtra("biz_chat_from_scene", 7);
        int i = -1;
        if (a.b(this.ynJ) != null) {
            i = a.b(this.ynJ).getCount();
        }
        b jx = y.Mm().jx(a.c(this.ynJ));
        int i2 = jx != null ? jx.field_qyUin : 0;
        int i3 = jx != null ? jx.field_userUin : 0;
        int jz = y.Mm().jz(a.a(this.ynJ));
        long j = jx != null ? jx.field_wwCorpId : 0;
        long j2 = jx != null ? jx.field_wwUserVid : 0;
        g.pQN.h(12648, new Object[]{a.c(this.ynJ), a.a(this.ynJ), Integer.valueOf(intExtra), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(jz), Integer.valueOf(i3), Long.valueOf(j), Long.valueOf(j2)});
        x.d("MicroMsg.BizChatConversationFmUI", "bizchat report belong:%s,brandUserName:%s,fromScene:%s,itemCount:%s,fatherUin:%d,childUin:%d,userUin:%d,wwCorpId:%l,wwUserVidL%l", new Object[]{a.c(this.ynJ), a.a(this.ynJ), Integer.valueOf(intExtra), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(jz), Integer.valueOf(i3), Long.valueOf(j), Long.valueOf(j2)});
        return false;
    }
}
