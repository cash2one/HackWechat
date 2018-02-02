package com.tencent.mm.plugin.exdevice.ui;

import com.tencent.mm.plugin.exdevice.model.ad;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.util.List;

class ExdeviceProfileUI$27 implements Runnable {
    final /* synthetic */ ExdeviceProfileUI lVZ;

    ExdeviceProfileUI$27(ExdeviceProfileUI exdeviceProfileUI) {
        this.lVZ = exdeviceProfileUI;
    }

    public final void run() {
        a l = ExdeviceProfileUI.l(this.lVZ);
        Object p = ExdeviceProfileUI.p(this.lVZ);
        List q = ExdeviceProfileUI.q(this.lVZ);
        l.lUZ = ad.aEm().za(l.jKk);
        l.lVc = p;
        if (bh.cA(p)) {
            l.lVa = 0;
        } else {
            l.lVa = p.size();
        }
        l.lVd = q;
        if (!bh.cA(q)) {
            l.lVb = q.size();
        }
        x.d("MicroMsg.ExdeviceProfileAdapter", "setData,mIsFollower:%s ,mFollowersNum:%s  ,mButtonNum:%s ,mUsername:%s", new Object[]{Boolean.valueOf(l.lUZ), Integer.valueOf(l.lVa), Integer.valueOf(l.lVb), l.jKk});
        ExdeviceProfileUI.l(this.lVZ).notifyDataSetChanged();
    }
}
