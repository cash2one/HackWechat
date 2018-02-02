package com.tencent.mm.plugin.card.sharecard.ui;

import com.tencent.mm.sdk.platformtools.x;

class ShareCardListUI$1 implements Runnable {
    final /* synthetic */ ShareCardListUI kPj;

    ShareCardListUI$1(ShareCardListUI shareCardListUI) {
        this.kPj = shareCardListUI;
    }

    public final void run() {
        ShareCardListUI.a(this.kPj);
        ShareCardListUI.b(this.kPj);
        this.kPj.kPe = true;
        x.d("MicroMsg.ShareCardListUI", "initLocation end");
    }
}
