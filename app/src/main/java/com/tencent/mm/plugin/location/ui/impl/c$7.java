package com.tencent.mm.plugin.location.ui.impl;

import android.view.View;
import android.view.View.OnFocusChangeListener;

class c$7 implements OnFocusChangeListener {
    final /* synthetic */ c nXi;

    c$7(c cVar) {
        this.nXi = cVar;
    }

    public final void onFocusChange(View view, boolean z) {
        if (z) {
            this.nXi.showVKB();
        }
    }
}
