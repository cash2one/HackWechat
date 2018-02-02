package com.tencent.mm.plugin.aa;

import com.tencent.mm.by.h.d;
import com.tencent.mm.g.a.bm;
import com.tencent.mm.g.a.bn;
import com.tencent.mm.g.a.mi;
import com.tencent.mm.g.a.mj;
import com.tencent.mm.g.a.tc;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.m;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.z.ap;
import com.tencent.mm.z.p;
import java.util.HashMap;

public class b implements ap {
    private static HashMap<Integer, d> gwY;
    private com.tencent.mm.plugin.aa.a.b.d ifA;
    private com.tencent.mm.plugin.aa.a.b.b ifB;
    private c<mj> ifu = new 1(this);
    private c<mi> ifv = new 2(this);
    private c<bm> ifw = new 3(this);
    private c<bn> ifx = new 4(this);
    private m ify = new 5(this);
    c<tc> ifz = new 6(this);

    private static b Wz() {
        return (b) p.s(b.class);
    }

    static {
        HashMap hashMap = new HashMap();
        gwY = hashMap;
        hashMap.put(Integer.valueOf("AARecord".hashCode()), new 7());
        gwY.put(Integer.valueOf("AAPayRecord".hashCode()), new 8());
    }

    public final HashMap<Integer, d> Bn() {
        return gwY;
    }

    public static com.tencent.mm.plugin.aa.a.b.d WA() {
        if (Wz().ifA == null) {
            b Wz = Wz();
            g.Dk();
            Wz.ifA = new com.tencent.mm.plugin.aa.a.b.d(g.Dj().gQj);
        }
        return Wz().ifA;
    }

    public static com.tencent.mm.plugin.aa.a.b.b WB() {
        if (Wz().ifB == null) {
            b Wz = Wz();
            g.Dk();
            Wz.ifB = new com.tencent.mm.plugin.aa.a.b.b(g.Dj().gQj);
        }
        return Wz().ifB;
    }

    public final void gd(int i) {
    }

    public final void bq(boolean z) {
        a.xef.b(this.ifu);
        a.xef.b(this.ifv);
        a.xef.b(this.ifw);
        a.xef.b(this.ifx);
        a.xef.b(this.ifz);
        ((n) g.k(n.class)).getSysCmdMsgExtension().a("paymsg", this.ify);
    }

    public final void br(boolean z) {
    }

    public final void onAccountRelease() {
        a.xef.c(this.ifu);
        a.xef.c(this.ifv);
        a.xef.c(this.ifw);
        a.xef.c(this.ifx);
        a.xef.c(this.ifz);
        ((n) g.k(n.class)).getSysCmdMsgExtension().b("paymsg", this.ify);
    }
}
