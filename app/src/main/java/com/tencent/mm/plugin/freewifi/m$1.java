package com.tencent.mm.plugin.freewifi;

import com.tencent.mm.ae.k;
import com.tencent.mm.plugin.freewifi.d.a;
import com.tencent.mm.plugin.freewifi.ui.FreeWifiFrontPageUI;
import com.tencent.mm.plugin.freewifi.ui.FreeWifiFrontPageUI$a;
import com.tencent.mm.plugin.freewifi.ui.FreeWifiFrontPageUI.b;
import com.tencent.mm.plugin.freewifi.ui.FreeWifiFrontPageUI.d;
import com.tencent.mm.protocal.c.ei;
import com.tencent.mm.sdk.platformtools.x;

class m$1 implements m$a {
    final /* synthetic */ int mCA;
    final /* synthetic */ String mDl;
    final /* synthetic */ FreeWifiFrontPageUI mDm;

    m$1(String str, FreeWifiFrontPageUI freeWifiFrontPageUI, int i) {
        this.mDl = str;
        this.mDm = freeWifiFrontPageUI;
        this.mCA = i;
    }

    public final void i(int i, int i2, String str, k kVar) {
        FreeWifiFrontPageUI freeWifiFrontPageUI;
        d dVar;
        FreeWifiFrontPageUI$a freeWifiFrontPageUI$a;
        if (i == 0 && i2 == 0) {
            if (kVar instanceof a) {
                ei aMc = ((a) kVar).aMc();
                if (aMc != null) {
                    x.i(this.mDl, "backPageInfo appid: %s, nickName: %s, userName: %s, finishActionCode: %d, finishUrl: %s, signature: %s, qingHuaiPageUrl: %s", new Object[]{aMc.nkv, aMc.kub, aMc.ksU, Integer.valueOf(aMc.vJH), aMc.vJI, aMc.hvw, aMc.vJJ});
                    FreeWifiFrontPageUI freeWifiFrontPageUI2 = this.mDm;
                    d dVar2 = d.mHD;
                    b bVar = new b();
                    bVar.mHz = aMc;
                    freeWifiFrontPageUI2.a(dVar2, bVar);
                    return;
                }
                x.i(this.mDl, "backPageInfo is null");
                freeWifiFrontPageUI = this.mDm;
                dVar = d.mHC;
                freeWifiFrontPageUI$a = new FreeWifiFrontPageUI$a();
                freeWifiFrontPageUI$a.mHb = m.a(this.mCA, k.b.mCJ, 21);
                freeWifiFrontPageUI.a(dVar, freeWifiFrontPageUI$a);
            }
        } else if (!m.cA(i, i2) || m.AA(str)) {
            freeWifiFrontPageUI = this.mDm;
            dVar = d.mHC;
            freeWifiFrontPageUI$a = new FreeWifiFrontPageUI$a();
            freeWifiFrontPageUI$a.mHb = m.a(this.mCA, k.b.mCJ, i2);
            freeWifiFrontPageUI.a(dVar, freeWifiFrontPageUI$a);
        } else {
            freeWifiFrontPageUI = this.mDm;
            dVar = d.mHC;
            freeWifiFrontPageUI$a = new FreeWifiFrontPageUI$a();
            freeWifiFrontPageUI$a.text = str;
            freeWifiFrontPageUI$a.mHb = m.a(this.mCA, k.b.mCJ, i2);
            freeWifiFrontPageUI.a(dVar, freeWifiFrontPageUI$a);
        }
    }
}
