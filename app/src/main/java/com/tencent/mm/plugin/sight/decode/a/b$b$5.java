package com.tencent.mm.plugin.sight.decode.a;

import android.view.View;
import android.view.animation.AnimationUtils;
import com.tencent.mm.plugin.sight.decode.a.b.b;

class b$b$5 implements Runnable {
    final /* synthetic */ b qub;

    b$b$5(b bVar) {
        this.qub = bVar;
    }

    public final void run() {
        if (b.q(this.qub.qtU) != null) {
            View bsS = b.q(this.qub.qtU).bsS();
            if (bsS != null) {
                if (!(b.C(this.qub.qtU) != null || b.q(this.qub.qtU).bsT() == -1 || b.k(this.qub.qtU).get() == null)) {
                    b.a(this.qub.qtU, AnimationUtils.loadAnimation(((View) b.k(this.qub.qtU).get()).getContext(), b.q(this.qub.qtU).bsT()));
                }
                if (b.C(this.qub.qtU) != null) {
                    bsS.startAnimation(b.C(this.qub.qtU));
                }
                bsS.setVisibility(0);
            }
        }
    }
}
