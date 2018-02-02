package com.tencent.mm.modelvoice;

import com.tencent.mm.ae.h;
import com.tencent.mm.compatible.d.q;
import com.tencent.mm.e.b.a;
import com.tencent.mm.e.b.c;
import com.tencent.mm.e.b.g$a;
import com.tencent.mm.e.c.d;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

public final class k implements a {
    private static int hXt = 100;
    private int fjM = 0;
    c.a fkK = new c.a(this) {
        final /* synthetic */ k hXv;

        {
            this.hXv = r1;
        }

        public final void q(byte[] bArr, int i) {
            if (this.hXv.hXu != null) {
                this.hXv.hXu.a(new g$a(bArr, i), 0, false);
            }
            k.a(this.hXv, bArr, i);
        }

        public final void aK(int i, int i2) {
        }
    };
    public c fkb;
    private d hXu;
    private String mFileName = null;
    public int mStatus = 0;

    static /* synthetic */ void a(k kVar, byte[] bArr, int i) {
        for (int i2 = 0; i2 < i / 2; i2++) {
            short s = (short) ((bArr[i2 * 2] & 255) | (bArr[(i2 * 2) + 1] << 8));
            if (s > kVar.fjM) {
                kVar.fjM = s;
            }
        }
    }

    public final boolean cI(String str) {
        if (bh.ov(this.mFileName)) {
            this.mStatus = 1;
            this.fjM = 0;
            this.fkb = new c(16000, 1, 0);
            this.fkb.fkz = -19;
            if (q.gGe.gEQ > 0) {
                this.fkb.n(q.gGe.gEQ, true);
            } else {
                this.fkb.n(5, false);
            }
            this.fkb.aO(false);
            this.fkb.fkK = this.fkK;
            this.hXu = new d();
            if (!this.hXu.cL(str)) {
                x.e("MicroMsg.SpeexRecorder", "init speex writer failed");
                clean();
                this.mStatus = -1;
                return false;
            } else if (this.fkb.vr()) {
                this.mFileName = str;
                return true;
            } else {
                x.e("MicroMsg.SpeexRecorder", "start record failed");
                clean();
                this.mStatus = -1;
                return false;
            }
        }
        x.e("MicroMsg.SpeexRecorder", "Duplicate Call startRecord , maybe Stop Fail Before");
        return false;
    }

    public final void a(h.a aVar) {
    }

    public final boolean vi() {
        this.mFileName = null;
        this.mStatus = 0;
        clean();
        return true;
    }

    public final int getStatus() {
        return this.mStatus;
    }

    private void clean() {
        if (this.fkb != null) {
            this.fkb.vi();
            this.fkb = null;
        }
        if (this.hXu != null) {
            this.hXu.vE();
            this.hXu = null;
        }
    }

    public final int getMaxAmplitude() {
        int i = this.fjM;
        this.fjM = 0;
        if (i > hXt) {
            hXt = i;
        }
        return (i * 100) / hXt;
    }

    public final int vj() {
        return this.fkb.fkP;
    }
}
