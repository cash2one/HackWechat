package com.tencent.mm.plugin.radar.b;

import com.tencent.mm.modelgeo.a.a;
import com.tencent.mm.modelstat.o;
import com.tencent.mm.plugin.radar.b.e.b;
import com.tencent.mm.pluginsdk.model.lbs.Location;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.rtmp.TXLiveConstants;

final class e$i implements a {
    final /* synthetic */ e pxL;

    e$i(e eVar) {
        this.pxL = eVar;
    }

    public final boolean a(boolean z, float f, float f2, int i, double d, double d2, double d3) {
        b bVar;
        if (e.a(this.pxL)) {
            bVar = e.pxt;
            x.d(e.access$getTAG$cp(), "cancel location");
            return false;
        } else if (e.c(this.pxL) != null) {
            return false;
        } else {
            if (z) {
                o.a(TXLiveConstants.PLAY_EVT_PLAY_END, f, f2, (int) d2);
                bVar = e.pxt;
                x.d(e.access$getTAG$cp(), "lat:%f lng:%f accuracy:%f", new Object[]{Float.valueOf(f2), Float.valueOf(f), Double.valueOf(d2)});
                e.a(this.pxL, new Location(f2, f, (int) d2, i, "", ""));
                e.e(this.pxL).fH(0);
            } else {
                e.f(this.pxL);
            }
            e.b(this.pxL, e.c(this.pxL));
            return false;
        }
    }
}
