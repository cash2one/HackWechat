package com.tencent.mm.plugin.fps_lighter.a;

import com.tencent.mm.plugin.fps_lighter.e.a.a;

class b$a {
    final /* synthetic */ b mAu;
    a mAv = com.tencent.mm.plugin.fps_lighter.e.a.pP(this.mAx);
    long mAw;
    int mAx;
    int scene;

    b$a(b bVar, int i, Long l) {
        this.mAu = bVar;
        this.scene = i;
        this.mAw = l.longValue();
        this.mAx = com.tencent.mm.plugin.fps_lighter.e.a.b(l.longValue(), bVar.mAl.mAF);
    }

    public final String toString() {
        return "scene:" + this.scene + ",durtime:" + this.mAw + ",answer:" + this.mAv.toString();
    }
}
