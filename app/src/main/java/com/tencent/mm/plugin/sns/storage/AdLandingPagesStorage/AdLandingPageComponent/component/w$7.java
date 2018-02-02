package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.sdk.platformtools.x;

class w$7 implements OnClickListener {
    final /* synthetic */ w rls;

    w$7(w wVar) {
        this.rls = wVar;
    }

    public final void onClick(View view) {
        x.d("MicroMsg.Sns.AdLandingPageSightVideoComponent", "btn onclick view [%b] bar[%b]", new Object[]{Boolean.valueOf(w.a(this.rls).isPlaying()), Boolean.valueOf(this.rls.rkO.fvG)});
        w.b(this.rls);
        if (this.rls.rkO.fvG) {
            w.c(this.rls);
            w.a(this.rls, 4);
        } else {
            if (this.rls.rle) {
                this.rls.bwF();
            } else {
                this.rls.bwJ();
                w.d(this.rls);
            }
            w.e(this.rls);
            w.a(this.rls, 3);
            if (this.rls.rfC) {
                this.rls.bwK();
            }
        }
        w.f(this.rls);
    }
}
