package com.tencent.mm.plugin.fts.b;

import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fts.b.a.d;
import com.tencent.mm.plugin.fts.b.a.e;
import com.tencent.mm.plugin.messenger.foundation.a.h;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.e.m.b;
import com.tencent.mm.storage.x;

class a$2 implements b {
    final /* synthetic */ a mMS;

    a$2(a aVar) {
        this.mMS = aVar;
    }

    public final void a(int i, m mVar, Object obj) {
        String str = (String) obj;
        if (a.Bk(str)) {
            x WJ = ((h) g.h(h.class)).EY().WJ(str);
            if (WJ == null || a.C(WJ)) {
                switch (i) {
                    case 2:
                        a.e(this.mMS).a(65556, new e(this.mMS, str));
                        return;
                    case 3:
                    case 4:
                        if (!a.b(this.mMS).containsKey(str)) {
                            a.e(this.mMS).a(65556, new a.h(this.mMS, str));
                            return;
                        }
                        return;
                    case 5:
                        a.e(this.mMS).a(65556, new d(this.mMS, str));
                        return;
                    default:
                        return;
                }
            }
            com.tencent.mm.sdk.platformtools.x.i("MicroMsg.FTS.FTS5SearchContactLogic", "onContactChangedListener hit cache and filter contact %s", new Object[]{str});
            return;
        }
        com.tencent.mm.sdk.platformtools.x.i("MicroMsg.FTS.FTS5SearchContactLogic", "onContactChangedListener filterByUsername %s", new Object[]{str});
    }
}
