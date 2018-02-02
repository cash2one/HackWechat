package com.tencent.mm.plugin.shake.d.a;

import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.e.b.c;
import com.tencent.mm.plugin.appbrand.jsapi.av;
import com.tencent.mm.protocal.c.bdf;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ar;
import com.tencent.qafpapi.QAFPNative;

public final class a implements e {
    c fkb;
    private com.tencent.mm.e.b.c.a flb = new 1(this);
    Object kIX = new Object();
    int qpA;
    byte[] qpm = new byte[10240];
    int qpn = 0;
    int qpo = 0;
    long qpp = 0;
    int qpq = 0;
    boolean qpr = false;
    e qps = null;
    a qpt = null;
    boolean qpu = false;
    boolean qpv = false;
    int qpw = 0;
    int qpx;
    private boolean qpy = false;
    long qpz;

    class AnonymousClass2 implements Runnable {
        final /* synthetic */ a qpB;
        final /* synthetic */ boolean qpC = false;
        final /* synthetic */ boolean qpD;

        AnonymousClass2(a aVar, boolean z, boolean z2) {
            this.qpB = aVar;
            this.qpD = z2;
        }

        public final void run() {
            if (this.qpC) {
                this.qpB.qpt.a(null, -1, this.qpD);
            } else if (!this.qpB.qpr) {
                x.w("MicroMsg.MusicFingerPrintRecorder", "tryCallBack netscen not return.");
            } else if (this.qpB.fkb != null) {
                x.w("MicroMsg.MusicFingerPrintRecorder", "tryCallBack device not ready!");
            } else if (this.qpB.qps != null) {
                a aVar = this.qpB.qpt;
                bdf bsf = this.qpB.qps.bsf();
                e eVar = this.qpB.qps;
                long Wp = bh.Wp();
                if (eVar.qpH > 0 && eVar.qpH < Wp) {
                    Wp = eVar.qpH;
                }
                aVar.a(bsf, Wp, this.qpD);
            } else {
                this.qpB.qpt.a(null, -1, this.qpD);
            }
        }
    }

    public final boolean bsc() {
        boolean z = false;
        synchronized (this.kIX) {
            if (this.qpy) {
                x.d("MicroMsg.MusicFingerPrintRecorder", "QAFPInit already inited");
            } else {
                int QAFPInit = QAFPNative.QAFPInit();
                x.d("MicroMsg.MusicFingerPrintRecorder", "QAFPInit ret:%d", new Object[]{Integer.valueOf(QAFPInit)});
                if (QAFPInit >= 0) {
                    this.qpy = true;
                }
                if (QAFPInit >= 0) {
                    z = true;
                }
            }
        }
        return z;
    }

    public final boolean bsd() {
        boolean z = false;
        synchronized (this.kIX) {
            if (this.qpy) {
                x.d("MicroMsg.MusicFingerPrintRecorder", "QAFPRelease ret:%d", new Object[]{Integer.valueOf(QAFPNative.QAFPRelease())});
                if (QAFPNative.QAFPRelease() >= 0) {
                    z = true;
                }
            } else {
                x.d("MicroMsg.MusicFingerPrintRecorder", "QAFPRelease never inited");
            }
        }
        return z;
    }

    public final boolean vi() {
        x.d("MicroMsg.MusicFingerPrintRecorder", "stopRecord now clientid:%d", new Object[]{Integer.valueOf(this.qpw)});
        ar.CG().b(367, this);
        ar.CG().b(av.CTRL_INDEX, this);
        synchronized (this.qpm) {
            this.qpn = 0;
        }
        if (this.fkb != null) {
            this.fkb.vi();
            this.fkb = null;
        }
        return true;
    }

    public final boolean a(int i, a aVar) {
        vi();
        synchronized (this.kIX) {
            this.qpx = QAFPNative.QAFPGetVersion();
        }
        bsc();
        this.qpq = i;
        this.qpt = aVar;
        this.qpv = false;
        this.qpu = false;
        this.qpr = false;
        ar.CG().a(367, this);
        ar.CG().a(av.CTRL_INDEX, this);
        this.qpw = (int) bh.Wp();
        x.d("MicroMsg.MusicFingerPrintRecorder", "startRecord now clientid:%d", new Object[]{Integer.valueOf(this.qpw)});
        this.fkb = new c(8000, 1, 4);
        this.fkb.fkz = -19;
        this.fkb.fkK = this.flb;
        if (this.fkb.vr()) {
            synchronized (this.kIX) {
                x.d("MicroMsg.MusicFingerPrintRecorder", "QAFPReset ret:%d", new Object[]{Integer.valueOf(QAFPNative.QAFPReset())});
                if (QAFPNative.QAFPReset() < 0) {
                    x.e("MicroMsg.MusicFingerPrintRecorder", "init failed QAFPReset:%d clientid:%d", new Object[]{Integer.valueOf(r3), Integer.valueOf(this.qpw)});
                    reset();
                    return false;
                }
                this.qpp = bh.Wp();
                this.qpz = bh.Wp();
                this.qpA = 0;
                return true;
            }
        }
        x.e("MicroMsg.MusicFingerPrintRecorder", "start record failed");
        reset();
        return false;
    }

    final void reset() {
        x.d("MicroMsg.MusicFingerPrintRecorder", "reset recorder clientid:%d", new Object[]{Integer.valueOf(this.qpw)});
        if (this.fkb != null) {
            this.fkb.vi();
            this.fkb = null;
        }
        hR(false);
    }

    private void hR(boolean z) {
        x.d("MicroMsg.MusicFingerPrintRecorder", "tryCallBack, directFail = %s", new Object[]{Boolean.valueOf(false)});
        ag.y(new AnonymousClass2(this, false, z));
    }

    final void OW() {
        ar.Dm().F(new 3(this));
    }

    public final void a(int i, int i2, String str, k kVar) {
        if (kVar.getType() == 367 || kVar.getType() == av.CTRL_INDEX) {
            x.d("MicroMsg.MusicFingerPrintRecorder", "onSceneEnd errType = %s, errCode = %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
            this.qpu = false;
            if (((e) kVar).bse()) {
                x.d("MicroMsg.MusicFingerPrintRecorder", "NetSceneShakeMedia isRecogSuccess stop now ! clientid:%d", new Object[]{Integer.valueOf(this.qpw)});
                vi();
                this.qps = (e) kVar;
                this.qpr = true;
                hR(false);
            } else if (this.qpn == 0 && this.qpv) {
                x.d("MicroMsg.MusicFingerPrintRecorder", "recog failed . clientid:%d", new Object[]{Integer.valueOf(this.qpw)});
                this.qps = null;
                this.qpr = true;
                if (i == 0 && i2 == 0) {
                    hR(false);
                } else {
                    hR(true);
                }
                ar.CG().b(367, this);
                ar.CG().b(av.CTRL_INDEX, this);
            } else {
                x.d("MicroMsg.MusicFingerPrintRecorder", "NetScene try again clientId:%d", new Object[]{Integer.valueOf(this.qpw)});
                OW();
            }
        }
    }
}
