package com.tencent.mm.plugin.fts.b;

import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fts.b.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.h;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.e.m.b;
import com.tencent.mm.storage.x;

class a$1 implements b {
    final /* synthetic */ a mMS;

    a$1(a aVar) {
        this.mMS = aVar;
    }

    public final void a(int i, m mVar, Object obj) {
        String str = (String) obj;
        if (a.Bk(str)) {
            x WJ = ((h) g.h(h.class)).EY().WJ(str);
            if (WJ == null || (a.C(WJ) && !WJ.cia())) {
                switch (i) {
                    case 2:
                    case 5:
                        if (!a.b(this.mMS).containsKey(str)) {
                            a.e(this.mMS).a(65556, new a.h(this.mMS, str));
                            return;
                        }
                        return;
                    case 3:
                        if (!a.c(this.mMS).contains(str) && !a.b(this.mMS).containsKey(str)) {
                            a.e(this.mMS).a(65556, new i(this.mMS, str));
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
            com.tencent.mm.sdk.platformtools.x.i("MicroMsg.FTS.FTS5SearchContactLogic", "onContactChangedListener hit cache and filter contact %s", new Object[]{str});
            return;
        }
        com.tencent.mm.sdk.platformtools.x.i("MicroMsg.FTS.FTS5SearchContactLogic", "onConversationChangeListener filterByUsername %s", new Object[]{str});
    }
}
