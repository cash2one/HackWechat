package com.tencent.mm.plugin.sns.ui;

import android.view.View;
import android.view.View.OnClickListener;

class SnsUploadConfigView$8 implements OnClickListener {
    final /* synthetic */ SnsUploadConfigView rLD;

    SnsUploadConfigView$8(SnsUploadConfigView snsUploadConfigView) {
        this.rLD = snsUploadConfigView;
    }

    public final void onClick(View view) {
        SnsUploadConfigView.c(this.rLD, !SnsUploadConfigView.g(this.rLD));
        if (SnsUploadConfigView.g(this.rLD)) {
            SnsUploadConfigView.e(this.rLD);
        }
        SnsUploadConfigView.h(this.rLD);
    }
}
