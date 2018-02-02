package com.tencent.mm.plugin.sns.ui;

import com.tencent.mm.plugin.sns.ui.SnsAdNativeLandingTestUI$a.a;
import com.tencent.mm.sdk.platformtools.x;

class SnsAdNativeLandingTestUI$9 implements a {
    final /* synthetic */ SnsAdNativeLandingTestUI ryI;

    SnsAdNativeLandingTestUI$9(SnsAdNativeLandingTestUI snsAdNativeLandingTestUI) {
        this.ryI = snsAdNativeLandingTestUI;
    }

    public final void cf(String str, int i) {
        if (!SnsAdNativeLandingTestUI.a(this.ryI).isPlaying()) {
            SnsAdNativeLandingTestUI.a(this.ryI).cP(false);
            if (!str.equals(SnsAdNativeLandingTestUI.a(this.ryI).quA.qtl)) {
                SnsAdNativeLandingTestUI.a(this.ryI).setVideoPath(str);
            }
            if (this.ryI.ryH.fvG) {
                SnsAdNativeLandingTestUI.a(this.ryI).q(SnsAdNativeLandingTestUI.d(this.ryI));
                SnsAdNativeLandingTestUI.a(this.ryI).start();
            }
        }
    }

    public final void KZ(String str) {
        x.e("MicroMsg.Sns.SnsAdNativieLandingTestUI", str);
    }

    public final void La(String str) {
        SnsAdNativeLandingTestUI.a(this.ryI).setVideoPath(str);
        SnsAdNativeLandingTestUI.a(this.ryI).cP(true);
        if (this.ryI.ryH.fvG) {
            SnsAdNativeLandingTestUI.a(this.ryI).q(SnsAdNativeLandingTestUI.d(this.ryI));
            SnsAdNativeLandingTestUI.a(this.ryI).start();
        }
    }
}
