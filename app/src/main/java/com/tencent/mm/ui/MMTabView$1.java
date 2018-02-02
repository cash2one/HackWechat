package com.tencent.mm.ui;

class MMTabView$1 implements Runnable {
    final /* synthetic */ String xKu;
    final /* synthetic */ MMTabView xKv;

    MMTabView$1(MMTabView mMTabView, String str) {
        this.xKv = mMTabView;
        this.xKu = str;
    }

    public final void run() {
        MMTabView.a(this.xKv).setText(this.xKu);
        this.xKv.cne();
    }
}
