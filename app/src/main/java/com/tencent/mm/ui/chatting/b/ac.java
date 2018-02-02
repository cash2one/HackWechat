package com.tencent.mm.ui.chatting.b;

import com.tencent.mm.g.a.rn;
import com.tencent.mm.g.a.ro;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.as;
import com.tencent.mm.storage.au;
import com.tencent.mm.ui.chatting.ChattingTranslateView.a;
import com.tencent.mm.z.ar;
import java.util.HashMap;

public final class ac {
    public p fhr;
    as yCw = new as(5, "msg-translate-update-worker");
    public HashMap<Long, a> yCx = new HashMap();
    public c yCy = new 3(this);

    public ac(p pVar) {
        this.fhr = pVar;
    }

    public final void a(long j, a aVar) {
        this.yCx.put(Long.valueOf(j), aVar);
    }

    public final a aU(au auVar) {
        a aVar = (a) this.yCx.get(Long.valueOf(auVar.field_msgId));
        if (aVar != null) {
            return aVar;
        }
        if (!auVar.cjr()) {
            b roVar = new ro();
            roVar.fJs.id = auVar.field_msgId;
            com.tencent.mm.sdk.b.a.xef.m(roVar);
            if (!roVar.fJt.fJu) {
                return a.yvB;
            }
            aVar = a.yvC;
            a(auVar.field_msgId, aVar);
            return aVar;
        } else if (auVar.cjw()) {
            return a.yvD;
        } else {
            return a.yvB;
        }
    }

    public final void aV(au auVar) {
        if (auVar.cjr()) {
            if (auVar.cjw()) {
                if (auVar.cjr()) {
                    auVar.fb(auVar.gjE & -17);
                }
                a(auVar.field_msgId, a.yvB);
                com.tencent.mm.modelstat.b.hPA.a(auVar, false);
            } else {
                auVar.cjx();
                a(auVar.field_msgId, a.yvD);
                com.tencent.mm.modelstat.b.hPA.a(auVar, true);
            }
            ar.Hg();
            com.tencent.mm.z.c.Fa().a(auVar.field_msgId, auVar);
        } else if (aU(auVar) != a.yvC) {
            b rnVar = new rn();
            rnVar.fJp.fJr = false;
            rnVar.fJp.id = auVar.field_msgId;
            rnVar.fJp.fJq = auVar.field_content;
            if (!this.fhr.csd() || auVar.field_isSend == 1) {
                rnVar.fJp.type = 0;
            } else {
                rnVar.fJp.type = 1;
            }
            rnVar.fJp.bhd = this.fhr.csi().field_username;
            com.tencent.mm.sdk.b.a.xef.m(rnVar);
            a(auVar.field_msgId, a.yvC);
        } else {
            return;
        }
        this.fhr.cpl();
    }
}
