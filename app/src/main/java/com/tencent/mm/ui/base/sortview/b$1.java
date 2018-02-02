package com.tencent.mm.ui.base.sortview;

class b$1 implements Runnable {
    final /* synthetic */ b yjW;

    b$1(b bVar) {
        this.yjW = bVar;
    }

    public final void run() {
        this.yjW.notifyDataSetChanged();
    }
}
