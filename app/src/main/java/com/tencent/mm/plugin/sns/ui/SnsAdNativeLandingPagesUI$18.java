package com.tencent.mm.plugin.sns.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.ui.widget.g;

class SnsAdNativeLandingPagesUI$18 implements OnClickListener {
    final /* synthetic */ SnsAdNativeLandingPagesUI ryv;

    SnsAdNativeLandingPagesUI$18(SnsAdNativeLandingPagesUI snsAdNativeLandingPagesUI) {
        this.ryv = snsAdNativeLandingPagesUI;
    }

    public final void onClick(View view) {
        g gVar = new g(this.ryv, g.ztp, false);
        gVar.rKC = new 1(this);
        gVar.ztB = new 2(this);
        gVar.rKD = new 3(this);
        if (SnsAdNativeLandingPagesUI.z(this.ryv)) {
            gVar.tGk = true;
        }
        if (SnsAdNativeLandingPagesUI.A(this.ryv)) {
            gVar.bUk();
            return;
        }
        this.ryv.aWs();
        SnsAdNativeLandingPagesUI.B(this.ryv).postDelayed(new 4(this, gVar), 300);
    }
}
