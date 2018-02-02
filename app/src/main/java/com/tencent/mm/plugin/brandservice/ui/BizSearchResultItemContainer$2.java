package com.tencent.mm.plugin.brandservice.ui;

class BizSearchResultItemContainer$2 implements Runnable {
    final /* synthetic */ BizSearchResultItemContainer kFP;

    BizSearchResultItemContainer$2(BizSearchResultItemContainer bizSearchResultItemContainer) {
        this.kFP = bizSearchResultItemContainer;
    }

    public final void run() {
        BizSearchResultItemContainer.e(this.kFP).setVisibility(BizSearchResultItemContainer.d(this.kFP).isEmpty() ? 0 : 8);
    }
}
