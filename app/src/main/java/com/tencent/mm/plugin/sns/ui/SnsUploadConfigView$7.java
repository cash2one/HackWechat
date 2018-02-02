package com.tencent.mm.plugin.sns.ui;

import android.view.View;
import android.view.View.OnClickListener;

class SnsUploadConfigView$7 implements OnClickListener {
    final /* synthetic */ SnsUploadConfigView rLD;

    SnsUploadConfigView$7(SnsUploadConfigView snsUploadConfigView) {
        this.rLD = snsUploadConfigView;
    }

    public final void onClick(View view) {
        SnsUploadConfigView.b(this.rLD, !SnsUploadConfigView.d(this.rLD));
        if (SnsUploadConfigView.d(this.rLD)) {
            SnsUploadConfigView.e(this.rLD);
        }
        SnsUploadConfigView.f(this.rLD);
    }
}
