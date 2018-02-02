package com.tencent.mm.ui.base;

import android.content.DialogInterface;
import android.view.View;
import android.view.View.OnClickListener;

class i$5 implements OnClickListener {
    final /* synthetic */ i xZn;
    final /* synthetic */ DialogInterface.OnClickListener xZq;
    final /* synthetic */ boolean xZr;

    i$5(i iVar, DialogInterface.OnClickListener onClickListener, boolean z) {
        this.xZn = iVar;
        this.xZq = onClickListener;
        this.xZr = z;
    }

    public final void onClick(View view) {
        if (this.xZq != null) {
            this.xZq.onClick(this.xZn, -2);
        }
        if (this.xZr) {
            this.xZn.cancel();
        }
    }
}
