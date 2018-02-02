package com.tencent.mm.plugin.wenote.model.nativenote.manager;

import com.tencent.mm.z.ar;

class d$1 implements Runnable {
    final /* synthetic */ String hAT;
    final /* synthetic */ d tSZ;
    final /* synthetic */ int toa;

    d$1(d dVar, String str, int i) {
        this.tSZ = dVar;
        this.hAT = str;
        this.toa = i;
    }

    public final void run() {
        d.b(this.tSZ).a(this.hAT, d.a(this.tSZ));
        if (d.c(this.tSZ) || this.toa != -50006) {
            ar.Dm().g(new Runnable(this) {
                final /* synthetic */ d$1 tTa;

                {
                    this.tTa = r1;
                }

                public final void run() {
                    d.b(this.tTa.tSZ).b(d.d(this.tTa.tSZ), d.a(this.tTa.tSZ));
                }
            }, 80);
        }
    }
}
