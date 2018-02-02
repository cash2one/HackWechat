package com.tencent.mm.plugin.fav.b.a;

import com.tencent.mm.plugin.fav.b.a.b.d;
import com.tencent.mm.sdk.e.j.a;
import com.tencent.mm.sdk.e.l;
import com.tencent.mm.sdk.platformtools.x;

class b$1 implements a {
    final /* synthetic */ b mop;

    b$1(b bVar) {
        this.mop = bVar;
    }

    public final void a(String str, l lVar) {
        if (lVar != null) {
            int i = lVar.iYZ;
            if (lVar.obj != null) {
                long longValue = ((Long) lVar.obj).longValue();
                if (longValue >= 0) {
                    x.i("MicroMsg.FTS.FTS5SearchFavoriteLogic", "EventData: %s", new Object[]{lVar});
                    switch (i) {
                        case 2:
                        case 3:
                            this.mop.gJk.a(65576, new d(this.mop, longValue, (byte) 0));
                            return;
                        case 5:
                            this.mop.gJk.a(65576, new b$b(this.mop, longValue));
                            return;
                        default:
                            return;
                    }
                }
            }
        }
    }
}
