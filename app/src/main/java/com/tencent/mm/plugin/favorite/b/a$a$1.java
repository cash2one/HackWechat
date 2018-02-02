package com.tencent.mm.plugin.favorite.b;

import com.tencent.mm.plugin.fav.a.f;
import com.tencent.mm.plugin.favorite.a.j;
import com.tencent.mm.plugin.favorite.b.a.a;
import com.tencent.mm.plugin.favorite.h;
import com.tencent.mm.sdk.platformtools.x;

class a$a$1 implements Runnable {
    final /* synthetic */ boolean mqY;
    final /* synthetic */ a mqZ;

    a$a$1(a aVar, boolean z) {
        this.mqZ = aVar;
        this.mqY = z;
    }

    public final void run() {
        if (this.mqY) {
            x.i("MicroMsg.Fav.FavAddService", "has data, check cdn now, type %d", new Object[]{Integer.valueOf(this.mqZ.mqC.field_type)});
            this.mqZ.mqC.field_itemStatus = 1;
            this.mqZ.mqC.field_xml = f.c(this.mqZ.mqC);
            if (j.x(this.mqZ.mqC)) {
                h.getFavItemInfoStorage().a(this.mqZ.mqC, new String[0]);
            } else {
                h.getFavItemInfoStorage().f(this.mqZ.mqC);
            }
            h.aIo().run();
            return;
        }
        x.i("MicroMsg.Fav.FavAddService", "no data, send item now, type %d", new Object[]{Integer.valueOf(this.mqZ.mqC.field_type)});
        this.mqZ.mqC.field_itemStatus = 9;
        this.mqZ.mqC.field_xml = f.c(this.mqZ.mqC);
        if (j.x(this.mqZ.mqC)) {
            h.getFavItemInfoStorage().a(this.mqZ.mqC, new String[0]);
        } else {
            h.getFavItemInfoStorage().f(this.mqZ.mqC);
        }
        h.aIn().run();
    }
}
