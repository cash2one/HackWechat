package com.tencent.mm.plugin.sns.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.mm.plugin.sns.c.a;

class SnsUploadConfigView$9 implements OnClickListener {
    final /* synthetic */ SnsUploadConfigView rLD;

    SnsUploadConfigView$9(SnsUploadConfigView snsUploadConfigView) {
        this.rLD = snsUploadConfigView;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        a.ifs.h(new Intent(), SnsUploadConfigView.i(this.rLD));
    }
}
