package com.tencent.mm.plugin.sns.ui;

class SnsSightUploadSayFooter$3 implements Runnable {
    final /* synthetic */ SnsSightUploadSayFooter rGD;

    SnsSightUploadSayFooter$3(SnsSightUploadSayFooter snsSightUploadSayFooter) {
        this.rGD = snsSightUploadSayFooter;
    }

    public final void run() {
        SnsSightUploadSayFooter.b(this.rGD).performClick();
        SnsSightUploadSayFooter.b(this.rGD).requestFocus();
        SnsSightUploadSayFooter.c(this.rGD).showVKB();
    }
}
