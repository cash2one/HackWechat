package com.tencent.mm.ui.conversation;

import android.content.Context;
import android.view.MenuItem;
import com.tencent.mm.R;
import com.tencent.mm.ag.f;
import com.tencent.mm.g.b.af;
import com.tencent.mm.modelsimple.aj;
import com.tencent.mm.modelstat.b;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.pointers.PBool;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMAppMgr;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.p.d;
import com.tencent.mm.ui.conversation.b.5;
import com.tencent.mm.ui.conversation.b.6;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.ba;
import com.tencent.mm.z.c;
import com.tencent.mm.z.s;

class f$1 implements d {
    final /* synthetic */ f yXq;

    f$1(f fVar) {
        this.yXq = fVar;
    }

    public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
        int i2 = 4;
        switch (menuItem.getItemId()) {
            case 4:
                if (s.eV(f.a(this.yXq))) {
                    g.pQN.h(14553, new Object[]{Integer.valueOf(1), Integer.valueOf(1), f.a(this.yXq)});
                } else {
                    g.pQN.h(14553, new Object[]{Integer.valueOf(0), Integer.valueOf(1), f.a(this.yXq)});
                }
                if (f.b(this.yXq).xye != null) {
                    x.i("MicroMsg.ConversationClickListener", "summerdel talker[%s] activity[%s] username[%s] latestInsertMsg[%s, %s, %s]", new Object[]{f.a(this.yXq), f.c(this.yXq), f.b(this.yXq).field_username, Long.valueOf(f.b(this.yXq).xye.field_msgId), f.b(this.yXq).xye.field_content, Long.valueOf(f.b(this.yXq).xye.field_createTime)});
                } else {
                    x.i("MicroMsg.ConversationClickListener", "summerdel talker[%s] activity[%s] username[%s] latestInsertMsg is null", new Object[]{f.a(this.yXq), f.c(this.yXq), f.b(this.yXq).field_username});
                }
                b.a(f.a(this.yXq), f.c(this.yXq), f.b(this.yXq), null, true, false);
                i2 = 1;
                break;
            case 5:
                x.d("MicroMsg.ConversationClickListener", "placed to the top");
                s.r(f.a(this.yXq), true);
                ar.Hg();
                af WO = c.EY().WO(f.a(this.yXq));
                if (WO != null && WO.cia()) {
                    g.pQN.h(13307, new Object[]{WO.field_username, Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1)});
                }
                h.bu(f.c(this.yXq), f.c(this.yXq).getString(R.l.eun));
                b.hPA.c(true, f.a(this.yXq), true);
                break;
            case 6:
                x.d("MicroMsg.ConversationClickListener", "unplaced to the top");
                s.s(f.a(this.yXq), true);
                ar.Hg();
                af WO2 = c.EY().WO(f.a(this.yXq));
                if (WO2 != null && WO2.cia()) {
                    g.pQN.h(13307, new Object[]{WO2.field_username, Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(1)});
                }
                h.bu(f.c(this.yXq), f.c(this.yXq).getString(R.l.euo));
                b.hPA.c(true, f.a(this.yXq), false);
                i2 = 5;
                break;
            case 7:
                x.d("MicroMsg.ConversationClickListener", "jacks mark read: %s", new Object[]{f.a(this.yXq)});
                ar.Hg();
                c.Fd().Xa(f.a(this.yXq));
                MMAppMgr.cancelNotification(f.a(this.yXq));
                aj.S(f.a(this.yXq), 1);
                b.hPA.I(f.a(this.yXq), false);
                i2 = 3;
                break;
            case 8:
                x.d("MicroMsg.ConversationClickListener", "jacks set unread: %s", new Object[]{f.a(this.yXq)});
                ar.Hg();
                c.Fd().Xb(f.a(this.yXq));
                b.hPA.I(f.a(this.yXq), true);
                i2 = 2;
                break;
            case 9:
                x.d("MicroMsg.ConversationClickListener", "jacks clear history: %s", new Object[]{f.a(this.yXq)});
                f.a(this.yXq).endsWith("@chatroom");
                String a = f.a(this.yXq);
                Context c = f.c(this.yXq);
                PBool pBool = new PBool();
                pBool.value = false;
                c.getString(R.l.dGO);
                ba.a(a, new 6(pBool, h.a(c, c.getString(R.l.dHc), true, new 5(pBool))));
                i2 = -1;
                break;
            case 10:
                x.d("MicroMsg.ConversationClickListener", "delete biz service: %s", new Object[]{f.a(this.yXq)});
                ar.Hg();
                com.tencent.mm.ui.tools.b.a(f.jS(f.a(this.yXq)), f.c(this.yXq), c.EY().WO(f.a(this.yXq)), 1);
                break;
        }
        i2 = -1;
        if (i2 > 0) {
            g.pQN.h(11090, new Object[]{Integer.valueOf(i2)});
            x.d("MicroMsg.ConversationClickListener", "jacks kv long click: %d", new Object[]{Integer.valueOf(i2)});
        }
    }
}
