package com.tencent.mm.ui.base;

import android.view.View;
import android.view.View.OnClickListener;

class u$6 implements OnClickListener {
    final /* synthetic */ q yek;
    final /* synthetic */ OnClickListener yen;

    u$6(q qVar, OnClickListener onClickListener) {
        this.yek = qVar;
        this.yen = onClickListener;
    }

    public final void onClick(View view) {
        this.yek.dismiss();
        if (this.yen != null) {
            this.yen.onClick(view);
        }
    }
}
