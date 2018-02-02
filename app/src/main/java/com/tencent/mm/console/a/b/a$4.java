package com.tencent.mm.console.a.b;

import com.tencent.mm.console.a.b.a.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.plugin.messenger.foundation.a.h;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.au;
import org.xwalk.core.R$styleable;

class a$4 implements a {
    final /* synthetic */ b gIO;
    final /* synthetic */ a gIQ;
    final /* synthetic */ String gIT;
    final /* synthetic */ int gIU;
    final /* synthetic */ int[] gIV;

    a$4(a aVar, String str, int i, int[] iArr, b bVar) {
        this.gIQ = aVar;
        this.gIT = str;
        this.gIU = i;
        this.gIV = iArr;
        this.gIO = bVar;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void execute() {
        x.i("MicroMsg.AgingTestCommand", "[oneliang] batch insert test msg info, begin single transaction, username:%s", new Object[]{this.gIT});
        long currentTimeMillis = System.currentTimeMillis();
        int i = 0;
        while (i < this.gIU) {
            au a;
            int i2 = this.gIV[a.fY(this.gIV.length)];
            c cVar = null;
            switch (i2) {
                case 3:
                    if (this.gIO.gIX.isEmpty()) {
                        continue;
                    } else {
                        a = a.a(this.gIQ, this.gIT, (c) this.gIO.gIX.get(a.fY(this.gIO.gIX.size())));
                    }
                case R$styleable.AppCompatTheme_dialogPreferredPadding /*43*/:
                    if (this.gIO.gIY.isEmpty()) {
                        continue;
                    } else {
                        c cVar2 = (c) this.gIO.gIY.get(a.fY(this.gIO.gIY.size()));
                        a = a.b(this.gIQ, this.gIT, cVar2);
                        cVar = cVar2;
                    }
                case 47:
                    if (this.gIO.gIZ.isEmpty()) {
                        continue;
                    } else {
                        a = a.c(this.gIQ, this.gIT, (c) this.gIO.gIZ.get(a.fY(this.gIO.gIZ.size())));
                    }
                default:
                    a = a.a(this.gIQ, this.gIT, i);
            }
            long Q = ((h) g.h(h.class)).aZi().Q(a);
            if (Q <= 0) {
                if (i > 0) {
                    i--;
                } else {
                    i = 0;
                }
            } else if (i2 == 43) {
                o.TU().a(a.a(this.gIT, (int) Q, a, cVar));
            }
            i++;
        }
        x.i("MicroMsg.AgingTestCommand", "[oneliang] batch insert test msg info, end single transaction, username:%s, cost:%s", new Object[]{this.gIT, Long.valueOf(System.currentTimeMillis() - currentTimeMillis)});
    }
}
