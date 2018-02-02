package com.tencent.mm.plugin.fingerprint.b;

import com.tencent.mm.g.a.lf;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fingerprint.a;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.pluginsdk.wallet.k;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.x;

public final class i extends c<lf> {
    private String fuH;
    boolean mza;
    private a mzv;
    lf mzw;
    private k mzx;
    private Runnable mzy;

    public i() {
        this.mzx = null;
        this.mzy = null;
        this.mza = false;
        this.fuH = "";
        this.xen = lf.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        lf lfVar = (lf) bVar;
        if (g.Dh().Cy()) {
            this.mza = false;
            if (lfVar instanceof lf) {
                x.i("MicroMsg.OpenFingerPrintAuthEventListener", "handle OpenFingerPrintAuthEventListener");
                if (e.aKi()) {
                    this.mzw = lfVar;
                    if (this.mzw == null) {
                        x.e("MicroMsg.OpenFingerPrintAuthEventListener", null, new Object[]{"mEvent is null !!!"});
                    } else {
                        this.mzy = this.mzw.fCw.fCA;
                        this.fuH = lfVar.fCw.fwY;
                        a.aJS();
                        if (a.aJT() == null) {
                            return true;
                        }
                        a.aJS();
                        a.aJT();
                        boolean aKb = c.aKb();
                        if (this.mzv == null) {
                            this.mzv = new a(this);
                        }
                        a.aJS();
                        a.aJT();
                        this.mzx = ((l) g.h(l.class)).aKn();
                        if (this.mzx == null) {
                            return fm(false);
                        }
                        this.mzx.a(new 1(this));
                        return aKb;
                    }
                }
                x.e("MicroMsg.OpenFingerPrintAuthEventListener", "device is not support FingerPrintAuth");
                this.mza = true;
                R(1, "");
                return true;
            }
        }
        x.e("MicroMsg.OpenFingerPrintAuthEventListener", "OpenFingerPrintAuthEvent account is not ready");
        return false;
    }

    public final void release() {
        a.aJS();
        if (a.aJT() != null) {
            a.aJS();
            a.aJT();
            c.release();
        }
        this.mzw = null;
    }

    public static void aKz() {
        a.aJS();
        if (a.aJT() != null) {
            boolean z;
            a.aJS();
            a.aJT();
            c.abort();
            a.aJS();
            a.aJT();
            c.release();
            String str = "MicroMsg.OpenFingerPrintAuthEventListener";
            String str2 = "stopIdentify() isSoter: %b";
            Object[] objArr = new Object[1];
            a.aJS();
            a.aJT();
            if (((l) g.h(l.class)).type() == 2) {
                z = true;
            } else {
                z = false;
            }
            objArr[0] = Boolean.valueOf(z);
            x.i(str, str2, objArr);
        }
    }

    final boolean fm(boolean z) {
        aKz();
        a.aJS();
        a.aJT();
        if (c.aKb()) {
            a.aJS();
            a.aJT();
            if (c.a(this.mzv, z) != 0) {
                x.e("MicroMsg.OpenFingerPrintAuthEventListener", "failed to start identify");
                release();
                this.mza = true;
                R(1, "");
                return false;
            }
            x.i("MicroMsg.OpenFingerPrintAuthEventListener", "startIdentify()");
            return true;
        }
        x.e("MicroMsg.OpenFingerPrintAuthEventListener", "no fingerprints enrolled, use settings to enroll fingerprints first");
        release();
        this.mza = true;
        R(1, "");
        return false;
    }

    final void R(int i, String str) {
        x.i("MicroMsg.OpenFingerPrintAuthEventListener", "onFail()");
        a.aJS();
        a.aJT();
        ((l) g.h(l.class)).a(this.mzw, i, str);
        if (this.mza) {
            this.mzw = null;
        }
        x.i("MicroMsg.OpenFingerPrintAuthEventListener", "callback OpenFingerPrintAuthEvent onFail()");
    }
}
