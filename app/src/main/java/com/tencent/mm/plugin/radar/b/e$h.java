package com.tencent.mm.plugin.radar.b;

import b.c.b.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.radar.b.e.b;
import com.tencent.mm.pluginsdk.model.lbs.Location;
import com.tencent.mm.sdk.platformtools.ak.a;
import com.tencent.mm.sdk.platformtools.x;

final class e$h implements a {
    final /* synthetic */ e pxL;

    e$h(e eVar) {
        this.pxL = eVar;
    }

    public final boolean uF() {
        b bVar;
        if (e.a(this.pxL)) {
            bVar = e.pxt;
            x.d(e.access$getTAG$cp(), "cancel radar searching");
        } else {
            e.a(this.pxL, e$f.pxH);
            bVar = e.pxt;
            x.d(e.access$getTAG$cp(), "status: %s", new Object[]{e.b(this.pxL)});
            Location c = e.c(this.pxL);
            if (c == null) {
                bVar = e.pxt;
                x.e(e.access$getTAG$cp(), "error! location is null!");
            } else if (c.bYW()) {
                bVar = e.pxt;
                x.e(e.access$getTAG$cp(), "error! location is null!");
            } else {
                bVar = e.pxt;
                x.d(e.access$getTAG$cp(), "do once search");
                e eVar = this.pxL;
                float f = c.hxF;
                float f2 = c.hxG;
                int i = c.accuracy;
                int i2 = c.fBe;
                String str = c.mac;
                e.h(str, "it.mac");
                String str2 = c.fBg;
                e.h(str2, "it.cellId");
                e.a(eVar, new b(1, f, f2, i, i2, str, str2));
                g.CG().d(e.d(this.pxL));
            }
        }
        return false;
    }
}
