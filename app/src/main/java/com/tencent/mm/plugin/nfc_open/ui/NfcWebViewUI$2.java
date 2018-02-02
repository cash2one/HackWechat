package com.tencent.mm.plugin.nfc_open.ui;

import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.x;

class NfcWebViewUI$2 implements Runnable {
    final /* synthetic */ NfcWebViewUI oSl;
    final /* synthetic */ String oSm;

    NfcWebViewUI$2(NfcWebViewUI nfcWebViewUI, String str) {
        this.oSl = nfcWebViewUI;
        this.oSm = str;
    }

    public final void run() {
        g.pQN.h(12794, new Object[]{this.oSm, Integer.valueOf(0)});
        x.d("MicroMsg.NfcWebViewUI", "doCardTypeReport url = " + this.oSm);
    }
}
