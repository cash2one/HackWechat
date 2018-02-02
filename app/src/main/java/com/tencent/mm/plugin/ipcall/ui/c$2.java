package com.tencent.mm.plugin.ipcall.ui;

class c$2 implements Runnable {
    final /* synthetic */ c nHO;

    c$2(c cVar) {
        this.nHO = cVar;
    }

    public final void run() {
        this.nHO.notifyDataSetChanged();
    }
}
