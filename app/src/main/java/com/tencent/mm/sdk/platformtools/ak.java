package com.tencent.mm.sdk.platformtools;

import android.os.Looper;
import android.os.Message;

public class ak extends af {
    private static int xfi;
    private final boolean jsD;
    private boolean mStop = false;
    private long xfT = 0;
    private final a xfU;
    private final int xfj;

    public interface a {
        boolean uF();
    }

    public ak(a aVar, boolean z) {
        this.xfU = aVar;
        this.xfj = cfJ();
        this.jsD = z;
        if (getLooper().getThread().getName().equals("initThread")) {
            x.e("MicroMsg.MTimerHandler", "MTimerHandler can not init handler with initThread looper, stack %s", bh.cgy());
        }
    }

    public ak(Looper looper, a aVar, boolean z) {
        super(looper);
        this.xfU = aVar;
        this.xfj = cfJ();
        this.jsD = z;
        if (looper.getThread().getName().equals("initThread")) {
            x.e("MicroMsg.MTimerHandler", "MTimerHandler can not init handler with initThread looper, stack %s", bh.cgy());
        }
    }

    private static int cfJ() {
        if (xfi >= 8192) {
            xfi = 0;
        }
        int i = xfi + 1;
        xfi = i;
        return i;
    }

    protected void finalize() {
        TG();
        super.finalize();
    }

    public void handleMessage(Message message) {
        if (message.what == this.xfj && this.xfU != null && this.xfU.uF() && this.jsD && !this.mStop) {
            sendEmptyMessageDelayed(this.xfj, this.xfT);
        }
    }

    public final void fH(long j) {
        J(j, j);
    }

    public final void TG() {
        removeMessages(this.xfj);
        this.mStop = true;
    }

    public final void J(long j, long j2) {
        this.xfT = j2;
        TG();
        this.mStop = false;
        sendEmptyMessageDelayed(this.xfj, j);
    }

    public final boolean cfK() {
        return this.mStop || !hasMessages(this.xfj);
    }

    public String toString() {
        if (this.xfU == null) {
            return "MTimerHandler(" + getClass().getName() + "){mCallBack = null}";
        }
        return "MTimerHandler(" + getClass().getName() + "){mCallBack = " + this.xfU.getClass().getName() + "}";
    }
}
