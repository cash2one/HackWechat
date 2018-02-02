package com.tencent.mm.ui.f.a;

import android.view.View;
import android.view.View.OnClickListener;

class f$1 implements OnClickListener {
    final /* synthetic */ f zci;

    f$1(f fVar) {
        this.zci = fVar;
    }

    public final void onClick(View view) {
        f.a(this.zci).onCancel();
        this.zci.dismiss();
    }
}
