package com.tencent.mm.plugin.nearlife.ui;

import com.tencent.mm.modelgeo.Addr;
import com.tencent.mm.modelgeo.b.a;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

class NearLifeCreatePoiUI$5 implements a {
    final /* synthetic */ NearLifeCreatePoiUI oRe;

    NearLifeCreatePoiUI$5(NearLifeCreatePoiUI nearLifeCreatePoiUI) {
        this.oRe = nearLifeCreatePoiUI;
    }

    public final void b(Addr addr) {
        CharSequence charSequence = bh.ou(addr.hxw) + bh.ou(addr.hxy);
        CharSequence charSequence2 = bh.ou(addr.hxz) + bh.ou(addr.hxA);
        x.d("MicroMsg.NearLifeCreatePoiUI", "get address:" + charSequence);
        if (bh.ov(NearLifeCreatePoiUI.e(this.oRe).getText().toString())) {
            NearLifeCreatePoiUI.e(this.oRe).setText(charSequence);
        }
        if (bh.ov(NearLifeCreatePoiUI.f(this.oRe).getText().toString()) && !bh.ov(charSequence2)) {
            NearLifeCreatePoiUI.f(this.oRe).setText(charSequence2);
        }
        NearLifeCreatePoiUI.a(this.oRe, addr);
    }
}
