package com.tencent.mm.plugin.facedetect;

import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.vending.g.d.a;
import com.tencent.mm.vending.j.c;

class PluginFace$1 implements a<c<Integer, String>> {
    final /* synthetic */ PluginFace mco;

    PluginFace$1(PluginFace pluginFace) {
        this.mco = pluginFace;
    }

    public final /* synthetic */ void aW(Object obj) {
        c cVar = (c) obj;
        if (cVar != null) {
            int a = bh.a((Integer) cVar.get(0), -1);
            String az = bh.az((String) cVar.get(1), "unknown");
            x.e("MicroMsg.PluginFace", "hy: onInterrupt errCode: %d, errMsg: %s", new Object[]{Integer.valueOf(a), az});
            return;
        }
        x.e("MicroMsg.PluginFace", "hy: null in on interrupt");
    }
}
