package com.tencent.mm.plugin.sns.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.sns.model.q;
import com.tencent.mm.plugin.sns.ui.SnsCommentDetailUI.43;

class SnsCommentDetailUI$43$1 implements OnCancelListener {
    final /* synthetic */ q rAT;
    final /* synthetic */ 43 rAU;

    SnsCommentDetailUI$43$1(43 43, q qVar) {
        this.rAU = 43;
        this.rAT = qVar;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        g.Dk();
        g.Di().gPJ.c(this.rAT);
    }
}
