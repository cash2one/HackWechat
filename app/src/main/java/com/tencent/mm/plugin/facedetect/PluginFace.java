package com.tencent.mm.plugin.facedetect;

import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.plugin.facedetect.a.a;
import com.tencent.mm.sdk.platformtools.x;

public class PluginFace extends f implements a {
    public String name() {
        return "plugin-facedetect";
    }

    public void execute(g gVar) {
        x.i("MicroMsg.PluginFace", "hy: starting execute.");
        if (gVar.DS()) {
            com.tencent.mm.vending.g.g.czW().c(new b()).a(new 1(this));
        }
    }
}
