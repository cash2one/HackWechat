package com.tencent.mm.ui.base;

import android.content.DialogInterface;
import android.view.View;
import android.view.View.OnClickListener;

class i$4 implements OnClickListener {
    final /* synthetic */ DialogInterface.OnClickListener xId;
    final /* synthetic */ boolean xIe;
    final /* synthetic */ i xZn;

    i$4(i iVar, DialogInterface.OnClickListener onClickListener, boolean z) {
        this.xZn = iVar;
        this.xId = onClickListener;
        this.xIe = z;
    }

    public final void onClick(View view) {
        if (this.xId != null) {
            this.xId.onClick(this.xZn, -1);
        }
        if (this.xIe) {
            this.xZn.dismiss();
        }
    }
}
