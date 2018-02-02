package com.tencent.mm.plugin.ipcall.ui;

import android.view.ViewTreeObserver.OnGlobalLayoutListener;

class IPCallDynamicTextView$2 implements OnGlobalLayoutListener {
    final /* synthetic */ IPCallDynamicTextView nJU;

    IPCallDynamicTextView$2(IPCallDynamicTextView iPCallDynamicTextView) {
        this.nJU = iPCallDynamicTextView;
    }

    public final void onGlobalLayout() {
        if (IPCallDynamicTextView.b(this.nJU) != IPCallDynamicTextView.c(this.nJU)) {
            IPCallDynamicTextView.e(this.nJU).sendEmptyMessage(1);
        }
    }
}
