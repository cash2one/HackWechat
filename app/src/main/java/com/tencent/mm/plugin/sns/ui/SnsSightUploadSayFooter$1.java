package com.tencent.mm.plugin.sns.ui;

import android.view.View;
import android.view.View.OnClickListener;

class SnsSightUploadSayFooter$1 implements OnClickListener {
    final /* synthetic */ SnsSightUploadSayFooter rGD;

    SnsSightUploadSayFooter$1(SnsSightUploadSayFooter snsSightUploadSayFooter) {
        this.rGD = snsSightUploadSayFooter;
    }

    public final void onClick(View view) {
        int i = 0;
        if (this.rGD.getVisibility() == 8) {
            this.rGD.setVisibility(0);
        }
        if (this.rGD.okx.getVisibility() == 0) {
            i = 1;
        }
        if (i != 0) {
            SnsSightUploadSayFooter.a(this.rGD);
        }
    }
}
