package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.sdk.platformtools.ag;

class w$9 implements OnClickListener {
    final /* synthetic */ w rls;

    w$9(w wVar) {
        this.rls = wVar;
    }

    public final void onClick(View view) {
        w.b(this.rls);
        w.e(this.rls);
        w.h(this.rls);
        if (!w.i(this.rls)) {
            this.rls.bwJ();
            w.d(this.rls);
            w.g(this.rls);
        } else if (this.rls.rle) {
            this.rls.bwF();
        } else {
            this.rls.bwJ();
            w.d(this.rls);
        }
        w.a(this.rls, 3);
        this.rls.rkO.setVisibility(4);
        this.rls.rlb.setVisibility(0);
        w.j(this.rls).setVisibility(0);
        if (this.rls.rkM != null) {
            this.rls.rkM.iD(true);
        }
        ag.h(new 1(this), 10000);
    }
}
