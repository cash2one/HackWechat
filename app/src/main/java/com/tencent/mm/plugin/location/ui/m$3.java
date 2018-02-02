package com.tencent.mm.plugin.location.ui;

import android.view.View;
import android.view.View.OnClickListener;

class m$3 implements OnClickListener {
    final /* synthetic */ m nVm;

    m$3(m mVar) {
        this.nVm = mVar;
    }

    public final void onClick(View view) {
        int[] iArr = new int[2];
        view.getLocationInWindow(iArr);
        m.a(this.nVm, iArr[0], iArr[1]);
    }
}
