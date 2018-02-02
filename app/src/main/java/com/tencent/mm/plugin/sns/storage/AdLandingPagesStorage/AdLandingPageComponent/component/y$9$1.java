package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.y.9;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.d.b;
import com.tencent.mm.sdk.platformtools.x;

class y$9$1 implements b {
    final /* synthetic */ 9 rlx;

    y$9$1(9 9) {
        this.rlx = 9;
    }

    public final void KZ(String str) {
        x.e("MicroMsg.Sns.AdLandingPageStreamVideoComponentOnlinePlayer", "video download fail %s", new Object[]{str});
        this.rlx.rlv.rlp = true;
    }

    public final void La(String str) {
        x.v("MicroMsg.Sns.AdLandingPageStreamVideoComponentOnlinePlayer", "video view height " + this.rlx.rlv.contentView.getHeight() + ", player height " + this.rlx.rlv.rkN.getHeight());
        this.rlx.rlv.rlp = false;
        this.rlx.rlv.jio = str;
        if (this.rlx.rlv.rkO.fvG) {
            this.rlx.rlv.rkN.Au(str);
            this.rlx.rlv.rlo = true;
        }
    }
}
