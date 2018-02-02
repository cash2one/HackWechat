package com.tencent.mm.ae;

import android.os.Looper;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.l.a;
import com.tencent.mm.network.r;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

public final class q extends a {
    private final k frb;
    final af handler;
    private final e hmA;
    private final e hmE;
    private final long hno = 330000;
    private com.tencent.mm.network.q hnp;
    private k hnq;
    private boolean hnr = false;
    private boolean hns = false;
    Runnable hnt = new Runnable(this) {
        final /* synthetic */ q hnu;

        {
            this.hnu = r1;
        }

        public final void run() {
            int i = 0;
            if (this.hnu.hnr || this.hnu.hns) {
                int i2;
                String str = "MicroMsg.RemoteOnGYNetEnd";
                String str2 = "time exceed But removeCallbacks failed hash:%d type:%d";
                Object[] objArr = new Object[2];
                if (this.hnu.frb == null) {
                    i2 = 0;
                } else {
                    i2 = this.hnu.frb.hashCode();
                }
                objArr[0] = Integer.valueOf(i2);
                if (this.hnu.frb != null) {
                    i = this.hnu.frb.getType();
                }
                objArr[1] = Integer.valueOf(i);
                x.e(str, str2, objArr);
                return;
            }
            final boolean a = this.hnu.hnr;
            final boolean b = this.hnu.hns;
            String str3 = "MicroMsg.RemoteOnGYNetEnd";
            String str4 = "time exceed, force to callback hash:%d type:%d";
            Object[] objArr2 = new Object[2];
            objArr2[0] = Integer.valueOf(this.hnu.frb == null ? 0 : this.hnu.frb.hashCode());
            if (this.hnu.frb != null) {
                i = this.hnu.frb.getType();
            }
            objArr2[1] = Integer.valueOf(i);
            x.w(str3, str4, objArr2);
            this.hnu.hnr = true;
            com.tencent.mm.sdk.f.e.post(new Runnable(this) {
                final /* synthetic */ AnonymousClass1 hnx;

                public final void run() {
                    int i = 0;
                    this.hnx.hnu.hmA.jr("push process's network haven't callback in 5.5min!!!! cancelStatus:" + a + " hasCallbackStatus:" + b);
                    String str = "MicroMsg.RemoteOnGYNetEnd";
                    String str2 = "time exceed, force to callback . kill push fin. hash:%d type:%d";
                    Object[] objArr = new Object[2];
                    objArr[0] = Integer.valueOf(this.hnx.hnu.frb == null ? 0 : this.hnx.hnu.frb.hashCode());
                    if (this.hnx.hnu.frb != null) {
                        i = this.hnx.hnu.frb.getType();
                    }
                    objArr[1] = Integer.valueOf(i);
                    x.w(str, str2, objArr);
                }
            }, "RemoteOnGYNetEnd_killPush");
            this.hnu.hnq.a(-1, 3, -1, "time exceed, force to callback", this.hnu.hnp, null);
        }
    };

    public q(com.tencent.mm.network.q qVar, k kVar, k kVar2, e eVar, e eVar2) {
        this.hnp = qVar;
        this.hnq = kVar;
        this.frb = kVar2;
        this.hmE = eVar;
        this.handler = Looper.myLooper() == null ? new af(Looper.getMainLooper()) : new af();
        this.hmA = eVar2;
    }

    public final void cancel() {
        this.hnr = true;
        this.handler.removeCallbacks(this.hnt);
    }

    public final void a(int i, int i2, int i3, String str, r rVar, byte[] bArr) {
        x.i("MicroMsg.RemoteOnGYNetEnd", "onGYNetEnd netId:%d, errType:%d, errCode:%d, isCancel:%b, hash[%d,%d]", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Boolean.valueOf(this.hnr), Integer.valueOf(this.frb.hashCode()), Integer.valueOf(this.hnp.hashCode()));
        this.frb.hmC = -1;
        if (!this.hnr && !this.hns) {
            this.hns = true;
            this.handler.removeCallbacks(this.hnt);
            final int i4 = i;
            final int i5 = i2;
            final int i6 = i3;
            final String str2 = str;
            final byte[] bArr2 = bArr;
            this.handler.post(new Runnable(this) {
                final /* synthetic */ q hnu;

                public final void run() {
                    if (this.hnu.hnr) {
                        x.w("MicroMsg.RemoteOnGYNetEnd", "netId:%d has been canceled", Integer.valueOf(i4));
                        return;
                    }
                    int i = i5;
                    int i2 = i6;
                    if (10016 == com.tencent.mm.platformtools.r.idt && !bh.ov(com.tencent.mm.platformtools.r.idv)) {
                        x.i("MicroMsg.RemoteOnGYNetEnd", "onGYNetEnd DK TEST SET : %s ", com.tencent.mm.platformtools.r.idv);
                        String[] split = com.tencent.mm.platformtools.r.idv.split(",");
                        if (split != null && split.length == 3 && bh.getInt(split[0], -1) == this.hnu.frb.getType()) {
                            i = bh.getInt(split[1], 0);
                            i2 = bh.getInt(split[2], 0);
                            if (i == 999) {
                                x.w("MicroMsg.RemoteOnGYNetEnd", "onGYNetEnd DK TEST SET syncservice : %s  NOT  CALLBACK !!!", com.tencent.mm.platformtools.r.idv);
                                return;
                            }
                        }
                    }
                    x.i("MicroMsg.RemoteOnGYNetEnd", "onGYNetEnd after post to worker netId:%d, errType:%d, errCode:%d, isCancel:%b, hashcode:%d", Integer.valueOf(i4), Integer.valueOf(i), Integer.valueOf(i2), Boolean.valueOf(this.hnu.hnr), Integer.valueOf(this.hnu.frb.hashCode()));
                    this.hnu.hnq.a(i4, i, i2, str2, this.hnu.hnp, bArr2);
                    if (this.hnu.frb.Kg() && !this.hnu.frb.hmF) {
                        x.e("MicroMsg.RemoteOnGYNetEnd", "the netscene hasn't call callback to onSceneEnd, type:%d", Integer.valueOf(this.hnu.frb.getType()));
                        x.cfk();
                    }
                }
            });
        }
    }
}
