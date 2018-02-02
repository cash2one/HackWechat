package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.graphics.BitmapFactory;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.d.a;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

class t$1 implements a {
    final /* synthetic */ t rkG;

    t$1(t tVar) {
        this.rkG = tVar;
    }

    public final void bxc() {
        this.rkG.startLoading();
    }

    public final void bxd() {
        this.rkG.lAk.setVisibility(8);
    }

    public final void KY(String str) {
        try {
            this.rkG.H(BitmapFactory.decodeFile(str));
        } catch (Throwable e) {
            x.e("MicroMsg.Sns.AdLandingPagePanoramaImageComponent", "%s" + bh.i(e));
        }
    }
}
