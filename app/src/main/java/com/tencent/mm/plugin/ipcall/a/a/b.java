package com.tencent.mm.plugin.ipcall.a.a;

import android.os.Looper;
import com.tencent.mm.ae.k;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.x;

public abstract class b extends a implements com.tencent.mm.plugin.ipcall.a.a.a.a {
    private af mHandler = new af(Looper.getMainLooper());
    protected boolean nDu = false;
    public a nDv = null;

    public interface a {
        void a(int i, k kVar, int i2, int i3);

        void b(int i, k kVar, int i2, int i3);
    }

    public abstract int aTL();

    public abstract void aTM();

    public abstract void aTN();

    public abstract void b(c cVar);

    public abstract void onStop();

    public final void init() {
        this.nDt = this;
        super.init();
    }

    public final void destroy() {
        super.destroy();
    }

    public final void a(c cVar) {
        super.a(cVar);
        this.nDu = true;
        x.d("MicroMsg.BaseIPCallTimerService", "start service, type: %d", new Object[]{Integer.valueOf(LC())});
    }

    public final void stop() {
        this.nDu = false;
        onStop();
        x.d("MicroMsg.BaseIPCallTimerService", "stop service, type: %d", new Object[]{Integer.valueOf(LC())});
    }

    public final void a(int i, Object obj, int i2, int i3) {
        x.i("MicroMsg.BaseIPCallTimerService", "timer request success!, type: %d, isLoop: %b, interval: %d", new Object[]{Integer.valueOf(i), Boolean.valueOf(this.nDu), Integer.valueOf(aTL())});
        aTM();
        if (this.nDv != null) {
            this.nDv.a(i, (k) obj, i2, i3);
        }
        if (this.nDu) {
            this.mHandler.postDelayed(new 1(this), (long) aTL());
        }
    }

    public final void b(int i, Object obj, int i2, int i3) {
        x.i("MicroMsg.BaseIPCallTimerService", "timer request failed, type: %d, isLoop: %b, interval: %d", new Object[]{Integer.valueOf(i), Boolean.valueOf(this.nDu), Integer.valueOf(aTL())});
        aTN();
        if (this.nDv != null) {
            this.nDv.b(i, (k) obj, i2, i3);
        }
        if (this.nDu) {
            this.mHandler.postDelayed(new 2(this), (long) aTL());
        }
    }
}
