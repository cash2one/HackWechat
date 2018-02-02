package com.tencent.mm.ui.chatting.b;

import com.tencent.mm.g.a.cf;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.sns.b.i;
import com.tencent.mm.pluginsdk.model.f;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.au;
import com.tencent.mm.ui.chatting.a.c;
import com.tencent.mm.ui.chatting.a.d;
import com.tencent.mm.y.h;
import com.tencent.mm.z.u;
import java.net.URLEncoder;

public final class m {
    public p fhr;

    public m(p pVar) {
        this.fhr = pVar;
    }

    public final void aO(au auVar) {
        b cfVar = new cf();
        f.a(cfVar, auVar);
        cfVar.fqp.pL = this.fhr.csq();
        cfVar.fqp.fqw = 43;
        a.xef.m(cfVar);
        if (cfVar.fqq.ret == 0) {
            if (auVar.aNc()) {
                com.tencent.mm.modelstat.b.hPA.b(auVar, h.g(auVar));
            } else {
                com.tencent.mm.modelstat.b.hPA.u(auVar);
            }
            if (auVar.aNc() || auVar.ciV()) {
                String hz = u.hz(auVar.field_msgSvrId);
                u.b t = u.GK().t(hz, true);
                t.o("prePublishId", "msg_" + auVar.field_msgSvrId);
                t.o("preUsername", com.tencent.mm.ui.chatting.viewitems.b.a(auVar, this.fhr.cse(), this.fhr.csf()));
                t.o("preChatName", this.fhr.crz());
                t.o("preMsgIndex", Integer.valueOf(0));
                t.o("sendAppMsgScene", Integer.valueOf(1));
                ((i) g.h(i.class)).a("adExtStr", t, auVar);
                cfVar.fqp.fqu = hz;
            }
            com.tencent.mm.y.g.a fT = com.tencent.mm.y.g.a.fT(bh.VH(auVar.field_content));
            if (!(fT == null || fT.type != 5 || fT.url == null)) {
                long Wo = bh.Wo();
                x.d("MicroMsg.ChattingUI.FavoriteImp", "report(%s), url : %s, clickTimestamp : %d, scene : %d, actionType : %d, flag : %d", Integer.valueOf(13378), fT.url, Long.valueOf(Wo), Integer.valueOf(2), Integer.valueOf(2), Integer.valueOf(1));
                String str = "";
                try {
                    str = URLEncoder.encode(fT.url, "UTF-8");
                } catch (Throwable e) {
                    x.printErrStackTrace("MicroMsg.ChattingUI.FavoriteImp", e, "", new Object[0]);
                }
                com.tencent.mm.plugin.report.service.g.pQN.h(13378, str, Long.valueOf(Wo), Integer.valueOf(2), Integer.valueOf(2), Integer.valueOf(1));
            }
            this.fhr.csq().hideVKB();
            com.tencent.mm.ui.chatting.a.a(c.ypb, d.ypg, auVar, 0);
        }
    }
}
