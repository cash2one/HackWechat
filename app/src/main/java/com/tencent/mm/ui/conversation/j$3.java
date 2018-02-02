package com.tencent.mm.ui.conversation;

import com.tencent.mm.g.b.aj;
import com.tencent.mm.plugin.report.service.f;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.conversation.g.d;
import com.tencent.mm.ui.f.a;
import com.tencent.mm.z.s;
import java.util.HashSet;
import java.util.Iterator;

class j$3 implements a {
    final /* synthetic */ j yZL;

    j$3(j jVar) {
        this.yZL = jVar;
    }

    public final void Xw() {
        f.vz(12);
        c b = j.b(this.yZL);
        b.yWu = -1;
        b.yWt.clear();
        if (b.yWw == null || b.yWv < 0 || !b.yWw.ckP()) {
            b.yWu = 0;
        } else if (b.yWw.yYB) {
            b.yWu = 0;
        } else if (b.yWw.yYz) {
            x.i("MicroMsg.ConvUnreadHelper", "unreadcheck preSetLauncherUIUnReadCount has contact change");
            b.yWu = 0;
            b.yWw.yYz = false;
        } else {
            HashSet hashSet = (HashSet) b.yWw.yYA.clone();
            x.i("MicroMsg.ConvUnreadHelper", "unreadcheck preSetLauncherUIUnReadCount  events size %d", Integer.valueOf(hashSet.size()));
            if (hashSet.contains("floatbottle")) {
                b.yWu = 0;
                return;
            }
            hashSet.remove("officialaccounts");
            if (hashSet.isEmpty()) {
                b.yWu = 1;
                return;
            }
            Iterator it = hashSet.iterator();
            while (it.hasNext()) {
                boolean z;
                String str = (String) it.next();
                g gVar = b.yWw;
                if (gVar.ZG(str)) {
                    z = false;
                } else {
                    d dVar = (d) gVar.yns.get(str);
                    z = dVar == null ? false : s.eV(str) ? dVar.yXj : dVar.yXg;
                }
                if (!z) {
                    aj ZF = b.ZF(str);
                    if (ZF == null) {
                        b.yWt.put(str, Integer.valueOf(0));
                        x.i("MicroMsg.ConvUnreadHelper", "unreadcheck preSetLauncherUIUnReadCount  cov == null username %s, unreadcount %d", str, Integer.valueOf(0));
                    } else {
                        b.yWt.put(str, Integer.valueOf(ZF.field_unReadCount));
                        x.i("MicroMsg.ConvUnreadHelper", "unreadcheck preSetLauncherUIUnReadCount  cov != null username %s, unreadcount %d", str, Integer.valueOf(ZF.field_unReadCount));
                    }
                }
            }
            x.i("MicroMsg.ConvUnreadHelper", "unreadcheck preSetLauncherUIUnReadCount  preUnReadCount size %d", Integer.valueOf(b.yWt.size()));
            if (b.yWt.isEmpty()) {
                b.yWu = 1;
            } else if (b.yWt.size() > 20) {
                b.yWu = 0;
            } else {
                b.yWu = 2;
            }
        }
    }

    public final void Xv() {
        j.b(this.yZL).cwp();
        if (j.a(this.yZL) != null) {
            g a = j.a(this.yZL);
            if (!(a.yns == null || a.yYA == null || a.yYA.isEmpty())) {
                if (a.yYB) {
                    a.yns.clear();
                    a.yYB = false;
                } else {
                    x.d("MicroMsg.ConversationWithCacheAdapter", "dealWithConversationEvents size %d", Integer.valueOf(a.yYA.size()));
                    Iterator it = a.yYA.iterator();
                    while (it.hasNext()) {
                        a.yns.remove(it.next());
                    }
                }
                a.yYA.clear();
            }
        }
        j.d(this.yZL).post(new 1(this));
    }
}
