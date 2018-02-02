package com.tencent.mm.plugin.traceroute.ui;

import android.os.Message;
import com.tencent.mm.sdk.platformtools.af;

class NetworkDiagnoseUI$2 extends af {
    final /* synthetic */ NetworkDiagnoseUI sfP;

    NetworkDiagnoseUI$2(NetworkDiagnoseUI networkDiagnoseUI) {
        this.sfP = networkDiagnoseUI;
    }

    public final void handleMessage(Message message) {
        switch (message.what) {
            case 1:
                NetworkDiagnoseUI.e(this.sfP);
                if (NetworkDiagnoseUI.b(this.sfP) < 95) {
                    NetworkDiagnoseUI.c(this.sfP).setProgress(95);
                }
                NetworkDiagnoseUI.d(this.sfP).bFu();
                return;
            case 2:
                if (NetworkDiagnoseUI.b(this.sfP) < 95) {
                    NetworkDiagnoseUI.c(this.sfP).setProgress(95);
                }
                NetworkDiagnoseUI.d(this.sfP).bFu();
                return;
            case 3:
                NetworkDiagnoseUI.c(this.sfP).setProgress(100);
                NetworkDiagnoseUI.a(this.sfP, false);
                return;
            case 4:
                NetworkDiagnoseUI.c(this.sfP).setProgress(100);
                NetworkDiagnoseUI.a(this.sfP, true);
                return;
            default:
                return;
        }
    }
}
