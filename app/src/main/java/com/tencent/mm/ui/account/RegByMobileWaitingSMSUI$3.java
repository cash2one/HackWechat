package com.tencent.mm.ui.account;

import android.os.Build.VERSION;
import android.os.CountDownTimer;

class RegByMobileWaitingSMSUI$3 extends CountDownTimer {
    final /* synthetic */ RegByMobileWaitingSMSUI xRA;

    RegByMobileWaitingSMSUI$3(RegByMobileWaitingSMSUI regByMobileWaitingSMSUI, long j) {
        this.xRA = regByMobileWaitingSMSUI;
        super(j, 1000);
    }

    public final void onFinish() {
        RegByMobileWaitingSMSUI.b(this.xRA);
    }

    public final void onTick(long j) {
        int c = (int) (((long) RegByMobileWaitingSMSUI.c(this.xRA)) - (j / 1000));
        RegByMobileWaitingSMSUI.d(this.xRA).setProgress(c);
        if (c % 2 == 0 && RegByMobileWaitingSMSUI.e(this.xRA) != null) {
            RegByMobileWaitingSMSUI.e(this.xRA).OI(this.xRA.xRw[(c / 2) % this.xRA.xRw.length]);
            RegByMobileWaitingSMSUI.f(this.xRA).post(new Runnable(this) {
                final /* synthetic */ RegByMobileWaitingSMSUI$3 xRB;

                {
                    this.xRB = r1;
                }

                public final void run() {
                    if (VERSION.SDK_INT >= 8) {
                        RegByMobileWaitingSMSUI.f(this.xRB.xRA).smoothScrollToPosition(RegByMobileWaitingSMSUI.e(this.xRB.xRA).getCount() - 1);
                    } else {
                        RegByMobileWaitingSMSUI.f(this.xRB.xRA).setSelection(RegByMobileWaitingSMSUI.e(this.xRB.xRA).getCount() - 1);
                    }
                }
            });
        }
    }
}
