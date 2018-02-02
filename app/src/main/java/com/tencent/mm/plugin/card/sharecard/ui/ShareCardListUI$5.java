package com.tencent.mm.plugin.card.sharecard.ui;

import com.tencent.mm.sdk.platformtools.x;

class ShareCardListUI$5 implements Runnable {
    final /* synthetic */ ShareCardListUI kPj;

    ShareCardListUI$5(ShareCardListUI shareCardListUI) {
        this.kPj = shareCardListUI;
    }

    public final void run() {
        ShareCardListUI.i(this.kPj);
        if (this.kPj.isFinishing()) {
            x.w("MicroMsg.ShareCardListUI", "Activity is finished!!!");
        } else {
            ShareCardListUI.j(this.kPj);
        }
    }
}
