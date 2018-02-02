package com.tencent.mm.plugin.h;

import com.tencent.mm.compatible.d.m;
import com.tencent.mm.compatible.util.k;
import com.tencent.mm.kernel.a.c.a;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.sight.base.b;
import com.tencent.mm.sdk.platformtools.x;

public final class f extends a {
    public final void execute(g gVar) {
        int yp = m.yp();
        if ((yp & WXMediaMessage.DESCRIPTION_LENGTH_LIMIT) != 0) {
            x.i("MicroMsg.SightInitTask", "load wechatsight_v7a, core number[%d]", new Object[]{Integer.valueOf(yp >> 12)});
            k.b("wechatsight_v7a", getClass().getClassLoader());
            if ((yp >> 12) >= 4) {
                b.qsU = 3;
                b.qsW = 3;
                b.qsX = 544000;
                return;
            }
            b.qsU = 1;
            b.qsW = 1;
            b.qsX = 640000;
            return;
        }
        x.i("MicroMsg.SightInitTask", "load wechatsight");
        k.b("wechatsight", getClass().getClassLoader());
        b.qsU = 1;
        b.qsW = 1;
        b.qsX = 640000;
    }

    public final String name() {
        return "boot-sight-init";
    }
}
