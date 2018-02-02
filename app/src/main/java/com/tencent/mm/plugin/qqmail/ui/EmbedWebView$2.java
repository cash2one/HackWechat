package com.tencent.mm.plugin.qqmail.ui;

import android.view.View;
import android.widget.ScrollView;

class EmbedWebView$2 implements Runnable {
    final /* synthetic */ EmbedWebView psi;

    EmbedWebView$2(EmbedWebView embedWebView) {
        this.psi = embedWebView;
    }

    public final void run() {
        View view = (View) this.psi.getParent();
        if (view != null) {
            view = (View) view.getParent();
            if (view != null && (view instanceof ScrollView)) {
                EmbedWebView.a(this.psi);
                view.setOnTouchListener(new 1(this));
            }
        }
    }
}
