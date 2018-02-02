package com.tencent.mm.plugin.sns.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.plugin.label.a.a;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.ui.base.h;

class SnsLabelUI$6 implements OnClickListener {
    final /* synthetic */ SnsLabelUI rDf;

    SnsLabelUI$6(SnsLabelUI snsLabelUI) {
        this.rDf = snsLabelUI;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        SnsLabelUI.i(this.rDf);
        a.aUX().aX(SnsLabelUI.b(this.rDf));
        SnsLabelUI.a(this.rDf, h.a(this.rDf, this.rDf.getString(j.qLn), false, null));
    }
}
