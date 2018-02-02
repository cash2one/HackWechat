package com.tencent.mm.plugin.game.ui;

class j$1 implements Runnable {
    final /* synthetic */ j nod;

    j$1(j jVar) {
        this.nod = jVar;
    }

    public final void run() {
        this.nod.notifyDataSetChanged();
    }
}
