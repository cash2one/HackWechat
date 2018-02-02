package com.tencent.mm.plugin.sns.ui;

import android.widget.ImageView;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.sns.ui.b.b;
import com.tencent.mm.sdk.platformtools.x;

class SnsAdNativeLandingPagesUI$3 implements b {
    final /* synthetic */ SnsAdNativeLandingPagesUI ryv;

    SnsAdNativeLandingPagesUI$3(SnsAdNativeLandingPagesUI snsAdNativeLandingPagesUI) {
        this.ryv = snsAdNativeLandingPagesUI;
    }

    public final void onAnimationStart() {
        x.i("MicroMsg.SnsAdNativeLandingPagesUI", "enter anim start, isFirstAnimStart %s", new Object[]{Boolean.valueOf(SnsAdNativeLandingPagesUI.E(this.ryv))});
        if (SnsAdNativeLandingPagesUI.E(this.ryv)) {
            SnsAdNativeLandingPagesUI.F(this.ryv);
            long currentTimeMillis = System.currentTimeMillis() - SnsAdNativeLandingPagesUI.G(this.ryv);
            g.pQN.h(14830, new Object[]{Long.valueOf(SnsAdNativeLandingPagesUI.G(this.ryv)), Long.valueOf(currentTimeMillis)});
            x.i("MicroMsg.SnsAdNativeLandingPagesUI", "launch time %d", new Object[]{Long.valueOf(currentTimeMillis)});
        }
    }

    public final void onAnimationEnd() {
        int i = 0;
        x.i("MicroMsg.SnsAdNativeLandingPagesUI", "enter anim end");
        if (SnsAdNativeLandingPagesUI.H(this.ryv)) {
            SnsAdNativeLandingPagesUI.I(this.ryv);
            SnsAdNativeLandingPagesUI.l(this.ryv);
        }
        SnsAdNativeLandingPagesUI.J(this.ryv).setVisibility(0);
        if (SnsAdNativeLandingPagesUI.K(this.ryv)) {
            SnsAdNativeLandingPagesUI.B(this.ryv).setVisibility(0);
        }
        ImageView L = SnsAdNativeLandingPagesUI.L(this.ryv);
        if (!SnsAdNativeLandingPagesUI.z(this.ryv)) {
            i = 4;
        }
        L.setVisibility(i);
        this.ryv.setRequestedOrientation(1);
        SnsAdNativeLandingPagesUI.bAs();
        SnsAdNativeLandingPagesUI.M(this.ryv);
    }
}
