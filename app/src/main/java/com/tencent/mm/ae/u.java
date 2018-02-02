package com.tencent.mm.ae;

import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

public final class u {
    public static b hnM = null;

    public interface a {
        int a(int i, int i2, String str, b bVar, k kVar);
    }

    public interface b {
        n CH();
    }

    static /* synthetic */ int a(boolean z, a aVar, int i, int i2, String str, b bVar, k kVar) {
        if (aVar != null) {
            final a aVar2;
            final int i3;
            final int i4;
            final String str2;
            final b bVar2;
            final k kVar2;
            if (z) {
                aVar2 = aVar;
                i3 = i;
                i4 = i2;
                str2 = str;
                bVar2 = bVar;
                kVar2 = kVar;
                hnM.CH().hmW.F(new Runnable() {
                    public final void run() {
                        aVar2.a(i3, i4, str2, bVar2, kVar2);
                    }

                    public final String toString() {
                        return super.toString() + "|tryCallback";
                    }
                });
            } else {
                aVar2 = aVar;
                i3 = i;
                i4 = i2;
                str2 = str;
                bVar2 = bVar;
                kVar2 = kVar;
                ag.y(new Runnable() {
                    public final void run() {
                        aVar2.a(i3, i4, str2, bVar2, kVar2);
                    }
                });
            }
        }
        return 0;
    }

    public static boolean KU() {
        if (hnM == null) {
            x.e("MicroMsg.RunCgi", "ERROR: MMCore Not init interface IGetNetSceneQueue.");
            return false;
        } else if (hnM.CH() != null) {
            return true;
        } else {
            x.e("MicroMsg.RunCgi", "ERROR: Get NetscneQueue is null.");
            return false;
        }
    }

    public static b a(b bVar) {
        a(bVar, null, false);
        return bVar;
    }

    public static b a(b bVar, a aVar) {
        a(bVar, aVar, false);
        return bVar;
    }

    public static k a(final b bVar, final a aVar, final boolean z) {
        if (hnM == null) {
            x.e("MicroMsg.RunCgi", "ERROR: MMCore Not init interface IGetNetSceneQueue.");
            return null;
        } else if (hnM.CH() == null) {
            x.e("MicroMsg.RunCgi", "ERROR: Get NetscneQueue is null.");
            return null;
        } else if (bVar == null) {
            x.e("MicroMsg.RunCgi", "ERROR: Param CommReqResp is null");
            return null;
        } else {
            k anonymousClass1 = new k() {
                private k hme = new k(this) {
                    final /* synthetic */ AnonymousClass1 hnU;

                    {
                        this.hnU = r1;
                    }

                    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
                        if (this.hnU.hnP != 2) {
                            this.hnU.hnQ.TG();
                            this.hnU.hnP = 1;
                            u.a(z, aVar, i2, i3, str, bVar, this.hnU.hnO);
                        } else {
                            x.w("MicroMsg.RunCgi", "Has been callback by protect:%d func:%d time:%d [%d,%d,%s]", Integer.valueOf(this.hnU.hnO.hashCode()), Integer.valueOf(this.hnU.getType()), Long.valueOf(bh.Wp() - this.hnU.startTime), Integer.valueOf(i2), Integer.valueOf(i3), str);
                        }
                        this.hnU.hnN.a(i2, i3, str, this.hnU.hnO);
                        x.i("MicroMsg.RunCgi", "onGYNetEnd:%d func:%d time:%d [%d,%d,%s]", Integer.valueOf(this.hnU.hnO.hashCode()), Integer.valueOf(this.hnU.getType()), Long.valueOf(bh.Wp() - this.hnU.startTime), Integer.valueOf(i2), Integer.valueOf(i3), str);
                    }
                };
                e hnN = null;
                final k hnO = this;
                int hnP = 0;
                ak hnQ = new ak(u.hnM.CH().hmW.oAt.getLooper(), new com.tencent.mm.sdk.platformtools.ak.a(this) {
                    final /* synthetic */ AnonymousClass1 hnU;

                    {
                        this.hnU = r1;
                    }

                    public final boolean uF() {
                        x.w("MicroMsg.RunCgi", "Warning: Never should go here. usr canceled:%b Or NetsceneQueue Not call onGYNetEnd! %d func:%d time:%d", Boolean.valueOf(this.hnU.hnO.aBT), Integer.valueOf(this.hnU.hnO.hashCode()), Integer.valueOf(this.hnU.getType()), Long.valueOf(bh.Wp() - this.hnU.startTime));
                        if (!(this.hnU.hnO.aBT || this.hnU.hnP == 1)) {
                            this.hnU.hnP = 2;
                            u.a(z, aVar, 3, -1, "", bVar, this.hnU.hnO);
                        }
                        return false;
                    }

                    public final String toString() {
                        return super.toString() + "|protectNotCallback";
                    }
                }, false);
                final long startTime = bh.Wp();

                public final int getType() {
                    return bVar.hmi;
                }

                public final int a(e eVar, e eVar2) {
                    this.hnN = eVar2;
                    int a = a(eVar, bVar, this.hme);
                    x.i("MicroMsg.RunCgi", "Start doScene:%d func:%d netid:%d time:%d", Integer.valueOf(this.hnO.hashCode()), Integer.valueOf(bVar.hmi), Integer.valueOf(a), Long.valueOf(bh.Wp() - this.startTime));
                    if (aVar != null) {
                        if (a < 0) {
                            u.a(z, aVar, 3, -1, "", bVar, this.hnO);
                        } else {
                            this.hnQ.J(60000, 60000);
                        }
                    }
                    return a;
                }
            };
            if (hnM.CH().a(anonymousClass1, 0)) {
                return anonymousClass1;
            }
            return null;
        }
    }
}
