package com.tencent.mm.plugin.traceroute.ui;

import com.tencent.mm.g.a.kc;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.x;

class NetworkDiagnoseAllInOneUI$1 extends c<kc> {
    final /* synthetic */ NetworkDiagnoseAllInOneUI sfv;

    NetworkDiagnoseAllInOneUI$1(NetworkDiagnoseAllInOneUI networkDiagnoseAllInOneUI) {
        this.sfv = networkDiagnoseAllInOneUI;
        this.xen = kc.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        int i;
        boolean z = true;
        kc kcVar = (kc) bVar;
        x.v("MicroMsg.NetworkDiagnoseAllInOneUI", "diagnose callback, stage:%d, status:%d", Integer.valueOf(kcVar.fBr.fBs), Integer.valueOf(kcVar.fBr.status));
        NetworkDiagnoseAllInOneUI networkDiagnoseAllInOneUI;
        if (kcVar.fBr.fBs == 0) {
            NetworkDiagnoseAllInOneUI.a(this.sfv, 33);
            networkDiagnoseAllInOneUI = this.sfv;
            if (kcVar.fBr.status != 0) {
                z = false;
            }
            NetworkDiagnoseAllInOneUI.a(networkDiagnoseAllInOneUI, z);
        } else if (kcVar.fBr.fBs == 1) {
            NetworkDiagnoseAllInOneUI.a(this.sfv, 66);
            networkDiagnoseAllInOneUI = this.sfv;
            if (kcVar.fBr.status != 0) {
                z = false;
            }
            NetworkDiagnoseAllInOneUI.b(networkDiagnoseAllInOneUI, z);
        } else if (kcVar.fBr.fBs == 2) {
            networkDiagnoseAllInOneUI = this.sfv;
            if (kcVar.fBr.status != 0) {
                z = false;
            }
            NetworkDiagnoseAllInOneUI.c(networkDiagnoseAllInOneUI, z);
        }
        int a = NetworkDiagnoseAllInOneUI.a(this.sfv);
        if (kcVar.fBr.fBt) {
            NetworkDiagnoseAllInOneUI.a(this.sfv, 100);
            ag.y(new 1(this));
            NetworkDiagnoseAllInOneUI.a(this.sfv, kcVar.fBr.fBu);
            if (NetworkDiagnoseAllInOneUI.c(this.sfv)) {
                a = 2;
                i = 1000;
            } else if (NetworkDiagnoseAllInOneUI.d(this.sfv)) {
                a = 4;
                i = 1000;
            } else if (NetworkDiagnoseAllInOneUI.e(this.sfv)) {
                a = 5;
                i = 1000;
            } else {
                a = 3;
                i = 1000;
            }
        } else {
            i = 0;
        }
        ag.h(new 2(this, a), (long) i);
        return false;
    }
}
