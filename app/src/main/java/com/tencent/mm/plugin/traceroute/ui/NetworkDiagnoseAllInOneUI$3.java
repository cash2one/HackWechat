package com.tencent.mm.plugin.traceroute.ui;

import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.ak.a;
import com.tencent.mm.sdk.platformtools.x;

class NetworkDiagnoseAllInOneUI$3 implements a {
    final /* synthetic */ NetworkDiagnoseAllInOneUI sfv;

    NetworkDiagnoseAllInOneUI$3(NetworkDiagnoseAllInOneUI networkDiagnoseAllInOneUI) {
        this.sfv = networkDiagnoseAllInOneUI;
    }

    public final boolean uF() {
        NetworkDiagnoseAllInOneUI.a(this.sfv, NetworkDiagnoseAllInOneUI.k(this.sfv) + 1);
        x.v("MicroMsg.NetworkDiagnoseAllInOneUI", "timer fired, percent:%d", Integer.valueOf(NetworkDiagnoseAllInOneUI.k(this.sfv)));
        if (NetworkDiagnoseAllInOneUI.k(this.sfv) > 99) {
            return false;
        }
        if (NetworkDiagnoseAllInOneUI.a(this.sfv) == 1) {
            NetworkDiagnoseAllInOneUI.l(this.sfv).setText(this.sfv.getString(R.l.dYE, new Object[]{Integer.valueOf(NetworkDiagnoseAllInOneUI.k(this.sfv))}));
        }
        return true;
    }
}
