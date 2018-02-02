package com.tencent.d.b.f;

import com.tencent.d.b.f.h.a;

class h$a$1 implements Runnable {
    final /* synthetic */ int AdD;
    final /* synthetic */ CharSequence AdE;
    final /* synthetic */ a AdF;

    h$a$1(a aVar, int i, CharSequence charSequence) {
        this.AdF = aVar;
        this.AdD = i;
        this.AdE = charSequence;
    }

    public final void run() {
        if (this.AdF.AdB.Adv != null) {
            this.AdF.AdB.Adv.onAuthenticationError(this.AdD, this.AdE);
        }
    }
}
