package com.tencent.mm.plugin.wenote.ui.nativenote.b;

import com.tencent.mm.plugin.wenote.model.nativenote.spans.u;
import com.tencent.mm.plugin.wenote.ui.nativenote.b.k.2;

class k$2$1 implements Runnable {
    final /* synthetic */ 2 tYB;

    k$2$1(2 2) {
        this.tYB = 2;
    }

    public final void run() {
        if (this.tYB.tYA.tRC != 0) {
            int i = k.a(this.tYB.tYy).bWN().Ww;
            if (i == this.tYB.tYA.content.length()) {
                k.a(this.tYB.tYy).bWP();
                k.a(this.tYB.tYy).getText().append("\n");
                k.a(this.tYB.tYy).bWQ();
                k.a(this.tYB.tYy).setSelection(i);
            }
            this.tYB.tYA.tRC = 0;
            if (this.tYB.tYA.tRD == 1) {
                k.a(this.tYB.tYy).a(u.tWk, Boolean.valueOf(true));
            } else if (this.tYB.tYA.tRD == 3) {
                k.a(this.tYB.tYy).a(u.tWj, Boolean.valueOf(true));
            } else if (this.tYB.tYA.tRD == 2) {
                k.a(this.tYB.tYy).a(u.tWl, Boolean.valueOf(true));
            }
        }
    }
}
