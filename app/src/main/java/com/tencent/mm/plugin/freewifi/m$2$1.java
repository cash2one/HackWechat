package com.tencent.mm.plugin.freewifi;

import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.plugin.freewifi.k.a;
import com.tencent.mm.plugin.freewifi.m.2;
import com.tencent.mm.sdk.platformtools.x;

class m$2$1 implements e {
    final /* synthetic */ 2 mDq;

    m$2$1(2 2) {
        this.mDq = 2;
    }

    public final void a(int i, int i2, String str, k kVar) {
        x.i(this.mDq.mDl, "sessionKey=%s, step=%d, desc=net request [apauth.getBackPage] returns. errType=%d, errCode=%d, errMsg=%s", m.D(this.mDq.val$intent), Integer.valueOf(m.E(this.mDq.val$intent)), Integer.valueOf(i), Integer.valueOf(i2), str);
        a aLe = k.aLe();
        aLe.ssid = m.AD(this.mDq.mDl);
        aLe.bssid = m.AE(this.mDq.mDl);
        aLe.fpA = m.AF(this.mDq.mDl);
        aLe.fpz = this.mDq.mDn;
        aLe.mCu = m.D(this.mDq.val$intent);
        aLe.mCv = m.F(this.mDq.val$intent);
        aLe.mCw = k$b.GetBackPage33Return.mDi;
        aLe.mCx = k$b.GetBackPage33Return.name;
        aLe.fCR = m.G(this.mDq.val$intent);
        aLe.result = i2;
        aLe.kZo = str;
        aLe.aLg().b(this.mDq.val$intent, true).aLf();
        this.mDq.mDp.i(i, i2, str, kVar);
    }
}
