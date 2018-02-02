package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.d.a;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

class aa$3 implements a {
    final /* synthetic */ aa rlI;

    aa$3(aa aaVar) {
        this.rlI = aaVar;
    }

    public final void bxc() {
    }

    public final void bxd() {
        aa.b(this.rlI, null);
        aa.a(this.rlI).countDown();
    }

    public final void KY(String str) {
        try {
            aa.b(this.rlI, MMBitmapFactory.decodeFile(str));
            aa.a(this.rlI).countDown();
        } catch (Throwable e) {
            x.e("AdlandingRadarChartComp", "%s" + bh.i(e));
        }
    }
}
