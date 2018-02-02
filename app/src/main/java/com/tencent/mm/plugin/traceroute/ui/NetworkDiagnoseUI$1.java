package com.tencent.mm.plugin.traceroute.ui;

import com.tencent.mm.sdk.platformtools.ak.a;

class NetworkDiagnoseUI$1 implements a {
    final /* synthetic */ NetworkDiagnoseUI sfP;

    NetworkDiagnoseUI$1(NetworkDiagnoseUI networkDiagnoseUI) {
        this.sfP = networkDiagnoseUI;
    }

    public final boolean uF() {
        NetworkDiagnoseUI.a(this.sfP, NetworkDiagnoseUI.a(this.sfP) + 1);
        NetworkDiagnoseUI.b(this.sfP, NetworkDiagnoseUI.b(this.sfP));
        if (NetworkDiagnoseUI.b(this.sfP) < 100) {
            NetworkDiagnoseUI.c(this.sfP).setProgress(NetworkDiagnoseUI.b(this.sfP));
            return true;
        }
        NetworkDiagnoseUI.c(this.sfP).setProgress(100);
        return false;
    }
}
