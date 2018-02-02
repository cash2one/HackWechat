package com.tencent.mm.ui.chatting;

import android.content.Context;
import com.tencent.mm.R;
import com.tencent.mm.g.a.mt;
import com.tencent.mm.g.b.cf;
import com.tencent.mm.modelstat.b;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.r;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.ba;
import com.tencent.mm.z.c;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public final class h {

    private static class a implements com.tencent.mm.sdk.platformtools.as.a {
        private r yrA;
        private ac yrB;
        private Set<Long> yrz;

        public a(Set<Long> set, r rVar, ac acVar) {
            this.yrz = set;
            this.yrA = rVar;
            this.yrB = acVar;
        }

        public final boolean JB() {
            Set<Long> set = this.yrz;
            List linkedList = new LinkedList();
            for (Long l : set) {
                ar.Hg();
                cf dH = c.Fa().dH(l.longValue());
                if (dH.field_msgId == l.longValue()) {
                    if (dH.aNc()) {
                        b.hPA.c(dH, com.tencent.mm.y.h.g(dH));
                    } else {
                        b.hPA.v(dH);
                    }
                }
                linkedList.add(l);
                com.tencent.mm.sdk.b.b mtVar = new mt();
                mtVar.fEE.type = 3;
                mtVar.fEE.fqm = l.longValue();
                com.tencent.mm.sdk.b.a.xef.m(mtVar);
            }
            ba.E(linkedList);
            if (this.yrB != null) {
                this.yrB.a(com.tencent.mm.ui.chatting.ac.a.yxi);
            }
            return true;
        }

        public final boolean JC() {
            if (this.yrA != null) {
                this.yrA.dismiss();
                if (this.yrB != null) {
                    this.yrB.b(com.tencent.mm.ui.chatting.ac.a.yxi);
                }
            }
            return true;
        }
    }

    public static void a(Context context, Set<Long> set, ac acVar) {
        if (context == null) {
            x.w("MicroMsg.ChattingEditModeDelMsg", "do delete msg fail, context is null");
        } else if (set == null || set.isEmpty()) {
            x.w("MicroMsg.ChattingEditModeDelMsg", "do delete msg fail, select ids is empty");
        } else {
            context.getString(R.l.dGO);
            s.ytO.c(new a(set, com.tencent.mm.ui.base.h.a(context, context.getString(R.l.dYv), false, null), acVar));
            g.pQN.h(10811, new Object[]{Integer.valueOf(4), Integer.valueOf(set.size())});
        }
    }
}
