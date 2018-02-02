package com.tencent.mm.plugin.appbrand.report;

import android.os.Looper;
import android.os.Message;
import com.tencent.mm.sdk.d.d;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

public final class f extends d {
    long jHd;
    public long jHe;
    private final c jHf = new c(this, (byte) 0);
    final b jHg = new b();
    final a jHh = new a(this, (byte) 0);
    private boolean jHi = false;
    public boolean mStopped = false;

    private final class b extends d {
        final /* synthetic */ f jHk;
        private long jHl;

        private b(f fVar) {
            this.jHk = fVar;
        }

        public final String getName() {
            return this.jHk.mName + "|Foreground";
        }

        public final boolean j(Message message) {
            if (1 != message.what) {
                return super.j(message);
            }
            this.jHk.b(this.jHk.jHh);
            return true;
        }

        public final void enter() {
            super.enter();
            this.jHl = bh.Wp();
        }

        public final void exit() {
            super.exit();
            this.jHk.jHe = bh.Wp() - this.jHl;
        }
    }

    public f(String str) {
        super("MicroMsg.StayingRecorder[" + str + "]", Looper.getMainLooper());
        a(this.jHg);
        a(this.jHh);
        a(this.jHf);
        b(this.jHf);
        start();
    }

    public final boolean ajN() {
        return cgH() == this.jHh || this.jHi;
    }

    public final void ajO() {
        x.d(this.mName, "toForeground");
        jz(2);
    }

    public final void ajP() {
        x.d(this.mName, "toBackground");
        jz(1);
    }

    private void jz(int i) {
        if (cgG() == null) {
            Dh(i);
        } else if (Looper.myLooper() == this.xiR.getLooper()) {
            this.xiR.handleMessage(Message.obtain(this.xiR, i));
        } else {
            Di(i);
        }
    }

    public final void start() {
        if (!this.mStopped) {
            super.start();
        }
    }

    protected final void ZF() {
        super.ZF();
        this.jHi = true;
    }
}
