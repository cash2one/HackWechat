package com.tencent.mm.bd;

import com.tencent.map.a.a.a;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

public final class c implements a, e {
    private float fBc;
    private int fBd;
    private int fBe;
    private String fBf;
    private String fBg;
    private float fzt;
    a hLO;
    byte[] hLP;
    private ak hLQ;
    private int hLR;
    Object lock = new Object();
    private int scene;

    public c(float f, float f2, int i, int i2, String str, String str2, int i3, int i4) {
        g.Dk();
        this.hLQ = new ak(g.Dm().oAt.getLooper(), new 1(this), false);
        this.fBc = f;
        this.fzt = f2;
        this.fBd = i;
        this.fBe = i2;
        this.fBf = str;
        this.fBg = str2;
        this.hLR = i3;
        this.scene = i4;
        g.Di().gPJ.a(752, this);
    }

    public final void finish() {
        this.hLQ.TG();
        if (this.hLO != null) {
            g.Di().gPJ.c(this.hLO);
        }
        this.hLO = null;
        this.hLP = null;
        synchronized (this.lock) {
            this.lock.notifyAll();
        }
        g.Di().gPJ.b(752, this);
    }

    public final byte[] r(byte[] bArr) {
        try {
            String str = new String(bArr, "UTF-8");
            x.d("MicroMsg.SenseWhereHttpUtil", "sense where http request content : " + str);
            this.hLP = null;
            this.hLO = new a(this.fBc, this.fzt, this.fBd, this.fBe, this.fBf, this.fBg, this.hLR, this.scene, str);
            g.Di().gPJ.a(this.hLO, 0);
            this.hLQ.J(60000, 60000);
            synchronized (this.lock) {
                this.lock.wait();
            }
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.SenseWhereHttpUtil", e, "", new Object[0]);
            x.e("MicroMsg.SenseWhereHttpUtil", "sense where http request error: " + e.toString());
        }
        x.i("MicroMsg.SenseWhereHttpUtil", "upload sense where info finish. it is response is null? %b", new Object[]{Boolean.valueOf(bh.bw(this.hLP))});
        return this.hLP;
    }

    public final void a(int i, int i2, String str, k kVar) {
        this.hLQ.TG();
        if (i == 0 && i2 == 0) {
            if (kVar instanceof a) {
                String az = bh.az(((a) kVar).hLo, "");
                x.d("MicroMsg.SenseWhereHttpUtil", "senseWhereResp: " + az);
                try {
                    this.hLP = az.getBytes("UTF-8");
                } catch (Throwable e) {
                    x.printErrStackTrace("MicroMsg.SenseWhereHttpUtil", e, "", new Object[0]);
                    x.e("MicroMsg.SenseWhereHttpUtil", "string to byte[] error. " + e.toString());
                }
            } else {
                this.hLP = null;
            }
            synchronized (this.lock) {
                this.lock.notifyAll();
            }
        } else {
            x.w("MicroMsg.SenseWhereHttpUtil", "upload sense where info error. errType[%d] errCode[%d] errMsg[%s]", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
            this.hLP = null;
            synchronized (this.lock) {
                this.lock.notifyAll();
            }
            b.Rk().Rm();
            com.tencent.mm.plugin.report.service.g.pQN.a(345, 4, 1, false);
        }
        this.hLO = null;
    }
}
