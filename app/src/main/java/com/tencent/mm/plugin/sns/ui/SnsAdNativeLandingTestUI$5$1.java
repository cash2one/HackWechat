package com.tencent.mm.plugin.sns.ui;

import com.tencent.mm.plugin.sns.ui.SnsAdNativeLandingTestUI.5;
import com.tencent.mm.sdk.platformtools.x;

class SnsAdNativeLandingTestUI$5$1 implements Runnable {
    final /* synthetic */ int jup;
    final /* synthetic */ int qvu;
    final /* synthetic */ 5 ryL;

    SnsAdNativeLandingTestUI$5$1(5 5, int i, int i2) {
        this.ryL = 5;
        this.jup = i;
        this.qvu = i2;
    }

    public final void run() {
        x.i("MicroMsg.Sns.SnsAdNativieLandingTestUI", "play time " + this.jup + " video time " + this.qvu);
        if (this.qvu > 0) {
            SnsAdNativeLandingTestUI.a(this.ryL.ryI, this.qvu);
            SnsAdNativeLandingTestUI.b(this.ryL.ryI, this.qvu);
        }
        if (this.ryL.ryI.ryH.qur != this.qvu) {
            this.ryL.ryI.ryH.wl(this.qvu);
        }
        this.ryL.ryI.ryH.seek(this.jup);
    }
}
