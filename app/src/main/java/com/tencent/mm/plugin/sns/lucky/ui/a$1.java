package com.tencent.mm.plugin.sns.lucky.ui;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.sdk.platformtools.x;

class a$1 implements OnCancelListener {
    final /* synthetic */ Dialog qSc;

    a$1(Dialog dialog) {
        this.qSc = dialog;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        x.i("MicroMsg.SnsLuckyCommentAlertUI", "showTipsDialog onCancel");
        if (this.qSc != null && this.qSc.isShowing()) {
            this.qSc.dismiss();
        }
    }
}
