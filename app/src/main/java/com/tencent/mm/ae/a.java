package com.tencent.mm.ae;

import com.tencent.mm.cd.f;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.protocal.c.bdf;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.vending.g.g;
import junit.framework.Assert;

public class a<_Resp extends bdf> {
    public b gJQ;
    b<_Resp> hlW = new b(this);
    private f<a<_Resp>> hlX;

    private static class b<_Resp extends bdf> extends k {
        e gOB = null;
        final k hma = this;
        b hmb;
        com.tencent.mm.vending.g.b hmc;
        a hmd;
        private k hme = new 1(this);
        final long mStartTime = bh.Wp();

        public b(a aVar) {
            this.hmd = aVar;
        }

        protected final int Bh() {
            return 1;
        }

        public final int getType() {
            return this.hmb.hmi;
        }

        public final int a(e eVar, e eVar2) {
            this.gOB = eVar2;
            int a = a(eVar, this.hmb, this.hme);
            x.i("MicroMsg.Cgi", "Start doScene:%d func:%d netid:%d time:%d", new Object[]{Integer.valueOf(this.hma.hashCode()), Integer.valueOf(this.hmb.hmi), Integer.valueOf(a), Long.valueOf(bh.Wp() - this.mStartTime)});
            if (a < 0) {
                g.a(this.hmc, new Object[]{a.a(3, -1, "", (bdf) this.hmb.hmh.hmo, this, this.hmd)});
            }
            return a;
        }
    }

    public synchronized f<a<_Resp>> JV() {
        Assert.assertNotNull("You should set a CommReqResp!", this.gJQ);
        Assert.assertTrue("RunCgi NetSceneQueue not ready!", u.KU());
        if (this.hlX == null) {
            this.hlX = new f().b(new com.tencent.mm.vending.g.c.a<a<_Resp>>(this) {
                final /* synthetic */ a hlY;

                {
                    this.hlY = r1;
                }

                public final /* synthetic */ Object call() {
                    com.tencent.mm.vending.g.b czX = g.czX();
                    this.hlY.hlW.hmc = czX;
                    this.hlY.hlW.hmb = this.hlY.gJQ;
                    if (!u.hnM.CH().a(this.hlY.hlW, 0)) {
                        x.e("MicroMsg.Cgi", "RunCgi doScene failed!");
                        g.a(czX);
                    }
                    return null;
                }
            });
        }
        return this.hlX;
    }

    public void a(int i, int i2, String str, _Resp _Resp, k kVar) {
    }
}
