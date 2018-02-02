package com.tencent.mm.plugin.wenote.model;

import com.tencent.mm.plugin.wenote.model.nativenote.manager.k;

class j$1 implements Runnable {
    final /* synthetic */ j tRk;

    j$1(j jVar) {
        this.tRk = jVar;
    }

    public final void run() {
        j.a(this.tRk);
        this.tRk.cu(this.tRk.tQp.pFF);
        if (k.bWZ() != null) {
            k.bXd();
        }
    }

    public final String toString() {
        return super.toString() + "|dealWNoteInfo";
    }
}
