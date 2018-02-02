package com.tencent.mm.plugin.appbrand.game.c;

import com.tencent.mm.sdk.platformtools.ak.a;

class c$1 implements a {
    final /* synthetic */ c iYz;

    c$1(c cVar) {
        this.iYz = cVar;
    }

    public final boolean uF() {
        g aej = i.iZn.aej();
        if (aej != null) {
            c cVar = this.iYz;
            double d = aej.iZj;
            double d2 = aej.iZk;
            cVar.azu.setLength(0);
            cVar.azu.append("MinFPS[").append(Math.round(d2)).append("] RT-FPS[").append(Math.round(d)).append("]");
            cVar.setText(cVar.azu);
        }
        return true;
    }
}
