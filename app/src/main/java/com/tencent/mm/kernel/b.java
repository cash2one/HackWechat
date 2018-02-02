package com.tencent.mm.kernel;

import com.tencent.mm.ae.n;
import com.tencent.mm.ae.u;
import com.tencent.mm.g.a.kc;
import com.tencent.mm.kernel.api.d;
import com.tencent.mm.network.e;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ah;
import java.util.HashSet;
import java.util.Iterator;

public final class b {
    private static ah gPM = null;
    public final a gPI;
    public final n gPJ;
    private HashSet<com.tencent.mm.network.n> gPK = new HashSet();
    public com.tencent.mm.network.n gPL = new com.tencent.mm.network.n.a(this) {
        final /* synthetic */ b gPN;

        {
            this.gPN = r1;
        }

        public final void eq(int i) {
            try {
                HashSet hashSet = new HashSet();
                synchronized (this.gPN.gPK) {
                    hashSet.addAll(this.gPN.gPK);
                }
                Iterator it = hashSet.iterator();
                while (it.hasNext()) {
                    ((com.tencent.mm.network.n) it.next()).eq(i);
                }
            } catch (final Throwable e) {
                x.printErrStackTrace("MMKernel.CoreNetwork", e, "onNetworkChange caught crash", new Object[0]);
                new af().post(new Runnable(this) {
                    final /* synthetic */ AnonymousClass2 gPP;

                    public final void run() {
                        throw new RuntimeException(e);
                    }
                });
            }
        }
    };

    static class a extends com.tencent.mm.cd.a<d> implements d {
        a() {
        }

        public final void b(final e eVar) {
            a(new com.tencent.mm.cd.a.a<d>(this) {
                final /* synthetic */ a gPS;

                public final /* synthetic */ void az(Object obj) {
                    ((d) obj).b(eVar);
                }
            });
        }
    }

    public b(com.tencent.mm.ae.n.a aVar, a aVar2) {
        this.gPJ = n.a(aVar);
        this.gPJ.hmW = g.Dm();
        u.hnM = new com.tencent.mm.ae.u.b(this) {
            final /* synthetic */ b gPN;

            {
                this.gPN = r1;
            }

            public final n CH() {
                return this.gPN.gPJ;
            }
        };
        this.gPI = aVar2;
    }

    public final void a(com.tencent.mm.network.n nVar) {
        synchronized (this.gPK) {
            this.gPK.add(nVar);
        }
    }

    public final void b(com.tencent.mm.network.n nVar) {
        synchronized (this.gPK) {
            this.gPK.remove(nVar);
        }
    }

    public static ah CE() {
        return gPM;
    }

    public static void a(ah ahVar) {
        gPM = ahVar;
    }

    public final byte[] CF() {
        byte[] bArr = null;
        try {
            if (!(this.gPJ == null || this.gPJ.hmV == null || this.gPJ.hmV.Kx() == null)) {
                bArr = this.gPJ.hmV.Kx().CF();
            }
        } catch (Throwable e) {
            x.w("MMKernel.CoreNetwork", "get session key error, %s", e.getMessage());
            x.e("MMKernel.CoreNetwork", "exception:%s", bh.i(e));
        }
        return bArr;
    }

    public final n CG() {
        return this.gPJ;
    }

    public static void a(int i, int i2, boolean z, String str) {
        com.tencent.mm.sdk.b.b kcVar = new kc();
        kcVar.fBr.status = i;
        kcVar.fBr.fBs = i2;
        kcVar.fBr.fBt = z;
        kcVar.fBr.fBu = str;
        com.tencent.mm.sdk.b.a.xef.m(kcVar);
    }
}
