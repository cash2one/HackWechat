package com.tencent.mm.plugin.location.ui.impl;

import android.view.View;
import android.view.ViewStub;
import android.view.ViewStub.OnInflateListener;
import com.tencent.mm.R;

class h$1 implements OnInflateListener {
    final /* synthetic */ h nYk;

    h$1(h hVar) {
        this.nYk = hVar;
    }

    public final void onInflate(ViewStub viewStub, View view) {
        view.findViewById(R.h.ctQ).setOnTouchListener(new 1(this));
    }
}
