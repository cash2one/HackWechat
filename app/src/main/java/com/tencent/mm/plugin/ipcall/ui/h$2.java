package com.tencent.mm.plugin.ipcall.ui;

class h$2 implements Runnable {
    final /* synthetic */ h nLs;

    h$2(h hVar) {
        this.nLs = hVar;
    }

    public final void run() {
        this.nLs.notifyDataSetChanged();
    }
}
