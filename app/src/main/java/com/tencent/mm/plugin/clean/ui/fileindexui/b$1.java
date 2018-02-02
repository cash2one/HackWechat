package com.tencent.mm.plugin.clean.ui.fileindexui;

class b$1 implements Runnable {
    final /* synthetic */ b lgr;

    b$1(b bVar) {
        this.lgr = bVar;
    }

    public final void run() {
        this.lgr.notifyDataSetChanged();
    }
}
