package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.ui.base.h;

class SnsUploadConfigView$13 implements OnClickListener {
    final /* synthetic */ SnsUploadConfigView rLD;

    SnsUploadConfigView$13(SnsUploadConfigView snsUploadConfigView) {
        this.rLD = snsUploadConfigView;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        SnsUploadConfigView snsUploadConfigView = this.rLD;
        Context context = this.rLD.getContext();
        this.rLD.getContext().getString(j.dGO);
        SnsUploadConfigView.a(snsUploadConfigView, h.a(context, this.rLD.getContext().getString(j.eRz), true, new 1(this)));
        SnsUploadConfigView.j(this.rLD).a(this.rLD, this.rLD.getContext());
    }
}
