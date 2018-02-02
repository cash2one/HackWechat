package com.tencent.mm.plugin.emoji.a.a;

import com.tencent.mm.plugin.emoji.model.f;

class a$1 implements Runnable {
    final /* synthetic */ f luG;
    final /* synthetic */ a luH;

    a$1(a aVar, f fVar) {
        this.luH = aVar;
        this.luG = fVar;
    }

    public final void run() {
        if (this.luG != null) {
            a.a(this.luH, this.luH.a(this.luG));
            this.luH.notifyDataSetChanged();
        }
    }
}
