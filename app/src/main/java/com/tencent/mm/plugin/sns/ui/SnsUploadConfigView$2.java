package com.tencent.mm.plugin.sns.ui;

import com.tencent.mm.g.a.fq;

class SnsUploadConfigView$2 implements Runnable {
    final /* synthetic */ SnsUploadConfigView rLD;
    final /* synthetic */ fq rLE;

    SnsUploadConfigView$2(SnsUploadConfigView snsUploadConfigView, fq fqVar) {
        this.rLD = snsUploadConfigView;
        this.rLE = fqVar;
    }

    public final void run() {
        if (!this.rLE.fva.fpW) {
            SnsUploadConfigView.k(this.rLD);
        }
    }
}
