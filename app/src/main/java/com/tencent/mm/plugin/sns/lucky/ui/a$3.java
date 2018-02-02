package com.tencent.mm.plugin.sns.lucky.ui;

import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.sdk.platformtools.x;

class a$3 implements OnClickListener {
    final /* synthetic */ Dialog qSc;

    a$3(Dialog dialog) {
        this.qSc = dialog;
    }

    public final void onClick(View view) {
        x.i("MicroMsg.SnsLuckyCommentAlertUI", "showTipsDialog OnClick: close");
        if (this.qSc != null && this.qSc.isShowing()) {
            this.qSc.dismiss();
        }
    }
}
