package com.tencent.mm.ui.chatting.b;

import android.database.Cursor;
import com.tencent.mm.g.b.cf;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.au;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;
import com.tencent.mm.z.m;

class x$5 implements Runnable {
    final /* synthetic */ x yBJ;
    final /* synthetic */ String yBK;

    public x$5(x xVar, String str) {
        this.yBJ = xVar;
        this.yBK = str;
    }

    public final void run() {
        if (!bh.ov(this.yBK)) {
            int gl = m.gl(this.yBK);
            ar.Hg();
            Cursor p = c.Fa().p(this.yBK, x.b(this.yBJ), x.c(this.yBJ));
            int i = 0;
            int i2 = 0;
            if (p == null || !p.moveToFirst()) {
                if (p != null) {
                    p.close();
                }
                x.d("MicroMsg.ChattingUI.StatisticImp", "dkchatmsg MuteRoomKvStat:muteRoomName%s stayTime%d memberNum%d newMsg%d sendMsgNum%d unreadMsgNum%d", this.yBK, Long.valueOf(x.c(this.yBJ) - x.b(this.yBJ)), Integer.valueOf(gl), Integer.valueOf(x.a(this.yBJ) + i2), Integer.valueOf(i), Integer.valueOf(x.a(this.yBJ)));
                g.pQN.h(12077, this.yBK, Long.valueOf(x.c(this.yBJ) - x.b(this.yBJ)), Integer.valueOf(gl), Integer.valueOf(i2 + x.a(this.yBJ)), Integer.valueOf(i), Integer.valueOf(x.a(this.yBJ)));
            }
            cf auVar = new au();
            do {
                auVar.b(p);
                if (auVar.field_isSend == 1) {
                    i++;
                } else {
                    i2++;
                }
            } while (p.moveToNext());
            if (p != null) {
                p.close();
            }
            x.d("MicroMsg.ChattingUI.StatisticImp", "dkchatmsg MuteRoomKvStat:muteRoomName%s stayTime%d memberNum%d newMsg%d sendMsgNum%d unreadMsgNum%d", this.yBK, Long.valueOf(x.c(this.yBJ) - x.b(this.yBJ)), Integer.valueOf(gl), Integer.valueOf(x.a(this.yBJ) + i2), Integer.valueOf(i), Integer.valueOf(x.a(this.yBJ)));
            g.pQN.h(12077, this.yBK, Long.valueOf(x.c(this.yBJ) - x.b(this.yBJ)), Integer.valueOf(gl), Integer.valueOf(i2 + x.a(this.yBJ)), Integer.valueOf(i), Integer.valueOf(x.a(this.yBJ)));
        }
    }
}
