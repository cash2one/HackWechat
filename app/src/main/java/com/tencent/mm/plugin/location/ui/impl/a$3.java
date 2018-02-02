package com.tencent.mm.plugin.location.ui.impl;

import com.tencent.mm.R;
import com.tencent.mm.modelgeo.Addr;
import com.tencent.mm.modelgeo.b.a;
import com.tencent.mm.plugin.location.ui.c;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

class a$3 implements a {
    final /* synthetic */ a nWf;

    a$3(a aVar) {
        this.nWf = aVar;
    }

    public final void b(Addr addr) {
        x.d("MicroMsg.BaseMapUI", "onGetAddrss  %s", new Object[]{addr.toString()});
        this.nWf.nVQ = addr;
        String str = addr.hxw;
        String OM = addr.OM();
        this.nWf.nVT.fDu = this.nWf.activity.getResources().getString(R.l.esY);
        if (addr.tag != null && addr.tag.equals(this.nWf.nVT.nQw)) {
            this.nWf.nVT.nQz = OM;
        } else if (!bh.ov(addr.hxu)) {
            this.nWf.nVU.nWh.setVisibility(0);
        }
        if (addr.tag != null && this.nWf.nVW.containsKey(addr.tag)) {
            c cVar = (c) this.nWf.nVW.get(addr.tag);
            cVar.setText(cVar.aVM() + OM);
        }
        float f = addr.hxG;
        f = addr.hxF;
    }
}
