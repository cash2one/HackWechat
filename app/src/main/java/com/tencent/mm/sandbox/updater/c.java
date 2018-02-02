package com.tencent.mm.sandbox.updater;

import android.os.Message;
import com.tencent.mm.compatible.util.f;
import com.tencent.mm.compatible.util.h;
import com.tencent.mm.protocal.c.bdf;
import com.tencent.mm.sandbox.b.a;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.x;

public final class c extends com.tencent.mm.sandbox.monitor.c {
    private String fel;
    private boolean hEW = false;
    private int kIS = 0;
    private String nBr;
    private String[] xcD;
    private a xcE = null;
    private boolean xcF = false;
    private af xcG = new 1(this);
    private a xcH = new 3(this);
    private a xcx;

    static /* synthetic */ void a(c cVar, bdf com_tencent_mm_protocal_c_bdf) {
        try {
            x.d("MicroMsg.NetSceneGetUpdatePackFromCDN", "in genNewAPKInNewThread()");
            e.post(new 2(cVar, com_tencent_mm_protocal_c_bdf), "NetSceneGetUpdatePackFromCDN_genApk");
        } catch (Throwable e) {
            x.e("MicroMsg.NetSceneGetUpdatePackFromCDN", "exception in genNewAPKInNewThread()");
            x.printErrStackTrace("MicroMsg.NetSceneGetUpdatePackFromCDN", e, "", new Object[0]);
            Message obtain = Message.obtain();
            obtain.what = 1;
            obtain.arg1 = 3;
            obtain.obj = com_tencent_mm_protocal_c_bdf;
            cVar.xcG.sendMessage(obtain);
        }
    }

    public c(int i, String str, int i2, String[] strArr, boolean z) {
        super(i, str, i2, z);
        this.xcD = strArr;
    }

    public c(int i, String str, int i2, String str2, String str3, String str4, boolean z) {
        super(i, str, i2, z);
        this.xcD = new String[]{str2};
        this.xcF = true;
        this.fel = str3;
        this.nBr = str4;
    }

    public final void a(a aVar) {
        this.xcx = aVar;
        if (!h.getExternalStorageState().equals("mounted")) {
            x.e("MicroMsg.NetSceneGetUpdatePackFromCDN", "SDCard not available.");
            aVar.a(-1, -1, null);
        } else if (this.hEW) {
            x.e("MicroMsg.NetSceneGetUpdatePackFromCDN", "netscene had been canceled.");
            aVar.a(-1, -1, null);
        } else if (ceh() || ceo() >= this.xcD.length) {
            x.e("MicroMsg.NetSceneGetUpdatePackFromCDN", "exceed max download url. url count = " + this.xcD.length);
            if (this.xcF) {
                aVar.a(1, -1, null);
            } else {
                aVar.a(-1, -1, null);
            }
        } else if (f.aC((long) this.xcc)) {
            this.xcE = new a(this, this.xcc, com.tencent.mm.a.e.bN(baW()), this.xcH);
            this.xcE.execute(new String[]{this.xcD[ceo()]});
        } else {
            x.e("MicroMsg.NetSceneGetUpdatePackFromCDN", "SDCard full");
            if (this.xcF) {
                aVar.a(13, -1, null);
            } else {
                aVar.a(-1, -1, null);
            }
        }
    }

    protected final String baW() {
        if (this.xcF) {
            return xca + this.fel + ".temp";
        }
        return super.baW();
    }

    public final String ceg() {
        if (this.xcF) {
            return xca + this.nBr + ".apk";
        }
        return xca + this.xce + ".apk";
    }

    public final void cancel() {
        x.d("MicroMsg.NetSceneGetUpdatePackFromCDN", "cancel netscene");
        this.hEW = true;
        if (this.xcE != null && !this.xcE.isCancelled()) {
            this.xcE.cancel(true);
        }
    }

    private int ceo() {
        x.i("MicroMsg.NetSceneGetUpdatePackFromCDN", "requestCount=" + this.kIS + ", curLinkIdx = " + (this.kIS / 5));
        return this.kIS / 5;
    }
}
