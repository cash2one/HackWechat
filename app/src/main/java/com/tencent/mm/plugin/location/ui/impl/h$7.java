package com.tencent.mm.plugin.location.ui.impl;

import android.view.View;
import android.view.View.OnClickListener;

class h$7 implements OnClickListener {
    final /* synthetic */ h nYk;

    h$7(h hVar) {
        this.nYk = hVar;
    }

    public final void onClick(View view) {
        this.nYk.aWq();
        this.nYk.aWs();
        this.nYk.activity.finish();
    }
}
