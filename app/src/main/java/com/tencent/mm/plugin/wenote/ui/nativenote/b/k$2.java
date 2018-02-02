package com.tencent.mm.plugin.wenote.ui.nativenote.b;

import com.tencent.mm.plugin.wenote.model.a.h;
import com.tencent.mm.pluginsdk.ui.d.i;
import com.tencent.mm.sdk.platformtools.ag;

class k$2 implements Runnable {
    final /* synthetic */ h tYA;
    final /* synthetic */ k tYy;

    k$2(k kVar, h hVar) {
        this.tYy = kVar;
        this.tYA = hVar;
    }

    public final void run() {
        k.a(this.tYy).QR(this.tYA.content);
        k.a(this.tYy).bWP();
        k.a(this.tYy).bWR();
        i.i(k.a(this.tYy));
        k.a(this.tYy).bWS();
        k.a(this.tYy).bWQ();
        if (this.tYA.tRt) {
            if (this.tYA.tRv == -1 || this.tYA.tRv >= k.a(this.tYy).getText().toString().length()) {
                k.a(this.tYy).setSelection(k.a(this.tYy).getText().toString().length());
            } else {
                k.a(this.tYy).setSelection(this.tYA.tRv);
            }
            k.a(this.tYy).requestFocus();
            ag.h(new 1(this), 500);
        } else if (k.a(this.tYy).hasFocus()) {
            k.a(this.tYy).clearFocus();
        }
        if (this.tYA.tRB) {
            this.tYA.tRB = false;
            k.a(this.tYy).tRB = true;
            k.a(this.tYy).onTextContextMenuItem(16908322);
        }
    }
}
