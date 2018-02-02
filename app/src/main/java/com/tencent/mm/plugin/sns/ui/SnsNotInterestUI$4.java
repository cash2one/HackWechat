package com.tencent.mm.plugin.sns.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.kernel.g;

class SnsNotInterestUI$4 implements OnCancelListener {
    final /* synthetic */ SnsNotInterestUI rEr;

    SnsNotInterestUI$4(SnsNotInterestUI snsNotInterestUI) {
        this.rEr = snsNotInterestUI;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        g.Dk();
        g.Di().gPJ.c(this.rEr.rEq);
    }
}
