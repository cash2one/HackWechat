package com.tencent.mm.ui.widget;

import android.view.View;
import android.view.View.OnClickListener;

class a$1 implements OnClickListener {
    final /* synthetic */ a zqP;

    a$1(a aVar) {
        this.zqP = aVar;
    }

    public final void onClick(View view) {
        if (this.zqP.isShowing()) {
            this.zqP.cancel();
        }
    }
}
