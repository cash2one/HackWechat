package com.tencent.mm.plugin.wallet.balance.a.a;

import com.tencent.mm.plugin.wallet.balance.a.a.j.2;
import com.tencent.mm.protocal.c.oj;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.vending.c.b;
import com.tencent.mm.vending.g.g;
import com.tencent.mm.vending.h.e;
import com.tencent.mm.vending.j.c;

public class k implements b<j> {
    public final d syA;
    public final c syB;
    protected j syx;
    public final b syy;
    public final a syz;

    public class a implements e<oj, c<String, Integer>> {
        final /* synthetic */ k syC;

        public a(k kVar) {
            this.syC = kVar;
        }

        public final /* synthetic */ Object call(Object obj) {
            c cVar = (c) obj;
            j jVar = this.syC.syx;
            String str = (String) cVar.get(0);
            int intValue = ((Integer) cVar.get(1)).intValue();
            com.tencent.mm.vending.g.b czQ = g.czQ();
            czQ.czP();
            x.i("MicroMsg.LqtDetailInteractor", "closeAccount, accountType: %s", new Object[]{Integer.valueOf(intValue)});
            new a(str, intValue).JV().f(new 2(jVar, czQ));
            return null;
        }

        public final String wx() {
            return "Vending.LOGIC";
        }
    }

    public final /* bridge */ /* synthetic */ Object WD() {
        return this.syx;
    }

    public k() {
        this(new j());
    }

    private k(j jVar) {
        this.syy = new b(this);
        this.syz = new a(this);
        this.syA = new d(this);
        this.syB = new c(this);
        this.syx = jVar;
    }
}
