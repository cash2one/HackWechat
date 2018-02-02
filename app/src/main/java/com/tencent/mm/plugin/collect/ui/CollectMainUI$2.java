package com.tencent.mm.plugin.collect.ui;

import android.widget.TextView;
import com.tencent.mm.g.a.st;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.wallet_core.ui.e;

class CollectMainUI$2 implements Runnable {
    final /* synthetic */ CollectMainUI lnh;
    final /* synthetic */ st lni;

    CollectMainUI$2(CollectMainUI collectMainUI, st stVar) {
        this.lnh = collectMainUI;
        this.lni = stVar;
    }

    public final void run() {
        if (bh.ov(this.lni.fKB.fKD)) {
            x.i("MicroMsg.CollectMainUI", "no bulletin data");
        } else {
            e.a((TextView) this.lnh.findViewById(f.ufy), this.lni.fKB.fKD, this.lni.fKB.content, this.lni.fKB.url);
        }
    }
}
