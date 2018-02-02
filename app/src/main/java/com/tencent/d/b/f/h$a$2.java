package com.tencent.d.b.f;

import com.tencent.d.b.f.h.a;

class h$a$2 implements Runnable {
    final /* synthetic */ a AdF;
    final /* synthetic */ int AdG;
    final /* synthetic */ CharSequence AdH;

    h$a$2(a aVar, int i, CharSequence charSequence) {
        this.AdF = aVar;
        this.AdG = i;
        this.AdH = charSequence;
    }

    public final void run() {
        if (this.AdF.AdB.Adv != null) {
            this.AdF.AdB.Adv.onAuthenticationHelp(this.AdG, a.W(this.AdH));
        }
    }
}
