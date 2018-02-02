package com.tencent.mm.plugin.sns.ui;

import com.tencent.mm.plugin.sns.ui.SnsAdNativeLandingTestUI.a;
import com.tencent.mm.sdk.platformtools.af;

class SnsAdNativeLandingTestUI$a$1 implements SnsAdNativeLandingTestUI$a$a {
    final /* synthetic */ af kCy;
    final /* synthetic */ SnsAdNativeLandingTestUI$a$a ryN;
    final /* synthetic */ a ryO;

    SnsAdNativeLandingTestUI$a$1(a aVar, af afVar, SnsAdNativeLandingTestUI$a$a snsAdNativeLandingTestUI$a$a) {
        this.ryO = aVar;
        this.kCy = afVar;
        this.ryN = snsAdNativeLandingTestUI$a$a;
    }

    public final void cf(final String str, final int i) {
        this.kCy.post(new Runnable(this) {
            final /* synthetic */ SnsAdNativeLandingTestUI$a$1 ryP;

            public final void run() {
                this.ryP.ryN.cf(str, i);
            }
        });
    }

    public final void KZ(String str) {
        this.kCy.post(new 2(this, str));
    }

    public final void La(final String str) {
        this.kCy.post(new Runnable(this) {
            final /* synthetic */ SnsAdNativeLandingTestUI$a$1 ryP;

            public final void run() {
                this.ryP.ryN.La(str);
            }
        });
    }
}
