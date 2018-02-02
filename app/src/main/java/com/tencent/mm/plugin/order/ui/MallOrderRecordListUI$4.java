package com.tencent.mm.plugin.order.ui;

import android.widget.TextView;
import com.tencent.mm.g.a.st;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.wallet_core.ui.e;

class MallOrderRecordListUI$4 implements Runnable {
    final /* synthetic */ st lni;
    final /* synthetic */ MallOrderRecordListUI pcu;

    MallOrderRecordListUI$4(MallOrderRecordListUI mallOrderRecordListUI, st stVar) {
        this.pcu = mallOrderRecordListUI;
        this.lni = stVar;
    }

    public final void run() {
        if (bh.ov(this.lni.fKB.fKD)) {
            x.i("MicroMsg.WalletOrderListUI", "no bulletin data");
        } else {
            e.a((TextView) this.pcu.findViewById(f.ufy), this.lni.fKB.fKD, this.lni.fKB.content, this.lni.fKB.url);
        }
    }
}
