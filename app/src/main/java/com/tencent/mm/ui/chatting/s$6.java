package com.tencent.mm.ui.chatting;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.R;
import com.tencent.mm.g.a.cf;
import com.tencent.mm.plugin.sns.b.i;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.au;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.chatting.a.c;
import com.tencent.mm.y.g;
import com.tencent.mm.z.u;
import com.tencent.mm.z.u.b;
import java.net.URLEncoder;
import java.util.List;

class s$6 implements OnClickListener {
    final /* synthetic */ s ytT;

    s$6(s sVar) {
        this.ytT = sVar;
    }

    private void b(cf cfVar) {
        int i;
        cfVar.fqp.pL = s.b(this.ytT);
        cfVar.fqp.fqw = 41;
        cfVar.fqp.fqy = new 1(this);
        a.xef.m(cfVar);
        if (cfVar.fqq.ret == 0) {
            i = 1;
        } else {
            i = 2;
        }
        List<au> e = s.e(this.ytT);
        long Wo = bh.Wo();
        for (au auVar : e) {
            if (auVar.aNc()) {
                g.a fT = g.a.fT(bh.VH(auVar.field_content));
                if (!(fT == null || fT.type != 5 || bh.ov(fT.url))) {
                    int i2;
                    if (auVar.ciV()) {
                        i2 = 1;
                    } else {
                        i2 = 2;
                    }
                    x.d("MicroMsg.ChattingMoreBtnBarHelper", "report(%s), url : %s, clickTimestamp : %d, scene : %d, actionType : %d, flag : %d", new Object[]{Integer.valueOf(13378), fT.url, Long.valueOf(Wo), Integer.valueOf(i2), Integer.valueOf(2), Integer.valueOf(1)});
                    String str = "";
                    try {
                        str = URLEncoder.encode(fT.url, "UTF-8");
                    } catch (Throwable e2) {
                        x.printErrStackTrace("MicroMsg.ChattingMoreBtnBarHelper", e2, "", new Object[0]);
                    }
                    com.tencent.mm.plugin.report.service.g.pQN.h(13378, new Object[]{str, Long.valueOf(Wo), Integer.valueOf(i2), Integer.valueOf(2), Integer.valueOf(i)});
                }
            }
        }
        if (cfVar.fqq.ret != 0) {
            return;
        }
        if (14 != cfVar.fqp.type) {
            x.d("MicroMsg.ChattingMoreBtnBarHelper", "not record type, do not report");
        } else if (cfVar.fqp.fqs == null) {
            x.e("MicroMsg.ChattingMoreBtnBarHelper", "want to report record fav, but type count is null");
        } else {
            com.tencent.mm.plugin.report.service.g.pQN.h(11142, new Object[]{Integer.valueOf(cfVar.fqp.fqs.wfk), Integer.valueOf(cfVar.fqp.fqs.wfl), Integer.valueOf(cfVar.fqp.fqs.wfm), Integer.valueOf(cfVar.fqp.fqs.wfn), Integer.valueOf(cfVar.fqp.fqs.wfo), Integer.valueOf(cfVar.fqp.fqs.wfp), Integer.valueOf(cfVar.fqp.fqs.wfq), Integer.valueOf(cfVar.fqp.fqs.wfr), Integer.valueOf(cfVar.fqp.fqs.wfs), Integer.valueOf(cfVar.fqp.fqs.wft), Integer.valueOf(cfVar.fqp.fqs.wfu), Integer.valueOf(cfVar.fqp.fqs.wfv), Integer.valueOf(cfVar.fqp.fqs.wfw), Integer.valueOf(cfVar.fqp.fqs.wfx), Integer.valueOf(cfVar.fqp.fqs.wfy)});
        }
    }

    public final void onClick(View view) {
        List<au> e = s.e(this.ytT);
        if (i.de(e)) {
            h.a(s.b(this.ytT).getContext(), s.b(this.ytT).getContext().getString(R.l.efv), "", s.b(this.ytT).getContext().getString(R.l.dBP), new 2(this));
            return;
        }
        au auVar;
        cf cfVar = new cf();
        x.d("MicroMsg.ChattingMoreBtnBarHelper", "want fav msgs from %s", new Object[]{s.g(this.ytT).field_username});
        if (e != null && e.size() == 1) {
            auVar = (au) e.get(0);
            if (auVar != null && (auVar.aNc() || auVar.ciV())) {
                String hz = u.hz(auVar.field_msgSvrId);
                b t = u.GK().t(hz, true);
                t.o("prePublishId", "msg_" + auVar.field_msgSvrId);
                t.o("preUsername", com.tencent.mm.ui.chatting.viewitems.b.a(auVar, s.f(this.ytT), s.b(this.ytT).ywd.vnK));
                t.o("preChatName", s.g(this.ytT).field_username);
                t.o("preMsgIndex", Integer.valueOf(0));
                t.o("sendAppMsgScene", Integer.valueOf(1));
                ((i) com.tencent.mm.kernel.g.h(i.class)).a("adExtStr", t, auVar);
                cfVar.fqp.fqu = hz;
            }
        }
        if (com.tencent.mm.pluginsdk.model.h.a(s.b(this.ytT).getContext(), cfVar, s.g(this.ytT).field_username, e, false, true)) {
            for (au auVar2 : e) {
                if (auVar2.aNc()) {
                    com.tencent.mm.modelstat.b.hPA.b(auVar2, com.tencent.mm.y.h.g(auVar2));
                } else {
                    com.tencent.mm.modelstat.b.hPA.u(auVar2);
                }
            }
            b(cfVar);
            dg(s.e(this.ytT));
        } else if (s.e(this.ytT).size() > 1) {
            String string;
            Context context = s.b(this.ytT).getContext();
            String string2 = cfVar.fqp.fqv >= 0 ? s.b(this.ytT).getContext().getString(R.l.efu) : s.b(this.ytT).getContext().getString(R.l.eft);
            String str = "";
            if (cfVar.fqp.fqv >= 0) {
                string = s.b(this.ytT).getContext().getString(R.l.dUc);
            } else {
                string = s.b(this.ytT).getContext().getString(R.l.eAd);
            }
            h.a(context, string2, str, string, s.b(this.ytT).getContext().getString(R.l.dUa), new 3(this, e, cfVar), null);
        } else {
            h.h(s.b(this.ytT).getContext(), cfVar.fqp.fqv, 0);
        }
    }

    private static void dg(List<au> list) {
        for (au a : list) {
            a.a(c.ypb, a$d.Samll, a, 0);
        }
    }
}
