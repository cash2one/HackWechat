package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.graphics.BitmapFactory;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.d.a;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

class v$1 implements a {
    final /* synthetic */ v rkL;

    v$1(v vVar) {
        this.rkL = vVar;
    }

    public final void bxc() {
        this.rkL.startLoading();
    }

    public final void bxd() {
        this.rkL.lAk.setVisibility(8);
    }

    public final void KY(String str) {
        try {
            this.rkL.I(BitmapFactory.decodeFile(str));
        } catch (Throwable e) {
            x.e("AdLandingPagePureImageComponet", "%s" + bh.i(e));
        }
    }
}
