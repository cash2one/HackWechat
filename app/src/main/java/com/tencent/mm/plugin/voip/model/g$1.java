package com.tencent.mm.plugin.voip.model;

import com.tencent.mm.e.b.c.a;

class g$1 implements a {
    final /* synthetic */ g skP;

    g$1(g gVar) {
        this.skP = gVar;
    }

    public final void q(byte[] bArr, int i) {
        synchronized (g.j(this.skP)) {
            if (this.skP.skA == 2 && g.a(this.skP) != null) {
                if (g.b(this.skP) == 1) {
                    g.a(this.skP, System.currentTimeMillis());
                    g.b(this.skP, g.c(this.skP));
                    g.d(this.skP);
                } else {
                    long currentTimeMillis = System.currentTimeMillis();
                    g.a(this.skP, (int) ((currentTimeMillis - g.e(this.skP)) - ((long) (g.skN * 20))));
                    g.a(this.skP, currentTimeMillis);
                }
                if (g.f(this.skP) <= 10) {
                    g.b(this.skP, 92);
                }
                g.b(this.skP, ((g.a(this.skP).bGe() + 24) + (g.f(this.skP) * 3)) / 4);
                if (g.g(this.skP) == 1) {
                    g.c(this.skP, g.a(this.skP).bGb());
                    if (g.h(this.skP) >= g.f(this.skP)) {
                        g.c(this.skP, g.h(this.skP) - g.f(this.skP));
                    }
                    g.b(this.skP, g.h(this.skP));
                    g.i(this.skP);
                } else {
                    g.b(this.skP, 0);
                }
                this.skP.siL.ske.recordCallback(bArr, i, g.f(this.skP));
                g.skN++;
            }
        }
    }

    public final void aK(int i, int i2) {
    }
}
