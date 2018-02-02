package com.tencent.mm.api;

import com.tencent.mm.sdk.platformtools.x;

class b$1 implements l {
    final /* synthetic */ b fdt;

    b$1(b bVar) {
        this.fdt = bVar;
    }

    public final void a(d dVar) {
        x.i("MicroMsg.DrawingView", "Default [onSelectedFeature] features:%s", new Object[]{dVar.name()});
    }

    public final void a(d dVar, int i) {
        x.i("MicroMsg.DrawingView", "Default [onSelectedDetailFeature] features:%s index:%s", new Object[]{dVar.name(), Integer.valueOf(i)});
    }

    public final void aD(boolean z) {
    }
}
