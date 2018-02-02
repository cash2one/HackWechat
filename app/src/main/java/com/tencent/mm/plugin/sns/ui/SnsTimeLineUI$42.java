package com.tencent.mm.plugin.sns.ui;

import android.os.SystemClock;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.sns.model.ae;

class SnsTimeLineUI$42 implements OnClickListener {
    final /* synthetic */ SnsTimeLineUI rIN;

    SnsTimeLineUI$42(SnsTimeLineUI snsTimeLineUI) {
        this.rIN = snsTimeLineUI;
    }

    public final void onClick(View view) {
        if (SystemClock.elapsedRealtime() - SnsTimeLineUI.H(this.rIN) < 300) {
            SnsTimeLineUI.E(this.rIN);
        }
        SnsTimeLineUI.a(this.rIN, SystemClock.elapsedRealtime());
        ae.aNT().removeCallbacks(SnsTimeLineUI.I(this.rIN));
        SnsTimeLineUI.I(this.rIN).run();
    }
}
