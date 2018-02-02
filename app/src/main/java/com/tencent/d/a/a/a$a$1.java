package com.tencent.d.a.a;

import android.content.Context;
import com.tencent.d.a.a.a.b;
import com.tencent.d.a.a.a.d;
import com.tencent.d.a.a.b.a;
import com.tencent.d.a.c.c;

class a$a$1 extends a {
    private boolean AbI = false;
    final /* synthetic */ b AbJ;
    final /* synthetic */ Context val$context;

    a$a$1(b bVar, Context context) {
        this.AbJ = bVar;
        this.val$context = context;
    }

    public final void onAuthenticationError(int i, CharSequence charSequence) {
        while (true) {
            c.d("Soter.FingerprintManagerCompat", "soter: basic onAuthenticationError", new Object[0]);
            if (!this.AbI) {
                this.AbI = true;
                if (i == 5) {
                    c.i("Soter.FingerprintManagerCompat", "soter: user cancelled fingerprint authen", new Object[0]);
                    this.AbJ.aKD();
                    return;
                } else if (i == 7) {
                    c.i("Soter.FingerprintManagerCompat", "soter: system call too many trial.", new Object[0]);
                    if (!(c.in(this.val$context) || c.im(this.val$context) || c.cFP())) {
                        c.ik(this.val$context);
                    }
                    this.AbI = false;
                    i = 10308;
                    charSequence = "Too many failed times";
                } else {
                    this.AbJ.onAuthenticationError(i, charSequence);
                    return;
                }
            }
            return;
        }
    }

    public final void onAuthenticationHelp(int i, CharSequence charSequence) {
        c.d("Soter.FingerprintManagerCompat", "soter: basic onAuthenticationHelp", new Object[0]);
        if (!this.AbI && !a.a.a(this, this.val$context)) {
            this.AbJ.onAuthenticationHelp(i, charSequence);
        }
    }

    public final void a(b.b bVar) {
        c.d("Soter.FingerprintManagerCompat", "soter: basic onAuthenticationSucceeded", new Object[0]);
        if (!this.AbI && !a.a.a(this, this.val$context)) {
            d dVar;
            a.c cVar;
            if (!c.cFP()) {
                c.il(this.val$context);
            }
            this.AbI = true;
            b bVar2 = this.AbJ;
            b.c cVar2 = bVar.AbP;
            if (cVar2 != null) {
                if (cVar2.AbM != null) {
                    dVar = new d(cVar2.AbM);
                } else if (cVar2.AbL != null) {
                    dVar = new d(cVar2.AbL);
                } else if (cVar2.AbN != null) {
                    dVar = new d(cVar2.AbN);
                }
                cVar = new a.c(dVar);
                bVar2.bCU();
            }
            dVar = null;
            cVar = new a.c(dVar);
            bVar2.bCU();
        }
    }

    public final void onAuthenticationFailed() {
        c.d("Soter.FingerprintManagerCompat", "soter: basic onAuthenticationFailed", new Object[0]);
        if (!this.AbI && !a.a.a(this, this.val$context)) {
            if (!c.cFP()) {
                Context context = this.val$context;
                c.as(context, Integer.valueOf(Integer.valueOf(c.ij(context)).intValue() + 1).intValue());
                if (!c.in(this.val$context)) {
                    c.w("Soter.FingerprintManagerCompat", "soter: too many fail trials", new Object[0]);
                    c.ik(this.val$context);
                    a.a.a(this);
                    return;
                }
            }
            this.AbJ.onAuthenticationFailed();
        }
    }
}
