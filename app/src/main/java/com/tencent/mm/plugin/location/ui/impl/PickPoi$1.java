package com.tencent.mm.plugin.location.ui.impl;

import com.tencent.mm.modelgeo.Addr;
import com.tencent.mm.modelgeo.b.a;
import com.tencent.mm.sdk.platformtools.x;

class PickPoi$1 implements a {
    final /* synthetic */ PickPoi nXq;

    PickPoi$1(PickPoi pickPoi) {
        this.nXq = pickPoi;
    }

    public final void b(Addr addr) {
        x.d("MicroMsg.PickPoi", "onGetAddrss  %s", new Object[]{addr.toString()});
        if (PickPoi.a(this.nXq) == null) {
            x.i("MicroMsg.PickPoi", "error, empty poi!");
            return;
        }
        f a = PickPoi.a(this.nXq);
        a.nXI = addr;
        a.nXy = addr.hxu;
        a.bhC = (double) addr.hxF;
        a.bhD = (double) addr.hxG;
        a.nXC = addr.hxv;
        a.nXD = addr.hxw;
        a.nXF = addr.hxA;
        a.nXH = addr.hxC;
        a.hKZ = addr.hxE;
        x.d("poidata", "roughAddr %s", new Object[]{addr.toString()});
        if (PickPoi.b(this.nXq) != null) {
            PickPoi.b(this.nXq).notifyDataSetChanged();
        }
    }
}
