package com.tencent.mm.plugin.wallet_payu.order.ui;

import com.tencent.mm.sdk.platformtools.x;

class PayUMallOrderRecordListUI$1 implements Runnable {
    final /* synthetic */ PayUMallOrderRecordListUI tcJ;

    PayUMallOrderRecordListUI$1(PayUMallOrderRecordListUI payUMallOrderRecordListUI) {
        this.tcJ = payUMallOrderRecordListUI;
    }

    public final void run() {
        if (PayUMallOrderRecordListUI.a(this.tcJ)) {
            x.v("MicroMsg.PayUMallOrderRecordListUI", "has more");
            if (!PayUMallOrderRecordListUI.b(this.tcJ)) {
                PayUMallOrderRecordListUI.c(this.tcJ).cpp();
                PayUMallOrderRecordListUI.e(this.tcJ).setAdapter(PayUMallOrderRecordListUI.d(this.tcJ));
                PayUMallOrderRecordListUI.f(this.tcJ);
            }
        } else {
            x.v("MicroMsg.PayUMallOrderRecordListUI", "no more! dismiss footer view!");
            PayUMallOrderRecordListUI.g(this.tcJ).cpq();
        }
        PayUMallOrderRecordListUI.h(this.tcJ).notifyDataSetChanged();
    }
}
