package com.tencent.mm.plugin.aa.a.c;

import com.tencent.mm.plugin.aa.a.c.a.1;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.vending.g.g;
import com.tencent.mm.vending.h.e;
import com.tencent.mm.vending.j.c;
import com.tencent.mm.vending.j.d;
import java.util.List;

public class b implements com.tencent.mm.vending.c.b<a> {
    protected a ihp;
    public final a ihq;

    public class a implements e<d<List, String, Boolean>, c<Boolean, Integer>> {
        final /* synthetic */ b ihr;

        public a(b bVar) {
            this.ihr = bVar;
        }

        public final /* synthetic */ Object call(Object obj) {
            int i;
            int i2 = 20;
            c cVar = (c) obj;
            a aVar = this.ihr.ihp;
            boolean booleanValue = ((Boolean) cVar.get(0)).booleanValue();
            int intValue = ((Integer) cVar.get(1)).intValue();
            if (!booleanValue || aVar.ihg <= 0) {
                i = 20;
            } else {
                i = aVar.ihg;
                aVar.ihg = 0;
                aVar.ihl = false;
            }
            if (aVar.ihm == intValue) {
                i2 = i;
            }
            aVar.ihm = intValue;
            x.i("MicroMsg.AAQueryListInteractor", "getNextAAQueryPage, currentPageOffset: %s, force: %s", new Object[]{Integer.valueOf(aVar.ihg), Boolean.valueOf(booleanValue)});
            com.tencent.mm.vending.g.b czQ = g.czQ();
            czQ.czP();
            (aVar.ihl ? new com.tencent.mm.plugin.aa.a.a.c(i2, aVar.ihg, intValue, aVar.ihh, aVar.ihi, aVar.ihj, aVar.ihk) : new com.tencent.mm.plugin.aa.a.a.c(i2, aVar.ihg, intValue)).JV().f(new 1(aVar, czQ));
            return null;
        }

        public final String wx() {
            return "Vending.ANY";
        }
    }

    public final /* bridge */ /* synthetic */ Object WD() {
        return this.ihp;
    }

    public b() {
        this(new a());
    }

    private b(a aVar) {
        this.ihq = new a(this);
        this.ihp = aVar;
    }
}
