package com.tencent.mm.ae;

import com.tencent.mm.network.e;
import com.tencent.mm.network.q;
import com.tencent.mm.network.r;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.be;
import junit.framework.Assert;

public abstract class k {
    public boolean aBT = false;
    private int asN = -99;
    public e hmA;
    public long hmB = bh.Wq();
    public int hmC = -1;
    private q hmD;
    e hmE;
    public boolean hmF;
    public q hmG;
    int priority = 0;

    static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] hmK = new int[b.Ki().length];

        static {
            try {
                hmK[b.hmO - 1] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                hmK[b.hmQ - 1] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                hmK[b.hmP - 1] = 3;
            } catch (NoSuchFieldError e3) {
            }
        }
    }

    protected enum a {
        EStatusCheckFailed,
        EReachMaxLimit
    }

    protected enum b {
        ;

        public static int[] Ki() {
            return (int[]) hmR.clone();
        }

        static {
            hmO = 1;
            hmP = 2;
            hmQ = 3;
            hmR = new int[]{hmO, hmP, hmQ};
        }
    }

    public abstract int a(e eVar, e eVar2);

    public abstract int getType();

    public final void reset() {
        this.hmB = bh.Wq();
        this.hmC = -1;
        this.asN = -99;
    }

    public void a(a aVar) {
    }

    public int a(q qVar) {
        return b.hmO;
    }

    public boolean Kd() {
        return false;
    }

    public int Bh() {
        return 1;
    }

    public boolean Ke() {
        return this.asN <= 0;
    }

    public boolean Kf() {
        return false;
    }

    public final void c(e eVar) {
        this.hmB = bh.Wq();
        this.hmA = eVar;
    }

    public boolean Kg() {
        return Bh() == 1;
    }

    public int a(e eVar, final q qVar, com.tencent.mm.network.k kVar) {
        c(eVar);
        this.hmG = qVar;
        final com.tencent.mm.network.k a = be.a(kVar);
        if (this.asN == -99) {
            this.asN = Bh();
            x.i("MicroMsg.NetSceneBase", "initilized security limit count to " + this.asN);
        }
        if (Bh() > 1) {
            switch (AnonymousClass2.hmK[a(qVar) - 1]) {
                case 1:
                    Assert.assertTrue("scene security verification not passed, type=" + qVar.getType() + ", uri=" + qVar.getUri() + ", CHECK NOW", false);
                    break;
                case 2:
                    x.e("MicroMsg.NetSceneBase", "scene security verification not passed, type=" + qVar.getType() + ", uri=" + qVar.getUri());
                    this.asN--;
                    a(a.EStatusCheckFailed);
                    this.hmC = -1;
                    return this.hmC;
                case 3:
                    break;
                default:
                    Assert.assertTrue("invalid security verification status", false);
                    break;
            }
        }
        if (Ke()) {
            x.e("MicroMsg.NetSceneBase", "dispatch failed, scene limited for security, current limit=" + Bh());
            a(a.EReachMaxLimit);
            this.hmC = -1;
            return this.hmC;
        }
        this.asN--;
        r sVar = new s(qVar);
        if (!(this.hmD == null || Kf())) {
            this.hmD.cancel();
        }
        this.hmD = new q(qVar, a, this, this.hmE, eVar);
        this.hmC = eVar.a(sVar, this.hmD);
        x.i("MicroMsg.NetSceneBase", "dispatcher send, %s", Integer.valueOf(this.hmC));
        if (this.hmC < 0) {
            x.i("MicroMsg.NetSceneBase", "dispatcher send, %s, ThreadID:%s, getType:%s", Integer.valueOf(this.hmC), Long.valueOf(Thread.currentThread().getId()), Integer.valueOf(qVar.getType()));
            new af().post(new Runnable(this) {
                final /* synthetic */ k hmJ;

                public final void run() {
                    x.i("MicroMsg.NetSceneBase", "dispatcher send, %s, ThreadID:%s, getType:%s", Integer.valueOf(this.hmJ.hmC), Long.valueOf(Thread.currentThread().getId()), Integer.valueOf(qVar.getType()));
                    a.a(-1, 3, -1, "send to network failed", qVar, null);
                    x.i("MicroMsg.NetSceneBase", "dispatcher send, %s, ThreadID:%s, getType:%s", Integer.valueOf(this.hmJ.hmC), Long.valueOf(Thread.currentThread().getId()), Integer.valueOf(qVar.getType()));
                }
            });
            return 99999999;
        }
        q qVar2 = this.hmD;
        qVar2.handler.postDelayed(qVar2.hnt, 330000);
        return this.hmC;
    }

    public final int Kh() {
        return this.hmG == null ? 0 : this.hmG.hashCode();
    }

    public void cancel() {
        x.i("MicroMsg.NetSceneBase", "cancel: %d, hash:%d, type:%d", Integer.valueOf(this.hmC), Integer.valueOf(hashCode()), Integer.valueOf(getType()));
        this.aBT = true;
        if (this.hmD != null) {
            this.hmD.cancel();
        }
        if (this.hmC != -1 && this.hmA != null) {
            int i = this.hmC;
            this.hmC = -1;
            this.hmA.cancel(i);
        }
    }

    public boolean a(k kVar) {
        return false;
    }

    public boolean b(k kVar) {
        return false;
    }

    public String getInfo() {
        return "";
    }
}
