package com.tencent.mm.ui.chatting;

import com.tencent.mm.g.b.cf;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.h;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.au;

class q$4 implements Runnable {
    final /* synthetic */ au heR;
    final /* synthetic */ q ytD;

    q$4(q qVar, au auVar) {
        this.ytD = qVar;
        this.heR = auVar;
    }

    public final void run() {
        if (q.b(this.ytD).get(Long.valueOf(this.heR.field_msgId)) != null) {
            x.i("MicroMsg.ChattingListAdapter", "summerbadcr getview found fault check exist!");
            return;
        }
        cf Ey = ((h) g.h(h.class)).aZi().Ey(this.heR.field_talker);
        if (Ey == null || Ey.field_msgId != this.heR.field_msgId) {
            Long l = (Long) q.b(this.ytD).put(Long.valueOf(this.heR.field_msgId), Long.valueOf(this.heR.field_msgSeq));
            x.i("MicroMsg.ChattingListAdapter", "summerbadcr getview found fault[%d, %d, %d, %d, %d, %d, %d, %s, %s]", new Object[]{Integer.valueOf(this.heR.field_flag), Integer.valueOf(this.heR.field_isSend), Long.valueOf(this.heR.field_msgId), Long.valueOf(this.heR.field_msgSvrId), Long.valueOf(this.heR.field_msgSeq), Long.valueOf(this.heR.field_createTime), Integer.valueOf(this.heR.getType()), this.heR.field_talker, l});
            if ((((h) g.h(h.class)).aZi().dH(this.heR.field_msgId).field_flag & 4) != 0) {
                x.i("MicroMsg.ChattingListAdapter", "summerbadcr getview found fault check[%d, %d, %d, %d, %d, %d, %d, %s]", new Object[]{Integer.valueOf(((h) g.h(h.class)).aZi().dH(this.heR.field_msgId).field_flag), Integer.valueOf(((h) g.h(h.class)).aZi().dH(this.heR.field_msgId).field_isSend), Long.valueOf(((h) g.h(h.class)).aZi().dH(this.heR.field_msgId).field_msgId), Long.valueOf(((h) g.h(h.class)).aZi().dH(this.heR.field_msgId).field_msgSvrId), Long.valueOf(((h) g.h(h.class)).aZi().dH(this.heR.field_msgId).field_msgSeq), Long.valueOf(((h) g.h(h.class)).aZi().dH(this.heR.field_msgId).field_createTime), Integer.valueOf(((h) g.h(h.class)).aZi().dH(this.heR.field_msgId).getType()), ((h) g.h(h.class)).aZi().dH(this.heR.field_msgId).field_talker});
                this.ytD.ysg.yvO.aQ(this.heR);
                return;
            }
            return;
        }
        x.i("MicroMsg.ChattingListAdapter", "summerbadcr getview found fault is last ret");
    }
}
