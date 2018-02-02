package com.tencent.mm.plugin.webview.ui.tools.fts;

import android.view.View;

class a$2 implements Runnable {
    final /* synthetic */ a tEB;
    final /* synthetic */ View tEC;

    a$2(a aVar, View view) {
        this.tEB = aVar;
        this.tEC = view;
    }

    public final void run() {
        this.tEB.tEi = this.tEC.getMeasuredHeight();
    }
}
