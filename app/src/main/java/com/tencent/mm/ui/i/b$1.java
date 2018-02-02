package com.tencent.mm.ui.i;

import android.view.View;
import android.view.View.OnClickListener;

class b$1 implements OnClickListener {
    final /* synthetic */ b zqj;

    b$1(b bVar) {
        this.zqj = bVar;
    }

    public final void onClick(View view) {
        b.a(this.zqj).onCancel();
        this.zqj.dismiss();
    }
}
