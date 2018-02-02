package com.tencent.mm.network;

import com.tencent.mars.comm.WakerLock;
import com.tencent.mm.network.j.a;
import com.tencent.mm.plugin.report.d;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

class t$a extends a implements l {
    private t gxO;
    private WakerLock iao;
    private int iap = 0;

    public t$a(t tVar, WakerLock wakerLock) {
        this.gxO = tVar;
        this.iao = wakerLock;
    }

    public final void a(r rVar, int i, int i2, String str) {
        this.iao.lock(1000, "MMAutoAuth.IOnAutoAuth.onAutoAuth");
        new 1(this, rVar, i, i2, str).b(this.gxO.handler);
    }

    public final void a(int i, int i2, int i3, String str, r rVar, byte[] bArr) {
        if (rVar.getType() == 701) {
            x.d("MicroMsg.AutoAuth", "summerauth IOnAutoAuth onGYNetEnd manual auth");
            if (rVar.KJ().KN() != 0 || i2 != 0) {
                d.pPH.a(148, -102 == i3 ? 30 : 29, 1, false);
            } else if (rVar.KK() == 2) {
                d.pPH.a(148, 28, 1, false);
                this.iap++;
                if (this.iap > 1) {
                    x.w("MicroMsg.AutoAuth", "summerauth manualLoginDecodeFailedTry beyond 1 no more try!");
                    this.gxO.d(i2, i3, "auth_decode_failed_" + bh.az(str, ""));
                } else {
                    rVar.a(this, 0, 0);
                }
            } else {
                this.iap = 0;
                rVar.a(this, i2, i3, str);
            }
        }
        if (rVar.KJ().KN() == 0 && i2 == 0) {
            rVar.a(this, i2, i3, str);
        } else if (-102 == i3) {
            this.gxO.hZO = i;
            rVar.a(this.gxO.hZK, this.gxO.hZM, 0, 0);
        } else {
            if (-301 == i3) {
                rVar.a(this, i2, i3, str);
            } else if (-105 == i3) {
                rVar.a(this, i2, i3, str);
            } else if (-17 == i3) {
                rVar.a(this, i2, i3, str);
            }
            this.gxO.d(i2, i3, "autoauth_errmsg_" + bh.az(str, ""));
        }
    }
}
